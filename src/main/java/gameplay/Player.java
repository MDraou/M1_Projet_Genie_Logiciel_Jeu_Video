package gameplay;

import engine.kernel.MoveStrategy;

public class Player implements State {

    private final Pong game;

    public Player(Pong pong) {
        game = pong;
    }

    @Override
    public void ZPressedAction() {
        game.getLeftPaddle().getEntity().process(new MoveStrategy(0, -10));
    }

    @Override
    public void SPressedAction() {
        game.getLeftPaddle().getEntity().process(new MoveStrategy(0, 10));
    }

    @Override
    public void UpPressedAction() {
        game.getRightPaddle().getEntity().process(new MoveStrategy(0, -10));
    }

    @Override
    public void DownPressedAction() {
        game.getRightPaddle().getEntity().process(new MoveStrategy(0, 10));
    }

    @Override
    public void ZReleasedAction() {
        game.getLeftPaddle().getEntity().process(new MoveStrategy(0, 0));
    }

    @Override
    public void SReleasedAction() {
        game.getLeftPaddle().getEntity().process(new MoveStrategy(0, 0));
    }

    @Override
    public void UpReleasedAction() {
        game.getRightPaddle().getEntity().process(new MoveStrategy(0, 0));
    }

    @Override
    public void DownReleasedAction() {
        game.getRightPaddle().getEntity().process(new MoveStrategy(0, 0));
    }
}
