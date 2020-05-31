package pl.sadowski.teaipracadomowatydzien5.exerc2.Client.Controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import pl.sadowski.teaipracadomowatydzien5.exerc2.Client.Model.BasicWeatherInfo;
import pl.sadowski.teaipracadomowatydzien5.exerc2.Client.Service.WeatherService;

@Controller
@Log4j2
public class WeatherClient {

   WeatherService weatherService;

   @Autowired
public WeatherClient(WeatherService weatherService){
      this.weatherService = weatherService;
   }
   public void getWeatherByCityName(String cityName){
      log.info(weatherService.getWeatherByCityName(cityName));
   }


   @EventListener(ApplicationReadyEvent.class)
   void geta(){
      getWeatherByCityName("Warsaw");
   }
}