package pairmatching.domain;

import java.util.List;
import pairmatching.view.input.exception.InputErrorMessage;
import pairmatching.view.input.exception.InputException;

public class MatchingResult {
    private final static String COMMA = ",";
    private static List<LevelMissions> levelMissions;

    public MatchingResult(List<LevelMissions> levelMissions) {
        MatchingResult.levelMissions = levelMissions;
    }

    public List<LevelMissions> getLevelMissions() {
        return levelMissions;
    }

    public LevelMissions findBy(String courseLevelMission) {
        String course = courseLevelMission.split(COMMA)[0].trim();
        String level = courseLevelMission.split(COMMA)[1].trim();
        String mission = courseLevelMission.split(COMMA)[2].trim();

        return levelMissions.stream()
                .filter(l -> l.getCourse(course) && l.getLevel(level) && l.getMission(mission))
                .findFirst()
                .orElse(null);
    }

    public void deleteAll() {
    }

    public void validate(String courseLevelMission) throws InputException {
        if (findBy(courseLevelMission) == null) {
            throw new InputException(InputErrorMessage.INVALID_INPUT);
        }
    }
}
