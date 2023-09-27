import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

public class Hero {
    private int x;
    private int y;
    Hero()
    {
        x=10;
        y=10;
    }
    Hero(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public void setX(int x)
    {
        this.x=x;
    }
    public void setY(int y)
    {
        this.y=y;
    }

    public void draw(Screen screen)
    {
        screen.setCharacter(x, y, TextCharacter.fromCharacter('X')[0]);
    }

    public void moveleft()
    {
        x--;
    }
    public void moveright()
    {
        x++;
    }
    public void moveup()
    {
        y--;
    }
    public void movedown()
    {
        y++;
    }
}
