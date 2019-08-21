package commons.dto.pagination;

import lombok.Setter;

/**
 * @Author amir
 * @CreatedAt 8/19/19
 */
@Setter
public class SimplePaginationDTO implements Pagination {

    private long start;
    private long len;

    @Override
    public long getStart() {
        return start;
    }

    @Override
    public long getLen() {
        return len;
    }
}
