package oncall.repository;

import oncall.domain.Employee;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class EmployeeRepository {
    //최소 5명, 최대 35명

    private Deque<Employee> employees = new ArrayDeque<>();

    public void addEmployee(Employee employee) {
        if (employees.size() >= 35) {
            throw new IllegalStateException("Cannot add more than 35 employees.");
        }
        employees.addLast(employee);
    }

    public Employee getFirst() {
        return employees.peekFirst();
    }

    public Employee pollEmployee() {
        if (employees.isEmpty()) {
            throw new IllegalStateException("No employees to remove.");
        }
        return employees.pollLast();
    }

    public void exchangeFirstSecond() {
        if (employees.size() < 2) {
            throw new IllegalStateException("Not enough employees to exchange.");
        }
        Employee first = employees.pollFirst();
        Employee second = employees.pollFirst();
        employees.addFirst(first);
        employees.addFirst(second);
    }
}
