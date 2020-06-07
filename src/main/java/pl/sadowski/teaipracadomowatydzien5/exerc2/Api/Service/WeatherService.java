package pl.sadowski.teaipracadomowatydzien5.exerc2.Api.Service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.sadowski.teaipracadomowatydzien5.exerc2.Api.Model.BasicWeatherInfo;
import pl.sadowski.teaipracadomowatydzien5.exerc2.Client.WeatherStackClient.weatherStackAPI.Response;

import java.util.Optional;

@Service("ApiService")
@Log4j2
public class WeatherService {

    private pl.sadowski.teaipracadomowatydzien5.exerc2.Client.WeatherStackClient.Controller.WeatherClient weatherClient;


    @Autowired
    public WeatherService(@Qualifier("ClientController") pl.sadowski.teaipracadomowatydzien5.exerc2.Client.WeatherStackClient.Controller.WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    public Optional<BasicWeatherInfo> getWeatherByCityname(String cityname) {
        Response info = weatherClient.getWeatherByCityName(cityname);
        BasicWeatherInfo opt = new BasicWeatherInfo.BasicWeatherInfoBuilder()
                .buildCity(info.getLocation().getName())
                .buildTemperature(info.getCurrent().getTemperature())
                .buildWeatherIcons(info.getCurrent().getWeatherIcons())
                .buildWindSpeed(info.getCurrent().getWindSpeed())
                .buildWindDir(info.getCurrent().getWindDir())
                .buildPressure(info.getCurrent().getPressure())
                .buildHumidity(info.getCurrent().getHumidity())
                .buildCloudcover(info.getCurrent().getCloudcover())
                .buildBasicWeatherInfo();

        return Optional.of(opt);
    }
}
