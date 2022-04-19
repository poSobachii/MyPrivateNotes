package u001Usefull;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class TimeDateComparison {


    public static void main(String[] args) {
        ZonedDateTime time = ZonedDateTime.now().minusDays(90);
        System.out.println(time);

        LocalDateTime localTime = LocalDateTime.now().minusDays(90);
        System.out.println(localTime);
    }
}
