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
}
