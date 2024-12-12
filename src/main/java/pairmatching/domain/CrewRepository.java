package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CrewRepository {
    private static final List<Crew> crews = new ArrayList<>();

    private static List<String> backEndCrew = new ArrayList<>();
    private static List<String> frontEndCrew = new ArrayList<>();

    public static List<Crew> crews() {
        return Collections.unmodifiableList(crews);
    }


    public static List<String> getBackEndCrew() {
        return Randoms.shuffle(backEndCrew);
    }

    public static List<String> getFrontEndCrew() {
        return Randoms.shuffle(frontEndCrew);
    }

    public static void addCrew(Crew crew) {
        crews.add(crew);
    }

    public static boolean deleteCrew(String name) {
        return crews.removeIf(crew -> Objects.equals(crew.getName(), name));
    }

    public static void deleteAll() {
        crews.clear();
    }

    public static Crew findCrewByName(String name) {
        for (Crew crew : crews()) {
            if (crew.isExistName(name)) {
//                matchedCrew에 매칭됐던 애인지 보기
                return crew;
            }
        }
        return null;
    }

    public static void addBackEndCrew(String c) {
        backEndCrew.add(c);
    }

    public static void addFrontEndCrew(String c) {
        frontEndCrew.add(c);
    }

}
