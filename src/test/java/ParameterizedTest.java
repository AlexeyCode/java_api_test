import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;
import com.mashape.unirest.http.HttpResponse;

import java.util.Arrays;



@RunWith(Parameterized.class)
public class ParameterizedTest {
    private String location;
    private String keyName;
    private String radius;
    private String rankby;
    public String address;
    public String endpoint;
    public String key;       // захордкожено не используеться
    public String status;

    public ParameterizedTest(String location, String keyName, String radius, String rankby, String address, String endpoint, String key) {
        this.location = location;
        this.keyName = keyName;
        this.radius = radius;
        this.rankby = rankby;
        this.address = address;
        this.endpoint = endpoint;
        this.key = key;
    }

    @Parameterized.Parameters()
    public static Iterable<Object[]> dataForTest() {
        return Arrays.asList(new Object[][]{
                {"40.765738,-73.978194", "configKey", "500", "prominence", "https://maps.googleapis.com/maps/api/" , "place/nearbysearch/json", "AIzaSyCWOSz0D-dfNnfv7FJh6pP3dghHM9NmyuQ"},
                {"40.765738,-73.978194", "configKey", "500", "prominence", "https://maps.googleapis.com/maps/api/" , "place/nearbysearch/json", "AIzaSyCWOSz0D-dfNnfv7FJh6pP3dghHM9NmyuQ"},
                {"40.765738,-73.978194", "configKey", "500", "prominence", "https://maps.googleapis.com/maps/api/" , "place/nearbysearch/json", "AIzaSyCWOSz0D-dfNnfv7FJh6pP3dghHM9NmyuQ"},
                {"40.765738,-73.978194", "configKey", "500", "prominence", "https://maps.googleapis.com/maps/api/" , "place/nearbysearch/json", "AIzaSyCWOSz0D-dfNnfv7FJh6pP3dghHM9NmyuQ"},
                {"40.765738,-73.978194", "configKey", "500", "prominence", "https://maps.googleapis.com/maps/api/" , "place/nearbysearch/json", "AIzaSyCWOSz0D-dfNnfv7FJh6pP3dghHM9NmyuQ"}
        });
    }

    @Test
    public void paramTest() {
        HttpResponse<String> response = null;
        try {
            response = Unirest.get(new JsonHelper().createUrl(location,keyName,radius,rankby,address,endpoint,key))
                    .header("cache-control", "no-cache")
                    .asString();
            assertEquals(200, response.getStatus());
        } catch (UnirestException e) {
            e.printStackTrace();
        }

    }
}