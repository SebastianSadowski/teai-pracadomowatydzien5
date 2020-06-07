package pl.sadowski.teaipracadomowatydzien5.exerc2.Api.Model;

import lombok.*;

import java.util.List;
@ToString
public class BasicWeatherInfo {

    public String city;
    public Integer temperature;
    public List<String> weatherIcons = null;
    public Integer windSpeed;
    public String windDir;
    public Integer pressure;
    public Integer humidity;
    public Integer cloudcover;


    public BasicWeatherInfo(BasicWeatherInfoBuilder basicWeatherInfoBuilder){
       this.city = basicWeatherInfoBuilder.city;
       this.temperature = basicWeatherInfoBuilder.temperature;
       this.weatherIcons = basicWeatherInfoBuilder.weatherIcons;
       this.windSpeed = basicWeatherInfoBuilder.windSpeed;
       this.windDir = basicWeatherInfoBuilder.windDir;
       this.pressure = basicWeatherInfoBuilder.pressure;
       this.humidity = basicWeatherInfoBuilder.humidity;
       this.cloudcover = basicWeatherInfoBuilder.cloudcover;
    }


    public static class BasicWeatherInfoBuilder {
        private String city;
        private Integer temperature;
        private List<String> weatherIcons = null;
        private Integer windSpeed;
        private String windDir;
        private Integer pressure;
        private Integer humidity;
        private Integer cloudcover;

        public BasicWeatherInfoBuilder buildCity(String city) {
            this.city = city;
            return this;
        }

        public BasicWeatherInfoBuilder buildTemperature(Integer temperature) {
            this.temperature = temperature;
            return this;
        }

        public BasicWeatherInfoBuilder buildWeatherIcons(List<String> weatherIcons) {
            this.weatherIcons = weatherIcons;
            return this;
        }

        public BasicWeatherInfoBuilder buildWindSpeed(Integer windSpeed) {
            this.windSpeed = windSpeed;
            return this;
        }

        public BasicWeatherInfoBuilder buildWindDir(String windDir) {
            this.windDir = windDir;
            return this;
        }

        public BasicWeatherInfoBuilder buildPressure(Integer pressure) {
            this.pressure = pressure;
            return this;
        }
        public BasicWeatherInfoBuilder buildHumidity(Integer humidity){
            this.humidity = humidity;
            return this;
        }
        public BasicWeatherInfoBuilder buildCloudcover(Integer cloudcover){
            this.cloudcover = cloudcover;
            return this;
        }


        public BasicWeatherInfo buildBasicWeatherInfo() {
            return new BasicWeatherInfo(this);

        }
    }
}