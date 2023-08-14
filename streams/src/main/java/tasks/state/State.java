package tasks.state;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class State {
    private List<String> cities = new ArrayList<>();
    public void addCity(String city){
        cities.add(city);
    }
    public List<String> getCities(){
        return this.cities;
    }
}
