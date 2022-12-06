package stepDefs;

import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import utils.ConfigurationReader;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class delete_Pet {

    @Then("the user should be able to delete a pet with id")
    public void the_user_should_be_able_to_delete_a_pet_with_id(String id) {

        int petId = Integer.parseInt(id);
        Response response = given().pathParam("id", petId)
                .and().header("api_key","special-key")
                .when().delete(ConfigurationReader.get("baseurl_petstore") + "/pet/{id}");

        assertEquals(200, response.statusCode());

        System.out.println("Pet is deleted");

        ValidatableResponse response2 = given().pathParam("id", petId)
                .and().header("api_key","special-key")
                .when().delete(ConfigurationReader.get("baseurl_petstore") + "/pet/{id}")
                .then().assertThat().statusCode(404);

    }

}
