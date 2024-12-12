package pairmatching.domain;

import java.util.List;

public class MatchingResult {
    private static List<LevelMissions> levelMissions;

    public MatchingResult(List<LevelMissions> levelMissions) {
        MatchingResult.levelMissions = levelMissions;
    }

    public List<LevelMissions> getLevelMissions() {
        return levelMissions;
    }

    public static LevelMissions findBy(String course, String level, String mission) {
        for (LevelMissions l : levelMissions) {
            if (l.getCourse(course) && l.getLevel(level) && l.getMission(mission)) {
                return l;
            }
        }
        return null;
    }
}
