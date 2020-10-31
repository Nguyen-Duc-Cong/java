package Game.Class;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackGroud {
    private Size size;
    private BufferedImage img;

    public BackGroud(Size size) {
        this.size = size;
        try {
            img = ImageIO.read(new File("src/Imgs/bg.png"));
        } catch (IOException e) {
        }
    }

    public Size getSize() {
        return size;
    }

    public void Draw() {
    }

    public BufferedImage getImg() {
        return img;
    }
    public void paint(Graphics g){
        g.drawImage(img,0,0, 800,1000, null);

    }
}
