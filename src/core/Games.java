package core;

public enum Games {

    TicTacToe(1),
    FLAPPY_BIRD(2),
    MINE_SWEEPER(3),
    PAC_MAN(4),
    SNAKE(5),
    MEMORY_CARD(6),
    SPACEINVADERS(7),
    PINGPONG(8);

    final int id;

    Games(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
