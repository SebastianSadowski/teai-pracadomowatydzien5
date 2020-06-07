package pl.sadowski.teaipracadomowatydzien5.exerc2.Api.Controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sadowski.teaipracadomowatydzien5.exerc2.Api.Model.BasicWeatherInfo;
import pl.sadowski.teaipracadomowatydzien5.exerc2.Api.Service.WeatherService;
import pl.sadowski.teaipracadomowatydzien5.exerc2.Config.MyClass;

import java.util.Optional;


@MyClass
@Controller
@RequestMapping("/weather/")
@Log4j2
@CrossOrigin

public class WeatherController {


    private final WeatherService weatherService;

    @Autowired
    public WeatherController(@Qualifier("ApiService") WeatherService weatherService){
        this.weatherService = weatherService;
    }

@GetMapping("{cityname}")
public ResponseEntity<BasicWeatherInfo> getWeatherByCityname(@PathVariable(name = "cityname") String city){
        log.info(city);
    Optional<BasicWeatherInfo> info = weatherService.getWeatherByCityname(city);
    info.ifPresent(i -> log.info(i.toString()));
    return info.map((inf) -> new ResponseEntity<>(inf, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
}

}
