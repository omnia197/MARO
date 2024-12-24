package Games.FlappyBirdGame;

import javax.swing.*;

public class DrawGame {
    Variables vars ;

    public DrawGame(Variables vars){
        this.vars = vars;
        vars.backgroundImg = new ImageIcon(getClass().getResource("/media/FlappyBird/flappybirdbackground.png")).getImage();
        vars.birdImg = new ImageIcon(getClass().getResource("/media/FlappyBird/flappybird.png")).getImage();
        vars.topPipeImg = new ImageIcon(getClass().getResource("/media/FlappyBird/toppipe.png")).getImage();
        vars.bottomPipeImg = new ImageIcon(getClass().getResource("/media/FlappyBird/bottompipe.png")).getImage();
    }

    public void placePipes(){

        int randomPipeY = (int)(vars.pipeY - vars.pipeheight/4 - Math.random()*(vars.pipeheight/2));
        int openingspace = vars.boardheight/4 ;

        Pipe topPipe = new Pipe(vars.topPipeImg , vars);
        topPipe.y = randomPipeY ;
        vars.pipes.add(topPipe);

        Pipe bottomPipe = new Pipe(vars.bottomPipeImg , vars);
        bottomPipe.y = topPipe.y + vars.pipeheight + openingspace ;
        vars.pipes.add(bottomPipe);
    }


}
