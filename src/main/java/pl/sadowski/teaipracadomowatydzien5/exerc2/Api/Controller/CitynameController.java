package pl.sadowski.teaipracadomowatydzien5.exerc2.Api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sadowski.teaipracadomowatydzien5.exerc2.Client.OpenCageDataClient.OCDController;

import java.util.Optional;

@RestController
@RequestMapping("/cityname/")
@CrossOrigin
public class CitynameController {
OCDController ocdController;
@Autowired
public CitynameController(OCDController ocdController){
    this.ocdController = ocdController;
}


    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
   public ResponseEntity<String> getCitynameByLatLon(@RequestParam(name = "lat")String latitude, @RequestParam(name = "lon")String longitude){
Optional<String> info = ocdController.getCitynameByLatLon(latitude, longitude);
return info.map(inf -> new ResponseEntity<>(inf, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    };
}
