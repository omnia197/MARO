package Games.SpaceInvaders;

import core.Games;
import core.GeneralFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import javafx.stage.Stage;

public abstract class SpaceInvadersGameFrame extends GeneralFrame {

    public SpaceInvadersGameFrame(Games game, Stage primaryStage) {

        super(game, primaryStage);
    }

    @Override
    public abstract void startGame();

    public abstract void draw(Graphics g);

    public abstract void actionPerformed(ActionEvent e);

}
