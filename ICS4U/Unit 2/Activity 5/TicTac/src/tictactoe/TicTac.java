package tictactoe;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * A Tic-Tac-Toe program main class.
 * @author Chris DeVisser
 */
public final class TicTac extends JFrame {
    public TicTac() {
        super(Constant.Game.TITLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Game.frame = this;

        //trigger resize
        Options.setIcon(
            Constant.Icon.EMPTY_INDEX,
            new ImageIcon(Constant.Icon.EMPTY)
        );

        Menu.create();
        Game.start();

        setVisible(true);
    }

    /**
     * The main function.
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        TicTac t = new TicTac();
    }
}