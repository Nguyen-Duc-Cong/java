package Game.Class;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Frog {
    private Rectangle conllisionMask;
    private Point point;
    private Size size;
    private BufferedImage[] img;

    private BufferedImage image;
    private JLabel boxImg;
    private final Color CRYSTAL_CLEAR = new Color(255, 255, 255, 0);

    private static final int ANIMATION_TIME = 2;
    private int countImg = 0;
    private boolean moving = false;
    private boolean faceR = true;

    public Frog() {
    }

    public Frog(Point point, Size size) {
        this.point = point;
        this.size = size;
        this.conllisionMask = new Rectangle(point.x,point.y,size.getWidth(),size.getHeight());
        try {
            for (int i = 0; i < 3; i++) {
                img[i] = ImageIO.read(new File("/Imgs/forg" + i + ".png"));
            }
        } catch (IOException e) {
        }
    }

    public BufferedImage getImage() {
        return image;
    }

    public void draw(Graphics window) {
        countImg++;

        try {
            if (faceR){
                if (countImg < this.ANIMATION_TIME) {
                    image = ImageIO.read(new File("/Imgs/forg1.png.png.png"));

                } else if (countImg < this.ANIMATION_TIME * 2) {
                    image = ImageIO.read(new File("/Imgs/forg2.png.png.png"));

                } else if (countImg < this.ANIMATION_TIME * 3) {
                    image = ImageIO.read(new File("/Imgs/forg3.png.png.png"));
                }
            }else {
                if (countImg < this.ANIMATION_TIME) {
                    image = ImageIO.read(new File("/Imgs/forg1.png.png.png"));
                    image = rotateCounterClockwise90(image);

                } else if (countImg < this.ANIMATION_TIME * 2) {
                    image = ImageIO.read(new File("/Imgs/forg2.png.png.png"));
                    image = rotateCounterClockwise90(image);

                } else if (countImg < this.ANIMATION_TIME * 3) {
                    image = ImageIO.read(new File("/Imgs/forg3.png.png.png"));
                    image = rotateCounterClockwise90(image);
                }
            }
        } catch (IOException e) {
        }    }
    public void move(){
        countImg++;
        if (!moving) {
            countImg = 0;
            idle();
        }
        else jump();
    }
    public void idle() {

        try {
            image = ImageIO.read(new File("/Imgs/forgIdle.png.png"));
            if (faceR) {
                image = ImageIO.read(new File("/Imgs/forgIdle.png.png"));

            } else {
                image = rotateCounterClockwise90(image);
            }
        } catch (IOException e) {
        }
    }
    public void jump() {
    }

    public Size getSize() {
        return size;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    private BufferedImage rotateCounterClockwise90(BufferedImage image) {
        final double rads = Math.toRadians(90);
        final double sin = Math.abs(Math.sin(rads));
        final double cos = Math.abs(Math.cos(rads));
        final int w = (int) Math.floor(image.getWidth() * cos + image.getHeight() * sin);
        final int h = (int) Math.floor(image.getHeight() * cos + image.getWidth() * sin);
        final BufferedImage rotatedImage = new BufferedImage(w, h, image.getType());
        final AffineTransform at = new AffineTransform();
        at.translate(w / 2, h / 2);
        at.rotate(rads, 0, 0);
        at.translate(-image.getWidth() / 2, -image.getHeight() / 2);
        final AffineTransformOp rotateOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        rotateOp.filter(image, rotatedImage);
        return image;
    }

}
