package Games.MemoryCard;

import core.GeneralFrame;
import core.Games;
import java.awt.*;
import java.awt.event.ActionEvent;
import javafx.stage.Stage;

public abstract class MemoryCardGameFrame extends GeneralFrame {

    public MemoryCardGameFrame(Games game, Stage primaryStage) {
        super(game, primaryStage);
    }

    @Override
    public abstract void startGame();

    public abstract void draw(Graphics g);

    public abstract void actionPerformed(ActionEvent e);

}
