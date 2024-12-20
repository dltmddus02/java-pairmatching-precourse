package pairmatching.view.input;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputFeature() {
        String feature = Console.readLine();
        InputValidator.validateFeature(feature);
        return feature;
    }

    public static String inputCourseLevelMission() {
        String courseLevelMission = Console.readLine();
        InputValidator.validateCourseLevelMission(courseLevelMission);
        return courseLevelMission;
    }

    public static String inputMatchingRetry() {
        String matchingRetry = Console.readLine();
        InputValidator.validateMatchingRetry(matchingRetry);
        return matchingRetry;
    }


}
