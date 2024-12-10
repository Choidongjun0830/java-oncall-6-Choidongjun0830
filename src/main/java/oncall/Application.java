package oncall;

import oncall.controller.OnCallController;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OnCallController controller = new OnCallController();

        controller.startProcess();
    }
}