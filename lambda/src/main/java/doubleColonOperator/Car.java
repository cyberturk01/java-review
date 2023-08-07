package doubleColonOperator;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class Car {
    private int model;
    private String make;

    public Car() {
    }

    public Car(int model) {
        this.model=model;
    }
}
