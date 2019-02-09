
public class JsonHelper {




    public String createUrl(String address, String endpoint, String location,
                            String radius, String keyword, String rankby, String type,
                            String key, String minprice, String maxprice, String language){

        String url = firstPart(address,endpoint) + location(location) + radius(radius)
                + keyword(keyword) + rankby(rankby) + type(type) + key(key)
                + minprice(minprice) + maxprice(maxprice) + language(language) ;

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

    private String keyword(String keyword){
        if(keyword != null){
            return "&keyword=" + keyword;
        }
        return "";
    }

    private String type(String type){
        if(type != null){
            return "&type=" + type;
        }
        return "";
    }

    private String key(String key){
        if(key != null){
            return "&key=" + "AIzaSyCWOSz0D-dfNnfv7FJh6pP3dghHM9NmyuQ";  // вот тут должна быть нормальная подгрузка ключа
        }
        return "";
    }

    private String minprice(String minprice){
        if(minprice != null){
            return "&minprice=" + minprice;
        }
        return "";
    }

    private String maxprice(String maxprice){
        if(maxprice != null){
            return "&maxprice=" + maxprice;
        }
        return "";
    }

    private String language(String language){
        if(language != null){
            return "&language=" + language;
        }
        return "";
    }

}