package u3a4_chrisdevisser_sorts;

import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java_utilities.ArrayUtil;
import javax.swing.DefaultListModel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Sorts a list of numbers and measures statistics.
 * @author Chris DeVisser
 */
public class Gui extends javax.swing.JFrame {
    /**
     * The JTable row index of each sort.
     */
    class SortIndex {
        public static final int Bubble = 0;
        public static final int Selection = 1;
        public static final int Insertion = 2;
        public static final int Quick = 3;
    }

    JRadioButton _selectedSize = new JRadioButton(); //used for not doing anything when radio button reselected

    public Gui() {
        initComponents();
        lstUnsorted.setModel(new DefaultListModel<Integer>());
        lstSorted.setModel(new DefaultListModel<Integer>());

        //center text in JTable cells
        DefaultTableCellRenderer cellRend = (DefaultTableCellRenderer)tblResults.getDefaultRenderer(Integer.class);
        cellRend.setHorizontalAlignment(SwingConstants.CENTER);

        DefaultTableCellRenderer headRend = (DefaultTableCellRenderer)tblResults.getTableHeader().getDefaultRenderer();
        headRend.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < tblResults.getColumnCount(); ++i) {
            tblResults.getColumnModel().getColumn(i).setCellRenderer(cellRend);
        }

        //generate an initial list of numbers
        sizeRadioButtonSelected(new ActionEvent(rad10, 0, null));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrpSize = new javax.swing.ButtonGroup();
        btnGrpOrder = new javax.swing.ButtonGroup();
        rad10 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        rad100 = new javax.swing.JRadioButton();
        rad1000 = new javax.swing.JRadioButton();
        rad5000 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        radAscending = new javax.swing.JRadioButton();
        radDescending = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstUnsorted = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstSorted = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblResults = new javax.swing.JTable();
        btnSort = new javax.swing.JButton();
        btnRegenerate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sorting");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        btnGrpSize.add(rad10);
        rad10.setSelected(true);
        rad10.setText("10");
        rad10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sizeRadioButtonSelected(evt);
            }
        });

        jLabel1.setText("How many numbers should be sorted?");

        btnGrpSize.add(rad100);
        rad100.setText("100");
        rad100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sizeRadioButtonSelected(evt);
            }
        });

        btnGrpSize.add(rad1000);
        rad1000.setText("1000");
        rad1000.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sizeRadioButtonSelected(evt);
            }
        });

        btnGrpSize.add(rad5000);
        rad5000.setText("5000");
        rad5000.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sizeRadioButtonSelected(evt);
            }
        });

        jLabel2.setText("How should the numbers be sorted?");

        btnGrpOrder.add(radAscending);
        radAscending.setSelected(true);
        radAscending.setText("Ascending");

        btnGrpOrder.add(radDescending);
        radDescending.setText("Descending");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel3.setText("Unsorted:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel4.setText("Sorted:");

        jScrollPane1.setViewportView(lstUnsorted);

        jScrollPane2.setViewportView(lstSorted);

        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tblResults.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"<html><b>Bubble Sort</b></html>", new Integer(0), new Integer(0), new Integer(0), new Integer(0)},
                {"<html><b>Selection Sort", new Integer(0), new Integer(0), new Integer(0), new Integer(0)},
                {"<html><b>Insertion Sort", new Integer(0), new Integer(0), new Integer(0), new Integer(0)},
                {"<html><b>Quicksort", new Integer(0), new Integer(0), new Integer(0), new Integer(0)}
            },
            new String [] {
                "", "<html><b>Loop Iterations", "<html><b>Comparisons", "<html><b>Shifted Values", "<html><b>Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblResults.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblResults.setAutoscrolls(false);
        tblResults.setFillsViewportHeight(true);
        jScrollPane3.setViewportView(tblResults);

        btnSort.setText("Sort");
        btnSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortActionPerformed(evt);
            }
        });

        btnRegenerate.setText("Regenerate");
        btnRegenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegenerateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radAscending)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radDescending))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(btnRegenerate))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rad10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rad100)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rad1000)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rad5000))
                            .addComponent(btnSort))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(rad10)
                    .addComponent(rad100)
                    .addComponent(rad1000)
                    .addComponent(rad5000))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(radDescending)
                        .addComponent(radAscending)))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSort)
                    .addComponent(btnRegenerate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Resizes the table cell heights to fill the space when window is resized.
     * @param evt Unused
     */
    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        tblResults.setRowHeight(tblResults.getParent().getHeight() / tblResults.getRowCount());
    }//GEN-LAST:event_formComponentResized

    /**
     * Sorts the list of unsorted numbers using all four sorts required and
     * updates table with statistics about each. The sorted list is also shown.
     *
     * @param evt Unused
     */
    private void btnSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortActionPerformed
        boolean asc = radAscending.isSelected() ? true : false;

        DefaultListModel<Integer> lm = (DefaultListModel<Integer>)lstUnsorted.getModel();
        Integer[] nums = new Integer[lm.getSize()];
        lm.copyInto(nums);

        //These all take arrays instead of lists because insertion sort was
        //not cooperating well with lists, the interface is consistent,
        //and all others but quick sort work well with arrays. Quicksort
        //is fixed separately.
        bubbleSort((Integer[])nums.clone(), asc);
        selectionSort((Integer[])nums.clone(), asc);
        insertionSort((Integer[])nums.clone(), asc);
        Integer[] newNums = quicksort((Integer[])nums.clone(), asc);

        lm = (DefaultListModel<Integer>)lstSorted.getModel();
        lm.clear();

        for (int i = 0; i < newNums.length; ++i) {
            lm.addElement(newNums[i]);
        }
    }//GEN-LAST:event_btnSortActionPerformed

    /**
     * Generates a new list of random numbers in [-10000, 10000].
     * @param evt Contains the valid source of the event.
     */
    private void sizeRadioButtonSelected(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sizeRadioButtonSelected
        //do nothing if already selected
        if (evt.getSource() == _selectedSize) {
            return;
        }

        _selectedSize = (JRadioButton)evt.getSource();
        Random rand = new Random();

        int newSize = 0;
        try {
            newSize = Integer.parseInt(_selectedSize.getText());
        } catch (NumberFormatException ex) {}
        
        DefaultListModel<Integer> lm = (DefaultListModel<Integer>)lstUnsorted.getModel();
        lm.clear();
        
        for (int i = 0; i < newSize; ++i) {
            lm.addElement(rand.nextInt(20001) - 10000);
        }
    }//GEN-LAST:event_sizeRadioButtonSelected

    /**
     * Generates a new list without changing the radio button selection back and forth.
     * @param evt Unused
     */
    private void btnRegenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegenerateActionPerformed
        _selectedSize = null; //forget which was selected before

        //figure out which is selected and fake event from that source
        JRadioButton sel = rad10.isSelected() ? rad10 : rad100.isSelected() ? rad100 : rad1000.isSelected() ? rad1000 : rad5000;
        sizeRadioButtonSelected(new ActionEvent(sel, 0, null)); 
    }//GEN-LAST:event_btnRegenerateActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGrpOrder;
    private javax.swing.ButtonGroup btnGrpSize;
    private javax.swing.JButton btnRegenerate;
    private javax.swing.JButton btnSort;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList lstSorted;
    private javax.swing.JList lstUnsorted;
    private javax.swing.JRadioButton rad10;
    private javax.swing.JRadioButton rad100;
    private javax.swing.JRadioButton rad1000;
    private javax.swing.JRadioButton rad5000;
    private javax.swing.JRadioButton radAscending;
    private javax.swing.JRadioButton radDescending;
    private javax.swing.JTable tblResults;
    // End of variables declaration//GEN-END:variables

    /**
     * Updates loop iterations table cell value.
     *
     * @param sortIndex The index of the sort.
     * 0 - Bubble Sort
     * 1 - Selection Sort
     * 2 - Insertion Sort
     * 3 - Quicksort
     *
     * @param newIters The new value of the cell.
     */
    void updateIters(int sortIndex, int newIters) {
        tblResults.setValueAt(newIters, sortIndex, 1);
    }

    /**
     * Updates comparisons table cell value.
     *
     * @param sortIndex The index of the sort.
     * 0 - Bubble Sort
     * 1 - Selection Sort
     * 2 - Insertion Sort
     * 3 - Quicksort
     *
     * @param newCompares The new value of the cell.
     */
    void updateCompares(int sortIndex, int newCompares) {
        tblResults.setValueAt(newCompares, sortIndex, 2);
    }

    /**
     * Updates shifted values table cell value.
     *
     * @param sortIndex The index of the sort.
     * 0 - Bubble Sort
     * 1 - Selection Sort
     * 2 - Insertion Sort
     * 3 - Quicksort
     *
     * @param newShifts The new value of the cell.
     */
    void updateShifts(int sortIndex, int newShifts) {
        tblResults.setValueAt(newShifts, sortIndex, 3);
    }

    /**
     * Updates time table cell value. A format of ##0.000 is used with units
     * ranging from ns to s.
     *
     * @param sortIndex The index of the sort.
     * 0 - Bubble Sort
     * 1 - Selection Sort
     * 2 - Insertion Sort
     * 3 - Quicksort
     *
     * @param newNanos The new value of the cell.
     */
    void updateTime(int sortIndex, long newNanos) {
        List<String> units = new LinkedList<String>(Arrays.asList("ns", "μs", "ms", "s"));
        double displayTime = simplifyTime(newNanos, units);

        DecimalFormat format = new DecimalFormat("##0.000");
        tblResults.setValueAt(format.format(displayTime) + units.get(0), sortIndex, 4);
    }

    /**
     * Simplifies the time to be less than 1000 units.
     *
     * Precondition: units contains enough strings to sustain the division.
     * Postcondition: The first element of units is the correct one to use with the result.
     *
     * @param time The time taken
     * @param units A list of units that are bigger by a factor of 1000 each time
     * @return The time with decimals, less than 1000, represented in units.get(0) units
     */
    double simplifyTime(long time, List<String> units) {
        double ret = time;

        while (time / 1000 != 0 && units.size() > 1) {
            time = (long)(ret /= 1000);
            units.remove(0);
        }

        return ret;
    }

    /*
     * Performs a bubble sort on the unsorted list and updates the UI.
     *
     * @param nums The list of numbers to sort
     * @param asc Whether the list should be sorted in ascending order
     * @return The sorted list
     */
    private Integer[] bubbleSort(Integer[] nums, boolean asc) {
        int iters = 0;
        int comps = 0;
        int shifts = 0;

        boolean anythingSwapped = true;
        int end = nums.length - 1; //array is built one more from end each pass

        //go for as long as elements are swapped in the pass and not all elements are correct
        //swap adjacent elements if necessary
        long startTime = System.nanoTime();
        while (anythingSwapped && !(anythingSwapped = false) && --end != 0) {
            for (int i = 0; i <= end; ++i, ++iters) {
                boolean cmp = asc ? nums[i + 1] < nums[i] : nums[i] < nums[i + 1];
                if (++comps != 0 && cmp) {
                    ArrayUtil.swapInteger(nums, i, i + 1);
                    shifts += 2;
                    anythingSwapped = true;
                }
            }
        }
        long time = System.nanoTime() - startTime;

        updateIters(SortIndex.Bubble, iters);
        updateCompares(SortIndex.Bubble, comps);
        updateShifts(SortIndex.Bubble, shifts);
        updateTime(SortIndex.Bubble, time);

        return nums;
    }
    
    /*
     * Performs a selection sort on the unsorted list and updates the UI.
     *
     * @param nums The list of numbers to sort
     * @param asc Whether the list should be sorted in ascending order
     * @return The sorted list
     */
    private Integer[] selectionSort(Integer[] nums, boolean asc) {
        int iters = 0;
        int comps = 0;
        int shifts = 0;

        //keep a solid position incrementing each time,
        //search for the min/max element from that position onwards,
        //swap the min/max element with the current position
        long startTime = System.nanoTime();
        for (int cur = 0, maxIndex = cur; cur < nums.length - 1; ++cur, maxIndex = cur) {
            for (int search = cur + 1; search < nums.length; ++search, ++iters) {
                boolean cmp = asc ? nums[search] < nums[maxIndex] : nums[maxIndex] < nums[search];
                if (++comps != 0 && cmp) {
                    maxIndex = search;
                }
            }

            ArrayUtil.swapInteger(nums, cur, maxIndex);
            shifts += 2;
        }
        long time = System.nanoTime() - startTime;

        updateIters(SortIndex.Selection, iters);
        updateCompares(SortIndex.Selection, comps);
        updateShifts(SortIndex.Selection, shifts);
        updateTime(SortIndex.Selection, time);

        return nums;
    }

    /*
     * Performs an insertion sort on the unsorted list and updates the UI.
     *
     * @param nums The list of numbers to sort
     * @param asc Whether the list should be sorted in ascending order
     * @return The sorted list
     */
    private Integer[] insertionSort(Integer[] nums, boolean asc) {
        int iters = 0;
        int comps = 0;
        int shifts = 0;

        Integer held; //holds the element pulled out of the array

        //for each element except the first,
        //pull that element out, shift elements right until the open spot
        //is where the pulled one fits in or the first position in the array,
        //place pulled element in open spot
        long startTime = System.nanoTime();
        for (int i = 1; i < nums.length; ++i) {
            held = nums[i];
            nums[i] = null;

            int insertInto = i;
            for (; insertInto > 0; --insertInto, ++iters) {
                boolean cmp = asc ? nums[insertInto - 1] <= held : held <= nums[insertInto - 1];
                if (++comps != 0 && cmp) {
                    break;
                }

                ++shifts;
                nums[insertInto] = nums[insertInto - 1];
            }

            ++shifts;
            nums[insertInto] = held;
        }
        long time = System.nanoTime() - startTime;

        updateIters(SortIndex.Insertion, iters);
        updateCompares(SortIndex.Insertion, comps);
        updateShifts(SortIndex.Insertion, shifts);
        updateTime(SortIndex.Insertion, time);

        return nums;
    }

    /*
     * Wraps the quicksort operation to pass extra data and transform types.
     *
     * @param nums The list of numbers to sort
     * @param asc Whether the list should be sorted in ascending order
     * @return The sorted list
     */
    private Integer[] quicksort(Integer[] nums, boolean asc) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(nums)); //make list
        QuicksortData data = new QuicksortData(); //make statistics data

        long startTime = System.nanoTime();
        list = quicksortImpl(list, asc, data); //sort list
        long time = System.nanoTime() - startTime;

        updateIters(SortIndex.Quick, data.iters);
        updateCompares(SortIndex.Quick, data.comps);
        updateShifts(SortIndex.Quick, data.shifts);
        updateTime(SortIndex.Quick, time);

        Integer[] ret = new Integer[list.size()]; //convert list back to array
        list.toArray(ret);
        return ret;
    }

    /**
     * Contains statistics data that the recursive quicksort can use.
     */
    private class QuicksortData {
        public int iters = 0;
        public int comps = 0;
        public int shifts = 0;
    }

    /**
     * Performs quicksort on a list of numbers.
     * @param nums The list of numbers to sort
     * @param asc Whether to sort in ascending order
     * @param data Extra statistics data to fill in
     * @return The sorted list of numbers
     */
    private List<Integer> quicksortImpl(List<Integer> nums, boolean asc, QuicksortData data) {
        //base case: empty or size one list needs no further processing
        if (nums.isEmpty() || nums.size() == 1) {
            return nums;
        }

        int pivotIndex = 0; //arbitrary, but zero works well
        List<Integer> left = new ArrayList<Integer>(); //elements <= pivot
        List<Integer> right = new ArrayList<Integer>(); //elements > pivot

        //move index 1 of list (pivot is index 0) to right sublist and shift other elements back
        while (nums.size() > 1 && ++data.shifts != 0 && ++data.iters != 0) {
            boolean cmp = asc ? nums.get(1) <= nums.get(pivotIndex) : nums.get(pivotIndex) <= nums.get(1);
            if (++data.comps != 0 && cmp) {
                left.add(nums.get(1));
            } else {
                right.add(nums.get(1));
            }

            data.shifts += nums.size() - 2; //pivot doesn't move, element 1 already counted
            nums.remove(1); //all elements past 1 shift back
        }

        left = quicksortImpl(left, asc, data); //sort left sublist
        right = quicksortImpl(right, asc, data); //sort right sublist

        //form list from left sublist
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < left.size(); ++i, ++data.shifts, ++data.iters) {
            ret.add(left.get(i));
        }

        //add pivot to formed list
        ++data.shifts;
        ret.add(nums.get(pivotIndex));

        //add right sublist to formed list
        for (int i = 0; i < right.size(); ++i, ++data.shifts, ++data.iters) {
            ret.add(right.get(i));
        }

        return ret;
    }
}
