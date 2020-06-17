package dayweek;

public enum DayOfWeek2 {
    MONDAY    {public String getWorkingHours(){ return "40 часов";}},
    TUESDAY   {public String getWorkingHours(){ return "32 часов";}},
    WEDNESDAY {public String getWorkingHours(){ return "24 часа";}},
    THURSDAY  {public String getWorkingHours(){ return "16 часов";}},
    FRIDAY    {public String getWorkingHours(){ return "8 часов";}},
    SATURDAY  {public String getWorkingHours(){ return "Сегодня выходной";}},
    SUNDAY    {public String getWorkingHours(){ return "Сегодня выходной";}};

    public abstract String getWorkingHours();
}
