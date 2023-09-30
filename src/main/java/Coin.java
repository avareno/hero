import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Coin extends Element{

    public Coin(int i, int i1)
    {

        setPosition(i,i1);

    }
    public void setPosition(int c, int i)
    {
        Position position = new Position(c,i);
        setPosition(position);
    }

    @Override
    public void draw(TextGraphics graphics)
    {
        super.draw(graphics);
        graphics.setForegroundColor(TextColor.Factory.fromString("#1bff00"));
        graphics.putString(new TerminalPosition(getPosition().getX(),getPosition().getY()),"@");
    }
}
