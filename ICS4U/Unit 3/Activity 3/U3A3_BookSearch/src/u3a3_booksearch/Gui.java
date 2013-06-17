package u3a3_booksearch;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Chris DeVisser
 */
public class Gui extends javax.swing.JFrame {
    private List<Integer> _refs = new ArrayList<Integer>(); //reference numbers
    private Map<Integer, String> _books = new HashMap<Integer, String>(); //map of reference numbers to titles
    private String _lastFileRead = ""; //used to know whether to read file

    public Gui() {
        initComponents();

        getRootPane().setDefaultButton(btnSearch);

        try {
            readFile(txtFile.getText());
        } catch (FileNotFoundException ex) {
            txtFile.setText(null);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        txtRef = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtFile = new javax.swing.JTextField();
        btnBrowse = new javax.swing.JButton();
        txtTitle = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtLinIter = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtBinIter = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Book Search");

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea1.setBackground(new java.awt.Color(240, 240, 240));
        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("\nEnter a book's reference number to search for it in the file.");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextArea1.setEnabled(false);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setText("Reference Number:");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel2.setText("File:");

        txtFile.setText("BookList.txt");

        btnBrowse.setText("Browse...");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        txtTitle.setEditable(false);
        txtTitle.setText("No search performed");
        txtTitle.setBorder(null);
        txtTitle.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtTitle.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Book Title:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Linear search iterations:");

        txtLinIter.setEditable(false);
        txtLinIter.setText("0");
        txtLinIter.setBorder(null);
        txtLinIter.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtLinIter.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Binary search iterations:");

        txtBinIter.setEditable(false);
        txtBinIter.setText("0");
        txtBinIter.setBorder(null);
        txtBinIter.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtBinIter.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRef, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFile, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLinIter, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBinIter, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtRef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(jLabel2)
                    .addComponent(txtFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtLinIter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtBinIter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Reads the file with the name passed in and extracts book data.
     * @param name The name of the file.
     * @throws FileNotFoundException
     */
    void readFile(String name) throws FileNotFoundException {
        _books.clear();
        _refs.clear();
        BufferedReader reader = new BufferedReader(new FileReader(name));

        try {
            //line1 = reference number, line2 = title
            String line, line2;
            for (;;) {
                if ((line = reader.readLine()) == null) {
                    break;
                }

                if ((line2 = reader.readLine()) == null) {
                    _books.clear();
                    _refs.clear();
                    JOptionPane.showMessageDialog(this, "The file format was not recognized.");
                    break;
                }

                try {
                    Integer ref = Integer.parseInt(line);
                    if (ref < 0) {
                        throw new NumberFormatException();
                    }

                    _refs.add(ref);
                    _books.put(ref, line2);
                } catch (NumberFormatException ex) {
                    _books.clear();
                    _refs.clear();
                    JOptionPane.showMessageDialog(this, "The file was not read successfully. One or more of the reference numbers was invalid.");
                    break;
                }
            }
        } catch (IOException ex) {
            _books.clear();
            _refs.clear();
            ex.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "The file was not closed successfully.");
            }
        }
    }

    /**
     * Performs a linear search on the data.
     */
    void linearSearch(int ref) {
        int numIter = 1;
        for (Iterator<Integer> it =  _refs.iterator(); it.hasNext(); ++numIter) {
            int current = it.next();

            if (current == ref) {
                txtLinIter.setText(numIter + "");
                txtTitle.setText(_books.get(ref));
                return;
            }

            if (current > ref) {
                break;
            }
        }

        txtLinIter.setText(numIter + "");
        txtTitle.setText("Not found");
    }

    /**
     * Performs a binary search on the data through [begin,end]
     * @param count The number of iterations.
     */
    void binarySearch(int ref, int begin, int end, int count) {
        int half = (begin + end) / 2;
        if (begin > end) {
            txtBinIter.setText(count + "");
            return;
        }

        if (_refs.get(half) == ref) {
            txtBinIter.setText(count + "");
        } else if (_refs.get(half) < ref) {
            binarySearch(ref, half + 1, end, count + 1);
        } else {
            binarySearch(ref, begin, half - 1, count + 1);
        }
    }

    /**
     * Searches for a book by reference number in the file.
     * @param evt Unused
     */
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        //update data if new file selected
        if (!_lastFileRead.equals(txtFile.getText())) {
            try {
                readFile(txtFile.getText());
                _lastFileRead = txtFile.getText();
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "The file was not found.");
                return;
            }
        }
        
        if (_refs.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No data to search.");
            return;
        }

        //validate reference number >= 0
        int ref = 0;
        try {
            ref = Integer.parseInt(txtRef.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Bad reference number.");
            return;
        }

        if (ref < 0) {
            JOptionPane.showMessageDialog(this, "Reference number must be nonnegative.");
            return;
        }

        linearSearch(ref);
        binarySearch(ref, 0, _books.size() - 1, 1);
    }//GEN-LAST:event_btnSearchActionPerformed

    /**
     * Browses for a file containing reference numbers and titles.
     * @param evt Unused
     */
    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
        if (chooser.showDialog(this, "Open") != JFileChooser.APPROVE_OPTION) {
            return;
        }

        txtFile.setText(chooser.getSelectedFile().getAbsolutePath());
    }//GEN-LAST:event_btnBrowseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField txtBinIter;
    private javax.swing.JTextField txtFile;
    private javax.swing.JTextField txtLinIter;
    private javax.swing.JTextField txtRef;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables

}
