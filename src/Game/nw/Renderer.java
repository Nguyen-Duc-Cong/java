package Game.nw;

import Game.Class.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Renderer implements ActionListener {
    //    public static Window window;
//    public static Renderer renderer;
    private final Size size = new Size(1000, 800);
    //    public int ticks, yMotion, score;
    private boolean gameOver = false;
    BackGroud backGroud;
    Frog frog;
    Base base;
    ArrayList<Pipe> pipes;

    public Renderer() {
    }

    public void setupGame() {
        BackGroud backGroud = new BackGroud(size);
        Frog frog = new Frog();
        Base base = new Base();
        ArrayList<Pipe> pipes = new ArrayList<>();
        gameOver =false;

    }

    public void reset() {

    }

    public void update(Graphics g) {
        g.drawImage(backGroud.getImg(), 0, 0, null);
        if (!gameOver) {
            if (frog.getPoint().y < 0)
                gameOver = true;
            if (frog.getPoint().y > size.getHeight())
                gameOver = true;
//            for (Pipe pipe : pipes) {
//                if (frog.getPoint().x + frog.getSize().getWidth() + bouncingRectSpeedX > pipe.getPoint().x &&
//                        frog.getPoint().x + bouncingRectSpeedX < pipe.getPoint().x + pipe.getSize().getWidth() &&
//                        frog.getPoint().y + frog.getSize().getHeight() > pipe.getPoint().y &&
//                        frog.getPoint().y < pipe.getPoint().y+ pipe.getSize().getHeight()) {
//
//                    bouncingRectSpeedX *= -1;
//                }
//                if (frog.getPoint().x + frog.getSize().getWidth() > pipe.getPoint().x &&
//                        frog.getPoint().x < pipe.getPoint().x + pipe.getSize().getWidth() &&
//                        frog.getPoint().y + frog.getSize().getHeight() + bouncingRectSpeedY > pipe.getPoint().y &&
//                        frog.getPoint().y + bouncingRectSpeedY < pipe.getPoint().y + pipe.getSize().getHeight()) {
//
//                    bouncingRectSpeedY *= -1;
//                }
            for (Pipe pipe : pipes) {
                if (frog.getPoint().x + frog.getSize().getWidth() > pipe.getPoint().x &&
                        frog.getPoint().x < pipe.getPoint().x + pipe.getSize().getWidth() &&
                        frog.getPoint().y + frog.getSize().getHeight() > pipe.getPoint().y &&
                        frog.getPoint().y < pipe.getPoint().y + pipe.getSize().getHeight()) {
                    gameOver = true;
                }

            }
        }


    }

}

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
