package Game.nw;

import Game.Class.*;

import java.util.ArrayList;

public class Update {
    private Frog frog;
    private ArrayList<Pipe> pipes;
    private BackGroud backGroud;
    private Base base;
    private CheckGame checkGame;

    private location NEWPIPIPOINT;

    public int count;

    private final static Size NEWPIPE = new Size(700, 150);

    public Update(Frog frog, ArrayList<Pipe> pipes, BackGroud backGroud, Base base, CheckGame checkGame) {
        this.frog = frog;
        this.pipes = pipes;
        this.backGroud = backGroud;
        this.base = base;
        this.checkGame = checkGame;
        NEWPIPIPOINT = new location(backGroud.getSize().getWidth() + 100, (int) backGroud.getSize().getHeight() / 2);
    }

    public void loop() {
        if (checkGame.isStarted() && !checkGame.isGameOver()) {
            for (int i = 0; i < pipes.size(); i++) {
                Pipe pipe = pipes.get(i);
                pipe.setPoint(new location(pipe.getPoint().getX() - chuanghiraten.PIPEVELOCITY, pipe.getPoint().getY()));
                if (pipe.getPoint().getX() + pipe.getSize().getWidth() < 0) {
                    pipes.remove(pipe);
                    if (pipe.getPoint().getX() - pipe.getSize().getWidth() <= 0) {
                        addColumn(false);
                    }
                }
                if (pipe.getPoint().getX() <= frog.getPoint().getY() && !pipe.isFinish()) {
                    checkGame.count += 1;
                    pipe.setFinish(true);
                }
            }
            frog.move();
            if (checkGame.checkGameOver())
                System.out.println("out");
        } else {
            reset();
        }
        System.out.println("it game start :"+ checkGame.isStarted() +" it gameover :" + checkGame.isGameOver());
    }

    public void reset() {
        pipes.clear();
        frog.getPoint().setY(400);
        frog.getPoint().setX(400);
        count = 0;
        pipes.add(new Pipe(NEWPIPIPOINT, NEWPIPE));
    }

    public void addColumn(boolean started) {
        if (started) {
            pipes.add(new Pipe(NEWPIPIPOINT, NEWPIPE));
        } else {
            pipes.add(new Pipe(NEWPIPIPOINT, NEWPIPE));
        }
    }

}
