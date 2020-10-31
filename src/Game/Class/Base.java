package Game.Class;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Base {
    private location point;
    private Size size;
    public BufferedImage img;



    public Base(location point, Size size) {
        this.point = point;
        this.size = size;
        try {
            img = ImageIO.read(new File("src/Imgs/base.png"));
        } catch (IOException e) {
        }
    }

    public location getPoint() {
        return point;
    }

    public void setPoint(location point) {
        this.point = point;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }
}
