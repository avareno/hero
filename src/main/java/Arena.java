import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Arena {
    private int width;
    private int height;
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

    public static void draw(Screen screen) {
        hero.draw(screen);
    }
}
