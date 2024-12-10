package oncall.dto;

import oncall.domain.Employee;

public class ResultDto {

    int month;
    int date;
    String day;
    Employee employee;
    String holiday;

    public ResultDto(int month, int date, String day, Employee employee, String holiday) {
        this.month = month;
        this.date = date;
        this.day = day;
        this.employee = employee;
        this.holiday = holiday;
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

    public Employee getEmployee() {
        return employee;
    }

    public String getHoliday() {
        return holiday;
    }
}
