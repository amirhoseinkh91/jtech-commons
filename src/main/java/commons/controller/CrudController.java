package commons.controller;

import commons.dto.FullDTO;
import commons.pagination.PageResult;
import commons.result.Result;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @Author amir
 * @CreatedAt 8/18/19
 */
public interface CrudController<R extends PagingAndSortingRepository, D extends FullDTO> {

    R getRepositoryInstance();

    Result<PageResult<D>> getAll(Pageable pageable);

    Result<D> findById(Long id);

    Result<Boolean> deleteById(Long id);

    Result<D> add(D d);

    Result<D> update(Long id, D d);

}
