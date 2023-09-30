import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.List;

public class Hero {
    private Position position;
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
        graphics.putString(new TerminalPosition(position.getX(),position.getY()), "X");
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void moveleft()
    {
        this.position.setX(position.getX()-1);
    }
    public void moveright()
    {
        this.position.setX(position.getX()+1);
    }
    public void moveup()
    {
        this.position.setY(position.getY()-1);
    }
    public void movedown()
    {
        this.position.setY(position.getY()+1);
    }


}
