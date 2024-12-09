package oncall.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getDay() {
        System.out.println("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
        return Console.readLine();
    }

    public String getWeekDay() {
        System.out.println("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        return Console.readLine();
    } // 평일 휴일에 각각 1번만
    //연속 2일은 근무 불가. 다음 근무자와 순서를 바꿔 편성
    public String getWeekend() {
        System.out.println("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        return Console.readLine();
    }
}
