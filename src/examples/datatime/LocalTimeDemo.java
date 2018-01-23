package examples.datatime;

import java.time.LocalTime;

import static java.lang.System.out;
import static java.time.temporal.ChronoUnit.*;

public class LocalTimeDemo {

    public static void main(String[] args){
        LocalTime now, nowPlus, nowHrsMins, lunch, bedtime;

        now = LocalTime.now();

        out.println("Now time is: "+now);

        nowPlus = now.plusHours(1).plusMinutes(15);
        out.println("Now time plus 1h and 15mins is: "+nowPlus);

        nowHrsMins = now.truncatedTo(MINUTES);
        out.println("Now time truncated to minutes: "+nowHrsMins);

        out.println("Now time in seconds from the beginning of the day: "+now.toSecondOfDay());
        out.println("Now time in minutes from the beginning of the day: "+now.toSecondOfDay()/60);

        lunch = LocalTime.of(13,30);
        out.println("My lunch time is "+lunch);
        out.println("Am I before lunch "+lunch.isAfter(now));

        long minutesToLunch = now.until(lunch, MINUTES);
        out.println("How many minutes to lunch "+minutesToLunch);

        bedtime = LocalTime.of(23,15);
        long hrsToBedTime = now.until(bedtime, HOURS);
        out.println("How many hours to bedtime "+hrsToBedTime);
    }
}
