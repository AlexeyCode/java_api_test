import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class JsonReader  {
    public static String getBaseUrl(String configPath) {
        String baseUrl = "";
        byte[] mapData = null;
        Map<String, String> jsonMap = new HashMap<>();
        try {
            mapData = Files.readAllBytes(Paths.get(configPath));
            ObjectMapper objectMapper = new ObjectMapper();

            jsonMap = objectMapper.readValue(mapData, HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return baseUrl = jsonMap.get("address") + jsonMap.get("endpoint") + "?key=" + jsonMap.get("key");

    }

    public static void main( String[] args ) {
        System.out.println(getBaseUrl("src\\main\\resources\\json\\config.json"));
    }


    }







