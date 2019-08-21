package commons.dto;

/**
 * @Author amir
 * @CreatedAt 8/19/19
 */
@FunctionalInterface
public interface SaverDTO<E> {

    void saveTo(E e);

}
