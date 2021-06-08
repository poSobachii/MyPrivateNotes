package as jar defined in pom.xml file under plugin section
run:  mvn clean install
in target folder you will find .jar file

must put .jar file into dockerfile map ( where Dockerfile located )   Dockerfile - with no extension and naming is stricted

docker build -t barkapp .      // the "." dot is neccessary argument
docker images                   // your image should appear

docker run --name "bark" -p 8080:8080 barkapp           // test run
docker run --name "bark" -p 8081:8080 barkapp           // test run different port e.g. http://localhost:8081/

docker exec -it bark sh                 // we can enter container
ls                      // to see all files inside, where we will se our .jar file

docker login                // to login your docker hub account
docker tag barkapp posobachii/bark                    // tag your image
docker push posobachii/bark                 // push your image to docker hub

docker run --name "bark" -p 8080:8080 posobachii/bark:latest                // now you can use this link to run your application


docker run --name "bark3" --mount source=dog-vol,destination=/upload-dir -p 8080:8080 barks
docker run --name "bark3" -v dog-vol:/upload-dir -p 8080:8080 barks