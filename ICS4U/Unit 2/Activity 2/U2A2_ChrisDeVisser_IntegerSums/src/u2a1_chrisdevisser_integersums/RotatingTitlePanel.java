/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package u2a1_chrisdevisser_integersums;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import javax.swing.JPanel;

/**
 *
 * @author astlr9001
 */

/**
 *
 * Provides capabilities for rotating and moving text in its own panel.
 */
public class RotatingTitlePanel {
    final private String _title; //the text to animate
    final private Font _font; //the font of the text
    private int _deg = 0; //the angle of the text in degrees
    private int _x, _y; //the position of the text

    private JPanel _panel = new JPanel() { //the panel containing the text
        /**
         * @brief Overrides to draw rotated content.
         * @param g The graphics object to use in painting.
         */
        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D)g.create(); //make 2D graphics object
            g2d.setFont(_font);

            //get width and height of text
            FontMetrics fm = _panel.getFontMetrics(_font);
            int w = fm.stringWidth(_title);
            int h = fm.getHeight();

            //future operations are translated and rotated
            AffineTransform transform = new AffineTransform();
            transform.rotate(Math.toRadians(_deg), _x + w/2, _y + h/2);
            g2d.transform(transform);

            g2d.drawString(_title, _x, _y); //paint text
        }
    };

    /**
     * @brief Constructs object with text and font.
     * @param title The text to animate
     * @param font The font of the text
     */
    public RotatingTitlePanel(String title, Font font) {
        _title = title;
        _font = font;
    }

    /**
     * @brief Retrieves the panel of the text.
     * @return The panel of the text.
     */
    public JPanel getPanel() {
        return _panel;
    }

    /**
     * @brief Animates the text.
     * @param startX The beginning x position
     * @param endX The ending x position. The text moves at a fixed rate.
     * @param startY The beginning y position
     * @param endY The ending y position. The text moves at a fixed rate.
     * @param totalDegrees The total number of degrees to rotate the text
     * @param degreesPerIter The degrees to rotate the text per iteration
     * @param sleepTime The delay time between each iteration
     */
    public void animate(final int startX, final int endX, final int startY, final int endY, final int totalDegrees, final int degreesPerIter, final int sleepTime) {
        final RotatingTitlePanel panel = this; //to access in thread

        new Thread(new Runnable() { //stay responsive when animating
            private RotatingTitlePanel titlePanel = panel;

            /**
             * @brief Performs the main actions of the thread
             */
            public void run() {
                for (int i = 0; i <= totalDegrees / degreesPerIter; ++i) {
                    //calculate current rotation and position and repaint
                    titlePanel._deg = i * degreesPerIter;
                    titlePanel._x = startX + (endX - startX) * i / (totalDegrees / degreesPerIter);
                    titlePanel._y =startY + (endY - startY) * i / (totalDegrees / degreesPerIter);
                    titlePanel.getPanel().repaint();

                    try {
                        Thread.sleep(sleepTime);
                    } catch (Exception e) {
                        //finish up if sleeping fails
                        titlePanel._x = endX;
                        titlePanel._y = endY;
                        titlePanel._deg = totalDegrees;
                        titlePanel.getPanel().repaint();
                        return;
                    }
                }
            }
        }).start(); //start the thread
    }
}
