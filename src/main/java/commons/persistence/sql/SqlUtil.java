package commons.persistence.sql;

/**
 * @Author amir
 * @CreatedAt 8/19/19
 */
public class SqlUtil {

    protected static String[] objArray2StrArray(Object[] objs) {
        String[] res = new String[objs.length];

        for (int i = 0; i < objs.length; ++i) {
            res[i] = "" + objs[i];
        }

        return res;
    }

    public static String comma(String... strings) {
        String result = "";
        int i = 0;
        String[] var3 = strings;
        int var4 = strings.length;

        for (int var5 = 0; var5 < var4; ++var5) {
            String str = var3[var5];
            result = result + (i++ > 0 ? ", " : "") + str;
        }

        return result;
    }

    public static String comma(Object... objects) {
        return comma(objArray2StrArray(objects));
    }

    public static String tuple(String... strings) {
        return "(" + comma(strings) + ")";
    }

    public static String tuple(Object... objects) {
        return tuple(objArray2StrArray(objects));
    }

    public static String table(String tableName, String... columnNames) {
        return tableName + tuple(columnNames);
    }

    public static String insertIntoTable(String tableName, String... columnNames) {
        return "insert into " + table(tableName, columnNames);
    }

    public static String values(String... tuples) {
        return " values " + comma(tuples);
    }

    public static String values(Object... tuples) {
        return values(objArray2StrArray(tuples));
    }

    public static String quote(String s) {
        return "'" + s + "'";
    }

    public static String quote(Object s) {
        return "'" + s + "'";
    }
}
