package commons.controller;

import commons.dto.FullDTO;
import commons.pagination.PageResult;
import commons.result.Result;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

/**
 * @Author amir
 * @CreatedAt 8/18/19
 */
public interface CrudController<R extends PagingAndSortingRepository, D extends FullDTO> {

    R getRepositoryInstance();

    Result<PageResult<D>> getAll(Pageable pageable, @Context HttpServletRequest servletRequest);

    Result<D> findById(Long id, @Context HttpServletRequest servletRequest);

    Result<Boolean> deleteById(Long id, @Context HttpServletRequest servletRequest);

    Result<D> add(D d, @Context HttpServletRequest servletRequest);

    Result<D> update(Long id, D d, @Context HttpServletRequest servletRequest);

}
