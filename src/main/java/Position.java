public class Position {
    private static int x;
    private static int y;

    public Position() {
        this.x = 10;
        this.y = 10;
    }
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public static int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
