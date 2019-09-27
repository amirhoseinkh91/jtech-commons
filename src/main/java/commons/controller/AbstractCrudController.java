package commons.controller;

import commons.dto.FullDTO;
import commons.exception.EntityNotFoundException;
import commons.result.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.ws.rs.core.HttpHeaders;

/**
 * @Author amir
 * @CreatedAt 9/27/19
 */
public abstract class AbstractCrudController<D extends FullDTO, R extends JpaRepository> implements CrudController<D> {

    protected abstract R getRepositoryInstance();

    protected abstract Class<D> getFullDtoClass();

    protected Long getLanguageId(HttpHeaders httpHeaders) {
        return Long.parseLong(httpHeaders.getRequestHeaders().getFirst("${language.header.name}").trim());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public Result<String> handleEntityNotFoundException(EntityNotFoundException ex) {
        return new Result<>(404, "Not Found", "No Result Found with given data.");
    }
}
