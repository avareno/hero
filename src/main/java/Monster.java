import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Monster extends Element{
    public Monster(int i, int i1)
    {
        super(i,i1);
    }

    public Position move()
    {
        List<Position> pos = new ArrayList<>();
        Random random = new Random();
        pos.add(new Position(this.getPosition().getX()+1,this.getPosition().getY()));
        pos.add(new Position(this.getPosition().getX()-1,this.getPosition().getY()));
        pos.add(new Position(this.getPosition().getX(),this.getPosition().getY()-1));
        pos.add(new Position(this.getPosition().getX(),this.getPosition().getY()+1));
        int i = random.nextInt(4);
        return pos.get(i);
    }

    @Override
    public void draw(TextGraphics graphics) {
        super.draw(graphics);
        graphics.setForegroundColor(TextColor.Factory.fromString("#ff0000"));
        graphics.putString(new TerminalPosition(getPosition().getX(),getPosition().getY()),"M");
    }
}
