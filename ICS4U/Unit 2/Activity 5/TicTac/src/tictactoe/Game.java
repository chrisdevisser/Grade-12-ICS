package tictactoe;

import java.awt.GridLayout;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The game management class.
 * @author Chris DeVisser
 */
public final class Game {
    public static JFrame frame; //window to play on
    public static Scores scores = new Scores(0, 0, 0); //scores dialog
    
    private static int _player = Constant.Player.NONE;
    private static Board _board;
    private static JPanel _gamePanel = null; //panel board is on

    /**
     * Gets the current player.
     * @return The number of the current player (1 or 2)
     */
    public static int getPlayer() {
        return _player;
    }

    /**
     * Starts the game.
     */
    public static void start() {
        scores.newgame();
        int dims = Options.getDimensions();

        if (_gamePanel != null) {
            frame.remove(_gamePanel);
        }

        _gamePanel = new JPanel(new GridLayout(dims, dims));
        _board = new Board(dims, _gamePanel, null);
        frame.add(_gamePanel);
        frame.invalidate();
        frame.validate();

        _player = Constant.Player.P1;
    }

    /**
     * Ends the game.
     */
    public static void end() {
        _player = Constant.Player.NONE;
    }

    /**
     * Determines whether the game is active (it begins as active).
     * @return True if the game is active, or false otherwise
     */
    public static boolean isActive() {
        return getPlayer() != Constant.Player.NONE;
    }

    /**
     * Determines whether a player has made a move in the first game.
     * @return True if a move has been made, else false
     */
    public static boolean hasStarted() {
        return _board.getLastClicked() != null;
    }

    /**
     * Ends the current player's turn, checking for wins and ties.
     */
    public static void endTurn() {
        if (checkWins()) {
            if (getPlayer() == Constant.Player.P1) {
                scores.p1win();
            } else {
                scores.p2win();
            }

            if (Options.getOpenAtEnd()) {
                scores.setVisible(true);
            }
            
            end();
        }
        
        if (checkTies()) {
            scores.catwin();

            if (Options.getOpenAtEnd()) {
                scores.setVisible(true);
            }
            
            end();
        }

        if (_player == Constant.Player.P1) {
            _player = Constant.Player.P2;
        } else if (_player == Constant.Player.P2) {
            _player = Constant.Player.P1;
        }
    }

    /**
     * Checks for wins.
     * <dt><b>Precondition:</b><dd>It is still the end of the player's turn.
     * @return True if the current player has won, else false
     */
    public static boolean checkWins() {
        Point pt = _board.getLastClicked();

        if (checkWinsHorizontal(pt) || checkWinsVertical(pt)
            || checkWinsUpRight(pt) || checkWinsDownRight(pt)
        ) {
            return true;
        }

        return false;
    }

    /**
     * Checks for ties.
     * <dt><b>Precondition:</b><dd> There is no winner
     * @return True if game is tied, else false.
     */
    public static boolean checkTies() {
        return _board.isFull();
    }

    /**
     * Checks for wins horizontally.
     * @param pt The point to start checking
     * @return True if the current player has won horizontally, else false
     */
    private static boolean checkWinsHorizontal(Point pt) {
        //All of the win checking functions use this algorithm:
        //1. Start on the last clicked square.
        //2. Move in one direction and count squares owned by the player.
        //3. Stop when one is not owned by the player.
        //4. Repeat in the other direction.
        //5. Check the total to see if enough in a row were encountered.

        Point iter = (Point)pt.clone(); //thanks for that debugging, Java

        int count = 0;
        while (iter.x >= 0 
            && _board.getSquare(iter.x, iter.y).getPlayer() == _player
        ) {
            ++count;
            --iter.x;
        }

        iter = (Point)pt.clone();
        while (iter.x < Options.getDimensions() 
            && _board.getSquare(iter.x, iter.y).getPlayer() == _player
        ) {
            ++count;
            ++iter.x;
        }

        if (count > Options.getNumberToWin()) { //last clicked counted twice
            return true;
        }

        return false;
    }

    /**
     * Checks for wins vertically.
     * @param pt The point to start checking
     * @return True if the current player has won vertically, else false
     */
    private static boolean checkWinsVertical(Point pt) {
        Point iter = (Point)pt.clone(); 

        int count = 0;
        while (iter.y >= 0 
            && _board.getSquare(iter.x, iter.y).getPlayer() == _player
        ) {
            ++count;
            --iter.y;
        }

        iter = (Point)pt.clone();
        while (iter.y < Options.getDimensions() 
            && _board.getSquare(iter.x, iter.y).getPlayer() == _player
        ) {
            ++count;
            ++iter.y;
        }

        if (count > Options.getNumberToWin()) {
            return true;
        }

        return false;
    }

    /**
     * Checks for wins diagonally up and right.
     * @param pt The point to start checking
     * @return True if the current player has won diagonally up and right,
     *         else false
     */
    private static boolean checkWinsUpRight(Point pt) {
        Point iter = (Point)pt.clone();

        int count = 0;
        while (iter.x < Options.getDimensions()
            && iter.y >= 0
            && _board.getSquare(iter.x, iter.y).getPlayer() == _player
        ) {
            ++count;
            ++iter.x;
            --iter.y;
        }

        iter = (Point)pt.clone();
        while (iter.x >= 0
            && iter.y < Options.getDimensions()
            && _board.getSquare(iter.x, iter.y).getPlayer() == _player
        ) {
            ++count;
            --iter.x;
            ++iter.y;
        }

        if (count > Options.getNumberToWin()) {
            return true;
        }

        return false;
    }

    /**
     * Checks for wins diagonally down and right.
     * @param pt The point to start checking
     * @return True if the current player has won diagonally down and right,
     *         else false
     */
    private static boolean checkWinsDownRight(Point pt) {
        Point iter = (Point)pt.clone(); 

        int count = 0;
        while (iter.x < Options.getDimensions()
            && iter.y < Options.getDimensions()
            && _board.getSquare(iter.x, iter.y).getPlayer() == _player
        ) {
            ++count;
            ++iter.x;
            ++iter.y;
        }

        iter = (Point)pt.clone();
        while (iter.x >= 0
            && iter.y >= 0
            && _board.getSquare(iter.x, iter.y).getPlayer() == _player
        ) {
            ++count;
            --iter.x;
            --iter.y;
        }

        if (count > Options.getNumberToWin()) {
            return true;
        }

        return false;
    }
}
