package commons.dto;

/**
 * @Author amir
 * @CreatedAt 8/19/19
 */
@FunctionalInterface
public interface LoaderDTO<E> {

    void loadFrom(E e);

}
