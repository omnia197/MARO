package core;

import userInterface.MainHome;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javafx.stage.Stage;
import javax.swing.*;

public abstract class GeneralFrame extends JPanel implements MainFramePaintInterface {
    private Games game;
    private Stage primaryStage;
    public JLabel iconLabel;
    public JLayeredPane secondLayer;

    public GeneralFrame(Games game, Stage primaryStage) {
        this.game = game;
        this.primaryStage = primaryStage;

        secondLayer = new JLayeredPane();
        secondLayer.setLayout(null);
        secondLayer.setBounds(0, 0, 800, 600); 

        setLayout(new BorderLayout());
        add(secondLayer, BorderLayout.CENTER);

        MainFrameGUI();
    }

    @Override
    public void MainFrameGUI() {
        BackIcon(); 
        setBackground(Color.BLACK);
    }

   @Override
public void BackIcon() {
    ImageIcon backIcon = new ImageIcon(getClass().getResource("/media/Home.png"));
    Image scaledImage = backIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
    ImageIcon scaledIcon = new ImageIcon(scaledImage);

    JLabel BackIconLabel = new JLabel(scaledIcon);
    BackIconLabel.setHorizontalAlignment(SwingConstants.RIGHT);  
    BackIconLabel.setVerticalAlignment(SwingConstants.TOP);    

    BackIconLabel.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            javafx.application.Platform.runLater(() -> {
                MainHome.HomeGUI(primaryStage);
            });
        }
    });

    int xPosition = secondLayer.getWidth() - 80;
    int yPosition = 10;

    BackIconLabel.setBounds(xPosition, yPosition, 70, 70); 
    secondLayer.add(BackIconLabel, JLayeredPane.PALETTE_LAYER); 

    // Add a listener to ensure correct positioning if the panel is resized
    secondLayer.addComponentListener(new java.awt.event.ComponentAdapter() {
        @Override
        public void componentResized(java.awt.event.ComponentEvent evt) {
            int xPosition = secondLayer.getWidth() -80;
            BackIconLabel.setBounds(xPosition, yPosition, 70, 70);
        }
    });
}


    public abstract void startGame();
}
