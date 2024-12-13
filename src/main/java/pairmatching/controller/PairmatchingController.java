package pairmatching.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import pairmatching.domain.Crew;
import pairmatching.domain.CrewRepository;
import pairmatching.domain.LevelMissions;
import pairmatching.domain.MatchingResult;
import pairmatching.util.NameReader;
import pairmatching.view.input.InputView;
import pairmatching.view.input.exception.InputErrorMessage;
import pairmatching.view.input.exception.InputException;
import pairmatching.view.output.OutputView;

public class PairmatchingController {
    private MatchingResult matchingResult;
    private final static String COMMA = ",";

    public PairmatchingController() {
        matchingResult = setupMissionInfo();
    }

    public void run() {
        NameReader.storeBackendCrew();
        NameReader.storeFrontendCrew();

        while (true) {
            try {
                String feature = prepareFeature();

                if (feature.equals("1")) {
                    OutputView.printCourseLevelMission();
                    while (true) {
                        String courseLevelMission = input();

                        boolean flag = pairMatchingStart(courseLevelMission);
                        if (flag) {
                            break;
                        }
                    }
                } else if (feature.equals("2")) {
                    OutputView.printCourseLevelMission();
                    String courseLevelMission = input();
                    pairInquiry(courseLevelMission);

                } else if (feature.equals("3")) {
                    resetMatchingResult();
                } else if (feature.equals("Q")) {
                    return;
                }
            } catch (InputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private MatchingResult setupMissionInfo() {
        LevelMissions back1 = new LevelMissions("백엔드", "레벨1", "자동차경주");
        LevelMissions back2 = new LevelMissions("백엔드", "레벨1", "로또");
        LevelMissions back3 = new LevelMissions("백엔드", "레벨1", "숫자야구게임");
        LevelMissions back4 = new LevelMissions("백엔드", "레벨2", "장바구니");
        LevelMissions back5 = new LevelMissions("백엔드", "레벨2", "결제");
        LevelMissions back6 = new LevelMissions("백엔드", "레벨2", "지하철노선도");
        LevelMissions back7 = new LevelMissions("백엔드", "레벨4", "성능개선");
        LevelMissions back8 = new LevelMissions("백엔드", "레벨4", "배포");

        LevelMissions front1 = new LevelMissions("프론트엔드", "레벨1", "자동차경주");
        LevelMissions front2 = new LevelMissions("프론트엔드", "레벨1", "로또");
        LevelMissions front3 = new LevelMissions("프론트엔드", "레벨1", "숫자야구게임");
        LevelMissions front4 = new LevelMissions("프론트엔드", "레벨2", "장바구니");
        LevelMissions front5 = new LevelMissions("프론트엔드", "레벨2", "결제");
        LevelMissions front6 = new LevelMissions("프론트엔드", "레벨2", "지하철노선도");
        LevelMissions front7 = new LevelMissions("프론트엔드", "레벨4", "성능개선");
        LevelMissions front8 = new LevelMissions("프론트엔드", "레벨4", "배포");

        List<LevelMissions> levelMissions = List.of(back1, back2, back3, back4, back5, back6, back7, back8, front1,
                front2, front3, front4, front5, front6, front7, front8);

        return new MatchingResult(levelMissions);
    }

    private String prepareFeature() {
        return retryOnInvalidInput(() -> {
            OutputView.printFeature();
            return InputView.inputFeature();
        });
    }

    private String input() {
        return retryOnInvalidInput(() -> {
            OutputView.printEnterCourseLevelMission();
            String courseLevelMission = InputView.inputCourseLevelMission();
            matchingResult.validate(courseLevelMission);
            return courseLevelMission;
        });
    }

    private boolean pairMatchingStart(String courseLevelMission) {
        String course = courseLevelMission.split(COMMA)[0].trim();
        String level = courseLevelMission.split(COMMA)[1].trim();
        String mission = courseLevelMission.split(COMMA)[2].trim();

        LevelMissions current = matchingResult.findBy(courseLevelMission);

        if (current.matchingResultAlreadyExist()) {
            OutputView.printMatchingRetry();
            String continueGame = InputView.inputMatchingRetry();
            if (continueGame.equals("아니오")) {
                return false;
            }
        }

        List<String> shuffledCrew = new ArrayList<>();
        if (course.equals("백엔드")) {
            shuffledCrew = CrewRepository.getBackEndCrew();
        } else if (course.equals("프론트엔드")) {
            shuffledCrew = CrewRepository.getFrontEndCrew();
        }

        setCrew(shuffledCrew, level);

        OutputView.printMatchingResult(shuffledCrew);
        current.setMatchingResult(shuffledCrew);
        return true;
    }

    private void setCrew(List<String> shuffledCrew, String level) {
        if (shuffledCrew.size() % 2 == 0) {
            for (int idx = 0; idx < shuffledCrew.size() / 2; idx += 2) {
                validateMatchedCrew(shuffledCrew.get(idx), shuffledCrew.get(idx + 1), level);
            }
            return;
        }
        for (int idx = 0; idx < shuffledCrew.size() / 2 - 1; idx += 2) {
            validateMatchedCrew(shuffledCrew.get(idx), shuffledCrew.get(idx + 1), level);
        }
        validateMatchedCrew(shuffledCrew.get(shuffledCrew.size() - 1), shuffledCrew.get(shuffledCrew.size() - 2),
                level);
        validateMatchedCrew(shuffledCrew.get(shuffledCrew.size() - 2), shuffledCrew.get(shuffledCrew.size() - 3),
                level);
        validateMatchedCrew(shuffledCrew.get(shuffledCrew.size() - 3), shuffledCrew.get(shuffledCrew.size() - 1),
                level);


    }

    private static void validateMatchedCrew(String pobi, String mark, String level) {
        Crew crew1 = CrewRepository.findCrewByName(pobi);
        if (crew1 == null) {
            crew1 = new Crew(pobi);
        }
        Crew crew2 = CrewRepository.findCrewByName(mark);
        if (crew2 == null) {
            crew2 = new Crew(mark);
        }

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

    private void pairInquiry(String courseLevelMission) {
        LevelMissions l = matchingResult.findBy(courseLevelMission);
        OutputView.printMatchingResult(l.getMatchingResult());
    }

    private void resetMatchingResult() {
        matchingResult = setupMissionInfo();
        CrewRepository.deleteAll();
    }

    private <T> T retryOnInvalidInput(Supplier<T> input) {
        while (true) {
            try {
                return input.get();
            } catch (InputException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
