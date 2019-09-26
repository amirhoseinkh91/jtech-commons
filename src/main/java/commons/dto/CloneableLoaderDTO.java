package commons.dto;

/**
 * @Author amir
 * @CreatedAt 9/26/19
 */
public abstract class CloneableLoaderDTO<E> implements LoaderDTO<E>, Cloneable {

    @Override
    public Object clone() throws CloneNotSupportedException {
        return  super.clone();
    }

}
