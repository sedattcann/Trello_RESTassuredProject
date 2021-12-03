import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;

import static io.restassured.RestAssured.*;

public class APITest {



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
         //String[] CartId={"61a770582a24cf70bfc0609b","61a7705ae9b7117cb4a9f767","d","f"};
        List<String >CartId=new ArrayList<>();
        CartId.add("61a770582a24cf70bfc0609b");
        CartId.add("61a7705ae9b7117cb4a9f767");
        Random random =new Random();
        int randomCart=random.nextInt(CartId.size());
        given().log().all()
                //.header("contentType","aContentType.JSON")
                .contentType(ContentType.JSON)
                .pathParam("id",CartId.get(randomCart))
                .queryParam("name","deneme")
                .queryParam("desc","açıklama")
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
                .put("/1/cards/{id}");
        System.out.println("status code : "+ get().getStatusCode());
    }
    @Test
    void GetList(){
        baseURI="https://api.trello.com";

        Response resp1=given()
                .log().all()
//                .contentType(ContentType.JSON)
//                .header("Content-Type","application/json;charset=utf-8")
                .header("accept-encoding", "gzip")
//                .contentType("application/json;charset=utf-8")

                .pathParams("id","61a89dbce5df2287ba3a0c01")
                .queryParam("key", "c280c8df9c716df8184e2e8432fa445f")
                .queryParam("token","b90d738b0a421d21ace7d231c68e7d6c7b47c5abc4bc8561d3afcb1714790681")
                .get("/1/lists/{id}");
        System.out.println("Time taken : "+get().time());
        System.out.println("StatusCode : "+get().getStatusCode());
        System.out.println("ContentType : "+get().getContentType());
        resp1.prettyPrint();
        String as=resp1.jsonPath().get("id");
        String as2=resp1.jsonPath().get("name");
        System.out.println("id : "+as+" name: "+as2);
//        System.out.println("Body"+get().getBody().asString());
        ByteArrayOutputStream bout=null;
        try {
//            System.out.println(get().getBody());
//            InflaterInputStream ini = new InflaterInputStream(new GZIPInputStream(get().getBody().asInputStream()));
//            String str=new String(Base64.getEncoder().encodeToString(get().getBody().asByteArray()));
//            byte bytes[]=str.getBytes("UTF-8");
//            bout =new ByteArrayOutputStream(512);
//            bout.write(bytes, 0, bytes.length);
//            int b;
//            while ((b = ini.read()) != -1) {
//                bout.write(b);
//            }
//            ini.close();
//            bout.close();
        } catch (Exception e){
            e.printStackTrace();
        }

//        String s=new String(bout.toByteArray());
//        System.out.println(s);
        //cart idlerini burdan almam gerkiyor.
    }

    private void readdata(InputStream stream) throws IOException {

    }
    @Test
    void DeleteCart(){
        baseURI="https://api.trello.com";
        List<String >CartId=new ArrayList<>();
        CartId.add("61a770582a24cf70bfc0609b");
        CartId.add("61a7705ae9b7117cb4a9f767");


        for (int x=0;x<CartId.size();x++){
            given().log().all()
                    .contentType(ContentType.JSON)
                    .pathParams("id",CartId.get(x))
                    .queryParam("key", "c280c8df9c716df8184e2e8432fa445f")
                    .queryParam("token","b90d738b0a421d21ace7d231c68e7d6c7b47c5abc4bc8561d3afcb1714790681")
                    .delete("/1/cards/{id}");
        }



        System.out.println("status code : "+ get().getStatusCode());
    }
    @Test
    void DeleteBoard(){

            baseURI="https://api.trello.com";


            given().log().all()
                    .contentType(ContentType.JSON)
                    .pathParams("id","s6jD1jNu")
                    .queryParam("key", "c280c8df9c716df8184e2e8432fa445f")
                    .queryParam("token","b90d738b0a421d21ace7d231c68e7d6c7b47c5abc4bc8561d3afcb1714790681")
                    .delete("/1/boards/{id}");

            System.out.println("status code : "+ get().getStatusCode());



    }

}
