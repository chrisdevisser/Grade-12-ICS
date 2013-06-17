package tictactoe;

import java.awt.event.KeyEvent;

/**
 * A set of constants for the tic-Tac-Toe program.
 * @author Chris DeVisser
 */
public final class Constant {
    public final class Game {
        final static String TITLE = "Tic-Tac-Toe";

        final static int DEF_WIDTH = 500;
        final static int DEF_HEIGHT = 500;
        
        final static int MIN_DIMS = 3; //3x3 min
        final static int DEF_DIMS = 3;
        final static int DEF_NUM_TO_WIN = 3; //3 in a row
        final static int MAX_DIMS = 8; //8x8 max
    }

    public final class Player {
        final static int NONE = 0;
        final static int P1 = 1;
        final static int P2 = 2;
    }

    public final class Icon {
        final static int NUM = 3;

        //for image filechooser
        //I'd use an array if I had the time to figure out how
        final static String FILTERNAME = "Images";
        final static String FILTER0 = "png";
        final static String FILTER1 = "jpg";
        final static String FILTER2 = "jpeg";
        final static String FILTER3 = "gif";
        final static String FILTER4 = "bmp";

        //default icons
        final static String EMPTY = Constant.Icon.TICTAC_EMPTY;
        final static String P1 = Constant.Icon.TICTAC_P1;
        final static String P2 = Constant.Icon.TICTAC_P2;

        //themes
        final static String EMOTIONS_EMPTY = "res/nothing.jpg";
        final static String EMOTIONS_P1 = "res/happyface.png";
        final static String EMOTIONS_P2 = "res/sadface.jpg";

        final static String CLASSIC_EMPTY = "res/brick.jpg";
        final static String CLASSIC_P1 = "res/o.jpg";
        final static String CLASSIC_P2 = "res/x.jpg";

        final static String TICTAC_EMPTY = "res/tictac-white.jpg";
        final static String TICTAC_P1 = "res/tictac-orange.jpg";
        final static String TICTAC_P2 = "res/tictac-citrus.jpg";

        //indices in the icon array
        final static int EMPTY_INDEX = 0;
        final static int P1_INDEX = 1;
        final static int P2_INDEX = 2;

        //max when combining all icons, used when selecting a custom icon
        final static int MAX_COMBINED_WIDTH = 1000;
        final static int MAX_COMBINED_HEIGHT = 1000;
    }

    public final class Menu {
        //menu structure with names and mnemonics
        final static String M0 = "File";
        final static int M0_KEY = KeyEvent.VK_F;
            final static String M00 = "New";
            final static int M00_KEY = KeyEvent.VK_N;
            final static String M01 = "Exit";
            final static int M01_KEY = KeyEvent.VK_E;
        final static String M1 = "Options";
        final static int M1_KEY = KeyEvent.VK_O;
            final static String M10 = "Size";
            final static int M10_KEY = KeyEvent.VK_S;
                //MIN_DIMS through MAX_DIMS
            final static String M11 = "Number to Win";
            final static int M11_KEY = KeyEvent.VK_N;
                //MIN_DIMS through MAX_DIMS
            final static String M12 = "Icon";
            final static int M12_KEY = KeyEvent.VK_I;
                final static String M120 = "Empty...";
                final static int M120_KEY = KeyEvent.VK_0;
                final static String M121 = "Player 1...";
                final static int M121_KEY = KeyEvent.VK_1;
                final static String M122 = "Player 2...";
                final static int M122_KEY = KeyEvent.VK_2;
                final static String M123 = "Themes";
                final static int M123_KEY = KeyEvent.VK_T;
                    final static String M1230 = "Emotions";
                    final static int M1230_KEY = KeyEvent.VK_E;
                    final static String M1231 = "Classic";
                    final static int M1231_KEY = KeyEvent.VK_C;
                    final static String M1232 = "Tictac";
                    final static int M1232_KEY = KeyEvent.VK_T;
            final static String M13 = "Always show score";
            final static int M13_KEY = KeyEvent.VK_A;
            final static String M14 = "Open score at end of game";
            final static int M14_KEY = KeyEvent.VK_O;
    }
}
