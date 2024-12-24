package Games.FlappyBirdGame;

import gameOver.GameOverLogic;
import core.Games;
import core.GeneralFrame;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;


public class FlappyBird extends GeneralFrame implements ActionListener{

    public Variables variables = new Variables();
    Bird bird ;
    DrawGame drawGame ;
    Move move ;
    FlappyBirdKeyHandle flappyBirdKeyHandle;
    Stage stage ;

    public FlappyBird(Stage stage){
        super(Games.FLAPPY_BIRD,stage);
        this.stage = stage;
        setPreferredSize(new Dimension(variables.boardwidth,variables.boardheight));

        //load the images
        drawGame = new DrawGame(variables);

        bird = new Bird(variables);

        flappyBirdKeyHandle = new FlappyBirdKeyHandle(variables,bird);

        setFocusable(true); //to make sure that the flappybird class(JPanel) takes the keyevents
        addKeyListener(flappyBirdKeyHandle);  //to make sure that we check the three functions (keyTyped,keyReleased,keyPressed)

        variables.pipes = new ArrayList<Pipe>();

        move = new Move(variables,bird);

        //place pipes timer
        variables.placePipesTimer = new Timer(1500,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                drawGame.placePipes();
            }
        });

        

        startGame();
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        //background
        g.drawImage(variables.backgroundImg,0,0,variables.boardwidth,variables.boardheight,null);

        //bird
        g.drawImage(bird.img, bird.x, bird.y, bird.width, bird.height, null);

        //pipes
        for(int i = 0 ; i< variables.pipes.size() ; i++){
            Pipe pipe = variables.pipes.get(i);
            g.drawImage(pipe.img, pipe.x, pipe.y, pipe.width, pipe.height, null);
        }

        //score
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.PLAIN , 32));
        if(variables.gameOver){
            g.drawString("Game Over: " + String.valueOf((int) variables.score) , 10 , 35);
        }
        else{
            g.drawString(String.valueOf((int) variables.score) , 10 , 35);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        move.move();
        repaint();
        if(variables.gameOver){
            variables.placePipesTimer.stop();
            variables.gameLoop.stop();
            Platform.runLater(() -> GameOverLogic.showGameOverScreen((int)variables.score,stage));
        }
    }


    @Override
    public void startGame() {
        variables.placePipesTimer.start();

        //game timer
        variables.gameLoop = new Timer(1000/60,this);
        variables.gameLoop.start();
    }
}
