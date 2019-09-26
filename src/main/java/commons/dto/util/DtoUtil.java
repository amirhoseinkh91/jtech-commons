package commons.dto.util;

import commons.dto.CloneableLoaderDTO;
import commons.dto.LoaderDTO;
import commons.dto.SaverDTO;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @Author amir
 * @CreatedAt 8/19/19
 */
public class DtoUtil {

    protected DtoUtil() {
    }

    public static <E, D extends SaverDTO> Collection<E> getEntities(Collection<D> dtoItems, Collection<E> entityCollection, Class<E> eClazz) {

        try {
            if (dtoItems != null) {
                Iterator var3 = dtoItems.iterator();
                E e = eClazz.newInstance();
                while (var3.hasNext()) {
                    D dto = (D) var3.next();
                    dto.saveTo(e);
                    entityCollection.add(e);
                }
            }
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }

        return entityCollection;
    }

    public static <E, D extends SaverDTO<E>> E saveDtoAndGetObject(D dto, E object) {
        if (dto == null) {
            return null;
        } else if (object == null) {
            throw new IllegalArgumentException("entity to save is null.");
        } else {
            dto.saveTo(object);
            return object;
        }
    }

    protected static <D> D createDto(Class<D> dtoClass) {
        try {
            return dtoClass.newInstance();
        } catch (IllegalAccessException | InstantiationException var2) {
            throw new IllegalArgumentException("Could not instanciate dto from class " + dtoClass, var2);
        }
    }

    public static <E, D extends LoaderDTO<E>> D createAndLoadDto(Class<D> dtoClass, E object) {
        if (object == null) {
            return null;
        } else {
            D dto = (D) createDto(dtoClass);
            dto.loadFrom(object);
            return dto;
        }
    }

    public static <E, D extends LoaderDTO<E>> Collection<D> loadDtoCollection(Class<D> dtoClass, Collection<E> entities) {
        if (entities == null) {
            return null;
        } else {
            Collection<D> result = new HashSet<>();
            for (E e : entities) {
                D dto = (D) createDto(dtoClass);
                dto.loadFrom(e);
                result.add(dto);
            }
            return result;
        }
    }

    public static <E, D extends CloneableLoaderDTO<E>> Collection<D> loadDtoCollection(D d, Collection<E> entities) {
        if (entities != null) {
            try {

                Collection<D> result = new HashSet<>();
                for (E e : entities) {
                    D dto = (D) d.clone();
                    dto.loadFrom(e);
                    result.add(dto);
                }
                return result;
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
