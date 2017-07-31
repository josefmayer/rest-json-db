package App;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Josef Mayer on 18.07.2017.
 */
public class Test {

    void testAll(){
        addCity1();
        addCity2();
        addCity3();
//        findCityByName();
//        findAllCities();
        addHotel1();
        addHotel2();
        addHotel3();
//        findHotelByName();

//        findHotelJsonByName();

        addHotelCity();

        addJson();

        addProduct1();
        addProduct2();
        addProduct3();
    }

    void addCity1(){
        given().
                contentType("application/json").
                //body("{\"name\":\"Lyon\", \"country\":\"France\"}").
                body(new File("data/city1.json")).
                //param("name", new File("data/city1.json")).
        when().
                post("/addCity").
        then().
                statusCode(200);
                //body("name", equalTo("Lyon")).
                //body("country", equalTo("France"));

    }

    void addCity2(){
        given().
                contentType("application/json").
                //body("{\"name\":\"Utrecht\", \"country\":\"Netherlands\"}").
                body(new File("data/city2.json")).
        when().
                post("/addCity").
        then().
                statusCode(200).
                body("name", equalTo("Utrecht")).
                body("country", equalTo("Netherlands"));
    }

    void addCity3(){
        given().
                contentType("application/json").
                //body("{\"name\":\"Gent\", \"country\":\"Belgium\"}").
                body(new File("data/city3.json")).
        when().
                post("/addCity").
        then().
                statusCode(200).
                body("name", equalTo("Gent")).
                body("country", equalTo("Belgium"));
    }

    void findCityByName(){
        given().
                param("name", "Lyon").
        when().
                post("/findCityByName").
        then().
                statusCode(200).
                body("name", equalTo("Lyon")).
                body("country", equalTo("France"));
    }

    void findAllCities(){
        given().
        when().
                get("/findAllCities").
        then().
                statusCode(200);
    }

    void addHotel1(){
        given().
                contentType("application/json").
                //body("{\"cityName\":\"Lyon\", \"name\":\"La Course\", \"street\":\"Rue Laroche\", \"postcode\":\"1234\"}").
                body(new File("data/hotel1.json")).
        when().
                post("/addHotel").
        then().
                statusCode(200);
    }

    void addHotel2(){
        given().
                contentType("application/json").
                //body("{\"cityName\":\"Utrecht\", \"name\":\"Hotel Balneario\", \"street\":\"Av del Cid\", \"postcode\":\"2356\"}").
                body(new File("data/hotel2.json")).
        when().
                post("/addHotel").
        then().
                statusCode(200);
    }

    void addHotel3(){
        given().
                contentType("application/json").
                //body("{\"cityName\":\"Lyon\", \"name\":\"Gravensteen\", \"street\":\"Damstraat\", \"postcode\":\"5544\"}").
                body(new File("data/hotel3.json")).
        when().
                post("/addHotel").
        then().
                statusCode(200);
    }

    void findHotelByName(){
        given().
                param("name", "La Course").
        when().
                post("/findHotelByName").
        then().
                statusCode(200).
                body("cityName", equalTo("Lyon")).
                body("name", equalTo("La Course")).
                body("street", equalTo("Rue Laroche")).
                body("postcode", equalTo("1234"));
    }

    void findHotelJsonByName(){
        given().
                param("name", "La Course").
        when().
                post("/findHotelJsonByName").
        then().
                statusCode(200);
                //body("name", equalTo("Lyon")).
                //body("country", equalTo("France"));

    }

    void addHotelCity(){
        given().
                contentType("application/json").
                //body("{\"cityName\":\"Lyon\", \"name\":\"Gravensteen\", \"street\":\"Damstraat\", \"postcode\":\"5544\"}").
                body(new File("data/hoteljson2_1.json")).
        when().
                post("/addHotelCity").
        then().
                statusCode(200);
    }

    void addJson(){
        given().
                contentType("application/json").
                //body("{\"name\":\"Lyon\", \"country\":\"France\"}").
                        body(new File("data/city1.json")).
                //param("name", new File("data/city1.json")).
                        when().
                post("/addJson").
                then().
                statusCode(200);
        //body("name", equalTo("Lyon")).
        //body("country", equalTo("France"));

    }

    void addProduct1(){
        given().
                contentType("application/json").
                body(new File("data/product1.json")).
        when().
                post("/addProduct").
                then().
                statusCode(200);
     }

    void addProduct2(){
        given().
                contentType("application/json").
                body(new File("data/product2.json")).
                when().
                post("/addProduct").
                then().
                statusCode(200);
    }
    void addProduct3(){
        given().
                contentType("application/json").
                body(new File("data/product3.json")).
                when().
                post("/addProduct").
                then().
                statusCode(200);
    }
}
