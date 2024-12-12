package pairmatching.view.output;

public enum OutputMessage {
    INPUT_FEATURE("기능을 선택하세요.\n"),
    FEATURE_TYPE("1. 페어 매칭\n"
            + "2. 페어 조회\n"
            + "3. 페어 초기화\n"
            + "Q. 종료\n"),
    INPUT_COURSE_LEVEL_MISSION("과정, 레벨, 미션을 선택하세요.\n"
            + "ex) 백엔드, 레벨1, 자동차경주\n"),
    MATCHING_RESULT("페어 매칭 결과입니다.\n"),
    PAIR("%s : %s\n"),
    TRIPLE("%s : %s : %s\n"),
    INPUT_MATCHING_RETRY("매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n"
            + "네 | 아니오\n"),
    RESET_COMPLETE("초기화 되었습니다.\n");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
