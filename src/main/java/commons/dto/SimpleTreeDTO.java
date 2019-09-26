package commons.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

/**
 * @Author amir
 * @CreatedAt 9/26/19
 */
public abstract class SimpleTreeDTO<E, D extends LoaderDTO> extends CloneableLoaderDTO<E> implements TreeDTO<E> {

    @Setter
    @Getter
    private String name;

    @Getter
    @Setter
    private String key;

    @Getter
    @Setter
    private Collection<D> children;

}
