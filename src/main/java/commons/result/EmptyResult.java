package commons.result;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author amir
 * @CreatedAt 8/19/19
 */
@Getter
@Setter
@ToString
public class EmptyResult extends Result {


    public EmptyResult() {
        super(0, "No result is found, returning empty result...!", null);
    }
}
