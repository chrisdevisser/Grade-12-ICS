package tictactoe;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

/**
 * A button with an image that automatically fits the button.
 * @author Chris DeVisser
 */
public class AutoFittingImageButton extends JButton {
    private int _iconIndex = Constant.Icon.EMPTY_INDEX;

    public void setIconIndex(int index) {
        _iconIndex = index;
    }

    public int getIconIndex() {
        return _iconIndex;
    }

    @Override
    public ImageIcon getIcon() {
        return Options.getIcon(_iconIndex);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        ImageIcon icon = getIcon();
        if (icon == null) {
            return;
        }

        Image i = icon.getImage();
        Rectangle area = new Rectangle();
        SwingUtilities.calculateInnerArea(this, area);
        g.drawImage(i, area.x, area.y, area.width, area.height, this);
    }
}
