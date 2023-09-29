import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;


public class Game
{
    static Screen screen;

    private void draw() throws IOException{
        screen.clear();
        Arena.draw(screen.newTextGraphics());
        screen.refresh();
    }
    private void processKey(KeyStroke key) throws IOException {

        Arena.processKey(key);
    }
    public void run() throws IOException {

        KeyStroke key = screen.readInput();
        while(key.getKeyType()!=KeyType.EOF) {
            draw();
            key = screen.readInput();
            processKey(key);
        }
        screen.close();
    }




    Game()
    {
        try {
            Arena arena = new Arena();
            TerminalSize terminalSize = new TerminalSize(Arena.getWidth(), Arena.getHeight());
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
