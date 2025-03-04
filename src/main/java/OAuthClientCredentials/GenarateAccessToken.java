package OAuthClientCredentials;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class GenarateAccessToken {
    public static String getAccessToken() {
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String resp = given().log().all().formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
                .formParam("grant_type", "client_credentials")
                .formParam("scope", "trust")
                .when().post("/oauthapi/oauth2/resourceOwner/token")
                .then().log().all().statusCode(200).extract().response().asString();

        System.out.println(resp);
        JsonPath jsp = new JsonPath(resp);
        String AccessToken= jsp.getString("access_token");
        return AccessToken;
    }
}
