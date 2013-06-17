/*
 * U2A1_ChrisDeVisser_IntegerSumsView.java
 */

package u2a1_chrisdevisser_integersums;

import java.awt.Color;
import java.awt.Font;
import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ButtonModel;
import javax.swing.DefaultListModel;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * The application's main frame.
 */
public class U2A1_ChrisDeVisser_IntegerSumsView extends FrameView {
    //flags for sorting the list
    enum SortOptions {
        None,
        Sorted,
        Reversed,
        SortedReversed //Sorted | Reversed
    };

    public U2A1_ChrisDeVisser_IntegerSumsView(SingleFrameApplication app) {
        super(app);

        initComponents();

        // <editor-fold defaultstate="collapsed" desc="Generated Code">
        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String)(evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer)(evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        });
        //</editor-fold>

        final Font font = new Font("Lucida Bright", Font.BOLD, 36);
        final String title = "Integer Sums";

        getFrame().setTitle(title);
        getFrame().setResizable(false);

        //make rotating title panel
        RotatingTitlePanel panel = new RotatingTitlePanel(title, font);

        //set up panel and make it the glass pane so it's on top
        panel.getPanel().setForeground(Color.blue);
        panel.getPanel().setOpaque(false);
        getFrame().setGlassPane(panel.getPanel());
        panel.getPanel().setVisible(true);

        //stay at x=50
        //move up from y=300 to y=50
        //do three full rotations
        //go smoothly and slowly enough
        panel.animate(60, 60, 300, 50, 360 * 3, 6, 10);

        //make list use integer default model
        nums.setModel(new DefaultListModel<Integer>());
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = U2A1_ChrisDeVisser_IntegerSumsApp.getApplication().getMainFrame();
            aboutBox = new U2A1_ChrisDeVisser_IntegerSumsAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        U2A1_ChrisDeVisser_IntegerSumsApp.getApplication().show(aboutBox);
    }
    //</editor-fold>

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        sumOdd = new javax.swing.JTextField();
        sumEven = new javax.swing.JTextField();
        sumAll = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        nums = new javax.swing.JList();
        add = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        sorted = new javax.swing.JRadioButton();
        sortedReversed = new javax.swing.JRadioButton();
        unsorted = new javax.swing.JRadioButton();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        sortGroup = new javax.swing.ButtonGroup();

        mainPanel.setName("mainPanel"); // NOI18N

        jLabel1.setText("Numbers"); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText("Sum of Odd:"); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setText("Sum of Even:"); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel4.setText("Sum of All:"); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        jSeparator1.setName("jSeparator1"); // NOI18N

        sumOdd.setEditable(false);
        sumOdd.setText("0"); // NOI18N
        sumOdd.setName("sumOdd"); // NOI18N

        sumEven.setEditable(false);
        sumEven.setText("0"); // NOI18N
        sumEven.setName("sumEven"); // NOI18N

        sumAll.setEditable(false);
        sumAll.setText("0"); // NOI18N
        sumAll.setName("sumAll"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        nums.setName("nums"); // NOI18N
        nums.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                numsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(nums);

        add.setText("Add..."); // NOI18N
        add.setName("add"); // NOI18N
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        remove.setText("Remove Selected"); // NOI18N
        remove.setEnabled(false);
        remove.setName("remove"); // NOI18N
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });

        sortGroup.add(sorted);
        sorted.setText("Sorted"); // NOI18N
        sorted.setName("sorted"); // NOI18N
        sorted.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                setSortState(evt);
            }
        });

        sortGroup.add(sortedReversed);
        sortedReversed.setText("Sorted and Reversed"); // NOI18N
        sortedReversed.setName("sortedReversed"); // NOI18N
        sortedReversed.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                setSortState(evt);
            }
        });

        sortGroup.add(unsorted);
        unsorted.setSelected(true);
        unsorted.setText("Unsorted"); // NOI18N
        unsorted.setName("unsorted"); // NOI18N
        unsorted.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                setSortState(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(add))
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel2)
                                                    .addComponent(jLabel3))
                                                .addGap(18, 18, 18)
                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(sumEven, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(sumOdd, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGap(54, 54, 54)
                                                .addComponent(jLabel4)
                                                .addGap(18, 18, 18)
                                                .addComponent(sumAll, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addGap(85, 85, 85)
                                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(sortedReversed)
                                            .addComponent(sorted)
                                            .addComponent(unsorted)))))))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(remove)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(sumOdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sumEven, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(11, 11, 11)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(sumAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sorted))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(add)
                        .addGap(11, 11, 11)
                        .addComponent(remove))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(sortedReversed)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(unsorted)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menuBar.setName("menuBar"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(u2a1_chrisdevisser_integersums.U2A1_ChrisDeVisser_IntegerSumsApp.class).getContext().getResourceMap(U2A1_ChrisDeVisser_IntegerSumsView.class);
        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(u2a1_chrisdevisser_integersums.U2A1_ChrisDeVisser_IntegerSumsApp.class).getContext().getActionMap(U2A1_ChrisDeVisser_IntegerSumsView.class, this);
        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 230, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusAnimationLabel)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusMessageLabel)
                    .addComponent(statusAnimationLabel)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        setComponent(mainPanel);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @brief Updates the list and outputs.
     */
    private void update() {
        //check for having to sort the list
        if ((sortOptions.ordinal() & SortOptions.Sorted.ordinal()) != 0) {
            ArrayList<Integer> values = new ArrayList<Integer>();

            //copy list into ArrayList
            for (int i = 0; i < nums.getModel().getSize(); ++i) {
                values.add((Integer)nums.getModel().getElementAt(i));
            }

            //sort list
            Object[] sorted = values.toArray();
            Arrays.sort(sorted);

            int start, end, iter;

            //choose how to refill the list based on sorting order
            if ((sortOptions.ordinal() & SortOptions.Reversed.ordinal()) != 0) {
                start = nums.getModel().getSize() - 1;
                end = -1;
                iter = -1;
            } else {
                start = 0;
                end = nums.getModel().getSize();
                iter = 1;
            }

            //clear list and refill with sorted elements
            DefaultListModel<Integer> lm = (DefaultListModel<Integer>)nums.getModel();
            lm.removeAllElements();

            for (int i = start; i != end; i += iter) {
                lm.addElement((Integer)sorted[i]);
            }
        } //end sort check

        //sums
        Integer odd = 0;
        Integer even = 0;

        //calculate both sums
        for (int i = 0; i < nums.getModel().getSize(); ++i) {
            Integer num = (Integer)nums.getModel().getElementAt(i);
            if (num % 2 == 0) {
                even += num;
            } else {
                odd += num;
            }
        }

        //update sum outputs
        sumOdd.setText(odd.toString());
        sumEven.setText(even.toString());
        sumAll.setText(((Integer)(odd + even)).toString());
    }

    /**
     * @brief Executed when Add... button is pressed. Adds items to list.
     * @param evt Unused
     */
    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        //prompt for numbers to add and make sure something is entered
        String newNumStr = JOptionPane.showInputDialog("Enter the integer to add.\nE.g. 2,5,6\nE.g. 2-4, 9-12\nE.g. 1 7 9");
        if (newNumStr == null) {
            return;
        }

        //split by commas and spaces
        String[] values = newNumStr.split("[,\\s]");

        DefaultListModel<Integer> lm = (DefaultListModel<Integer>)nums.getModel();

        for (String value : values) {
            int num;
            try {
                //see if this part is a range, and add all numbers in that range
                String[] ends = value.split("-");
                if (ends.length == 2) {
                    int begin = Integer.parseInt(ends[0]);
                    int end = Integer.parseInt(ends[1]);

                    if (end >= begin) {
                        for (int i = begin; i <= end; ++i) {
                            lm.addElement(i);
                            update();
                        }
                    }
                } else if (ends.length == 1) { //if not range, add number
                    num = Integer.parseInt(value);
                    lm.addElement(num);
                    update();
                }
            } catch (NumberFormatException e) {} //ignore invalid tokens
        }
    }//GEN-LAST:event_addActionPerformed

    /**
     * @brief Executed when Remove Selected button is pressed. Removes selected items from list.
     * @param evt Unused
     */
    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        //sort indices to remove
        int[] indices = nums.getSelectedIndices();
        Arrays.sort(indices);

        DefaultListModel<Integer> lm = (DefaultListModel<Integer>)nums.getModel();

        //go through sorted indices in reverse order to delete the right ones
        for (int i = indices.length - 1; i >= 0; --i) {
            lm.remove(indices[i]);
        }

        remove.setEnabled(false); //disable remove button since nothing is selected
        update();
    }//GEN-LAST:event_removeActionPerformed

    /**
     * @brief Executed when list selection changes. Enables/disables the remove button.
     * @param evt Unused
     */
    private void numsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_numsValueChanged
        //enable or disable remove button based on whether anything is selected
        remove.setEnabled(nums.getSelectedIndices().length > 0);
    }//GEN-LAST:event_numsValueChanged

    /**
     * @brief Executed when a radio button is selected. Sets sorting options.
     * @param evt Unused
     */
    private void setSortState(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_setSortState
        ButtonModel bm = sortGroup.getSelection();

        if (bm.equals(sorted.getModel())) {
            sortOptions = SortOptions.Sorted;
        } else if (bm.equals(sortedReversed.getModel())) {
            sortOptions = SortOptions.SortedReversed;
        } else {
            sortOptions = SortOptions.None;
        }

        update();
    }//GEN-LAST:event_setSortState

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JList nums;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JButton remove;
    private javax.swing.ButtonGroup sortGroup;
    private javax.swing.JRadioButton sorted;
    private javax.swing.JRadioButton sortedReversed;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JTextField sumAll;
    private javax.swing.JTextField sumEven;
    private javax.swing.JTextField sumOdd;
    private javax.swing.JRadioButton unsorted;
    // End of variables declaration//GEN-END:variables

    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;

    private JDialog aboutBox;

    SortOptions sortOptions = SortOptions.None; //default to no sorting
}
