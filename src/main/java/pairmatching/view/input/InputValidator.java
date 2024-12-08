package pairmatching.view.input;

import pairmatching.view.input.exception.InputErrorMessage;
import pairmatching.view.input.exception.InputException;

public class InputValidator {
    private final static String COMMA = ",";

    public static void validateOption(String input) {
        if (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("Q")) {
            throw new InputException(InputErrorMessage.INVALID_INPUT);
        }
    }

    public static void validateCourse(String input) {
        validateNotNullOrEmpty(input);
//        콤마로 구분했을때 3개로 나뉘는지
        validateFormat(input);
//        if (!input.equals("백엔드") && !input.equals("프론트엔드")) {
//            throw new InputException(InputErrorMessage.INVALID_INPUT);
//        }

    }

    public static void validateNotNullOrEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new InputException(InputErrorMessage.INVALID_INPUT);
        }
    }

    public static void validateFormat(String input) {
        if (!isCorrectFormat(input)) {
            throw new InputException(InputErrorMessage.INVALID_INPUT);
        }
    }

    private static boolean isCorrectFormat(String input) {
        if (!input.contains(COMMA)) {
            return false;
        }
        if (input.split(COMMA).length != 3) {
            return false;
        }
        return true;
    }

}
