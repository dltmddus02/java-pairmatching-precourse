package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class CrewRepository {
    private List<Crew> backEndCrew;
    private List<Crew> frontEndCrew;

    public CrewRepository() {
        this.backEndCrew = new ArrayList<>();
        this.frontEndCrew = new ArrayList<>();
    }

    public void addBackEndCrew(Crew c) {
        this.backEndCrew.add(c);
    }

    public void addFrontEndCrew(Crew c) {
        this.frontEndCrew.add(c);
    }
}
