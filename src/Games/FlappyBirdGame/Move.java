package Games.FlappyBirdGame;

public class Move {
    Variables vars ;
    Bird bird ;

    public Move(Variables vars , Bird bird){
        this.vars=vars;
        this.bird = bird;
    }

    public void move(){
        //bird
        vars.velocityY += vars.gravity ;
        bird.y += vars.velocityY ;
        bird.y = Math.max(bird.y, 0);

        //pipes
        for(int i = 0 ; i < vars.pipes.size() ; i++ ){
            Pipe pipe = vars.pipes.get(i);
            pipe.x += vars.velocityX ;

            if(!pipe.passed && bird.x > pipe.x + pipe.width){
                pipe.passed = true ;
                vars.score += 0.5 ;
            }

            if(collision(bird, pipe)){
                vars.gameOver = true ;
            }
        }

        if(bird.y > vars.boardheight){
            vars.gameOver = true ;
        }
    }

    public boolean collision(Bird a , Pipe b){
        return a.x < b.x + b.width &&
                a.x + a.width > b.x &&
                a.y < b.y + b.height &&
                a.y + a.height > b.y ;
    }
}
