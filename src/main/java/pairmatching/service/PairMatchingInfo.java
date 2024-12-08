package pairmatching.service;

import pairmatching.domain.PairMatching;
import pairmatching.view.input.exception.InputErrorMessage;
import pairmatching.view.input.exception.InputException;

public class PairMatchingInfo {
    private final static String COMMA = ",";

    public PairMatching parsePairMatchingInfo(String input) {
//        input 맞는 입력인지 검증
//
        input = input.trim();
        validateInput(input);
        String course = input.split(COMMA)[0].trim();
        String level = input.split(COMMA)[1].trim();
        String mission = input.split(COMMA)[2].trim();
        return new PairMatching(course, level, mission);
    }

    private void validateInput(String input) {
        String course = input.split(COMMA)[0].trim();
        String level = input.split(COMMA)[1].trim();
        String mission = input.split(COMMA)[2].trim();

        if (!course.equals("백엔드") && !course.equals("프론트엔드")) {
            throw new InputException(InputErrorMessage.INVALID_INPUT);
        }

        if (!level.equals("레벨1") && !level.equals("레벨2") && !level.equals("레벨3") && !level.equals("레벨4")
                && !level.equals("레벨5")) {
            throw new InputException(InputErrorMessage.INVALID_INPUT);
        }

        if (!mission.equals("자동차경주") && !mission.equals("로또") && !mission.equals("숫자야구게임") && !mission.equals("장바구니")
                && !mission.equals("결제") && !mission.equals("지하철노선도") && !mission.equals("성능개선") && !mission.equals(
                "배포")) {
            throw new InputException(InputErrorMessage.INVALID_INPUT);
        }
    }
}
