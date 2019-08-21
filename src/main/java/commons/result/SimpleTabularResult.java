package commons.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.Collections;

/**
 * @Author amir
 * @CreatedAt 8/19/19
 */
@Getter
@AllArgsConstructor
public final class SimpleTabularResult<T> {

    private long itemsCount;

    private Collection<T> items;

    public SimpleTabularResult() {
        this(0, Collections.emptyList());
    }

    public static SimpleTabularResult of(Page page) {
        return new SimpleTabularResult<>(page.getTotalElements(), page.getContent());
    }

}
