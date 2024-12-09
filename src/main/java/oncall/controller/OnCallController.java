package oncall.controller;

import oncall.domain.Employee;
import oncall.dto.EmergencyDateDto;
import oncall.service.OnCallService;
import oncall.view.InputView;

import java.util.ArrayDeque;
import java.util.Deque;

public class OnCallController {

    private InputView inputView = new InputView();
    private OnCallService onCallService = new OnCallService();

    public void startProcess() {
        EmergencyDateDto monthAndDay = onCallService.getMonthAndDay();

        Deque<Employee> weekdays = new ArrayDeque<>();
        Deque<Employee> weekends = new ArrayDeque<>();
        onCallService.getEmergencyLists(weekdays, weekends);

        for (Employee weekend : weekends) {
            System.out.println("weekend = " + weekend);
        }

    }
}
