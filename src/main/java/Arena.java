import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public class Arena {
    private static int width;
    private static int height;
    private static Hero hero = new Hero();
    public static void processKey(KeyStroke key) throws IOException {
        switch(key.getKeyType())
        {
            case ArrowLeft:
                hero.moveleft();
                break;
            case ArrowDown:
                hero.movedown();
                break;
            case ArrowRight:
                hero.moveright();
                break;
            case ArrowUp:
                hero.moveup();
                break;
            case Character:
                if(key.getCharacter()=='q')Game.screen.close();


        }
        System.out.println(key);
    }

    public static Hero getHero() {
        return hero;
    }

    public static void setHero(Hero hero) {
        Arena.hero = hero;
    }

    public static int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public static int getWidth() {
        return width;
    }

    public Arena() {
        width=100;
        height=100;
    }

    public static void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
                graphics.fillRectangle(new TerminalPosition(0, 0), new
                        TerminalSize(getWidth(), getWidth()), ' ');
        hero.draw(graphics);
    }
}
