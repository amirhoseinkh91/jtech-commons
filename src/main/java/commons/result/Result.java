package commons.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author amir
 * @CreatedAt 8/19/19
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Result<T> {

    private Integer code;

    private String message;

    private T data;

    public Result() {
        this(null, null, null);
    }
}
