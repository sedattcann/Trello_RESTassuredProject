import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITest {

//    @Test
//    void test1(){
//       String baseUrl="http://anka-weblogiclb.ng112.gov.tr:7003/AcilNG112Middleware-war/webresources";
//
//       Response response= get(baseUrl+"/ng112rest/eventType/list");
//
//
//        System.out.println("Status Code :"+response.getStatusCode());
//        System.out.println("Response : "+ response.asString());
//        System.out.println("Body : "+response.getBody().asString());
//        System.out.println("Time taken : "+response.getTime());
//        System.out.println("Header : "+response.getHeader("content-type"));
//        int statusCode =response.getStatusCode();
//        Assert.assertEquals(statusCode,201);
//
////        if (response.getStatusCode()==200){
////            System.out.println("Deneme");
////        }
   // }
    @Test
    void CreateBoard(){
       // String baseUrl="https://api.trello.com";
        for (int x=0;x<1;x++){

        }

        RestAssured.baseURI = "https://api.trello.com";
        given().log().all()
                //.header("contentType","aContentType.JSON")
                .contentType(ContentType.JSON)
                .queryParam("name","Pano")
                .queryParam("key", "c280c8df9c716df8184e2e8432fa445f")
                .queryParam("token","b90d738b0a421d21ace7d231c68e7d6c7b47c5abc4bc8561d3afcb1714790681")
                .post("/1/boards/");
        System.out.println("status code : "+ get().getStatusCode());





    }
    @Test
    void CreateCart(){
        for (int x=1;x<3;x++){
            RestAssured.baseURI = "https://api.trello.com";
            given().log().all()
                    //.header("contentType","aContentType.JSON")
                    .contentType(ContentType.JSON)
                    .queryParam("name","Cart"+x)
                    .queryParam("key", "c280c8df9c716df8184e2e8432fa445f")
                    .queryParam("token","b90d738b0a421d21ace7d231c68e7d6c7b47c5abc4bc8561d3afcb1714790681")
                    .queryParam("idList","61a76db8b95d31254525df41")
                    .post("/1/cards");
            System.out.println("status code : "+ get().getStatusCode());
        }
    }
    @Test
    void UpdateCart(){
        RestAssured.baseURI = "https://api.trello.com";
        given().log().all()
                //.header("contentType","aContentType.JSON")
                .contentType(ContentType.JSON)
                .pathParams("id","61a770582a24cf70bfc0609b")
                .queryParam("name","sedat")
                .queryParam("desc","Açıklama")
                .queryParam("closed","false")
                .queryParam("idMembers","")
                .queryParam("idAttachmentCover","")
                .queryParam("idList","61a76db8b95d31254525df41")
                .queryParam("idLabels","")
                .queryParam("idBoard","61a76db8b95d31254525df40")
                .queryParam("pos","16384")
                .queryParam("due","")
                .queryParam("dueComplete","false")
                .queryParam("subscribed","false")
                .queryParam("address","")
                .queryParam("locationName","")
                .queryParam("coordinates","")
                .queryParam("key", "c280c8df9c716df8184e2e8432fa445f")
                .queryParam("token","b90d738b0a421d21ace7d231c68e7d6c7b47c5abc4bc8561d3afcb1714790681")

                .put("/1/cards");
        System.out.println("status code : "+ get().getStatusCode());
    }
    @Test
    void DeleteBoard(){

            baseURI="https://api.trello.com";
            given().log().all()
                    .contentType(ContentType.JSON)
                    .pathParams("id","guG3qhHH")
                    .queryParam("key", "c280c8df9c716df8184e2e8432fa445f")
                    .queryParam("token","b90d738b0a421d21ace7d231c68e7d6c7b47c5abc4bc8561d3afcb1714790681")
                    .delete("/1/boards/{id}");

            System.out.println("status code : "+ get().getStatusCode());



    }

}
