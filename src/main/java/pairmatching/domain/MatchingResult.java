package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import pairmatching.view.input.exception.InputErrorMessage;
import pairmatching.view.input.exception.InputException;

public class MatchingResult {
    PairMatching pairMatching;

    private List<String> courses;
    private List<String> levels;
    private List<String> missions;

    private List<List<String>> matchingResult;

    public MatchingResult(PairMatching pairMatching) {
        this.courses = new ArrayList<String>();
        this.levels = new ArrayList<String>();
        this.missions = new ArrayList<String>();
        this.matchingResult = new ArrayList<>();
        this.pairMatching = pairMatching;
    }

    public List<List<String>> getMatchingResult() {
        return matchingResult;
    }

    public void addMatching(PairMatching pairMatching, List<String> crews) {
        courses.add(pairMatching.getCourse());
        levels.add(pairMatching.getLevel());
        missions.add(pairMatching.getMission());

        matchingResult.add(crews);
    }

    public Integer findMatchingResult(PairMatching pairMatching) {
        String course = pairMatching.getCourse();
        String level = pairMatching.getLevel();
        String mission = pairMatching.getMission();

        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).equals(course) && levels.get(i).equals(level) && missions.get(i).equals(mission)) {
                return i;
            }
        }

        throw new InputException(InputErrorMessage.NO_MATCHING_HISTORY);
    }

    public void resetMatchingData() {
        this.courses.clear();
        this.levels.clear();
        this.missions.clear();
        this.matchingResult.clear();
    }
}
