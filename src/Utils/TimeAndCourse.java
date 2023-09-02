package Utils;

import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class TimeAndCourse {
    public static String getCourses(Time time, DayOfWeek dayOfWeek){
        switch (dayOfWeek){
            case MONDAY:
                if (isTimeInRange(time, "1:00", "3:00")) {
                    return "MTH 104";
                } else if (isTimeInRange(time,"3:00","5:00")){
                    return "FEN 102";
                }else {
                    return "No courses scheduled at this time.";
                }
            case TUESDAY:
               if (isTimeInRange(time,"10:00","12:00")){
                   return "MTH 102";
               } else if (isTimeInRange(time,"2:30","4:30")) {
                   return "CHEM 104";
               }else {
                   return "No courses scheduled at this time.";
               }
            case WEDNESDAY:
                if (isTimeInRange(time,"10:00","12:00")){
                    return "MTH 104";
                } else if (isTimeInRange(time,"3:00","4:00")) {
                    return "FEN 102";
                }else {
                    return "No courses scheduled at this time.";
                }
            case THURSDAY:
                if (isTimeInRange(time,"7:00","8:00")){
                    return "GES 106";
                } else if (isTimeInRange(time,"8:00","10:00")) {
                    return "CHEM 102";
                } else if (isTimeInRange(time,"10:00","12:00")) {
                    return "FEN 104";
                } else if (isTimeInRange(time,"12:30", "2:30")) {
                    return "PHY 104";
                }else {
                    return "No courses scheduled at this time.";
                }
            case FRIDAY:
                if (isTimeInRange(time,"3:00","5:00")){
                    return "FEN 102";
                }else {
                    return "No courses scheduled at this time.";
                }
            case SATURDAY:
                if (isTimeInRange(time,"10:00","2:00")){
                    return "TUTORIAL";
                }else {
                    return "No courses scheduled at this time.";
                }
            default:
                return "UNKNOWN";
        }
    }
    private static boolean isTimeInRange(Time time, String startTimeStr, String endTimeStr) {
        try {
            LocalTime startTime = LocalTime.parse(startTimeStr);
            LocalTime endTime = LocalTime.parse(endTimeStr);
            LocalTime currentTime = LocalTime.parse(time.toString()); // Assuming Time has a proper toString() method

            return !currentTime.isBefore(startTime) && !currentTime.isAfter(endTime);
        } catch (DateTimeParseException e) {
            // Handle parsing exception, e.g., log an error or return false
            System.err.println("Error parsing time: " + e.getMessage());
            return false;
        }
    }
}
