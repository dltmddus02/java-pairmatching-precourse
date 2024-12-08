package pairmatching.view.input;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputOption() {
        String option = Console.readLine();
        InputValidator.validateOption(option);
        return option;
    }

    public static String inputCourse() {
        String course = Console.readLine();
        InputValidator.validateCourse(course);
        return course;
    }
}
