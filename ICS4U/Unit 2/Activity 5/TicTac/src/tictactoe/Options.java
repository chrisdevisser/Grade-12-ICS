package tictactoe;

import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Options for the Tic-Tac-Toe game.
 * @author Chris DeVisser
 */
public final class Options {
    private static int _dims = Constant.Game.DEF_DIMS;
    private static int _numberToWin = Constant.Game.DEF_NUM_TO_WIN;
    private static ImageIcon[] _icons = {
        new ImageIcon(Constant.Icon.EMPTY),
        new ImageIcon(Constant.Icon.P1),
        new ImageIcon(Constant.Icon.P2)
    };
    private static boolean _openScoreAtEnd = true;

    /**
     * Sets the dimensions of the game.
     * @param dims The number of rows/columns.
     */
    public static void setDimensions(int dims) {
        if (dims == _dims) {
            return;
        }

        if (Game.isActive() && Game.hasStarted()
            && JOptionPane.showConfirmDialog(
                null, "This will start a new game. Are you sure?"
           ) != JOptionPane.YES_OPTION
        ) {
            //select the previous Size option
            checkMenuItem(Constant.Menu.M10, ((Integer)_dims).toString());
            return;
        }

        _dims = dims;
        _numberToWin = dims;

        //select the same Number to Win option
        checkMenuItem(Constant.Menu.M11, ((Integer)_dims).toString());

        sizeToFit(); //pack() kills it
        Game.end();
        Game.start();
    }

    /**
     * Gets dimensions of the game.
     * @return The number of rows/columns.
     */
    public static int getDimensions() {
        return _dims;
    }

    /**
     * Sets number of required consecutive squares to win.
     * @param num The required number of consecutive squares to win.
     */
    public static void setNumberToWin(int num) {
        if (num == _numberToWin) {
            return;
        }

        if (Game.isActive() && Game.hasStarted()
            && JOptionPane.showConfirmDialog(
                null, "This will start a new game. Are you sure?"
           ) != JOptionPane.YES_OPTION
        ) {
            //select previous option
            checkMenuItem(
                Constant.Menu.M11,
                ((Integer)_numberToWin).toString()
            );
            return;
        }

        _numberToWin = num;

        //change size if needed
        if (_numberToWin > _dims) {
            _dims = _numberToWin;
            checkMenuItem(Constant.Menu.M10, ((Integer)num).toString());
        }

        Game.end();
        Game.start();
    }

    /**
     * Gets number of required consecutive squares to win.
     * @return The required number of consecutive squares to win
     */
    public static int getNumberToWin() {
        return _numberToWin;
    }

    /**
     * Sets icon at specified index.
     * @param index The index to set icon for
     * @param icon The icon to set
     * @throws IllegalArgumentException
     */
    public static void setIcon(int index, ImageIcon icon) {
        if (index < 0 || index >= Constant.Icon.NUM) {
            throw new IndexOutOfBoundsException(
                "Index must be between 0 and " + (Constant.Icon.NUM - 1) + "."
            );
        }

        _icons[index] = icon;
        sizeToFit();
        Game.frame.invalidate();
        Game.frame.validate();
        Game.frame.repaint();
    }

    /**
     * Retrieves icon at specified index.
     * @param index The index of the icon
     * @return The icon at the index
     */
    public static ImageIcon getIcon(int index) {
        if (index < 0 || index >= Constant.Icon.NUM) {
            throw new IndexOutOfBoundsException(
                "Index must be between 0 and " + (Constant.Icon.NUM - 1) + "."
            );
        }

        return _icons[index];
    }

    /**
     * Sets whether the score opens at the end of each game.
     * @param b True if the score should open at the end of each game
     */
    public static void setOpenAtEnd(boolean b) {
        _openScoreAtEnd = b;
    }

    /**
     * Gets whether the score opens at the end of each game.
     * @return True if the score opens at the end of each game, else false
     */
    public static boolean getOpenAtEnd() {
        return _openScoreAtEnd;
    }

    /**
     * Retrieves the options menu.
     * @return The options menu.
     */
    private static JMenu getOptionsMenu() {
        JMenuBar menuBar = Game.frame.getJMenuBar();
        for (int i = 0; i < menuBar.getComponentCount(); ++i) {
            JMenu menu = (JMenu)menuBar.getComponent(i);
            if (menu.getText().equals(Constant.Menu.M1)) {
                return menu;
            }
        }
        return null;
    }

    /**
     * Retrieves a submenu of the options menu.
     * @param name The name of the submenu
     * @return The submenu with the specified name
     */
    private static JMenu getSubOptionsMenu(String name) {
        JMenu menu = null;
        for (int i = 0; i < getOptionsMenu().getItemCount(); ++i) {
            menu = (JMenu)getOptionsMenu().getItem(i);
            if (menu.getText().equals(name)) {
                return menu;
            }
        }
        return null;
    }

    /**
     * Selects a menu item in a submenu of the option menu.
     * @param menuName The name of the submenu
     * @param itemName The name of the item in the submenu to check
     */
    private static void checkMenuItem(String menuName, String itemName) {
        
        JMenu menu = getSubOptionsMenu(menuName);
        if (menu == null) {
            return;
        }

        for (int i = 0; i < menu.getItemCount(); ++i) {
            JMenuItem mi = menu.getItem(i);
            if (mi.getText().equals(itemName)) {
                mi.setSelected(true);
            }
        }
    }

    private static void sizeToFit() {
        int w1 = getIcon(Constant.Icon.EMPTY_INDEX).getIconWidth();
        int w2 = getIcon(Constant.Icon.P2_INDEX).getIconWidth();
        int w3 = getIcon(Constant.Icon.P1_INDEX).getIconWidth();

        int h1 = getIcon(Constant.Icon.EMPTY_INDEX).getIconHeight();
        int h2 = getIcon(Constant.Icon.P2_INDEX).getIconHeight();
        int h3 = getIcon(Constant.Icon.P1_INDEX).getIconHeight();

        int wmax = Math.max(Math.max(w1, w2), w3) * (getDimensions() + 2);
        int hmax = Math.max(Math.max(h1, h2), h3) * (getDimensions() + 1);

        Game.frame.setSize(wmax, hmax);
    }
}
