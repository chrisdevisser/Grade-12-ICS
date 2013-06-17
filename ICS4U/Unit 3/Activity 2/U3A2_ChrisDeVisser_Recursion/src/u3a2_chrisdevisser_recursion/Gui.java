package u3a2_chrisdevisser_recursion;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultCaret;

/**
 * A GUI to find Fibonacci numbers, calculate combinations, and reduce fractions.
 * Fibonacci numbers are limited by the processing time and computer's memory.
 *
 * @author Chris DeVisser
 */
public class Gui extends javax.swing.JFrame {
    private static final int TEXT_DELAY = 1000; //response time for typing, ms
    private static final int FIB_INCREMENT = 1000; //Fibonacci numbers to find at a time

    private Timer tmrFibNth = new Timer(); //timer for nth number textbox
    private Timer tmrFibCheck = new Timer(); //timer for check textbox
    private Timer tmrCmbN = new Timer(); //timer for N textbox
    private Timer tmrCmbR = new Timer(); //timer for R textbox
    private Timer tmrFracNum = new Timer(); //timer for numerator textbox
    private Timer tmrFracDen = new Timer(); //timer for denominator textbox

    //maps index to that Fibonacci number
    private Map<Integer, BigInteger> _fibResults = new HashMap<Integer, BigInteger>();
    
    private StringBuilder _fibString; //builds text area string because appending directly is slow
    private StringBuilder _cmbString;
    private StringBuilder _fracString;

    private boolean _fibRunning = false; //whether a Fibonacci number is currently being found
    private boolean _fibShouldStop = false; //whether the current Fibonacci operations should be aborted
    private boolean _fibCleanseMap = false; //whether the saved numbers could be invalid

    public Gui() {
        initComponents();

        //auto scroll to bottom when text added, http://stackoverflow.com/a/9000922/962089
        DefaultCaret fibCaret = (DefaultCaret)txtFibRes.getCaret();
        fibCaret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        DefaultCaret cmbCaret = (DefaultCaret)txtCmbRes.getCaret();
        cmbCaret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        DefaultCaret fracCaret = (DefaultCaret)txtFracRes.getCaret();
        fracCaret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        scrlFibRes = new javax.swing.JScrollPane();
        txtFibRes = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        panFibNth = new javax.swing.JPanel();
        txtFibNth = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        panFibCheck = new javax.swing.JPanel();
        txtFibCheck = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCmbHead = new javax.swing.JTextArea();
        txtCmbN = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCmbR = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtCmbRes = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtFracHead = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        txtFracNum = new javax.swing.JTextField();
        txtFracDen = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtFracRes = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Recursion");

        txtFibRes.setColumns(20);
        txtFibRes.setEditable(false);
        txtFibRes.setRows(5);
        txtFibRes.setText("1: 1\n");
        scrlFibRes.setViewportView(txtFibRes);

        jLabel1.setText("Find Nth number (enter N):");

        txtFibNth.setText("1");
        txtFibNth.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFibNthKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panFibNthLayout = new javax.swing.GroupLayout(panFibNth);
        panFibNth.setLayout(panFibNthLayout);
        panFibNthLayout.setHorizontalGroup(
            panFibNthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFibNthLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtFibNth, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addContainerGap())
        );
        panFibNthLayout.setVerticalGroup(
            panFibNthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFibNthLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtFibNth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Check if number is part of sequence:");

        panFibCheck.setBackground(new java.awt.Color(0, 255, 0));

        txtFibCheck.setText("1");
        txtFibCheck.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFibCheckKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panFibCheckLayout = new javax.swing.GroupLayout(panFibCheck);
        panFibCheck.setLayout(panFibCheckLayout);
        panFibCheckLayout.setHorizontalGroup(
            panFibCheckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFibCheckLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtFibCheck, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addContainerGap())
        );
        panFibCheckLayout.setVerticalGroup(
            panFibCheckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFibCheckLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtFibCheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Copy Last to Clipboard");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addComponent(panFibNth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panFibCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(12, 12, 12))
            .addComponent(scrlFibRes, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panFibNth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panFibCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(15, 15, 15)))
                .addComponent(scrlFibRes, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Fibonacci Numbers", jPanel1);

        jScrollPane1.setBorder(null);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txtCmbHead.setBackground(new java.awt.Color(240, 240, 240));
        txtCmbHead.setColumns(20);
        txtCmbHead.setEditable(false);
        txtCmbHead.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCmbHead.setLineWrap(true);
        txtCmbHead.setRows(5);
        txtCmbHead.setText("Enter N, the number of objects, and R, the number being selected, to find out how many combinations can be made by selecting R objects from N available.");
        txtCmbHead.setWrapStyleWord(true);
        txtCmbHead.setBorder(null);
        txtCmbHead.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCmbHead.setEnabled(false);
        jScrollPane1.setViewportView(txtCmbHead);

        txtCmbN.setText("0");
        txtCmbN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCmbNKeyTyped(evt);
            }
        });

        jLabel3.setText("N:");

        txtCmbR.setText("0");
        txtCmbR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCmbRKeyTyped(evt);
            }
        });

        jLabel4.setText("R:");

        jScrollPane2.setBorder(txtCmbN.getBorder());

        txtCmbRes.setColumns(1);
        txtCmbRes.setEditable(false);
        txtCmbRes.setRows(5);
        txtCmbRes.setText("0 choose 0 is 0");
        jScrollPane2.setViewportView(txtCmbRes);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtCmbN, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                .addGap(96, 96, 96)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtCmbR, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                .addGap(130, 130, 130))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCmbN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCmbR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Combinations", jPanel2);

        jScrollPane3.setBorder(null);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txtFracHead.setBackground(new java.awt.Color(240, 240, 240));
        txtFracHead.setColumns(20);
        txtFracHead.setEditable(false);
        txtFracHead.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtFracHead.setLineWrap(true);
        txtFracHead.setRows(5);
        txtFracHead.setText("Enter the numerator and denominator of a fraction and watch it be reduced.");
        txtFracHead.setWrapStyleWord(true);
        txtFracHead.setBorder(null);
        txtFracHead.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtFracHead.setEnabled(false);
        jScrollPane3.setViewportView(txtFracHead);

        jLabel5.setText("Numerator:");

        txtFracNum.setText("0");
        txtFracNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFracNumKeyTyped(evt);
            }
        });

        txtFracDen.setText("1");
        txtFracDen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFracDenKeyTyped(evt);
            }
        });

        jLabel6.setText("Denominator:");

        jScrollPane4.setBorder(txtCmbN.getBorder());

        txtFracRes.setColumns(1);
        txtFracRes.setEditable(false);
        txtFracRes.setRows(5);
        txtFracRes.setText("0 / 1 = 0");
        jScrollPane4.setViewportView(txtFracRes);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtFracNum, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                .addGap(96, 96, 96)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtFracDen, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                .addGap(130, 130, 130))
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFracNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFracDen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Fraction Reducer", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    ///////////////
    // FIBONACCI //
    ///////////////
    
    /**
     * Calculates F(stopAt) through F(nth) and adds them to the map if not there.
     *
     * Precondition: 1 <= stopAt <= nth, stopAt != 2
     * If stopAt is not 1, the map must contain values for F(stopAt-1) and F(stopAt-2).
     *
     * Postcondition: Any new values will be added to the map. This does not
     * necessarily mean they are correct. If aborted, the function returns 0
     * and any map values depending on it will be wrong. In this case,
     * _fibCleanseMap is set to true.
     *
     * @param nth The highest Fibonacci number to calculate.
     * @param stopAt The lowest Fibonacci number to calculate.
     * @return F(nth), or 0 if the calculation was aborted.
     */
    private BigInteger doFibonacci(int nth, int stopAt) {
        //Provide a quick exit mechanism in case the calculation is aborted.
        //The flag means the map should be nuked.
        if (_fibShouldStop) {
            _fibCleanseMap = true;
            return new BigInteger("0");
        }
        
        if (stopAt == 1) { //first group is special because of the base case
            if (_fibResults.containsKey(nth)) { //use cached value if possible
                return _fibResults.get(nth);
            }

            if (nth == 1) {
                _fibResults.put(nth, new BigInteger("1")); //F(1) = 1
            } else if (nth == 2) {
                _fibResults.put(nth, new BigInteger("1")); //F(2) = 1
                doFibonacci(nth - 1, stopAt); //make sure F(1) is calculated
            } else {
                //F(n) = F(n-1) + F(n-2)
                _fibResults.put(nth, doFibonacci(nth - 1, stopAt).add(doFibonacci(nth - 2, stopAt)));
            }
            
            return _fibResults.get(nth);
        } else { //stopAt != 1, not the first batch
            if (nth == stopAt) { //base case
                //already have last two of previous section due to precondition
                _fibResults.put(nth, _fibResults.get(nth - 1).add(_fibResults.get(nth - 2)));
                return _fibResults.get(nth);
            } else { //nth != stopAt
                if (_fibResults.containsKey(nth)) { //use cached value if possible
                    return _fibResults.get(nth);
                } else { //value not in map
                    //if nth - 2 overlaps the previous section, use cached value
                    BigInteger possibleResult;
                    if (nth - 2 < stopAt) {
                        possibleResult = _fibResults.get(nth - 2);
                    } else {
                        possibleResult = doFibonacci(nth - 2, stopAt);
                    }

                    _fibResults.put(nth, doFibonacci(nth - 1, stopAt).add(possibleResult));
                    return _fibResults.get(nth);
                }
            }
        }
    }

    /**
     * Manages the calculation of Fibonacci numbers.
     */
    private void fibOnTxtDelay() {
        //if another calculation is going on, ask whether to stop it
        if (_fibRunning) {
            int answer = JOptionPane.showConfirmDialog(this, "There is already a calculation in progress. Would you like to stop it?");
            
            if (answer == JOptionPane.YES_OPTION) {
                _fibShouldStop = true;
            }

            return;
        }

        _fibRunning = true;

        //clear map if possibly invalid from aborting calculation
        if (_fibCleanseMap) {
            _fibResults.clear();  
            _fibCleanseMap = false;
        }

        //validate nth entry is a number > 0
        int n = 0;
        try {
            n = Integer.parseInt(txtFibNth.getText().trim());
        } catch (NumberFormatException ex) {}

        if (n <= 0) {
            n = 1;
        }

        txtFibNth.setText(n + "");
        txtFibNth.setCaretPosition(txtFibNth.getText().length()); //set caret to end

        ///////////////////////////

        //validate check entry is a number > 0
        BigInteger check = new BigInteger("0");
        try {
            check = new BigInteger(txtFibCheck.getText().trim());
        } catch (NumberFormatException ex) {}

        if (check.toString().charAt(0) == '-') {
            check = new BigInteger("1");
        }

        txtFibCheck.setText(check + "");
        txtFibCheck.setCaretPosition(txtFibCheck.getText().length());

        /////////////////////////////

        _fibString = new StringBuilder();
        txtFibRes.setText("Calculating... please wait.");

        //fill map with (0, FIB_INCREMENT], then (FIB_INCREMENT, 2 * FIB_INCREMENT] and so on
        //this prevents a stack overflow from too much recursion
        //go until the index is high enough and the check has been (dis)proven
        long startTimeCalc = System.currentTimeMillis();
        int index = 1;
        while (true) {
            if (_fibShouldStop) {
                break;
            }

            if (doFibonacci(index + FIB_INCREMENT - 1, index).compareTo(check) >= 0 && index + FIB_INCREMENT > n) {
                break;
            }

            index += FIB_INCREMENT;
        }
        long timeCalc = System.currentTimeMillis() - startTimeCalc;

        if (_fibResults.containsValue(check)) {
            panFibCheck.setBackground(Color.GREEN);
        } else {
            panFibCheck.setBackground(Color.RED);
        }

        //add results from map until both input conditions are met
        long startTimeString = System.currentTimeMillis();
        for (int i = 1; i <= _fibResults.size(); ++i) {
            if (_fibShouldStop) {
                break;
            }

            BigInteger val = _fibResults.get(i);
            _fibString.append(i).append(": ").append(val).append("\n");

            if (i >= n && val.compareTo(check) >= 0) {
                break;
            }
        }
        long timeString = System.currentTimeMillis() - startTimeString;

        //if aborted, restart with the up to date inputs
        if (_fibShouldStop) {
            _fibRunning = false;
            _fibShouldStop = false;
            fibOnTxtDelay();
        } else { //otherwise, display the results
            txtFibRes.setText(_fibString + "\nCalculation time taken: " + (double)timeCalc / 1000  + " seconds\nOutput formation time taken: " + (double)timeString / 1000 + " seconds");
        }

        _fibRunning = false;
        _fibCleanseMap = false;
    }

    /**
     * Fires when something is typed into the check textbox.
     * Starts waiting to take action.
     * @param evt Unused
     */
    private void txtFibCheckKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFibCheckKeyTyped
        tmrFibNth.cancel();
        tmrFibCheck.cancel();
        tmrFibCheck = new Timer();
        tmrFibCheck.schedule(new TimerTask() {
            @Override
            public void run() {
                fibOnTxtDelay();
            }
        }, TEXT_DELAY);
    }//GEN-LAST:event_txtFibCheckKeyTyped

    /**
     * @param evt Unused
     * @see txtFibCheckKeyTyped
     */
    private void txtFibNthKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFibNthKeyTyped
        tmrFibNth.cancel();
        tmrFibCheck.cancel();
        tmrFibNth = new Timer();
        tmrFibNth.schedule(new TimerTask() {
            @Override
            public void run() {
                fibOnTxtDelay();
            }
        }, TEXT_DELAY);
    }//GEN-LAST:event_txtFibNthKeyTyped

    //////////////////
    // COMBINATIONS //
    //////////////////

    /**
     * Calculates N choose R. Uses the identity C(N,R) = C(N,R-1) * (N-R+1)/R
     * This helps for filling the results area.
     *
     * Precondition: n >= 0, r >= 0
     *
     * @param n N in the formula
     * @param r R in the formula
     * @return N choose R: the number of combinations
     */
    private BigDecimal doCombinations(int n, int r) {
        if (r == 0) {
            _cmbString.append(n).append(" choose ").append(r).append(" is 1\n");
            return BigDecimal.ONE;
        }

        if (n == 0) {
            _cmbString.append(n).append(" choose ").append(r).append(" is 0\n");
            return BigDecimal.ZERO;
        }

        BigDecimal ret = doCombinations(n, r - 1).multiply(BigDecimal.valueOf(n - r + 1)).divide(BigDecimal.valueOf(r));
        _cmbString.append(n).append(" choose ").append(r).append(" is ").append(ret).append("\n");
        return ret;
    }

    /**
     * Manages calculation of combinations.
     */
    private void cmbOnTxtDelay() {
        //validate N is a number >= 0
        int n = 0;
        try {
            n = Integer.parseInt(txtCmbN.getText().trim());
        } catch (NumberFormatException ex) {}

        n = Math.max(n, 0);
        txtCmbN.setText(n + "");
        txtCmbN.setCaretPosition(txtCmbN.getText().length()); //set caret to end

        ////////////////////////////

        //validate R is a number >= 0
        int r = 0;
        try {
            r = Integer.parseInt(txtCmbR.getText().trim());
        } catch (NumberFormatException ex) {}

        r = Math.max(r, 0);
        txtCmbR.setText(r + "");
        txtCmbR.setCaretPosition(txtCmbR.getText().length()); //set caret to end

        /////////////////////////////

        long startTime = System.currentTimeMillis();
        _cmbString = new StringBuilder();
        txtCmbRes.setText("Calculating... please wait.");
        doCombinations(n, r);
        txtCmbRes.setText(_cmbString + "\nTotal time taken: " + (double)(System.currentTimeMillis() - startTime) / 1000 + " seconds");
    }

    /*
     * @param evt Unused
     * @see txtFibCheckKeyTyped
     */
    private void txtCmbNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCmbNKeyTyped
        tmrCmbN.cancel();
        tmrCmbR.cancel();
        tmrCmbN = new Timer();
        tmrCmbN.schedule(new TimerTask() {
            @Override
            public void run() {
                cmbOnTxtDelay();
            }
        }, TEXT_DELAY);
    }//GEN-LAST:event_txtCmbNKeyTyped

    /**
     * @param evt Unused
     * @see txtFibCheckKeyTyped
     */
    private void txtCmbRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCmbRKeyTyped
        tmrCmbN.cancel();
        tmrCmbR.cancel();
        tmrCmbR = new Timer();
        tmrCmbR.schedule(new TimerTask() {
            @Override
            public void run() {
                cmbOnTxtDelay();
            }
        }, TEXT_DELAY);
    }//GEN-LAST:event_txtCmbRKeyTyped

    /**
     * Reduces a fraction and updates the result string.
     * The code is slow, but the updating is a lot slower.
     *
     * Precondition: den is not 0.
     *
     * @param num The numerator of the fraction
     * @param den The denominator of the fraction
     */
    void doFractionReducing(BigInteger num, BigInteger den) {
        if (num.compareTo(BigInteger.ZERO) < 0 && den.compareTo(BigInteger.ZERO) < 0) {
            _fracString.append(num + " / " + den + " = ");
            num = num.negate();
            den = den.negate();
            _fracString.append(num + " / " + den + "\n");
        }

        if (num.equals(BigInteger.ZERO)) {
            _fracString.append("0 / " + den + " = 0\n");
            return;
        }

        if (den.equals(BigInteger.ONE)) {
            _fracString.append(num + " / 1 = " + num + "\n");
            return;
        }
        
        //doing square roots isn't obvious with Big* classes anyway
        for (BigInteger i = BigInteger.valueOf(2); i.compareTo(den.abs()) <= 0; i = i.add(BigInteger.ONE)) {
            if (num.mod(i).equals(BigInteger.ZERO) && den.mod(i).equals(BigInteger.ZERO)) {
                _fracString.append(num + " / " + den + " = " + num.divide(i) + " / " + den.divide(i) + "\n");
                doFractionReducing(num.divide(i), den.divide(i));
                return;
            }
        }

        _fracString.append(num + " / " + den + " is in lowest terms.\n");
    }

    /**
     * Manages calculation of fraction reducing.
     */
    private void fracOnTxtDelay() {
        //validate numerator is a number
        BigInteger num = BigInteger.ZERO;
        try {
            num = new BigInteger(txtFracNum.getText());
        } catch (NumberFormatException ex) {}
        
        txtFracNum.setText(num + "");
        txtFracNum.setCaretPosition(txtFracNum.getText().length()); //set caret to end

        ////////////////////////////

        //validate R is a number != 0
        BigInteger den = BigInteger.ONE;
        try {
            den = new BigInteger(txtFracDen.getText());
        } catch (NumberFormatException ex) {}

        if (den.equals(BigInteger.ZERO)) {
            den = BigInteger.ONE;
        }

        txtFracDen.setText(den + "");
        txtFracDen.setCaretPosition(txtFracDen.getText().length()); //set caret to end

        /////////////////////////////

        long startTime = System.currentTimeMillis();
        _fracString = new StringBuilder();
        txtFracRes.setText("Calculating... please wait.");
        doFractionReducing(num, den);
        txtFracRes.setText(_fracString + "\nTotal time taken: " + (double)(System.currentTimeMillis() - startTime) / 1000 + " seconds");
    }

    /**
     * @param evt Unused
     * @see txtFibCheckKeyTyped
     */
    private void txtFracNumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFracNumKeyTyped
        tmrFracNum.cancel();
        tmrFracDen.cancel();
        tmrFracNum = new Timer();
        tmrFracNum.schedule(new TimerTask() {
            @Override
            public void run() {
                fracOnTxtDelay();
            }
        }, TEXT_DELAY);
    }//GEN-LAST:event_txtFracNumKeyTyped

    /**
     * @param evt Unused
     * @see txtFibCheckKeyTyped
     */
    private void txtFracDenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFracDenKeyTyped
        tmrFracNum.cancel();
        tmrFracDen.cancel();
        tmrFracDen = new Timer();
        tmrFracDen.schedule(new TimerTask() {
            @Override
            public void run() {
                fracOnTxtDelay();
            }
        }, TEXT_DELAY);
    }//GEN-LAST:event_txtFracDenKeyTyped

    /**
     * Copies last Fibonacci number in output to clipboard.
     * @param evt Unused
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String txt = txtFibRes.getText();
        int location;
        //skip over the two time taken colons
        for (location = txt.lastIndexOf(": ") - 1; ; location = txt.lastIndexOf(": ", location) - 1) {
            if (location < 0) {
                return;
            }

            if (Character.isDigit(txt.charAt(location))) {
                break;
            }
        }

        txt = txt.substring(location + 3, txt.indexOf("\n", location));

        //copy to clipboard: http://stackoverflow.com/a/6713290/962089
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(txt), null);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel panFibCheck;
    private javax.swing.JPanel panFibNth;
    private javax.swing.JScrollPane scrlFibRes;
    private javax.swing.JTextArea txtCmbHead;
    private javax.swing.JTextField txtCmbN;
    private javax.swing.JTextField txtCmbR;
    private javax.swing.JTextArea txtCmbRes;
    private javax.swing.JTextField txtFibCheck;
    private javax.swing.JTextField txtFibNth;
    private javax.swing.JTextArea txtFibRes;
    private javax.swing.JTextField txtFracDen;
    private javax.swing.JTextArea txtFracHead;
    private javax.swing.JTextField txtFracNum;
    private javax.swing.JTextArea txtFracRes;
    // End of variables declaration//GEN-END:variables

}