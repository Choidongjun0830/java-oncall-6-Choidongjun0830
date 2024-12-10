package oncall.controller;

import oncall.domain.Employee;
import oncall.domain.Week;
import oncall.dto.EmergencyDateDto;
import oncall.dto.ResultDto;
import oncall.service.OnCallService;
import oncall.view.InputView;
import oncall.view.OutputView;

import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class OnCallController {

    private InputView inputView = new InputView();
    private OnCallService onCallService = new OnCallService();
    private OutputView outputView = new OutputView();

    public void startProcess() {

        EmergencyDateDto monthAndDay = onCallService.getMonthAndDay();
        int month = monthAndDay.getMonth();
        String day = monthAndDay.getDay();

        Deque<Employee> weekdays = new ArrayDeque<>();
        Deque<Employee> weekends = new ArrayDeque<>();
        List<String> holidays = new ArrayList<>();
        onCallService.getEmergencyLists(weekdays, weekends);
        onCallService.initHolidays(holidays);

        List<ResultDto> results = new ArrayList<>();
        int lengthOfMonth = LocalDate.of(2023, monthAndDay.getMonth(), 1).lengthOfMonth();
        Week weekday = Week.findDay(day);

        processAssign(lengthOfMonth, month, holidays, weekday, weekends, results, weekdays);
        outputView.printResults(results);
    }

    private static void processAssign(int lengthOfMonth, int month, List<String> holidays, Week weekday, Deque<Employee> weekends, List<ResultDto> results, Deque<Employee> weekdays) {
        for(int date = 1; date <= lengthOfMonth; date++) {
            String today = month + "/" + date;
            Employee employee = getEmployee(holidays, weekday, weekends, weekdays, today, results);
            String isHoliday = "";
            if(holidays.contains(today)) {
                isHoliday = "(휴일)";
            }
            results.add(new ResultDto(month, date, weekday.getDay(), employee, isHoliday));
            weekday = weekday.next();
        }
    }

    private static Employee getEmployee(List<String> holidays, Week weekday, Deque<Employee> weekends, Deque<Employee> weekdays, String today, List<ResultDto> results) {
        Employee employee;
        if(holidays.contains(today) || weekday.isHoliday()) { //휴일일 경우
            employee = weekends.peek();
            if(!results.isEmpty()) {
                Employee lastEmployee = results.get(results.size() - 1).getEmployee();
                if(lastEmployee.getName().equals(employee.getName())) {
                    Employee temp = weekends.poll();
                    weekends.addFirst(employee);
                    weekends.addFirst(temp);
                }
            }
            return weekends.poll();
        }
        employee = weekdays.peek();
        if(!results.isEmpty()) {
            Employee lastEmployee = results.get(results.size() - 1).getEmployee();
            if(lastEmployee.getName().equals(employee.getName())) {
                Employee firstEmployee = weekdays.poll();
                Employee secondEmployee = weekdays.poll();
                weekdays.addFirst(firstEmployee);
                weekdays.addFirst(secondEmployee);
            }
        }
        return weekdays.poll();
    }
}
