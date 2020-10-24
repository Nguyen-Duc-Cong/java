package Game.nw;

import Game.Class.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public abstract class Renderer implements ActionListener, KeyListener, MouseListener {

    private final Size size = new Size(1000, 800);
    private final static int GRAVITATION = 15;
    private final static int PIPEVELOCITY = 15;
    private boolean gameOver = false;

    private Graphics Render;
    private BackGroud backGroud;
    private Frog frog;
    private Base base;
    private ArrayList<Pipe> pipes;

    public Renderer() {
        JFrame jFrame = new JFrame();
        jFrame.addMouseListener(this);
        jFrame.addKeyListener(this);
    }

    public void setupGame() {
        BackGroud backGroud = new BackGroud(size);
        Frog frog = new Frog();
        Base base = new Base();
        ArrayList<Pipe> pipes = new ArrayList<>();
        gameOver = false;

    }

    public void reset() {
        pipes.clear();
    }

    public void paint(Graphics g) {
        g.drawImage(backGroud.getImg(), 0, 0, null);
        g.drawImage(frog.getImage(), frog.getSize().getHeight(), frog.getSize().getWidth(), null);
        for (Pipe pipe : pipes) {
            pipe.draw(g);

        }
    }

    public void update() {
        checkGameRunning();
        if (!gameOver) {
            frog.setPoint(new Point(frog.getPoint().x, frog.getPoint().y + GRAVITATION));
            for (Pipe pipe : pipes) {
                pipe.setPoint(new Point(frog.getPoint().x - PIPEVELOCITY, frog.getPoint().y));
                if (pipe.getPoint().x < 0)
                    pipes.remove(pipe);
            }
        } else {
            reset();
        }
    }

    public void checkGameRunning() {
        if (frog.getPoint().y < 0) {
            gameOver = true;
            return;
        }
        if (frog.getPoint().y > size.getHeight()) {
            gameOver = true;
            return;
        }
//            for (Pipe pipe : pipes) {
//                if (frog.getPoint().x + frog.getSize().getWidth() + bouncingRectSpeedX > pipe.getPoint().x &&
//                        frog.getPoint().x + bouncingRectSpeedX < pipe.getPoint().x + pipe.getSize().getWidth() &&
//                        frog.getPoint().y + frog.getSize().getHeight() > pipe.getPoint().y &&
//                        frog.getPoint().y < pipe.getPoint().y+ pipe.getSize().getHeight()) {
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
                return;
            }
        }
        gameOver = false;
        return;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (!gameOver) {
                frog.jump();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (!gameOver) {
            frog.jump();
        }
    }

}
