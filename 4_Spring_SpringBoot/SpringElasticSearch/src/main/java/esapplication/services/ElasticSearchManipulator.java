package esapplication.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import esapplication.entities.RecType;
import esapplication.entities.Record;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ElasticSearchManipulator {

    @Autowired
    private ObjectMapper mapper;
    private RestHighLevelClient client;


    public void run() throws Exception {
        runningActual();
    }

    private void runningActual() throws Exception {
        ClientConfiguration clientConfiguration = ClientConfiguration.builder().connectedTo("localhost:9200").build();
        client = RestClients.create(clientConfiguration).rest();

//        seedDb();
//        cleanDb();
//        retrieveOneDocument();
//        retrieveAllDocuments();
//        retrieveOneIndex();
//        deleteSomeEntries();
        querySomeEntries();
//        deleteBySpecificQuery();
    }

    private void seedDb() throws IOException {
        for (int i = 0; i < 10; i++) {
            LocalDateTime dateTime = LocalDateTime.now().minusMonths(i);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
            Record dogRecord = new Record("DOGTEXT=" + i, RecType.DOG, dateTime, dateTime, dateTime.format(formatter));
            IndexRequest dogRequest = new IndexRequest("animals").source(mapper.writeValueAsString(dogRecord), XContentType.JSON);
            client.index(dogRequest, RequestOptions.DEFAULT);

            Record catRecord = new Record("CATTEXT=" + i, RecType.CAT, dateTime, dateTime, dateTime.format(formatter));
            IndexRequest catRequest = new IndexRequest("animals");
            catRequest.source(mapper.writeValueAsString(catRecord), XContentType.JSON);
            client.index(catRequest, RequestOptions.DEFAULT);

            Record birdRecord = new Record("BIRDTEXT=" + i, RecType.BIRD, dateTime, dateTime, dateTime.format(formatter));
            IndexRequest birdRequest = new IndexRequest("animals");
            birdRequest.source(mapper.writeValueAsString(birdRecord), XContentType.JSON);
            client.index(birdRequest, RequestOptions.DEFAULT);

        }
    }

    private void cleanDb() throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest("animals");
        AcknowledgedResponse deleteIndexResponse = client.indices().delete(request, RequestOptions.DEFAULT);
        System.out.println("JOBS DONE");
    }

    private void retrieveOneDocument() throws IOException {
        GetRequest getRequest = new GetRequest("animals");
        getRequest.id("id to search");
        GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
        Map<String, Object> oneObjectAsMap = getResponse.getSourceAsMap();
        System.out.println("JOBS DONE");

    }

    private void retrieveAllDocuments() throws IOException {
        SearchRequest searchRequest = new SearchRequest("animals");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchSourceBuilder.size(100);
        searchRequest.source(searchSourceBuilder);

        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);

        SearchHit[] searchHits = response.getHits().getHits();
        List<Record> results =
                Arrays.stream(searchHits)
                        .map(hit -> parseJsn(hit.getSourceAsString()))
                        .collect(Collectors.toList());

        Map<String, Record> results2 = new HashMap<>();
        Arrays.stream(searchHits)
                .forEach(hit -> {
                    Record rec = parseJsn(hit.getSourceAsString());
                    String id = hit.getId();
                    results2.put(id, rec);
                });

        System.out.println("JOBS DONE");
    }

    private Record parseJsn(String json) {
        try {
            return mapper.readValue(json, Record.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }


    private void retrieveOneIndex() {
        SearchRequest searchRequest = new SearchRequest("animals");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchRequest.source(searchSourceBuilder);

        System.out.println("JOBS DONE");
    }

    private void deleteSomeEntries() throws IOException {
        SearchRequest searchRequest = new SearchRequest("animals");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        QueryBuilder query = QueryBuilders.matchQuery("type", RecType.CAT.toString());
        searchSourceBuilder.query(query);
        searchRequest.source(searchSourceBuilder);

        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
        SearchHit[] searchHits = response.getHits().getHits();


        List<String> toDelete = Arrays.stream(searchHits)
                .map(SearchHit::getId)
                .collect(Collectors.toList());
        toDelete.forEach(id -> {
            DeleteRequest request = new DeleteRequest("animals", id);
            try {
                client.delete(request, RequestOptions.DEFAULT);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        System.out.println("JOBS DONE");
    }

    private void querySomeEntries() throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        String date = LocalDateTime.now().minusDays(90).format(formatter);

        SearchRequest searchRequest = new SearchRequest("animals");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        QueryBuilder query = QueryBuilders.boolQuery()
                .must(QueryBuilders.matchQuery("type", RecType.CAT.toString()))
//                .should(QueryBuilders.matchQuery("type", RecType.DOG.toString()))
                .must(QueryBuilders.rangeQuery("firstDate").lt(date));
        searchSourceBuilder.query(query);
        searchSourceBuilder.size(100);
        searchRequest.source(searchSourceBuilder);

        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
        SearchHit[] searchHits = response.getHits().getHits();
        List<Record> results =
                Arrays.stream(searchHits)
                        .map(hit -> parseJsn(hit.getSourceAsString()))
                        .collect(Collectors.toList());

        System.out.println("JOBS DONE");
    }

    private void deleteBySpecificQuery() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        String date = LocalDateTime.now().minusDays(90).format(formatter);

        DeleteByQueryRequest request = new DeleteByQueryRequest("animals");
        QueryBuilder query = QueryBuilders.boolQuery()
                .must(QueryBuilders.matchQuery("type", RecType.CAT.toString()))
                .must(QueryBuilders.rangeQuery("firstDate").lt(date));
        request.setQuery(query);
        try {
            client.deleteByQuery(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("JOBS DONE");
    }

}
