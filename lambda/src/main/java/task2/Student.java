package task2;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {
    int id;

    String name;

    double percentage;

    String specialization;
}
