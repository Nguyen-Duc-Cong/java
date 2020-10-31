package Game.Class;


public class location {
    private int x;
    private int y;
    public location(int x, int y) { this.x = x;this.y = y; }
    public int getX() { return x; }
    public void setX(int x) { this.x = x; }
    public int getY() { return y; }

    @Override
    public String toString() {
        return "location{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public void setY(int y) { this.y = y; }
}
