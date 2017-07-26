package appRest;

import java.util.Date;

public class Json1 {

    public Json1(){}

    public Json1(long id, String time, CityJson cityJson) {
        this.id = id;
        this.time = time;
        this.cityJson = cityJson;
    }

    private long id;
    private String time;
    private CityJson cityJson;

    public long getId() {
        return id;
    }

    public String getTime(){
        return time;
    }

    public CityJson getCityJson() {
        return cityJson;
    }

}
