package pairmatching.controller;

import java.util.List;
import pairmatching.domain.Crew;
import pairmatching.domain.MatchingResult;
import pairmatching.domain.PairMatching;
import pairmatching.service.CrewReader;
import pairmatching.service.PairMatchingInfo;
import pairmatching.view.input.InputView;
import pairmatching.view.input.exception.InputException;
import pairmatching.view.output.OutputView;

public class PairmatchingController {
    PairMatching pairMatching;
    PairMatchingInfo pairMatchingInfo;
    MatchingResult matchingResult;
    Crew crew;

    public PairmatchingController() {
        pairMatchingInfo = new PairMatchingInfo();
        matchingResult = new MatchingResult(pairMatching);
        crew = new Crew();
    }

    public void run() {
        loadCrewMember();

        while (true) {
            try {
                String option = chooseOption();

                if (option.equals("1")) {
                    shuffleCrewMember();
                    pairMatching = prepareMatchingInfo();
                    List<String> crewType = getCrews(pairMatching);
                    matchingResult.addMatching(pairMatching, crewType);
                    printPairMatchingResult(crewType);
                }
                if (option.equals("2")) {
                    pairMatching = prepareMatchingInfo();
                    findPairMatchingResult(pairMatching);
                }
                if (option.equals("3")) {
                    resetMatchResult();
                }
                if (option.equals("Q")) {
                    return;
                }
            } catch (InputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void shuffleCrewMember() {
        crew.shuffleBackends();
        crew.shuffleFrontends();
    }

    private void loadCrewMember() {
        CrewReader.loadCrewsFromFile(crew);
    }

    private String chooseOption() {
        while (true) {
            try {
                OutputView.printOption();
                return InputView.inputOption();
            } catch (InputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private PairMatching prepareMatchingInfo() {
        OutputView.printMatchingInfo();
        while (true) {
            try {
                OutputView.printChooseMatchingInfo();
                String course = InputView.inputCourse();
                return pairMatchingInfo.parsePairMatchingInfo(course);
            } catch (InputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<String> getCrews(PairMatching pairMatching) {
        if (pairMatching.getCourse().equals("백엔드")) {
            return crew.getBackends();
        }
        return crew.getFrontends();
    }

    private void printPairMatchingResult(List<String> crewType) {
        OutputView.printPairMatchingResult();
        OutputView.printPairMatch(crewType);
    }

    private void findPairMatchingResult(PairMatching pairMatching) {
        Integer matchingIndex = matchingResult.findMatchingResult(pairMatching);
        printPairMatchingResult(matchingResult.getMatchingResult().get(matchingIndex));
    }

    private void resetMatchResult() {
        matchingResult.resetMatchingData();
    }
}
