package pairmatching.view.output;

public enum OutputMessage {
    INPUT_OPTION("기능을 선택하세요.\n"),
    OPTION("1. 페어 매칭\n"
            + "2. 페어 조회\n"
            + "3. 페어 초기화\n"
            + "Q. 종료\n"),
    COURSE_MISSION("과정: 백엔드 | 프론트엔드\n"
            + "미션:\n"
            + "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
            + "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
            + "  - 레벨3: \n"
            + "  - 레벨4: 성능개선 | 배포\n"
            + "  - 레벨5: \n"),
    INPUT_COURSE_LEVEL_MISSION("과정, 레벨, 미션을 선택하세요.\n"
            + "ex) 백엔드, 레벨1, 자동차경주\n"),
    HASH_DELIMITER("#############################################"),
    MATCHING_RESULT("페어 매칭 결과입니다."),
    PAIR_CREW("%s : %s\n"),
    TRIPLE_CREW("%s : %s : %s\n");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
