package appRest;

import data.*;
import data.Product.Product;
import dbClients.MSSQLClient;

import com.fasterxml.jackson.databind.ObjectMapper;

import dbClients.MySQLClient;
import dbClients.PostgresClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class Controller {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private final AtomicLong counterJson = new AtomicLong();


    @Autowired
    //MySQLClient dbClient;
    //MSSQLClient dbClient;
    PostgresClient dbClient;


    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }


    //******************
    @RequestMapping(value = "/addCity", method = RequestMethod.POST, consumes="application/json", produces="application/json")
    public CityJson addCity(@RequestBody CityJson cityJson){
        ObjectMapper mapper = new ObjectMapper();
        String cityJsonString = "";
        try {
            cityJsonString = mapper.writeValueAsString(cityJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
        dbClient.insertCityJson(cityJsonString);
        return cityJson;
    }

    @RequestMapping(value = "/addHotel", method = RequestMethod.POST, consumes="application/json", produces="application/json")
    public void addHotel(@RequestBody HotelJson hotelJson){
        ObjectMapper mapper = new ObjectMapper();
        String hotelJsonString = "";
        try {
            hotelJsonString = mapper.writeValueAsString(hotelJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
        dbClient.insertHotelJson(hotelJsonString);
    }

    @RequestMapping(value = "/addHotelCity", method = RequestMethod.POST, consumes="application/json", produces="application/json")
    public void addHotelCity(@RequestBody HotelCityJson hotelCityJson){
        ObjectMapper mapper = new ObjectMapper();
        String hotelCityJsonString = "";
        try {
            hotelCityJsonString = mapper.writeValueAsString(hotelCityJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
        dbClient.insertHotelCityJson(hotelCityJsonString);
    }

    @RequestMapping(value = "/addJson", method = RequestMethod.POST, consumes="application/json", produces="application/json")
    public void addJson(@RequestBody CityJson cityJson){

        Date date = new Date(System.currentTimeMillis());
        Json1 json1 = new Json1(counterJson.incrementAndGet(), date.toString(), cityJson);

        ObjectMapper mapper = new ObjectMapper();
        String Json1String = "";
        try {
            Json1String = mapper.writeValueAsString(json1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        dbClient.insertJson(Json1String);
    }


    @RequestMapping(value = "/addProduct", method = RequestMethod.POST, consumes="application/json", produces="application/json")
    public void addHotelCity(@RequestBody Product product){
        ObjectMapper mapper = new ObjectMapper();


        String attributeString = "";
        String nameString = "";
        try {
            nameString = product.getName();
            attributeString = mapper.writeValueAsString(product.getAttributes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        dbClient.insertProduct(nameString, attributeString);
    }


    @RequestMapping(value = "/findAllCities", method = RequestMethod.GET, produces="application/json")
    public List<CityJson> findAllCities(){
        ObjectMapper mapper = new ObjectMapper();
        List<CityJson> cityJsonList = new ArrayList<CityJson>();
        List<String> resultList = dbClient.findAllCities();

        for (String str : resultList){
            try {
                cityJsonList.add(mapper.readValue(str, CityJson.class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  cityJsonList;
    }

    @RequestMapping(value = "/findAllHotels", method = RequestMethod.GET, produces="application/json")
    public List<HotelJson> findAllHotels(){
        ObjectMapper mapper = new ObjectMapper();
        List<HotelJson> hotelJsonList = new ArrayList<HotelJson>();
        List<String> resultList = dbClient.findAllHotels();

        for (String str : resultList){
            try {
                hotelJsonList.add(mapper.readValue(str, HotelJson.class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  hotelJsonList;
    }


    //*********
//    @RequestMapping(value = "/findCityByName", method = RequestMethod.POST, produces="application/json")
//    public CityJson findCityByName(@RequestParam(value="name") String name){
//        CityJson cityJson = null;//cityHotelService.findCityJsonByName(name);
//        return cityJson;
//    }
//
//    @RequestMapping(value = "/findHotelByName", method = RequestMethod.POST, produces="application/json")
//    public HotelJson findHotelByName(@RequestParam(value="name") String name){
//        HotelJson hotelJson = null; //cityHotelService.findHotelByName(name);
//        return hotelJson;
//    }
//
//    @RequestMapping(value = "/findHotelJsonByName", method = RequestMethod.POST, produces="application/json")
//    public HotelCityJson findHotelJsonByName(@RequestParam(value="name") String name){
//        HotelCityJson hotelCityJson = null; //cityHotelService.findHotelByName2(name);
//        return hotelCityJson;
//    }


}
