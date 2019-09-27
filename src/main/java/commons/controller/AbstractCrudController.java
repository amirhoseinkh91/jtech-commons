package commons.controller;

import commons.dto.FullDTO;
import commons.exception.EntityNotFoundException;
import commons.result.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author amir
 * @CreatedAt 9/27/19
 */
@RestController
public abstract class AbstractCrudController<D extends FullDTO> implements CrudController<D> {

    @Value("${language.header.name}")
    private String languageHeaderName;

    protected Long getLanguageId(HttpServletRequest servletRequest) {
        return (long) servletRequest.getIntHeader(languageHeaderName);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public Result<String> handleEntityNotFoundException(EntityNotFoundException ex) {
        return new Result<>(404, "Not Found", "No Result Found with given data.");
    }
}
