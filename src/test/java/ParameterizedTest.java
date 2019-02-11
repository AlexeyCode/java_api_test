import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import com.mashape.unirest.http.HttpResponse;


@RunWith(DataProviderRunner.class)
public class ParameterizedTest {


    @DataProvider
    public static Object[][]dataForPositiveTest() {
        return new Object[][]{
                //location, radius, keyword, rankby, type, minprice, maxprice, language
                {"55.6372523,37.5203141", "25000", null , null, null, null ,null ,null, "OK"},
                {"55.6372523,37.5203141", null, null , "distance", "bar",null ,null ,null, "OK"},
                {"45.7701495,4.8517567","1500","establishment", null, "bar", "0", null, "es", "OK"},
                {"45.7701495,4.8517567", null, "establishment","distance", "restaurant", null, null,"en", "OK"},
                {"45.7701495,4.8517567", "2000", "establishment" ,"prominence", "cafe", null, "4",null,  "en", "OK"},
                {"55.6372523,37.5203141", "50000", null , null, null, null ,null ,null, "OK"},
                {"55.6372523,37.5203141", "1", null , null, null, null ,null ,null, "OK"},
                {"90,180", "49999", null , null, null, null ,null ,null, "OK"},
                {"-90,-180", "30000", null , null, null, null ,null ,null, "OK"},
                {"45.7701495,4.8517567","10500","establishment", null, "bar", "4", null, null, "OK"}

        };
    }

    @Test
    @UseDataProvider("dataForPositiveTest")
    public  void positiveTest(String location, String radius, String keyword,
                           String rankby, String type, String minprice,
                           String maxprice, String language, String statusMessage) {

        HttpResponse<String> response = null;

        try {
            response = Unirest.get(new JsonHelper().createUrl(location,
                    radius, keyword, rankby, type ,minprice,maxprice, language))
                    .header("cache-control", "no-cache")
                    .asString();

            assertEquals(200, response.getStatus());


        } catch (UnirestException e) {
            e.printStackTrace();
        }

    }

    @DataProvider
    public static Object[][]dataForNegativeTest() {
        return new Object[][]{
                //location, radius, keyword, rankby, type, minprice, maxprice, language, statusMessage
                {null, "1", null , null, null, null ,null ,null, "OK"},
                {"91,-181", null, null, "distance", "bar", null, null, null, "OK"},
                {"-91,181", null, null, "distance", "bar", null, null, null, "OK"},
                {"55,37", "50001", null , null, null, null ,null ,null,"OK"},
                {"22,-11", "-1", null , null, null, null ,null ,null, "OK"},
                {"45.7701495,4.8517567","2000","establishment", null, "bar", "5", null, null, "OK"},
                {"45.7701495,4.8517567","2000","establishment", null, "bar", "-1", null, null, "OK"},
                {"45.7701495,4.8517567","2000","establishment", null, "bar", null, "5", null, "OK"},
                {"45.7701495,4.8517567","2000","establishment", null, "bar", null, "-1", null, "OK"},
                {"55.6372523,37.5203141", null, null, "distance", null, null, null, null, "OK"},
                {"45.7701495,4.8517567","2000", null, "distance", "bar", null, null, null, "OK"},
                {"45.7701495,4.8517567","50000", null, "distance", "bar", null, "0", null, "OK"},


        };
    }

    @Test
    @UseDataProvider("dataForNegativeTest")
    public  void negativeTest(String location, String radius, String keyword,
                            String rankby, String type, String minprice,
                            String maxprice, String language, String statusMessage) {

        HttpResponse<String> response = null;

        try {
            response = Unirest.get(new JsonHelper().createUrl(location,
                    radius, keyword, rankby, type ,minprice,maxprice, language))
                    .header("cache-control", "no-cache")
                    .asString();

            assertEquals(200, response.getStatus());


            System.out.println(JsonHelper.getResponseParam(response.getBody()).status);

        } catch (UnirestException e) {
            e.printStackTrace();
        }


    }
}