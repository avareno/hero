import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Hero {
    private Position position = new Position();
    Hero()
    {
        this.position = new Position();
    }
    Hero(int x, int y)
    {
        this.position = new Position(x,y);
    }


    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
                graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(Position.getX(),
                Position.getY()), "X");
    }

    public void moveleft()
    {
        this.position.setX(Position.getX()-1);
    }
    public void moveright()
    {
        this.position.setX(Position.getX()+1);
    }
    public void moveup()
    {
        this.position.setY(Position.getY()-1);
    }
    public void movedown()
    {
        this.position.setY(Position.getY()+1);
    }
}
