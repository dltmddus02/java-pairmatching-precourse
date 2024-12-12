package pairmatching.view.input.exception;

public enum InputErrorMessage {
    INVALID_INPUT("유효하지 않은 입력 값입니다. 다시 입력해 주세요.\n"),
    INCORRECT_INPUT_FORMAT("올바르지 않은 형식으로 입력했습니다. 다시 입력해 주세요.\n"),
    ALREADY_PAIR("이미 페어를 맺었습니다.\n"),
    THREE_TIMES_ATTEMPTS("3회 시도까지 매칭되지 않았습니다.\n"),
    NON_EXISTENT_MATCH_CASE("매칭 가능한 경우의 수가 없습니다.\n");
    
    private static final String PREFIX = "[ERROR] ";
    private final String message;

    InputErrorMessage(String message) {
        this.message = PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
