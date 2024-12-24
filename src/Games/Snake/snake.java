package Games.Snake;

import core.Games;
import core.GeneralFrame;
import gameOver.GameOverLogic;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import java.util.Random;

public class snake extends GeneralFrame {

    private final snakeVariables variables;
    private final snakeLogic logic;
    private final MoveSnake moveSnake;
    Stage stage;

    public snake(Stage stage) {
        
        super(Games.SNAKE, stage);
        this.variables = new snakeVariables();
        this.logic = new snakeLogic(variables,stage);
        this.moveSnake = new MoveSnake(variables);
        variables.rand = new Random();
        variables.isGameOver = false;
        this.stage = stage;
        SnakeKeyHandle keyHandle = new SnakeKeyHandle();
        addKeyListener(keyHandle);
         setFocusable(true);
         requestFocusInWindow();
        startGame();
    }

    @Override
    public void startGame() {
        if (variables.time != null) {
            variables.time.stop();
        }
        logic.newApple();
        variables.moving = true;
        variables.snakeBody = 6;
        variables.applesEaten = 0;

        for (int i = 0; i < variables.snakeBody; i++) {
            variables.x[i] = 0;
            variables.y[i] = 0;
        }
        variables.time = new Timer(variables.delay, this::actionPerformed);
        variables.time.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        if (variables.moving) {
            // Draw score
            g.setColor(new Color(128, 128, 128));
            g.setFont(new Font("Ink Free", Font.BOLD, 50));
            FontMetrics metrics1 = getFontMetrics(g.getFont());
            g.drawString("Score : " + variables.applesEaten,
                    variables.width / 2 - metrics1.stringWidth("Score: " + variables.applesEaten) / 2,
                    variables.height / 2 - 100);

            // Draw grid lines
            for (int i = 0; i < variables.height / variables.unit; i++) {
                g.drawLine(i * variables.unit, 0, i * variables.unit, variables.height);
                g.drawLine(0, i * variables.unit, variables.width, i * variables.unit);
            }

            g.setColor(Color.red);
            g.fillOval(variables.applex, variables.appley, variables.unit, variables.unit);

            for (int i = 0; i < variables.snakeBody; i++) {
                if (i == 0) {
                    g.setColor(Color.green);
                    g.fillRect(variables.x[i], variables.y[i], variables.unit, variables.unit);
                } else {
                    g.setColor(variables.color);
                    g.fillRect(variables.x[i], variables.y[i], variables.unit, variables.unit);
                }
            }
        } else {
            variables.isGameOver = true;

            Platform.runLater(() -> GameOverLogic.showGameOverScreen(variables.applesEaten,stage));

        }
    }

    public void actionPerformed(ActionEvent e) {
        if (variables.moving) {
            moveSnake.move();
            logic.checkApples();
            logic.checkCollisions();
        }
        repaint();
    }
}
