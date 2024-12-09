package oncall.dto;

public class EmergencyDateDto {

    private int month;
    private String day;

    public EmergencyDateDto(int month, String day) {
        this.month = month;
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }
}
