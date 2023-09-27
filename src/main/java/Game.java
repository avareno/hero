import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game
{
    private int flag = 0;
    private int c = 0;
    private static Screen screen;
    private Hero hero = new Hero();
    private void draw() throws IOException{
        screen.clear();
        hero.draw(screen);
        screen.refresh();
    }
    private void processKey(KeyStroke key) throws IOException {


        switch(key.getKeyType())
        {
            case ArrowLeft:
                hero.moveleft();
                draw();
                break;
            case ArrowDown:
                hero.movedown();
                draw();
                break;
            case ArrowRight:
                hero.moveright();
                draw();
                break;
            case ArrowUp:
                hero.moveup();
                draw();
                break;
            case Character:
                if(key.getCharacter() == 'q'){
                    flag =1;
                    screen.close();
                }

        }
        c++;
        System.out.println(key);
    }
    public void run() throws IOException {
        draw();
        while(flag==0) {
            KeyStroke key = screen.readInput();
            processKey(key);
        }
        screen.close();
    }




    Game()
    {
        try {

            TerminalSize terminalSize = new TerminalSize(40, 800);
            DefaultTerminalFactory terminalFactory = new
                    DefaultTerminalFactory()
                    .setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null); // we don't need a cursor
            screen.startScreen(); // screens must be started
            screen.doResizeIfNecessary(); // resize screen if necessary


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
