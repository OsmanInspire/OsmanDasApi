package stepDefs;

import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.ConfigurationReader;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class post_newAvailablePet_assert {
    @When("post method should be able to use with following endPoint to create a new pet")
    public void post_method_should_be_able_to_use_with_following_end_point_to_create_a_new_pet(String endPoint) {

        String newPet ="{\n" +
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
                "  \"status\": \"available\"\n" +
                "}";

        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(newPet)
                .post(ConfigurationReader.get("baseurl_petstore") + "/" + endPoint);
        assertEquals(200,response.statusCode());
        assertEquals("application/json", response.contentType());
        assertEquals(response.path("status").toString().replace("[", "").replace("]", ""),"available");
        assertEquals(response.path("name").toString().replace("[", "").replace("]", ""),"Franky");

        System.out.println(response.body().prettyPrint() + " \n A new pet is added");

    }

}
