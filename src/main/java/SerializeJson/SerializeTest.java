package SerializeJson;

import Pojo_Serialization.Addplace;
import Pojo_Serialization.Location;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;


public class SerializeTest {

    public static void main(String[] args) {

        Addplace payload = new Addplace();
        Location addvalue = new Location();
        addvalue.setLat(38.383494d);
        addvalue.setLng(33.427362d);

        ArrayList<String> ar = new ArrayList<>();
        ar.add(0,"shoe park");
        ar.add(1,"shop");

        payload.setTypes(ar);

        payload.setAccuracy(50);
        payload.setAddress("29, side layout, cohen 09");
        payload.setLanguage("French-IN");
        payload.setName("Frontline house");
        payload.setPhone_number("(+91) 983 893 3937");
        payload.setWebsitewebsite("http://google.com");
        payload.setLocation(addvalue);

        //RequestSpecification req =new RequestSpecBuilder() -> for Request to endpoint
        //ResponseSpecification resspec =new ResponseSpecBuilder()-> response from the endpoint

        RequestSpecification req =new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("Key","qaclick123")
                .setContentType(ContentType.JSON).build();

        ResponseSpecification resspec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();


        //RestAssured.baseURI = "https://rahulshettyacademy.com";

        RequestSpecification res=given().log().all().spec(req)
                .body(payload);
        String response = res.when().post("/maps/api/place/add/json?Key=qaclick123")
                .then().log().all().spec(resspec).extract().response().asString();

        System.out.println(response);

    }

}
