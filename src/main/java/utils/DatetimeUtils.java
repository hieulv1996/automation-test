package utils;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DatetimeUtils {
    public static final String FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String FORMAT_DD_MM_YYYY = "dd/MM/yyyy";
    public static final String TIME_FORMAT_DD_MMM_YYYY_HH_MM_SS = "dd-MMM-yyyy HH:mm:ss";
    public static final String TIME_FORMAT_DD_MMM_YYYY_HH_MM_A = "dd MMM yyyy, hh:mm a";
    public static final String TIME_FORMAT_LOG = "yyyyMMdd";
    public static final String FORMAT_DD_MM_YYYY_HH_MM_SS_NO_SPACE = "ddMMyyyyHHmmss";
    public static final String FORMAT_HH_MM_A = "hh:mma";
    public static final String FORMAT_HH_MM_A_DD_HH = "hh:mma dd MMM";
    public static final String FORMAT_DD_MM_HH_MM_A = "dd MMM";
    public static final String FORMAT_DD_MM_YYYY_HYPHEN = "dd-MM-yyyy";
    public static final String FORMAT_DD_MMM_YYYY = "dd-MMM-yyyy";
    public static final String DATE_FORMAT_ISO_8601_PE = "yyyy-MM-dd'T'HH:mm:ssZ";

    public static final SimpleDateFormat simpleDateFormat_YYYY_MM_DD = new SimpleDateFormat(FORMAT_YYYY_MM_DD);

    public static Date convertStringToDate(String input, String pattern) throws ParseException {
        if (StringUtils.isNotBlank(input)) {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.parse(input);
        }
        return null;
    }

    public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public static Long getDateDuration(Date studentDob) {
        Date currentDate = new Date();
        long diffInMillies = Math.abs(studentDob.getTime() - currentDate.getTime());
        return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

    public static List<LocalDate> getDatesBetween(LocalDate startDate, LocalDate endDate) {
        long numOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        return IntStream.iterate(0, i -> i + 1)
                .limit(numOfDaysBetween)
                .mapToObj(i -> startDate.plusDays(i))
                .collect(Collectors.toList());
    }

    public static long getMonthDuration(Date borrowDate, Date dateNow) {
        LocalDate localDateBorrow = convertToLocalDateViaInstant(borrowDate);
        LocalDate localCurrentDate = convertToLocalDateViaInstant(dateNow);
        return ChronoUnit.MONTHS.between(localDateBorrow, localCurrentDate);
    }

    public static int getMonthDuration(Date borrowDate) {
        LocalDate localDateBorrow = convertToLocalDateViaInstant(borrowDate);
        int borrowDay = localDateBorrow.getDayOfMonth();

        LocalDate localCurrentDate = convertToLocalDateViaInstant(new Date());
        int currentDay = localCurrentDate.getDayOfMonth();

        long monthsBetween = ChronoUnit.MONTHS.between(
                localDateBorrow.withDayOfMonth(1),
                localCurrentDate.withDayOfMonth(1));

        int fee = 0;
        if (monthsBetween == 3) {
            if (currentDay > borrowDay) {
                fee = 1;
            }
        } else if (monthsBetween > 3) {
            if (currentDay > borrowDay) {
                monthsBetween = monthsBetween + 1;
            }
            fee = (int) monthsBetween - 3;
        }
        return fee;
    }


}
