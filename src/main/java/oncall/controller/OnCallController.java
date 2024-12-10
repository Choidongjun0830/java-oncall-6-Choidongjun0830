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
        List<LocalDate> holidays = new ArrayList<>();
        List<ResultDto> results = new ArrayList<>();
        onCallService.getEmergencyLists(weekdays, weekends);
        onCallService.initHolidays(holidays);

        int lengthOfMonth = LocalDate.of(2024, monthAndDay.getMonth(), 1).lengthOfMonth();
        Week weekday = Week.findDay(day);

        for(int date = 1; date <= lengthOfMonth; date++) {
            LocalDate today = LocalDate.of(2024, month, date);
            if(holidays.contains(today) || weekday.isHoliday()) { //휴일일 경우
                Employee employee = weekends.poll();
                results.add(new ResultDto(month, date, weekday.getDay(), employee.getName()));
                weekday = weekday.next();
            } else {
                Employee employee = weekdays.poll();
                results.add(new ResultDto(month, date, weekday.getDay(), employee.getName()));
                weekday = weekday.next();
            }

        }

        outputView.printResults(results);
    }
}
