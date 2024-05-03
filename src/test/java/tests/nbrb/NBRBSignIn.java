package tests.nbrb;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import page.objects.day21_classwork.restAssured.SignIn;

public class NBRBSignIn {
    public static void main(String[] args) {
        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri("http://178.124.206.46:8001/app/")
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
        String x = RestAssured
                .given()
                .spec(requestSpec)
                .body(new SignIn())
                .when()
                .post()
                .then().extract().body().asString();
        System.out.println(x);
    }

}
