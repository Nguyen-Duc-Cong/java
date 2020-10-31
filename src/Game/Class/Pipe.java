package Game.Class;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Pipe {
    private Rectangle conllisionMask;
    private location point;
    private Size size;
    private BufferedImage imgTop;
    private BufferedImage imgBot;
    private boolean finish;

    private Random ran;

    public Rectangle getConllisionMask() {
        return conllisionMask;
    }

    public location getPoint() {
        return point;
    }


    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public Pipe(location point, Size size) {
        this.point = point;
        this.size = size;
        finish = false;
        ran = new Random();
        this.point.setY(200+ ran.nextInt(600));
        this.conllisionMask = new Rectangle(point.getX(), point.getY(), size.getWidth(), size.getHeight());
        try {
            this.imgTop = ImageIO.read(new File("src/Imgs/pipe2.png"));
            this.imgBot = ImageIO.read(new File("src/Imgs/pipe1.png"));
        } catch (IOException e) {
        }

    }
    public Size getSize() {
        return size;
    }

    public BufferedImage getImgTop() {
        return imgTop;
    }


    public BufferedImage getImgBot() {
        return imgBot;
    }


    public void setPoint(location point) {
        this.point = point;
    }
}
