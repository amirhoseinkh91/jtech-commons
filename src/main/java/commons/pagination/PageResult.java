package commons.pagination;

import commons.dto.LoaderDTO;
import commons.dto.util.DtoUtil;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Author amir
 * @CreatedAt 8/21/19
 */
@Setter
@Getter
@RequiredArgsConstructor
public class PageResult<D extends LoaderDTO> {

    private final long totalElements;
    private final int totalPages;
    private final int pageNumber;
    private final int size;
    private final Collection<D> content;


    protected PageResult() {
        this(0, 0, new ArrayList<>(), 1, 0);
    }

    public PageResult(long totalElements, int totalPages, Collection<D> collection, int number, int size) {
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.content = collection;
        this.pageNumber = number;
        this.size = size;
    }

    public static <D extends LoaderDTO> PageResult<D> of(Page entityPage, Class<D> dtoClass) {
        Collection<D> collection = DtoUtil.loadDtoCollection(dtoClass, entityPage.getContent());
        return new PageResult<>(entityPage.getTotalElements(), entityPage.getTotalPages(), collection, entityPage.getNumber(), entityPage.getSize());
    }

}
