package Games.FlappyBirdGame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Variables {
    int boardwidth = 800 ;
    int boardheight = 800 ;

    //images to store the images
    Image backgroundImg;
    Image birdImg;
    Image topPipeImg;
    Image bottomPipeImg;

    //Bird
    int birdx = boardwidth/8;
    int birdy = boardheight/2;
    int birdwidth = 34;
    int birdheight = 24;

    //Pipes
    int pipeX = boardwidth ;
    int pipeY = 0 ;
    int pipewidth = 64 ;
    int pipeheight = 512 ;

    //game
    int velocityX = -4;  // the pipes move to the left speed
    int velocityY = 0 ;  // the bird move in the direction of y-axis
    int gravity = 1 ;

    ArrayList<Pipe> pipes ;

    Timer gameLoop ;
    Timer placePipesTimer ;

    boolean gameOver = false ;

    double score = 0 ;

}
