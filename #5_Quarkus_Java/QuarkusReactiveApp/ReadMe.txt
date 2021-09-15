Quarkus reactive app
#QUARKUS
#REST

./mvnw compile quarkus:dev
// launch app

> curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"name":"peach"}' \
  http://localhost:8080/fruits

// use this CURL to insert new fruit