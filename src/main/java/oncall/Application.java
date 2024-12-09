package oncall;

import oncall.controller.OnCallController;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("Default Encoding: " + System.getProperty("file.encoding"));
        System.out.println("아아");
        try {
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out, "UTF-8"), true);
            writer.println("한글 출력 테스트");
        } catch (Exception e) {
            e.printStackTrace();
        }
        OnCallController controller = new OnCallController();

        controller.startProcess();
    }
}