package tictactoe;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JPanel;

/**
 * A Tic-Tac-Toe board with configurable dimensions.
 * Keeps the dimensions once established.
 * @author Chris DeVisser
 */
public class Board {
    /**
     * Callback for when a square is clicked for the first time.
     * To be used for things unnecessary for the game to work.
     * For example, can be used for a runtime-selectable click effect.
     */
    public interface SquareFirstClickedCallback {
        void invoke(AutoFittingImageButton sender);
    }

    /**
     * A square of the board.
     */
    public class Square {
        private final AutoFittingImageButton _button = 
            new AutoFittingImageButton();
        
        private final SquareFirstClickedCallback _callback;

        /**
         * Makes a new square with the specified callback.
         * @param panel The panel to add the button to
         * @param callback The callback for first clicking on the square
         */
        public Square(JPanel panel, final SquareFirstClickedCallback callback) {
            final Square instance = this;
            _callback = new SquareFirstClickedCallback() {
                public void invoke(AutoFittingImageButton sender) {
                    _lastClicked = instance;

                    if (callback != null) {
                        callback.invoke(sender);
                    }
                }
            };
            
            _button.setBackground(Color.WHITE);
            _button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //return if already clicked or game isn't going
                    if (isTaken() || Game.getPlayer() == Constant.Player.NONE) {
                        return;
                    }

                    int iconIndex = Game.getPlayer(); //1 or 2
                    _button.setIconIndex(iconIndex);

                    if (_callback != null) {
                        _callback.invoke(_button);
                    }
                    
                    Game.endTurn();
                }
            });

            panel.add(_button);
        }

        /**
         * Determines whether the square is taken.
         * @return True if the square is taken, or false otherwise
         */
        public boolean isTaken() {
            return _button.getIconIndex() != Constant.Icon.EMPTY_INDEX;
        }

        /**
         * Gets player who has taken this square.
         * @return 1 for player 1, 2 for player 2, 0 for neither
         */
        public int getPlayer() {
            return _button.getIconIndex();
        }
    }

    private final int _dim;
    private Square[] _squares; //I prefer a 1D array here
    private Square _lastClicked = null;

    /**
     * Creates a board with the specified dimensions.
     * @param dim The dimensions of the board. E.g., 3 would create a 3x3 board.
     * @param panel The panel to add the board to
     * @param callback The callback to call when each square is first clicked
     */
    public Board(int dim, JPanel panel, SquareFirstClickedCallback callback) {
        _dim = dim;
        _squares = new Square[dim*dim];

        for (int i = 0; i < dim*dim; ++i) {
            _squares[i] = new Square(panel, callback);
        }
    }

    /**
     * Get dimensions of the board.
     * @return Dimensions of the board. E.g., a 3x3 board returns 3.
     */
    public int getDimensions() {
        return _dim;
    }

    /**
     * Retrieves a square at the specified coordinates.
     * @param x The x coordinate of the square
     * @param y The y coordinate of the square
     * @return The square at the specified coordinates
     */
    public Square getSquare(int x, int y) {
        return _squares[y*_dim + x];
    }

    /**
     * Determines whether the board is full.
     * @return True if the board is full, false otherwise
     */
    public boolean isFull() {
        for (int i = 0; i < _dim*_dim; ++i) {
            if (!_squares[i].isTaken()) {
                return false;
            }
        }

        return true;
    }

    /**
     * Retrieves last square clicked that was not taken.
     * @return The last square clicked that was not taken
     */
    public Point getLastClicked() {
        if (_lastClicked == null) {
            return null;
        }
        
        int index = Arrays.asList(_squares).indexOf(_lastClicked);
        return new Point(index % _dim, index / _dim);
    }
}
