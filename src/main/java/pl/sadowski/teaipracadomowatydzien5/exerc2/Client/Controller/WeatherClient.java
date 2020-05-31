package pl.sadowski.teaipracadomowatydzien5.exerc2.Client.Controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import pl.sadowski.teaipracadomowatydzien5.exerc2.Client.Model.weatherStackAPI.Response;

@Controller
@Log4j2
public class WeatherClient {

   @Value("${acces_key}")
   String accessKey;

   public void getWeatherByCityName(String cityName){

      RestTemplate restTemplate = new RestTemplate();


      Response info = restTemplate.getForObject(String.format("http://api.weatherstack.com/current?access_key=%s&query=%s", accessKey, cityName), Response.class);
      log.info("DUPA DUPA");
      log.info(info);
   }



   @EventListener(ApplicationReadyEvent.class)
   public void getWeatherByCityNama(){
   getWeatherByCityName("Radom");
   }
}