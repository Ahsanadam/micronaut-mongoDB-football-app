##How to use the application:

1. Download, install and run [Docker Desktop](https://www.docker.com/products/docker-desktop/)
2. Create a network by using the following command:

   docker network create mongo-network
3. Create a volume for MongoDB by using the following command:

   docker volume create mongodb_data
4. Start a MongoDB container by using the following command: 

   docker run -d --name mongo1 --network mongo-network -e MONGO_INITDB_ROOT_USERNAME=mongoadmin -e MONGO_INITDB_ROOT_PASSWORD=secret --volume mongodb_data:/data/db -p 27017:27017 mongo
5. Navigate to the right folder where the application is located and write mvn compile(Press CTRL ENTER after)  in the command prompt and create a native image inside docker by using the following command:

   ./mvnw package -Dpackaging=docker-native -Pgraalvm
6. Start the container of the app by using the following command:

   docker run -d --network mongo-network -p 8080:8080 --name football-clubs-app micronautguide:latest
7. You can now try testing the endpoints by using [Insomnia](https://insomnia.rest/download), [Postman](https://www.postman.com/downloads/)https://www.postman.com/downloads) or any other testing and validating tool for RESTful applications.

##Endpoints

| HTTP   | Path                   | Information      | Status Code |
|--------|------------------------|--------------------------------         |-------------|
| GET    | /footballclubs             | Get all football clubs from list    | 200         |
| POST    | /footballclubs | Save a football club to list | 201  | 

###GET

GET endpoint will give you a list of all football cubs currently in the MongoDB database. It will return in JSON design.

###POST

There are two designs that you can use that are included in POST, both requires a JSON body. You can either type:

      {
        "name": "Internazionale"
      }

###or

    {
      "name": "Internazionale"
      "stadium": "San Siro"
    }
 
    

