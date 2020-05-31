package pl.sadowski.teaipracadomowatydzien5.exerc2.Client.Service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.sadowski.teaipracadomowatydzien5.exerc2.Client.Model.BasicWeatherInfo;
import pl.sadowski.teaipracadomowatydzien5.exerc2.Client.Model.weatherStackAPI.Response;
@Service
public class WeatherService {
@Value("${acces_key}")
    private String accessKey;

    public BasicWeatherInfo getWeatherByCityName(String cityName) {
        RestTemplate restTemplate = new RestTemplate();

        Response info = restTemplate.getForObject(String.format("http://api.weatherstack.com/current?access_key=%s&query=%s", accessKey, cityName), Response.class);

return new BasicWeatherInfo.BasicWeatherInfoBuilder()
        .buildCity(info.getLocation().getName())
        .buildTemperature(info.getCurrent().getTemperature())
        .buildWeatherIcons(info.getCurrent().getWeatherIcons())
        .buildWindSpeed(info.getCurrent().getWindSpeed())
        .buildWindDir(info.getCurrent().getWindDir())
        .buildPressure(info.getCurrent().getPressure())
        .buildHumidity(info.getCurrent().getHumidity())
        .buildCloudcover(info.getCurrent().getCloudcover())
        .buildBasicWeatherInfo();


     }
}

