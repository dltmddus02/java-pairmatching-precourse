package pairmatching.domain;

import java.util.List;

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
}
