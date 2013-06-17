package u2a7_chrisdevisser_flight;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 * Properly renders a Passenger in a JList.
 * The rendered text is the passenger's full name.
 * If the passenger is eligible for bonus points, it is rendered in bold.
 * @author Chris DeVisser
 */
public class PassengerCellRenderer extends JLabel implements ListCellRenderer<Passenger> {
    private JLabel label = this;

    public Component getListCellRendererComponent(JList<? extends Passenger> list, Passenger passenger, int index, boolean isSelected, boolean cellHasFocus) {
        boolean special = passenger.eligibleForBonus();
        Font font = new Font(getFont().getName(), special ? Font.BOLD : Font.PLAIN, getFont().getSize());
        Color back = special ? new Color(100, 255, 100) : new Color(51,153,255);

        if (isSelected) {
            setOpaque(true);
            setBackground(back);
        } else {
            setOpaque(false);
        }

        label.setFont(font);
        label.setText(passenger.getFullName());
        return this;
    }
}
