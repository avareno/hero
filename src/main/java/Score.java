import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Score extends Element{
    private int health=5;
    private int points=0;

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Score()
    {

    }
    @Override
    public void draw(TextGraphics graphics)
    {
        this.setPosition(new Position(40,0));
        super.draw(graphics);
        graphics.setBackgroundColor(TextColor.Factory.fromString("#00ffa6"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#330099"));
        graphics.putString(new TerminalPosition(getPosition().getX(),getPosition().getY()),"Health="+health+"/5  Score="+points+"/5");
    }


}
