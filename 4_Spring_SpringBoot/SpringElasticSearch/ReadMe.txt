docker run -d --name es762 -p 9200:9200 -e "discovery.type=single-node" elasticsearch:7.6.2

docker exec -it es762 bash              // go inside docker
curl http://localhost:9200              // use inside docker to get info
curl -X PUT http://localhost:9200/test  // to make new index
curl -X POST "localhost:9200/logs-my_app-default/_doc?pretty" -H 'Content-Type: application/json' -d'{"@timestamp": "2099-05-06T16:21:15.000Z","event": {"original": "192.0.2.42 - - [06/May/2099:16:21:15 +0000] \"GET /images/bg.jpg HTTP/1.0\" 200 24736"}}'

http://localhost:9200/                      // default port for ES
http://localhost:9200/people                // to get information about particular index
http://localhost:9200/people/_search        // to retrieve hits from people index
http://localhost:9200/_cat/indices?pretty   // to get all indexes info
http://localhost:9200/_cat/indices/animals*?v&s=index   // particular index
http://localhost:9200/animals/_search?size=100          // get size 100

POST /people/_delete_by_query
{
  "query": {
    "match": {
      "_id": "elkbee"
    }
  }
}
                                            // to delete by id ( use postman etc.)


GET /b2b-notifications-alias/_search
{
    "query": {
        "term": {
            "messageID.keyword": {
                "value": "CHInfo-001598"
            }
        }
    }
}

DELETE http://localhost:9200/people

gt Greater than.
gte Greater than or equal to.
lt Less than.
lte Less than or equal to.














