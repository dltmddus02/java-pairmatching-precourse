package pairmatching.view.input.exception;

public enum InputErrorMessage {
    INVALID_INPUT("유효하지 않은 입력 값입니다. 다시 입력해 주세요.\n"),
    NO_MATCHING_HISTORY("매칭 이력이 없습니다.\n");
    private static final String PREFIX = "[ERROR] ";
    private final String message;

    InputErrorMessage(String message) {
        this.message = PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
