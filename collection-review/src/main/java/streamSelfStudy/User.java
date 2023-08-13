package streamSelfStudy;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@ToString
public class User {
    private String name;
    private Integer age=30;
    List<String> phoneNumber;

    public User(String name) {
        this.name = name;
    }

    public User(String name, Integer age, List<String> phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }
}
