package oncall.domain;

public enum Week {

    MON("월", false),
    TUE("화", false),
    WEN("수", false),
    THU("목", false),
    FRI("금", false),
    SAT("토", true),
    SUN("일", true);

    String day;
    boolean isHoliday;

    Week(String day, boolean isHoliday) {
        this.day = day;
        this.isHoliday = isHoliday;
    }

    public String getDay() {
        return day;
    }

    public boolean isHoliday() {
        return isHoliday;
    }

    public static Week findDay(String day) {
        for (Week week : Week.values()) {
            if (week.day.equals(day)) {
                return week;
            }
        }
        throw new IllegalArgumentException("해당 요일을 찾을 수 없습니다: " + day);
    }

    public Week next() {
        return values()[(ordinal() + 1) % values().length];
    }
}
