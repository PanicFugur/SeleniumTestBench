package drillproductions.data;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class DataReader {
    public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException {
        String jsonData = "";
        jsonData = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);

        ObjectMapper objectMapper = new ObjectMapper();
        List<HashMap<String, String>> result = objectMapper.readValue(jsonData, new TypeReference<List<HashMap<String, String>>>() {
        });
        return result;




    }
}
