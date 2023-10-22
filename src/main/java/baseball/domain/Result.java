package baseball.domain;

import baseball.view.OutputView;

import static baseball.config.NumberConfig.NUMBER_LENGTH;

public class Result {
    private final int ballCount;
    private final int strikeCount;

    private Result(final Numbers playerNumber, final Numbers computerNumber) {
        ballCount = playerNumber.countBallCount(computerNumber);
        strikeCount = playerNumber.countStrikeCount(computerNumber);
    }

    public static Result create(final Numbers playerNumber, final Numbers computerNumber) {
        return new Result(playerNumber, computerNumber);
    }

    public void print() {
        if (ballCount == 0 && strikeCount == 0) {
            OutputView.printNothing();
        } else if (ballCount > 0 && strikeCount > 0) {
            OutputView.printBallAndStrikeCount(ballCount, strikeCount);
        } else if (ballCount > 0) {
            OutputView.printBallCount(ballCount);
        } else if (strikeCount > 0) {
            OutputView.printStrikeCount(strikeCount);
        }
    }

    public boolean checkGameOver() {
        return strikeCount == NUMBER_LENGTH.getValue();
    }
}
