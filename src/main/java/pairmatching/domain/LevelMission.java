package pairmatching.domain;

import java.util.List;

public enum LevelMission {
    LEVEL1("레벨1", List.of("자동차경주", "로또", "숫자야구게임")),
    LEVEL2("레벨2", List.of("장바구니", "결제", "지하철노선도")),
    LEVEL3("레벨3", List.of()),
    LEVEL4("레벨4", List.of("성능개선", "배포")),
    LEVEL5("레벨5", List.of());

    private final String level;
    private final List<String> missions;

    LevelMission(String level, List<String> missions) {
        this.level = level;
        this.missions = missions;
    }

    public List<String> getMissions() {
        return missions;
    }

    public static boolean isExistentMission(String level, String mission) {
        for (LevelMission levelMission : LevelMission.values()) {
            if (levelMission.missions.contains(mission)) {
                return validMatchPair(level, levelMission);
            }
        }
        return false;
    }

    private static boolean validMatchPair(String level, LevelMission levelMission) {
        return levelMission.level.equals(level);
    }

}
