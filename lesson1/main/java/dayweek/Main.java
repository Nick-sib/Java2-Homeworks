package dayweek;

import java.util.Random;

public class Main {


    public static void main(String[] args) {
        final Random random = new Random();

        DayOfWeek dayOfWeek = DayOfWeek.values()[random.nextInt(7)];
        System.out.printf("var1 From %s - %s\n", dayOfWeek, getWorkingHours(dayOfWeek));

        DayOfWeek1 dayOfWeek1 = DayOfWeek1.values()[random.nextInt(7)];
        System.out.printf("var2 From %s - %s\n", dayOfWeek1, dayOfWeek1.getWorkingHours());

        DayOfWeek2 dayOfWeek2 = DayOfWeek2.values()[random.nextInt(7)];
        System.out.printf("var3 From %s - %s\n", dayOfWeek2, dayOfWeek2.getWorkingHours());
    }

    static String getWorkingHours(DayOfWeek val){
        switch (val) {
            case MONDAY:
                return "40 часов";
            case TUESDAY:
                return "32 часа";
            case WEDNESDAY:
                return "24 часа";
            case THURSDAY:
                return "16 часов";
            case FRIDAY:
                return "8 часов";
            case SATURDAY:
            case SUNDAY:
                return "Сегодня выходной";
            default: return "Не логичная ошибка";
        }
    }
}
