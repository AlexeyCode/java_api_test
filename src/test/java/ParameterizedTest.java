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
                {"55.6372523,37.5203141", "25000", null , null, null, null ,null ,null},
                {"55.6372523,37.5203141", null, null , "distance", "bar",null ,null ,null},
                {"45.7701495,4.8517567","1500","establishment", null, "bar", "0", null, "es"},
                {"45.7701495,4.8517567", null, "establishment","distance", "restaurant", null, null, "en"},
                {"45.7701495,4.8517567", "2000", "establishment" ,"prominence", "cafe", null, "4", "en"},
                {"55.6372523,37.5203141", "50000", null , null, null, null ,null ,null},
                {"55.6372523,37.5203141", "1", null , null, null, null ,null ,null},
                {"90,180", "49999", null , null, null, null ,null ,null},
                {"-90,-180", "30000", null , null, null, null ,null ,null},
                {"45.7701495,4.8517567","10500","establishment", null, "bar", "4", null, "es"},

        };
    }

    @Test
    @UseDataProvider("dataForPositiveTest")
    public  void paramTest1(String location, String radius, String keyword,
                           String rankby, String type, String minprice,
                           String maxprice, String language) {

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
                //location, radius, keyword, rankby, type, minprice, maxprice, language
                {null, "1", null , null, null, null ,null ,null},
                {"91,-181", null, null, "distance", "bar", null, null, null},
                {"-91,181", null, null, "distance", "bar", null, null, null},
                {"55,37", "50001", null , null, null, null ,null ,null},
                {"22,-11", "-1", null , null, null, null ,null ,null},
                {"45.7701495,4.8517567","2000","establishment", null, "bar", "5", null, null},
                {"45.7701495,4.8517567","2000","establishment", null, "bar", "-1", null, null},
                {"45.7701495,4.8517567","2000","establishment", null, "bar", null, "5", null},
                {"45.7701495,4.8517567","2000","establishment", null, "bar", null, "-1", null},
                {"55.6372523,37.5203141", null, null, "distance", null, null, null, null},
                {"45.7701495,4.8517567","2000", null, "distance", "bar", null, null, null},
                {"45.7701495,4.8517567","50000", null, "distance", "bar", null, "0", null}


        };
    }

    @Test
    @UseDataProvider("dataForNegativeTest")
    public  void paramTest2(String location, String radius, String keyword,
                            String rankby, String type, String minprice,
                            String maxprice, String language) {

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
}