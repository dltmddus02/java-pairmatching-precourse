package pairmatching.view.input;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputFeature() {
        String feature = Console.readLine();
        InputValidator.validateFeature(feature);
        return feature;
    }
}
