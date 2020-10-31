package Game.nw;

import Game.Class.Frog;
import Game.Class.Pipe;
import Game.Class.chuanghiraten;

import java.util.ArrayList;

public class CheckGame {
    private boolean gameOver;
    private boolean started;


    private Frog frog;
    private ArrayList<Pipe> pipes;
    public int count;


    public CheckGame(Frog frog, ArrayList<Pipe> pipes) {
        this.frog = frog;
        this.pipes = pipes;
        started = false;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean checkGameOver() {
        if (frog.getPoint().getY() < 0) {
            gameOver = true;
            return true;
        }
        if (frog.getPoint().getY() > 1000) {
            gameOver = true;
            return true;
        }
        for (Pipe pipe : pipes) {

            if (frog.getPoint().getX() + frog.getSize().getWidth() >= pipe.getPoint().getX() &&
//                    frog.getPoint().getX() + frog.getSize().getWidth() <= pipe.getPoint().getX() + pipe.getSize().getWidth())
                    frog.getPoint().getX() + frog.getSize().getWidth() <= pipe.getPoint().getX() + chuanghiraten.BOXNULL) {
                System.out.println("check game  in pipe X" + pipe.toString());
                if (frog.getPoint().getY() < (pipe.getPoint().getY() - chuanghiraten.BOXNULL) ||
                        frog.getPoint().getY() + frog.getSize().getHeight() > (pipe.getPoint().getY() + chuanghiraten.BOXNULL)) {
                    System.out.println("check game  in pipe y" + pipe.toString());
                    gameOver = true;
                    return true;
                }
            }
        }
        gameOver = false;
        return false;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}