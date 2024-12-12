package pairmatching.view.input;

import java.util.Arrays;
import java.util.regex.Pattern;
import pairmatching.view.input.exception.InputErrorMessage;
import pairmatching.view.input.exception.InputException;

public class InputValidator {
    private final static String COMMA = ",";

    public static void validateFeature(String input) {
        validateNotNullOrEmpty(input);
        if (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("Q")) {
            throw new InputException(InputErrorMessage.INVALID_INPUT);
        }
    }

    public static void validateCourseLevelMission(String input) {
        validateNotNullOrEmpty(input);
        validateFormat(input);
    }

    public static void validateNotNullOrEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new InputException(InputErrorMessage.INVALID_INPUT);
        }
    }

    public static void validateFormat(String input) {
        if (!input.contains(COMMA)) {
            throw new InputException(InputErrorMessage.INCORRECT_INPUT_FORMAT);
        }
        if (Arrays.stream(input.split(COMMA)).count() != 3) {
            throw new InputException(InputErrorMessage.INCORRECT_INPUT_FORMAT);
        }
    }

    private static boolean isCorrectFormat(String input) {
        String characterPattern = "[가-힣]+";
        String numberPattern = "[0-9]+";

        String singlePattern = String.format("\\[(%s),(%s),(%s)]", characterPattern, numberPattern);
        String repeatPattern = String.format("%s(;%s)*", singlePattern, singlePattern);

        Pattern correctPattern = Pattern.compile("^" + repeatPattern + "$");

        return correctPattern.matcher(input).find();
    }

    public static void validateMatchingRetry(String input) {
        if (!input.equals("네") && !input.equals("아니오")) {
            throw new InputException(InputErrorMessage.INCORRECT_INPUT_FORMAT);
        }
    }
}
