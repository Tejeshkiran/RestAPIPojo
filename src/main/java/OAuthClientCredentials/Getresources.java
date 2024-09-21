package OAuthClientCredentials;

import O_Pojo_Deserialization.GetCourseDetails;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class Getresources {
    public static void main(String[] args) {

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        GetCourseDetails GCD = given().log().all().queryParam("access_token", GenarateAccessToken.getAccessToken())
                .when().get("/oauthapi/getCourseDetails")
                .then().log().all().assertThat().statusCode(401).extract().as(GetCourseDetails.class);

        for (int i = 0; i<GCD.getCourses().getApi().size(); i++){
            if(GCD.getCourses().getApi().get(i).getCourseTitle().
                    equalsIgnoreCase("Rest Assured Automation using Java"))
            {
                System.out.println(GCD.getCourses().getApi().get(i).getPrice());
            }
            
        }
    }
}
