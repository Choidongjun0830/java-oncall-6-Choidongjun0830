package oncall.service;

import oncall.domain.Employee;
import oncall.dto.EmergencyDateDto;
import oncall.validator.InputValidator;
import oncall.view.InputView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class OnCallService {

    InputView inputView = new InputView();
    InputValidator inputValidator = new InputValidator();

    public EmergencyDateDto getMonthAndDay() {
        while(true) {
            try {
                String monthAndDay = inputView.getDay();
                String[] split = monthAndDay.split(",");
                String month = split[0];
                String day = split[1];
                inputValidator.validateMonth(month);
                inputValidator.validateDays(day);
                return new EmergencyDateDto(Integer.parseInt(month), day);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void getEmergencyLists(Deque<Employee> weekdays, Deque<Employee> weekends) {
        List<String> weekDay = getWeekDayLists();
        List<Employee> employeeWeekday = convertEmployeeList(weekDay);
        for (Employee employee : employeeWeekday) {
            inputValidator.validateNameString(employee.getName());
            weekdays.addLast(employee);
        }

        List<String> weekend = getWeekEndLists();
        List<Employee> employeeWeekend = convertEmployeeList(weekend);
        for (Employee employee : employeeWeekend) {
            inputValidator.validateNameString(employee.getName());
            weekends.addLast(employee);
        }
    }

    private List<String> getWeekDayLists() {
        while(true) {
            try {
                String weekDayInput = inputView.getWeekDay();
                List<String> weekDay = Arrays.asList(weekDayInput.split(","));
                inputValidator.validateEmployeeList(weekDay);
                validateName(weekDay);
                return weekDay;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<String> getWeekEndLists() {
        while(true) {
            try {
                String weekendInput = inputView.getWeekend();
                List<String> weekend = Arrays.asList(weekendInput.split(","));
                inputValidator.validateEmployeeList(weekend);
                validateName(weekend);
                return weekend;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private void validateName(List<String> weekDay) {
        for (String name : weekDay) {
            inputValidator.validateNameString(name);
        }
    }

    public void initHolidays(List<String> holidays) {
        holidays.add("1/1");
        holidays.add("3/1");
        holidays.add("5/5");
        holidays.add("6/6");
        holidays.add("8/15");
        holidays.add("10/3");
        holidays.add("10/9");
        holidays.add("12/25");
    }

    private List<Employee> convertEmployeeList(List<String> list) {
        List<Employee> employees = new ArrayList<>();
        for (String emp : list) {
            emp = emp.trim();
            Employee employee = new Employee(emp);
            employees.add(employee);
        }
        return employees;
    }


}
