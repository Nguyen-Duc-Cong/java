package Game.nw;

import Game.Class.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Game implements ActionListener, KeyListener, MouseListener {
    private static Game game;

    private final Size size = new Size(1000, 800);
    private BackGroud backGroud;
    private Frog frog;
    private Base base;
    private ArrayList<Pipe> pipes;


    private CheckGame checkGame;
    private Update update;
    private Renderer render;
    private final static Size NEWPIPE = new Size(700, 150);

    public Game() {
        this.backGroud = new BackGroud(size);
        this.frog = new Frog(new location(400, 500), new Size(100, 100));
        this.base = new Base(new location(0, 900), new Size(100, 800));
        this.pipes = new ArrayList<>();
        this.checkGame = new CheckGame(frog, pipes);

        pipes.add(new Pipe(new location(900, 500), NEWPIPE));


        this.update = new Update(frog, pipes, backGroud, base, checkGame);
        this.render = new Renderer(frog, pipes, backGroud, base, checkGame);

        JFrame jframe = new JFrame();
        Timer timer = new Timer(80, this);
        jframe.add(render);
        jframe.setTitle("Flappy Bird");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(size.getWidth(), size.getHeight());

        jframe.addMouseListener(this);
        jframe.addKeyListener(this);
        jframe.setResizable(false);
        jframe.setVisible(true);
        timer.start();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        update.loop();
//        System.out.println(frog.toString());
        render.repaint();
    }


    public static void main(String[] args) {
        game = new Game();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            frog.jump();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (!checkGame.isGameOver() && checkGame.isStarted()) {
            frog.jump();
            System.out.println("jump");
        } else {
            if (!checkGame.isStarted())
                checkGame.setStarted(true);
            checkGame.setGameOver(false);

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
