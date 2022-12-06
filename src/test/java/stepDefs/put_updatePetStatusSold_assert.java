package stepDefs;

import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import utils.ConfigurationReader;

import static io.restassured.RestAssured.given;

public class put_updatePetStatusSold_assert {
    @Then("put method should be used to update the pet status")
    public void put_method_should_be_used_to_update_the_pet_status() {

        String putBody="{\n" +
                "  \"id\": 13,\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"Franky\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"sold\"\n" +
                "}";

        ValidatableResponse response = given().contentType(ContentType.JSON)
                .and().body(putBody).when().put(ConfigurationReader.get("baseurl_petstore")+ "/pet")
                .then().assertThat().statusCode(200);

        System.out.println("Pet status updated as sold");
    }


}
