import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import com.mashape.unirest.http.HttpResponse;




@RunWith(DataProviderRunner.class)
public class ParameterizedTest {

    @Before

    @DataProvider
    public static Object[][]dataForPositiveTest() {
        return new Object[][]{
                {"https://maps.googleapis.com/maps/api/", "place/nearbysearch/json", "55.6372523,37.5203141", "25000", null , null, null, "AIzaSyCyOG34X2U6iKWgvwGmukiaBaVr3-PkNs4",null ,null ,null}
        };
    }

    @Test
    @UseDataProvider("dataForPositiveTest")
    public void paramTest1(String address, String endpoint, String location,
                           String radius, String keyword, String rankby, String type,
                           String key, String minprice, String maxprice, String language) {

        HttpResponse<String> response = null;
        try {
            response = Unirest.get(new JsonHelper().createUrl(address, endpoint, location,
                    radius, keyword, rankby, type,key,minprice,maxprice, language))
                    .header("cache-control", "no-cache")
                    .asString();

            assertEquals(200, response.getStatus());

        } catch (UnirestException e) {
            e.printStackTrace();
        }

    }
//
//    @DataProvider
//    public static Object[][]dataForNegativeTest() {
//        return new Object[][]{
//                {"40,-73.978194", "configKey", "500", "prominence", "https://maps.googleapis.com/maps/api/" , "place/nearbysearch/json", "AIzaSyCWOSz0D-dfNnfv7FJh6pP3dghHM9NmyuQ"},
//                {"40,-73.978194", "configKey", "500", "prominence", "https://maps.googleapis.com/maps/api/" , "place/nearbysearch/json", "AIzaSyCWOSz0D-dfNnfv7FJh6pP3dghHM9NmyuQ"},
//                {"40,-73.978194", "configKey", "500", "prominence", "https://maps.googleapis.com/maps/api/" , "place/nearbysearch/json", "AIzaSyCWOSz0D-dfNnfv7FJh6pP3dghHM9NmyuQ"},
//                {"40,-73.978194", "configKey", "500", "prominence", "https://maps.googleapis.com/maps/api/" , "place/nearbysearch/json", "AIzaSyCWOSz0D-dfNnfv7FJh6pP3dghHM9NmyuQ"},
//                {"40,-73.978194", "configKey", "500", "prominence", "https://maps.googleapis.com/maps/api/" , "place/nearbysearch/json", "AIzaSyCWOSz0D-dfNnfv7FJh6pP3dghHM9NmyuQ"}
//        };
//    }
//
//    @Test
//    @UseDataProvider("dataForNegativeTest")
//    public void paramTest2(String location, String keyName, String radius, String rankby, String address, String endpoint, String key) {
//        HttpResponse<String> response = null;
//        try {
//            response = Unirest.get(new JsonHelper().createUrl(location,keyName,radius,rankby,address,endpoint,key))
//                    .header("cache-control", "no-cache")
//                    .asString();
//            assertEquals(200, response.getStatus());
//        } catch (UnirestException e) {
//            e.printStackTrace();
//        }
//
//    }

}