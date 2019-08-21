package commons.dto.pagination;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

/**
 * @Author amir
 * @CreatedAt 8/19/19
 */
public interface Pagination {

    @QueryParam("start")
    @DefaultValue("0")
    long getStart();

    @QueryParam("len")
    @DefaultValue("50")
    long getLen();


}
