package Game.nw;

import Game.Class.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Renderer extends JPanel {


    private static final long serialVersionUID = 1L;
    private final static Size NEWPIPE = new Size(700, 150);

//    public static Render render;

    private Frog frog;
    private ArrayList<Pipe> pipes;
    private BackGroud backGroud;
    private Base base;
    private CheckGame checkGame;

    public Renderer(Frog frog, ArrayList<Pipe> pipes, BackGroud backGroud, Base base, CheckGame checkGame) {
        this.frog = frog;
        this.pipes = pipes;
        this.backGroud = backGroud;
        this.base = base;
        this.checkGame = checkGame;
    }

    public void repaint(Graphics g) {

        g.drawImage(backGroud.getImg(), 0, 0, backGroud.getSize().getWidth(), backGroud.getSize().getHeight(), null);
        g.drawImage(base.getImg(), base.getPoint().getX(), base.getPoint().getY(), base.getSize().getWidth(), base.getSize().getHeight(), null);
        frog.draw();
        g.drawImage(frog.getImage(), frog.getPoint().getX(), frog.getPoint().getY(), frog.getSize().getWidth(), frog.getSize().getHeight(), null);
//        for (Pipe i : pipes) {
        for (int i = 0; i < pipes.size(); i++) {
            Pipe pipe = pipes.get(i);
            g.drawImage(pipe.getImgTop(), pipe.getPoint().getX(), pipe.getPoint().getY() - 700 - 100, NEWPIPE.getWidth(), NEWPIPE.getHeight(), null);
            g.drawImage(pipe.getImgBot(), pipe.getPoint().getX(), pipe.getPoint().getY() + 100, NEWPIPE.getWidth(), NEWPIPE.getHeight(), null);
            System.out.println(pipe.getPoint().getY() + " point y pipe");
            g.setColor(Color.red);
            g.fillRect(pipe.getPoint().getX(), pipe.getPoint().getY(), 10, 10);
        }
        g.setColor(Color.white);
        g.setFont(new Font("Arial", 1, 100));
        if (!checkGame.isStarted()) {
            g.drawString("Click to start!", 75, backGroud.getSize().getHeight() / 2 - 50);
        }

        if (checkGame.isGameOver()) {
            g.drawString("Game Over!", 100, backGroud.getSize().getHeight() / 2 - 50);
        }

        if (checkGame.isStarted() && !checkGame.isGameOver()) {
            g.drawString(String.valueOf(checkGame.count), backGroud.getSize().getWidth() / 2 - 25, 100);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.repaint(g);
    }

}
