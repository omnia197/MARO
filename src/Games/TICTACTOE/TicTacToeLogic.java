package Games.TICTACTOE;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class TicTacToeLogic {
    TicTacToeVariables ticTacToeVariables;
    public  TicTacToeLogic(TicTacToeVariables ticTacToeVariables){
        this.ticTacToeVariables = ticTacToeVariables;
    }
    void checkWinner(){
        checkHorizontal();
        checkVertical();
        checkDiagonally();
        checkUntiDiagonally();
        checkTie();
    }
    void checkHorizontal(){
        for (int r=0 ; r<3 ; r++){
            if (Objects.equals(ticTacToeVariables.board[r][0].getText(), "")) continue;

            if (Objects.equals(ticTacToeVariables.board[r][0].getText(), ticTacToeVariables.board[r][1].getText()) &&
                    Objects.equals(ticTacToeVariables.board[r][1].getText(), ticTacToeVariables.board[r][2].getText())){
                for (int i=0 ; i<3 ; i++){
                    setWinner(ticTacToeVariables.board[r][i]);
                }
                ticTacToeVariables.gameOver = true;
                return;
            }
        }
    }
    void checkVertical(){
        //vertical
        for (int c=0 ; c<3 ; c++){
            if (Objects.equals(ticTacToeVariables.board[0][c].getText(), "")) continue;

            if (Objects.equals(ticTacToeVariables.board[0][c].getText(), ticTacToeVariables.board[1][c].getText()) &&
                    Objects.equals(ticTacToeVariables.board[1][c].getText(), ticTacToeVariables.board[2][c].getText())){
                for (int i=0 ; i<3 ; i++){
                    setWinner(ticTacToeVariables.board[i][c]);
                }
                ticTacToeVariables.gameOver = true;
                return;
            }
        }
    }
    void checkDiagonally(){

        if (Objects.equals(ticTacToeVariables.board[0][0].getText(), ticTacToeVariables.board[1][1].getText()) &&
                Objects.equals(ticTacToeVariables.board[1][1].getText(), ticTacToeVariables.board[2][2].getText()) &&
                !Objects.equals(ticTacToeVariables.board[0][0].getText(), "")){
            for (int i=0 ; i<3 ; i++){
                setWinner(ticTacToeVariables.board[i][i]);
            }
            ticTacToeVariables.gameOver = true;
            return;
        }

    }
    void checkUntiDiagonally(){
        if (Objects.equals(ticTacToeVariables.board[0][2].getText(), ticTacToeVariables.board[1][1].getText()) &&
                Objects.equals(ticTacToeVariables.board[1][1].getText(), ticTacToeVariables.board[2][0].getText()) &&
                !Objects.equals(ticTacToeVariables.board[0][2].getText(), "")){
            setWinner(ticTacToeVariables.board[0][2]);
            setWinner(ticTacToeVariables.board[1][1]);
            setWinner(ticTacToeVariables.board[2][0]);
            ticTacToeVariables.gameOver = true;
            return;
        }

    }
    void checkTie(){

        if (ticTacToeVariables.turns == 9){
            for (int r=0 ; r<3 ; r++){
                for (int c=0 ; c<3 ; c++){
                    setTie(ticTacToeVariables.board[r][c]);
                }
            }
            ticTacToeVariables.gameOver = true;
        }

    }

    void setTie(JButton tile){
        tile.setForeground(Color.orange);
        tile.setBackground(Color.gray);
        ticTacToeVariables.textLabel.setText("Tie!");
    }

    void setWinner(JButton tile){
        tile.setForeground(Color.GREEN);
        tile.setBackground(Color.GRAY);
        ticTacToeVariables.textLabel.setText(ticTacToeVariables.currentPlayer+" is the winner!");
    }

}
