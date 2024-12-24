package userInterface;

import javafx.scene.control.Button;

public class GameDesignButton {
    
     public static Button GeneralButton(String text) {
        Button button = new Button(text);
        button.setStyle(
                 "-fx-background-color: linear-gradient(#ffd65b, #e68400),"
                + "linear-gradient(#ffef84, #f2ba44),"
                + "linear-gradient(#ffea6a, #efaa22),"
                + "linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%),"
                + "linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));"
                + "-fx-background-radius: 30;"
                + "-fx-background-insets: 0,1,2,3,0;"
                + "-fx-text-fill: #654b00;"
                + "-fx-font-weight: bold;"
                + "-fx-font-size: 14px;"
                + "-fx-padding: 10 20 10 20;"
        );

        button.setOnMouseEntered(e -> button.setStyle(
            "-fx-background-color: linear-gradient(#e68400, #ffd65b),"
                + "linear-gradient(#f2ba44, #ffef84),"
                + "linear-gradient(#efaa22, #ffea6a),"
                + "linear-gradient(#f8c202 50%, #ffe657 100%, #eea10b 0%),"
                + "linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));"
                + "-fx-background-radius: 30;"
                + "-fx-background-insets: 0,1,2,3,0;"
                + "-fx-text-fill: #654b00;"
                + "-fx-font-weight: bold;"
                + "-fx-font-size: 14px;"
                + "-fx-padding: 10 20 10 20;"
        ));

        button.setOnMouseExited(e -> button.setStyle(
            "-fx-background-color: linear-gradient(#ffd65b, #e68400),"
                + "linear-gradient(#ffef84, #f2ba44),"
                + "linear-gradient(#ffea6a, #efaa22),"
                + "linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%),"
                + "linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));"
                + "-fx-background-radius: 30;"
                + "-fx-background-insets: 0,1,2,3,0;"
                + "-fx-text-fill: #654b00;"
                + "-fx-font-weight: bold;"
                + "-fx-font-size: 14px;"
                + "-fx-padding: 10 20 10 20;"
        ));
        return button;
    }
    
}
