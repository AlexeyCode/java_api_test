
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
                {"55.6372523,37.5203141", "25000", null , null, null, null ,null ,null},
                {"55.6372523,37.5203141", null, null , "rankby=distance", "bar",null ,null ,null}
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


}