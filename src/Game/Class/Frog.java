package Game.Class;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Frog {
    private Rectangle conllisionMask;
    private location point;
    private Size size;
    private BufferedImage img1;
    private BufferedImage img2;
    private BufferedImage img3;

    private BufferedImage image;
    private final Color CRYSTAL_CLEAR = new Color(255, 255, 255, 0);

    private static final int ANIMATION_TIME = 5;
    private int countImg = 0;
    private int tickCount = 0;
    private int velosity = 0;
    private int yBeforeJump;
    private boolean jumping = false;
    private boolean faceR = true;


    @Override
    public String toString() {
        return "Frog{" +
                "conllisionMask=" + conllisionMask +
                ", point=" + point +
                ", size=" + size +
                ", image=" + (image !=null) +
                ", CRYSTAL_CLEAR=" + CRYSTAL_CLEAR +
                ", countImg=" + countImg +
                ", tickCount=" + tickCount +
                ", velosity=" + velosity +
                ", yBeforeJump=" + yBeforeJump +
                ", jumping=" + jumping +
                ", faceR=" + faceR +
                '}';
    }

    public Frog(location point, Size size) {
        this.point = point;
        this.size = size;
        this.conllisionMask = new Rectangle(point.getX(), point.getY(), size.getWidth(), size.getHeight());
        try {
//            for (int i = 0; i < 3; i++) {
//                img[i] = ImageIO.read(new File("src/Imgs/forg" + i + ".png"));
//        }
            img1 = ImageIO.read(new File("src/Imgs/forg1.png"));
            img2 = ImageIO.read(new File("src/Imgs/forg2.png"));
            img3 = ImageIO.read(new File("src/Imgs/forg3.png"));
            image = ImageIO.read(new File("src/Imgs/forg2.png"));
        } catch (IOException e) {
            System.out.println(e);
        }
//        image = img[2];
    }

    public BufferedImage getImage() {
        return image;
    }

    public void draw() {
        if (jumping){
            countImg++;
            if (countImg < this.ANIMATION_TIME) {
                image = img1;
            } else if (countImg < this.ANIMATION_TIME * 2) {
                image = img2;
            } else if (countImg < this.ANIMATION_TIME * 3) {
                image = img3;
            } else if (countImg == this.ANIMATION_TIME * 3+1){
                jumping =false;
                countImg = 0;
                image = img2;
            }
        }else {
            image = img2;
        }
        System.out.println("countImg"+countImg);

    }

    public void move() {
        tickCount++;
        int displacement = (int) (velosity*tickCount + 1.5*3*tickCount*tickCount);
        if (displacement >= 30)
        displacement = (displacement/Math.abs(displacement)) * 30;
        if (displacement < 0) {
            displacement -= 30;
//            tickCount =0;
        }
        point.setY((point.getY() + displacement));
//        System.out.println("displacement: "+displacement+" tickCount: "+tickCount);


    }


    public void jump() {
        tickCount = 0;
        velosity = -30;
        yBeforeJump = this.point.getY();
        jumping = true;


    }

    public Size getSize() {
        return size;
    }

    public location getPoint() {
        return point;
    }

    public void setPoint(location point) {
        this.point = point;
    }

//    private BufferedImage rotateCounterClockwise90(BufferedImage image) {
//        final double rads = Math.toRadians(90);
//        final double sin = Math.abs(Math.sin(rads));
//        final double cos = Math.abs(Math.cos(rads));
//        final int w = (int) Math.floor(image.getWidth() * cos + image.getHeight() * sin);
//        final int h = (int) Math.floor(image.getHeight() * cos + image.getWidth() * sin);
//        final BufferedImage rotatedImage = new BufferedImage(w, h, image.getType());
//        final AffineTransform at = new AffineTransform();
//        at.translate(w / 2, h / 2);
//        at.rotate(rads, 0, 0);
//        at.translate(-image.getWidth() / 2, -image.getHeight() / 2);
//        final AffineTransformOp rotateOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
//        rotateOp.filter(image, rotatedImage);
//        return image;
//    }

}
