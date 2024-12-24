package Games.FlappyBirdGame;

import java.awt.*;

public class Pipe {

    int x  ;
    int y  ;
    int width  ;
    int height ;
    Image img ;
    boolean passed = false ;

    Pipe(Image img ,Variables vars){
        this.img = img ;
        this.x = vars.pipeX ;
        this.y = vars.pipeY ;
        this.width = vars.pipewidth ;
        this.height = vars.pipeheight;
    }
}
