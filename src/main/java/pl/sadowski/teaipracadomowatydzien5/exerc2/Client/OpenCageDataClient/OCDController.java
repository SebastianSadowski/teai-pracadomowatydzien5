package pl.sadowski.teaipracadomowatydzien5.exerc2.Client.OpenCageDataClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class OCDController {
private final OCDService ocdService;

@Autowired
public OCDController(OCDService ocdService){
        this.ocdService = ocdService;
    }

public Optional<String> getCitynameByLatLon(String lat, String lon){
   return Optional.of(ocdService.getCitynameByLatLon(lat, lon));
}
}
