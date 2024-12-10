package oncall.view;

import oncall.dto.ResultDto;

import java.util.List;

public class OutputView {

    public void printResults(List<ResultDto> results) {
        for (ResultDto result : results) {
            System.out.println(result.getMonth() + "월 " + result.getDate() + "일 "
            + result.getDay() + " " + result.getEmployee().getName() + " " + result.getHoliday());
        }
    }
}
