package streamSelfStudy;

import lombok.*;

@Data
@Getter
@Setter
@ToString
public class User {
    private String name;
    private Integer age=30;

    public User(String name) {
        this.name = name;
    }
}
