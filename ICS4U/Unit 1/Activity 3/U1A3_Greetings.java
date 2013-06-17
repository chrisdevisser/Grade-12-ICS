package u1a3_greetings;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Chris DeVisser
 */
public class U1A3_Greetings extends JFrame implements ChangeListener {
    //colour of all text, sliders for adjusting colour, labels
    private Color textColour = new Color(0);
    private JSlider red = new JSlider(0, 255, 0);
    private JSlider green = new JSlider(0, 255, 0);
    private JSlider blue = new JSlider(0, 255, 0);
    private ArrayList<JLabel> labels = new ArrayList<>();
    private JPopupMenu tooltip = new JPopupMenu();

    //simply add coloured label to JPanel
    private void addText(JPanel pane, String text) {
        JLabel label = new JLabel(text);
        label.setForeground(textColour);
        labels.add(label);
        pane.add(label);
    }

    public U1A3_Greetings() {
        super("About Me");
        setSize(500, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1)); //2 rows, 1 col

        JPanel info = new JPanel(new GridLayout(5, 1)); //for information

        addText(info, "Name: Chris DeVisser");
        addText(info, "School: Waterloo Collegiate Institute");
        addText(info, "Favourite Music: Nothing in particular");
        addText(info, "Favourite TV Show: The Simpsons");
        addText(info, "Favourite Colour: #487269");
        addText(info, "Favourite Food: Perogies");

        JPanel colour = new JPanel(); //for colour
        colour.setLayout(new GridLayout(3, 2));

        //monitor slider changes
        red.addChangeListener(this);
        green.addChangeListener(this);
        blue.addChangeListener(this);

        //add labels and sliders
        addText(colour, "Red: ");
        colour.add(red);
        addText(colour, "Green: ");
        colour.add(green);
        addText(colour, "Blue: ");
        colour.add(blue);

        add(info); //add information pane
        add(colour); //add colour pane
        setVisible(true);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider slider = (JSlider)e.getSource(); //get sender

        int r = textColour.getRed(); //set colour to current
        int g = textColour.getGreen();
        int b = textColour.getBlue();

        //WORKAROUND FOR CONTINUOUS TOOLTIP
        tooltip = new JPopupMenu();
        tooltip.add(new JMenuItem(Integer.toString(slider.getValue())));

        //get current cursor location and convert to window coordinates
        Point p = MouseInfo.getPointerInfo().getLocation();
        SwingUtilities.convertPointFromScreen(p, getComponent(0));

        //x: left of current cursor location
        //y: same as slider
        int x = p.x - 55;
        int y = SwingUtilities.convertPoint(slider, 0, 0, this).y;
        tooltip.show(this, x, y);

        //find out which colour to change
        if (slider == red) {
            r = slider.getValue();
        } else if (slider == green) {
            g = slider.getValue();
        } else {
            b = slider.getValue();
        }

        textColour = new Color(r, g, b); //change text colour

        //update colour
        for (JLabel label : labels) {
            label.setForeground(textColour);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        U1A3_Greetings greetings = new U1A3_Greetings();
    }
}
