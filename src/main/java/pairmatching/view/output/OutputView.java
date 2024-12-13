package pairmatching.view.output;

import static pairmatching.view.output.OutputMessage.COURSE_LEVEL_MISSION;
import static pairmatching.view.output.OutputMessage.FEATURE_TYPE;
import static pairmatching.view.output.OutputMessage.INPUT_COURSE_LEVEL_MISSION;
import static pairmatching.view.output.OutputMessage.INPUT_FEATURE;
import static pairmatching.view.output.OutputMessage.INPUT_MATCHING_RETRY;
import static pairmatching.view.output.OutputMessage.MATCHING_RESULT;
import static pairmatching.view.output.OutputMessage.PAIR;
import static pairmatching.view.output.OutputMessage.TRIPLE;

import java.util.List;
import pairmatching.domain.Crew;
import pairmatching.domain.CrewRepository;
import pairmatching.view.input.exception.InputErrorMessage;
import pairmatching.view.input.exception.InputException;

public class OutputView {
    public static void printFeature() {
        System.out.println(INPUT_FEATURE.getMessage());
        System.out.println(FEATURE_TYPE.getMessage());
    }

    public static void printCourseLevelMission() {
        System.out.println(COURSE_LEVEL_MISSION.getMessage());
    }

    public static void printEnterCourseLevelMission() {
        System.out.println(INPUT_COURSE_LEVEL_MISSION.getMessage());
    }

    public static void printMatchingResult(List<String> shuffledCrew) {
        System.out.println(MATCHING_RESULT.getMessage());
        if (shuffledCrew.size() % 2 == 0) {
            for (int idx = 0; idx < shuffledCrew.size(); idx += 2) {
                System.out.printf(PAIR.getMessage(), shuffledCrew.get(idx), shuffledCrew.get(idx + 1));
            }
            return;
        }
        for (int idx = 0; idx < shuffledCrew.size()-3; idx += 2) {
            System.out.printf(PAIR.getMessage(), shuffledCrew.get(idx), shuffledCrew.get(idx + 1));
        }
        System.out.printf(TRIPLE.getMessage(), shuffledCrew.get(shuffledCrew.size() - 3),
                shuffledCrew.get(shuffledCrew.size() - 2),
                shuffledCrew.get(shuffledCrew.size() - 1));

    }

    private static void validateMatchedCrew(String pobi, String mark, String level) {
        Crew crew1 = CrewRepository.findCrewByName(pobi);
        Crew crew2 = CrewRepository.findCrewByName(mark);

//        delete하고 다시 add
        if (crew1.isAlreadyMatchedWith(crew2, level)) {
            throw new InputException(InputErrorMessage.ALREADY_PAIR);
        }

        crew1.addMatchedCrew(mark, level);
        crew2.addMatchedCrew(pobi, level);

        CrewRepository.deleteCrew(pobi);
        CrewRepository.addCrew(crew1);

        CrewRepository.deleteCrew(mark);
        CrewRepository.addCrew(crew2);
    }

    public static void printMatchingRetry() {
        System.out.println(INPUT_MATCHING_RETRY.getMessage());
    }
}
