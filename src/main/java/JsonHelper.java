import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonHelper {




    public String createUrl(String location, String keyName, String radius, String rankby, String address, String endpoint, String key){
        String url = firstPart(address,endpoint) + location(location)+ keyName(keyName)+ radius(radius) + rankby(rankby);
        System.out.println("url: " + url);
        return url;
    }


    private String firstPart(String address, String endpoint){
        return address+endpoint+"?";
    }
    private String location(String location){
        if(location != null){
            return "location=" + location;
        }
        return "";
    }

    private String keyName(String keyName){
        if(keyName != null){
            return "&key=" + "AIzaSyCWOSz0D-dfNnfv7FJh6pP3dghHM9NmyuQ";  // вот тут должна быть нормальная подгрузка ключа
        }
        return "";
    }

    private String radius(String radius){
        if(radius != null){
            return "&radius=" + radius;
        }
        return "";
    }
    private String rankby(String rankby){
        if(rankby != null){
            return "&rankby=" + rankby;
        }
        return "";
    }


}