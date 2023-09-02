import Utils.TimeAndCourse;

import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static Utils.TimeAndCourse.getCourses;

public class Main {
    public static void main(String[] args) {
        LocalTime localTime = LocalTime.now();
        LocalDate currentDate = LocalDate.now();
        DayOfWeek currentDayOfWeek = currentDate.getDayOfWeek();

        String timeTable = getCourses(Time.valueOf(localTime),currentDayOfWeek);
        // Display the result to the user
        System.out.println("The current day is " + currentDayOfWeek.toString().toLowerCase() + ".");
        System.out.println("And "+timeTable);

    }
}