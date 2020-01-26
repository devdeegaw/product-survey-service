# Product Survey Service

This service is build for to collect products survey data.

## Use cases ##

1. Allow admin to add questions for a given product.

2. Get questions for product to present it to user

3. Allow user to submit product survey question by selecting an answer
from 1 to 5 for each question


## Run the Application

### Prerequisites
* JDK 1.8 or later
* Maven 3.2+

If you use Maven, run the following command in a terminal window (in the complete) directory :


```bash
mvn spring-boot:run
```

Alternatively, execute the main method from ProductSurveyApplication class

The app will start running at <http://localhost:8084>.

## Explore Rest APIs

The app defines following CRUD APIs.

* Add questions to product : http://localhost:8084/api/product/{productId}/questions/add
* Get questions for product : http://localhost:8084/api/product/{productId}/questions
* Submit product survey: http://localhost:8084/api/survey/product/{productId}/user/{userId}/submission

## Built With
* [Maven](https://maven.apache.org/) - Dependency Management



