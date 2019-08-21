package commons.controller;

import commons.dto.FullDTO;
import commons.dto.pagination.Pagination;
import commons.result.Result;
import commons.result.SimpleTabularResult;
import org.springframework.data.repository.CrudRepository;

import javax.ws.rs.BeanParam;
import java.util.Collection;
import java.util.List;

/**
 * @Author amir
 * @CreatedAt 8/18/19
 */
public interface CrudController<R extends CrudRepository, D extends FullDTO> {

    R getRepositoryInstance();

    Result<SimpleTabularResult<D>> getAll(@BeanParam Pagination pagination);

    Result<D> findById(Long id);

    Result<Boolean> deleteById(Long id);

    Result<D> add(D d);

    Result<D> update(Long id, D d);


}
