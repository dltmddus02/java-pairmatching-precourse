package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Crew {
    private final String name;
    private List<Crew> matchedCrew;

    public Crew(String name) {
        this.name = name;
        this.matchedCrew = new ArrayList<>();
    }
}
