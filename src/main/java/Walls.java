import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Walls extends Element {

    public Walls(int x , int y)
    {
        setPosition(x,y);

    }

    public void setPosition(int c, int i)
    {
        Position position = new Position(c,i);
        setPosition(position);
    }

    @Override
    public void draw(TextGraphics graphics) {
        super.draw(graphics);
        graphics.setForegroundColor(TextColor.Factory.fromString("#00ffa6"));
        graphics.putString(new TerminalPosition(getPosition().getX(),getPosition().getY()),"█");
    }
}
