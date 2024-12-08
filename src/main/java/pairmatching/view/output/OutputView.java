package pairmatching.view.output;

import static pairmatching.view.output.OutputMessage.COURSE_MISSION;
import static pairmatching.view.output.OutputMessage.HASH_DELIMITER;
import static pairmatching.view.output.OutputMessage.INPUT_COURSE_LEVEL_MISSION;
import static pairmatching.view.output.OutputMessage.INPUT_OPTION;
import static pairmatching.view.output.OutputMessage.MATCHING_RESULT;
import static pairmatching.view.output.OutputMessage.OPTION;
import static pairmatching.view.output.OutputMessage.PAIR_CREW;
import static pairmatching.view.output.OutputMessage.TRIPLE_CREW;

import java.util.List;

public class OutputView {
    public static void printOption() {
        System.out.print(INPUT_OPTION.getMessage());
        System.out.print(OPTION.getMessage());
    }

    public static void printMatchingInfo() {
        System.out.println(HASH_DELIMITER.getMessage());
        System.out.print(COURSE_MISSION.getMessage());
        System.out.println(HASH_DELIMITER.getMessage());
    }

    public static void printChooseMatchingInfo() {
        System.out.print(INPUT_COURSE_LEVEL_MISSION.getMessage());
    }

    public static void printPairMatchingResult() {
        System.out.println();
        System.out.println(MATCHING_RESULT.getMessage());
    }

    public static void printPairMatch(List<String> crewType) {
        for (int i = 0; i < crewType.size() - 3; i += 2) {
            System.out.printf(PAIR_CREW.getMessage(), crewType.get(i), crewType.get(i + 1));
        }
        if (crewType.size() % 2 == 0) {
            System.out.printf(PAIR_CREW.getMessage(), crewType.get(crewType.size() - 2),
                    crewType.get(crewType.size() - 1));
            System.out.println();
            return;
        }
        System.out.printf(TRIPLE_CREW.getMessage(), crewType.get(crewType.size() - 3),
                crewType.get(crewType.size() - 2), crewType.get(crewType.size() - 1));
        System.out.println();

//        }
//        else if (crewType.size() / 2 == 1) {
//            for (int i = 0; i < crewType.size(); i += 2) {
//                System.out.printf;
//            }
//        }
    }
}
