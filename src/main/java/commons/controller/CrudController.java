package commons.controller;

import commons.dto.FullDTO;
import commons.pagination.PageResult;
import commons.result.Result;
import org.springframework.data.domain.Pageable;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

/**
 * @Author amir
 * @CreatedAt 8/18/19
 */
public interface CrudController<D extends FullDTO> {

    Result<PageResult<D>> getAll(Pageable pageable, @Context HttpHeaders httpHeaders);

    Result<D> findById(Long id, @Context HttpHeaders httpHeaders);

    Result<Boolean> deleteById(Long id, @Context HttpHeaders httpHeaders);

    Result<D> add(D d, @Context HttpHeaders httpHeaders);

    Result<D> update(Long id, D d, @Context HttpHeaders httpHeaders);

}
