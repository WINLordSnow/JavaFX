import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtil {
    //private static final String DATE_PATTERN = "E dd.MM.yyyy' в 'hh:mm:ss";
    private static final String DATE_PATTERN = "dd.MM.yyyy";
    private static final DateTimeFormatter DATE_FORMATTER= DateTimeFormatter.ofPattern(DATE_PATTERN);

    /**
     * From date to string.
     *
     * @param date date.
     * @return date in string.
     */
    public static String format(LocalDate date) {
        if (date == null) {
            return null;
        }
        return DATE_FORMATTER.format(date);
    }

    /**
     * From string to date.
     *
     * @param dateString date in string.
     * @return date.
     */
    public static LocalDate parse(String dateString) {
        try {
            return DATE_FORMATTER.parse(dateString, LocalDate::from);
        } catch (DateTimeParseException ex) {
            return null;
        }
    }
}
