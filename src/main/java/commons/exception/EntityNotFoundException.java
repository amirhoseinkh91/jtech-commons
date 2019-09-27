package commons.exception;

/**
 * @Author amir
 * @CreatedAt 9/27/19
 */
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException() {
    }

    public EntityNotFoundException(String message) {
        super(message);
    }
}
