package pl.sadowski.teaipracadomowatydzien5.exerc2.Client.OpenCageDataClient;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@Log4j2

public class OCDService {
@Value("${acces_key_OCD}")
private String acces_key;

    public String getCitynameByLatLon(String lat, String lon){
        RestTemplate restTemplate = new RestTemplate();
        String URL = String.format("https://api.opencagedata.com/geocode/v1/json?q=%s+%s&key=%s", lat, lon, acces_key);
        JsonNode jsonNode = restTemplate.getForObject(URL, JsonNode.class);
        Optional<JsonNode> optionalJsonNode = Optional.ofNullable(jsonNode.findValue("city")).or( ()-> Optional.ofNullable(jsonNode.findValue("village"))).or( ()-> Optional.ofNullable(jsonNode.findValue("town")));
     return optionalJsonNode.map(JsonNode::toString).orElse("NIE ZNALEZIONO");
    }
}
