package dayweek;

enum DayOfWeek1 {
    MONDAY    ("40 часов"),
    TUESDAY   ("32 часа"),
    WEDNESDAY ("24 часа"),
    THURSDAY  ("16 часов"),
    FRIDAY    ("8 часов"),
    SATURDAY  ("Сегодня выходной"),
    SUNDAY    ("Сегодня выходной");

    private String workingHours;

    DayOfWeek1(String title) {
        this.workingHours = title;
    }

    public String getWorkingHours() {
        return workingHours;
    }
}
