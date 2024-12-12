package pairmatching.domain;

import java.util.HashMap;
import java.util.Map;

public class Crew {
    private final String name;
    // 주니, 레벨1
    private Map<String, String> matchedCrew;

    public Crew(String name) {
        this.name = name;
        this.matchedCrew = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addMatchedCrew(String name, String level) {
        this.matchedCrew.put(name, level);
    }

    public boolean isExistName(String name) {
        return this.name.equals(name);
    }

    public boolean isAlreadyMatchedWith(Crew c, String level) {
        for (String name : matchedCrew.keySet()) {
            if (name.equals(c.name) && matchedCrew.get(name).equals(level)) {
                return true;
            }
        }
        return false;
    }
}
