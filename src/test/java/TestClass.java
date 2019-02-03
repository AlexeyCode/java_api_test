import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestClass {
    @Test
    public void testMethod(){
        try {
            HttpResponse<String> response = Unirest.get("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-23.8670522,151.1957362&key=AIzaSyCyOG34X2U6iKWgvwGmukiaBaVr3-PkNs4&radius=1500")
                    .header("cache-control", "no-cache")
                    .asString();
            assert 200 == response.getStatus();

            System.out.println("test passed");
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
    @Before
    public void beforeMethod(){
        System.out.println("before");
    }
    @After
    public void afterMethod(){
        System.out.println("after");
    }
}
