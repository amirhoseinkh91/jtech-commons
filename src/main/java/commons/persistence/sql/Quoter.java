package commons.persistence.sql;

/**
 * @Author amir
 * @CreatedAt 8/19/19
 */
public class Quoter {

    private boolean[] doQuotes;

    public Quoter(boolean... doQuotes) {
        this.doQuotes = doQuotes;
    }

    public String[] getQuoted(String... strings) {
        int n = strings.length;
        if (n > this.doQuotes.length) {
            throw new IllegalArgumentException("given list of strings has more elements");
        } else {
            String[] qs = new String[n];

            for (int i = 0; i < n; ++i) {
                qs[i] = this.doQuotes[i] ? SqlUtil.quote(strings[i]) : strings[i];
            }

            return qs;
        }
    }

    public String comma(String... strings) {
        return SqlUtil.comma(this.getQuoted(strings));
    }

    public String comma(Object... objects) {
        return this.comma(SqlUtil.objArray2StrArray(objects));
    }

    public String tuple(String... strings) {
        return SqlUtil.tuple(this.getQuoted(strings));
    }

    public String tuple(Object... objects) {
        return this.tuple(SqlUtil.objArray2StrArray(objects));
    }

}
