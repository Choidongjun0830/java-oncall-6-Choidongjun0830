package oncall.dto;

public class ResultDto {

    int month;
    int date;
    String day;
    String employee;

    public ResultDto(int month, int date, String day, String employee) {
        this.month = month;
        this.date = date;
        this.day = day;
        this.employee = employee;
    }

    public int getMonth() {
        return month;
    }

    public int getDate() {
        return date;
    }

    public String getDay() {
        return day;
    }

    public String getEmployee() {
        return employee;
    }
}
