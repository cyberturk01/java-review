package task1;

import lombok.*;

@Builder
@Data
public class Orange {
    private int weight;
    private Color color;
}


//@Builder generates allArgsConstructor unless there is another @XConstractor