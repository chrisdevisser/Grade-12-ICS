package u2a7_chrisdevisser_flight;

import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java_utilities.ArrayUtil;
import java_utilities.CommonRegex;
import java_utilities.Serializer;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * The GUI for the FlightMiles Reward Points program.
 * @author astlr9001
 */
public class FlightGUI extends javax.swing.JFrame {
    /**
     * Serializes and deserializes passenger data and selected index.
     */
    private Serializer _serPassenger = new Serializer("passengers.dat");
    private Serializer _serSelection = new Serializer("selection.dat");

    /** Creates new form FlightGUI */
    public FlightGUI() {
        initComponents();

        list.setModel(new DefaultListModel<Passenger>());
        list.setCellRenderer(new PassengerCellRenderer());

        load();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Saves passenger data and selected index to files.
     */
    void save() {
        try {
            DefaultListModel<Passenger> model = (DefaultListModel<Passenger>)list.getModel();
            _serPassenger.serialize(Arrays.asList(model.toArray()));

            Object[] index = {list.getSelectedIndex()};
            _serSelection.serialize(Arrays.asList(index));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Failed to properly save data.");
        }
    }

    /**
     * Loads passenger data from file.
     */
    void load() {
        try {
            List<Object> ser = _serPassenger.deserialize();
            DefaultListModel<Passenger> model = (DefaultListModel<Passenger>)list.getModel();

            for (int i = 0; i < ser.size(); ++i) {
                model.addElement((Passenger)ser.get(i));
            }

            ser = _serSelection.deserialize();
            list.setSelectedIndex((Integer)ser.get(0));
        } catch (FileNotFoundException ex) {
            //ignore
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Failed to properly load data.");
        }
    }
	
	/**
     * Prompts for a name and weekly points and adds passenger to list.
     * @param evt Unused
     */
    private void addPassenger(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPassenger
        String[] names = promptName();
        if (names == null) {
            return;
        }

        int[] weeks = promptPoints();
        if (weeks == null) {
            return;
        }

        DefaultListModel<Passenger> model = (DefaultListModel<Passenger>)list.getModel();
        model.addElement(new Passenger(names[0], names[1], weeks));
        save();
    }//GEN-LAST:event_addPassenger

    /**
     * Prompts for a passenger's name.
     * @return An array of names.
     * The first element is the first name.
     * The second element is the second name.
     * If invalid input, the array is null.
     */
    String[] promptName() {
        String input = JOptionPane.showInputDialog(this, "Enter the passenger's name:", "Name Entry", JOptionPane.QUESTION_MESSAGE);

        if (input == null) { //cancelled
            return null;
        }

        //check for enclosing spaces
        if (!input.trim().equals(input)) {
            JOptionPane.showMessageDialog(this, "Name cannot have surrounding spaces.");
            return null;
        }

        //check for the last space, and error if no space
        int lastSpace = input.lastIndexOf(' ');
        if (lastSpace == -1) {
            JOptionPane.showMessageDialog(this, "Name must have at least one space.");
            return null;
        }

        //check for second last space (De Visser etc), and use the first if not existent
        int lastSpace2 = input.lastIndexOf(' ', lastSpace - 1);
        if (lastSpace2 == -1) {
            lastSpace2 = lastSpace;
        }

        //get both possibilities for first name
        String first[] = new String[2];
        first[0] = input.substring(0, lastSpace);
        first[1] = input.substring(0, lastSpace2);

        //get both possibilities for last name
        String last[] = new String[2];
        last[0] =input.substring(lastSpace + 1);
        last[1] =input.substring(lastSpace2 + 1);

        //if first set is valid, return first set
        if (CommonRegex.isFirstName(first[0], true) && CommonRegex.isLastName(last[0], true)) {
            return new String[]{first[0], last[0]};
        } else {
            //if first name in second set is invalid, error
            if (!CommonRegex.isFirstName(first[1], true)) {
                JOptionPane.showMessageDialog(this, "Invalid first name.");
                return null;
            }

            //if last name in second set is invalid, error
            if (!CommonRegex.isLastName(last[1], true)) {
                JOptionPane.showMessageDialog(this, "Invalid last name.");
                return null;
            }

            //return second set
            return new String[]{first[1], last[1]};
        }
    }

    /**
     * Prompts for a passenger's weekly miles.
     * @return An array of four (WEEKS_PER_MONTH) point amounts.
     * If invalid input, the array is null.
     */
    int[] promptPoints() {
        String input = JOptionPane.showInputDialog(
            this,
            "Enter the passenger's " + Passenger.WEEKS_PER_MONTH + " weekly\npoints, separated by spaces:",
            "Points Entry",
            JOptionPane.QUESTION_MESSAGE
        );
        
        if (input == null) { //cancelled
            return null;
        }

        String[] weeks = input.split(" ");
        if (weeks.length != Passenger.WEEKS_PER_MONTH) {
            JOptionPane.showMessageDialog(this, "There must be " + Passenger.WEEKS_PER_MONTH + " point entries.");
            return null;
        }

        int[] ret = new int[Passenger.WEEKS_PER_MONTH]; //returned points

        //fill array with point values
        for (int i = 0; i < Passenger.WEEKS_PER_MONTH; ++i) {
            try {
                ret[i] = Integer.parseInt(weeks[i]);

                if (ret[i] < 0 || ret[i] > Passenger.MAX_WEEK_POINTS) {
                    JOptionPane.showMessageDialog(this, "Points must be between 0 and " + Passenger.MAX_WEEK_POINTS);
                    return null;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Points entry is not a number.");
                return null;
            }
        }

        return ret;
    }

    /**
     * Removes all selected passengers from list.
     * @param evt Unused
     */
    private void removePassenger(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePassenger
        DefaultListModel<Passenger> model = (DefaultListModel<Passenger>)list.getModel();
        model.remove(list.getSelectedIndex());
        outputArea.setText(null);
        save();
    }//GEN-LAST:event_removePassenger

    /**
     * Manages whether the Remove button is enabled.
     * Displays information about the selected passenger.
     * @param evt Unused
     */
    private void displayOutput(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_displayOutput
        save();
        int index = list.getSelectedIndex();
        if (index == -1) {
            removeButton.setEnabled(false);
            outputArea.setText(null);
            return;
        } else {
            removeButton.setEnabled(true);
        }

        DefaultListModel<Passenger> model = (DefaultListModel<Passenger>)list.getModel();
        Passenger passenger = model.getElementAt(index);

        String text = "";
        
        //add weekly points
        for (int i = 0; i < Passenger.WEEKS_PER_MONTH; ++i) {
            text += "Week " + (i + 1) + ":" + String.format("%12s", passenger.points[i]) + '\n';
        }

        text += "Total:" + String.format("%16s", ArrayUtil.sum(passenger.points)) + '\n';

        //add optional bonus message
        if (passenger.eligibleForBonus()) {
            text += "\n" + passenger.getFullName() + "\nhas qualified for 1000\nbonus points!";
        }

        outputArea.setText(text);
    }//GEN-LAST:event_displayOutput

    /**
     * Displays a full report of passengers.
     * @param evt Unused
     */
    private void showReport(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showReport
        DefaultListModel<Passenger> model = (DefaultListModel<Passenger>)list.getModel();
        ArrayList<Passenger> passengers = new ArrayList<Passenger>();

        //fill arraylist with GUI list values
        for (int i = 0; i < model.getSize(); ++i) {
            passengers.add(model.get(i));
        }

        JDialog dlg = new JDialog(this, "Report");
        dlg.setModalityType(ModalityType.APPLICATION_MODAL); //make it modal

        //week 1   week 2   week 3   week 4   eligible for bonus   total
        JTable table = new JTable(passengers.size() + 1, Passenger.WEEKS_PER_MONTH + 3);

        //fill column headers with test numbers
        for (int i = 1; i < Passenger.WEEKS_PER_MONTH + 1; ++i) {
            table.setValueAt("<html><b>Week " + i + "</b></html>", 0, i);
        }
        table.setValueAt("<html><b>Bonus</b></html>", 0, table.getColumnCount() - 2);
        table.setValueAt("<html><b>Total</b></html>", 0, table.getColumnCount() - 1);

        //fill row headers with passenger names
        for (int i = 1; i < table.getRowCount(); ++i) {
            table.setValueAt("<html><b>" + passengers.get(i - 1).getFullName() + "</b></html>", i, 0);
        }

        //fill table with main data
        for (int row = 1; row <= passengers.size(); ++row) {
            Passenger p = passengers.get(row - 1);

            for (int col = 1; col <= Passenger.WEEKS_PER_MONTH; ++col) {
                table.setValueAt(p.points[col - 1]+"", row, col);
            }

            String bonus = p.eligibleForBonus() ? "Yes" : "No";
            table.setValueAt(bonus, row, table.getColumnCount() - 2);
            table.setValueAt(ArrayUtil.sum(p.points)+"", row, table.getColumnCount() - 1);
        }

        table.setEnabled(false);
        JScrollPane scroll = new JScrollPane(table);
        table.setTableHeader(null); //added with scroll

        //set minimum column widths to hold the widest text
        for (int i = 0; i < table.getColumnCount(); ++i) {
            int max = 0;
            for (int j = 0; j < table.getRowCount(); ++j) {
                FontMetrics fm = getGraphics().getFontMetrics();
                String value = (String)table.getValueAt(j, i);

                value = value == null ? "" : value; //turn null into empty string
                value = value.replaceAll("</?html>|</?b>", ""); //erase html

                int width = fm.stringWidth(value); //get text width of cell
                max = Math.max(max, width);
            }

            table.getColumnModel().getColumn(i).setMinWidth(max + 5); //set width
        }

        dlg.add(scroll); //in case too big

        //set dialog size
        dlg.getContentPane().setPreferredSize(
            new Dimension(
                dlg.getPreferredSize().width,
                table.getRowCount() * table.getRowHeight() + 3
            )
        );
        dlg.pack();

        dlg.setLocationRelativeTo(null); //centre it
        dlg.setVisible(true);
    }//GEN-LAST:event_showReport

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        list = new javax.swing.JList<Passenger>();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        outputArea = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FlightMiles Reward Points");
        setResizable(false);

        list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                displayOutput(evt);
            }
        });
        jScrollPane1.setViewportView(list);

        addButton.setText("Add...");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPassenger(evt);
            }
        });

        removeButton.setText("Remove");
        removeButton.setEnabled(false);
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePassenger(evt);
            }
        });

        jScrollPane2.setBorder(null);
        jScrollPane2.setEnabled(false);

        outputArea.setBackground(new java.awt.Color(240, 240, 240));
        outputArea.setColumns(20);
        outputArea.setEditable(false);
        outputArea.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        outputArea.setLineWrap(true);
        outputArea.setRows(5);
        jScrollPane2.setViewportView(outputArea);

        jButton1.setText("See Full Report");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showReport(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addGap(26, 26, 26)
                        .addComponent(removeButton)
                        .addGap(54, 54, 54)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeButton)
                    .addComponent(addButton)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                        .addGap(25, 25, 25))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<Passenger> list;
    private javax.swing.JTextArea outputArea;
    private javax.swing.JButton removeButton;
    // End of variables declaration//GEN-END:variables

}
