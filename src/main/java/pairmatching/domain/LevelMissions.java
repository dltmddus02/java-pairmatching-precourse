package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class LevelMissions {
    private final String course;
    private final String level;
    private final String mission;
    private List<String> matchingResult;

    public LevelMissions(String course, String level, String mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
        this.matchingResult = new ArrayList<>();
    }

    public boolean getCourse(String course) {
        return this.course.equals(course);
    }

    public boolean getLevel(String level) {
        return this.level.equals(level);
    }

    public boolean getMission(String mission) {
        return this.mission.equals(mission);
    }

    public List<String> getMatchingResult() {
        return matchingResult;
    }

    public void setMatchingResult(List<String> matchingResult) {
        this.matchingResult = matchingResult;
    }

    public boolean matchingResultAlreadyExist() {
        return !this.matchingResult.isEmpty();
    }
}
