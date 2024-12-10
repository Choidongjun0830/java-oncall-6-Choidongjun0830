package oncall.service;

import oncall.domain.Employee;
import oncall.dto.EmergencyDateDto;
import oncall.view.InputView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class OnCallService {

    private InputView inputView = new InputView();

    public EmergencyDateDto getMonthAndDay() {
        String monthAndDay = inputView.getDay();
        String[] split = monthAndDay.split(",");
        int month = Integer.parseInt(split[0]);
        String day = split[1];

        return new EmergencyDateDto(month, day);
    }

    public void getEmergencyLists(Deque<Employee> weekdays, Deque<Employee> weekends) {
        String weekDayInput = inputView.getWeekDay();
        List<String> weekDay = Arrays.asList(weekDayInput.split(","));
        List<Employee> employeeWeekday = convertEmployeeList(weekDay);
        for (Employee employee : employeeWeekday) {
            weekdays.addLast(employee);
        }

        String weekendInput = inputView.getWeekend();
        List<String> weekend = Arrays.asList(weekendInput.split(","));
        List<Employee> employeeWeekend = convertEmployeeList(weekend);
        for (Employee employee : employeeWeekend) {
            weekends.addLast(employee);
        }
    }

    public void initHolidays(List<LocalDate> holidays) {
        holidays.add(LocalDate.of(2023, 1, 1));
        holidays.add(LocalDate.of(2023, 3, 1));
        holidays.add(LocalDate.of(2023, 5, 5));
        holidays.add(LocalDate.of(2023, 6, 6));
        holidays.add(LocalDate.of(2023, 8, 15));
        holidays.add(LocalDate.of(2023, 10, 3));
        holidays.add(LocalDate.of(2023, 10, 9));
        holidays.add(LocalDate.of(2023, 12, 25));
    }


    private List<Employee> convertEmployeeList(List<String> list) {
        return list.stream()
                .map(Employee::new)
                .toList();
    }


}
