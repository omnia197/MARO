package Games.SpaceInvaders;

public class Board {
    private int tileSize;
    private int rows;
    private int columns;
    private int boardWidth;
    private int boardHeight;
    private static Board b = new Board();

    private Board() {}

    public static Board getB() {
        return b;
    }

    public int getTileSize() { return tileSize; }
    public void setTileSize(int tileSize) {
        this.tileSize = tileSize;
        updateDimensions();
    }

    public int getRows() { return rows; }
    public void setRows(int rows) {
        this.rows = rows;
        updateDimensions();
    }

    public int getColumns() { return columns; }
    public void setColumns(int columns) {
        this.columns = columns;
        updateDimensions();
    }

    public int getBoardWidth() { return boardWidth; }
    public int getBoardHeight() { return boardHeight; }

    private void updateDimensions() {
        this.boardWidth = this.columns * this.tileSize;
        this.boardHeight = this.rows * this.tileSize;
    }
}