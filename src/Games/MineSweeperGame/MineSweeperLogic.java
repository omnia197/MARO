package Games.MineSweeperGame;

import java.util.Random;
import java.util.ArrayList;

public class MineSweeperLogic {
    MineSweeperVariables mineSweeperVariables ;
    Random random = new Random();

    public MineSweeperLogic(MineSweeperVariables mineSweeperVariables){
        this.mineSweeperVariables = mineSweeperVariables;
    }

    void setMines() {
        mineSweeperVariables.mineList = new ArrayList<MineTile>();

        int mineLeft = mineSweeperVariables.mineCount;
        while (mineLeft > 0) {
            int r = random.nextInt(mineSweeperVariables.numRows); //0-7
            int c = random.nextInt(mineSweeperVariables.numCols);

            MineTile tile = mineSweeperVariables.board[r][c];
            if (!mineSweeperVariables.mineList.contains(tile)) {
                mineSweeperVariables.mineList.add(tile);
                mineLeft -= 1;
            }
        }
    }

    void revealMines() {
        for (int i = 0; i < mineSweeperVariables.mineList.size(); i++) {
            MineTile tile = mineSweeperVariables.mineList.get(i);
            tile.setText("💣");
        }

        mineSweeperVariables.gameOver = true;
        mineSweeperVariables.textLabel.setText("Game Over!");
    }

    void checkMine(int r, int c) {
        if (r < 0 || r >= mineSweeperVariables.numRows || c < 0 || c >= mineSweeperVariables.numCols) {
            return;
        }

        MineTile tile = mineSweeperVariables.board[r][c];
        if (!tile.isEnabled()) {
            return;
        }
        tile.setEnabled(false);
        mineSweeperVariables.tilesClicked += 1;

        int minesFound = 0;

        //top 3
        minesFound += countMine(r-1, c-1);  //top left
        minesFound += countMine(r-1, c);    //top
        minesFound += countMine(r-1, c+1);  //top right

        //left and right
        minesFound += countMine(r, c-1);    //left
        minesFound += countMine(r, c+1);    //right

        //bottom 3
        minesFound += countMine(r+1, c-1);  //bottom left
        minesFound += countMine(r+1, c);    //bottom
        minesFound += countMine(r+1, c+1);  //bottom right

        if (minesFound > 0) {
            tile.setText(Integer.toString(minesFound));
            mineSweeperVariables.score +=10;
        }
        else {
            tile.setText("");

            //top 3
            checkMine(r-1, c-1);    //top left
            checkMine(r-1, c);      //top
            checkMine(r-1, c+1);    //top right

            //left and right
            checkMine(r, c-1);      //left
            checkMine(r, c+1);      //right

            //bottom 3
            checkMine(r+1, c-1);    //bottom left
            checkMine(r+1, c);      //bottom
            checkMine(r+1, c+1);    //bottom right
        }

        if (mineSweeperVariables.tilesClicked == mineSweeperVariables.numRows * mineSweeperVariables.numCols - mineSweeperVariables.mineList.size()) {
            mineSweeperVariables.gameOver = true;
            mineSweeperVariables.textLabel.setText("Mines Cleared!");
        }
    }

    int countMine(int r, int c) {
        if (r < 0 || r >= mineSweeperVariables.numRows || c < 0 || c >= mineSweeperVariables.numCols) {
            return 0;
        }
        if (mineSweeperVariables.mineList.contains(mineSweeperVariables.board[r][c])) {
            return 1;
        }
        return 0;
    }
}
