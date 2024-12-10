package oncall.validator;

import oncall.utils.Regex;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputValidator {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+");
    //음수 허용 안하려면 \\d+
    public InputValidator() {
    }

    public void validateNumber(String input) {
        validateIsNumeric(input);
        validateRange(input);
    }

    public void validateNull(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] NULL이 될 수 없습니다.");
        }
    }

    public void validateIsNumeric(String input) {
        if (!NUMBER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
    }

    public void validateRange(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력 범위를 초과한 입력입니다.");
        }
    }

    public void validateMonth(String input) {
        List<Integer> months = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12);
        if(!months.contains(Integer.parseInt(input))) {
            throw new IllegalArgumentException("[ERROR] 입력 범위를 초과한 입력입니다.");
        }
    }

    public void validateDays(String input) {
        List<String> days = Arrays.asList("월", "화", "수", "목", "금", "토", "일");
        if(!days.contains(input)) {
            throw new IllegalArgumentException("[ERROR] 입력 범위를 초과한 입력입니다.");
        }
    }

    public void validateNameCharacters(String name) {
        if (!name.matches("^[a-zA-Z]*$")) {
            throw new IllegalArgumentException("자동차의 이름은 영어로만 이루어져야 합니다.");
        }
    }

    public void validateNameString(String name) {
        if (!name.matches(String.valueOf(Regex.KOREAN_WITH_ENGLISH))) {
            throw new IllegalArgumentException("[ERROR] 문자로만 이루어져야 합니다.");
        }
    }

    public void isDistinct(String input, int expectedSize) { //문자열에서 각 문자가 중복되지 않는지 검사
        long count = input.chars()
                .distinct()
                .count();
        if (count != expectedSize) {
            throw new IllegalArgumentException("[ERROR] 문자열에 중복된 값이 있습니다.");
        }
    }

    public void validateEmployeeList(List<String> employees) {
        validateEmployeeAmount(employees);
        validateEmployeeDuplicate(employees);
    }

    private void validateEmployeeAmount(List<String> employees) {
        if(!(employees.size() >= 5 && employees.size() <= 35)) {
            throw new IllegalArgumentException("[ERROR] 사원 수는 5명에서 35명이어야 합니다.");
        }
    }

    private void validateEmployeeDuplicate(List<String> employees) { //리스트에서 각 원소가 중복되지 않는지 검사
        List<String> distinctElements = employees.stream()
                .distinct()
                .toList();

        if (employees.size() != distinctElements.size()) {
            throw new IllegalArgumentException("[ERROR] 입력하신 리스트에 중복된 값이 있습니다.");
        }
    }
}