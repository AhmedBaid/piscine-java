import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormatDate {

    public static String formatToFullText(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return String.format("Le %d %s de l'an %d à %02dh%02dm et %02ds", dateTime.getDayOfMonth(),
                dateTime.getMonth().getDisplayName(java.time.format.TextStyle.SHORT, Locale.FRENCH),
                dateTime.getYear(),
                dateTime.getHour(),
                dateTime.getMinute(),
                dateTime.getSecond());
    }

    public static String formatSimple(LocalDate date) {
        if (date == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd yy")
                .withLocale(Locale.ITALIAN);
        String formattedDate = date.format(formatter);
        return formattedDate;
    }

    public static String formatIso(LocalTime time) {
        if (time == null) {
            return null;
        }
        return String.format("%02d:%02d:%02d", time.getHour(), time.getMinute(), time.getSecond());
    }
}
