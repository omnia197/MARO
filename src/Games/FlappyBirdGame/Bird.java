package Games.FlappyBirdGame;

import java.awt.*;

public class Bird {

    int x ;
    int y ;
    int width  ;
    int height ;
    Image img ;

    Bird(Variables vars){
        this.img = vars.birdImg ;
        this.x = vars.birdx ;
        this.y = vars.birdy;
        this.width = vars.birdwidth ;
        this.height = vars.birdheight;
    }
}
