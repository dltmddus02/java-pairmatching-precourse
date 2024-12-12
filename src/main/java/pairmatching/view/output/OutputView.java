package pairmatching.view.output;

import static pairmatching.view.output.OutputMessage.INPUT_COURSE_LEVEL_MISSION;
import static pairmatching.view.output.OutputMessage.INPUT_FEATURE;

public class OutputView {
    public static void printFeature() {
        System.out.println(INPUT_FEATURE.getMessage());
    }

    public static void printCourseLevelMission() {
        System.out.println(INPUT_COURSE_LEVEL_MISSION.getMessage());
    }
}
