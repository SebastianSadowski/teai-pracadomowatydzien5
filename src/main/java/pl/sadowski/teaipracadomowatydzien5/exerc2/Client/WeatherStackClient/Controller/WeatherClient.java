package pl.sadowski.teaipracadomowatydzien5.exerc2.Client.WeatherStackClient.Controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.sadowski.teaipracadomowatydzien5.exerc2.Client.WeatherStackClient.weatherStackAPI.Response;
import pl.sadowski.teaipracadomowatydzien5.exerc2.Client.WeatherStackClient.Service.WeatherService;

@Controller("ClientController")
@Log4j2
public class WeatherClient {

    WeatherService weatherService;

    @Autowired
    public WeatherClient(WeatherService weatherService) {
        this.weatherService = weatherService;
    }




    public Response getWeatherByCityName(String cityName) {
        return weatherService.getWeatherByCityName(cityName);
    }


}