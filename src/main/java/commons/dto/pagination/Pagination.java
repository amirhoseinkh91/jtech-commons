package commons.dto.pagination;

import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

/**
 * @Author amir
 * @CreatedAt 8/19/19
 */
public interface Pagination {

    @QueryParam("start")
    @DefaultValue("0")
    int getStart();

    @QueryParam("len")
    @DefaultValue("50")
    int getLen();

    @Transient
    Pageable toPageable();

}
