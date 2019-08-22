package commons.result;

/**
 * @Author amir
 * @CreatedAt 8/22/19
 */
public class ResultFactory {

    protected ResultFactory() {

    }

    public static <T> Result<T> ok(T data) {
        return new Result<>(200, "OK", data);
    }

    public static <T> Result<T> notFound() {
        return new Result<>(404, "Not Found", null);
    }

}
