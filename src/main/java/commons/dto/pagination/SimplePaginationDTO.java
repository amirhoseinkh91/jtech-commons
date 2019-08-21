package commons.dto.pagination;

import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * @Author amir
 * @CreatedAt 8/19/19
 */
@Setter
public class SimplePaginationDTO implements Pagination {

    private int start;
    private int len;

    @Override
    public int getStart() {
        return start;
    }

    @Override
    public int getLen() {
        return len;
    }

    @Override
    public Pageable toPageable() {
        return PageRequest.of(start, len);
    }
}
