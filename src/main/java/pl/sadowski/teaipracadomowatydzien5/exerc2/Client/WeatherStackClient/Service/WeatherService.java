package pl.sadowski.teaipracadomowatydzien5.exerc2.Client.WeatherStackClient.Service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.sadowski.teaipracadomowatydzien5.exerc2.Client.WeatherStackClient.weatherStackAPI.Response;
@Service("ClientService")
@Log4j2
public class WeatherService {
@Value("${acces_key}")
    private String accessKey;


    public Response getWeatherByCityName(String cityName) {
        RestTemplate restTemplate = new RestTemplate();

        Response info = restTemplate.getForObject(String.format("http://api.weatherstack.com/current?access_key=%s&query=%s", accessKey, cityName), Response.class);
        return info;
     }
}

