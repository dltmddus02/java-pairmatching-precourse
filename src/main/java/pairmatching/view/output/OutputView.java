package pairmatching.view.output;

import static pairmatching.view.output.OutputMessage.FEATURE_TYPE;
import static pairmatching.view.output.OutputMessage.INPUT_COURSE_LEVEL_MISSION;
import static pairmatching.view.output.OutputMessage.INPUT_FEATURE;
import static pairmatching.view.output.OutputMessage.MATCHING_RESULT;
import static pairmatching.view.output.OutputMessage.PAIR;
import static pairmatching.view.output.OutputMessage.TRIPLE;

import java.util.List;

public class OutputView {
    public static void printFeature() {
        System.out.println(INPUT_FEATURE.getMessage());
        System.out.println(FEATURE_TYPE.getMessage());
    }

    public static void printCourseLevelMission() {
        System.out.println(INPUT_COURSE_LEVEL_MISSION.getMessage());
    }

    public static void printMatchingResult(List<String> shuffledCrew) {
        System.out.println(MATCHING_RESULT.getMessage());
        if (shuffledCrew.size() % 2 == 0) {
            for (int idx = 0; idx < shuffledCrew.size() / 2; idx++) {
                System.out.printf(PAIR.getMessage(), shuffledCrew.get(idx), shuffledCrew.get(idx + 1));
            }
            return;
        }
        for (int idx = 0; idx < shuffledCrew.size() / 2 - 1; idx++) {
            System.out.printf(PAIR.getMessage(), shuffledCrew.get(idx), shuffledCrew.get(idx + 1));
        }
        System.out.printf(TRIPLE.getMessage(), shuffledCrew.get(shuffledCrew.size() - 3),
                shuffledCrew.get(shuffledCrew.size() - 2),
                shuffledCrew.get(shuffledCrew.size() - 1));

    }
}
