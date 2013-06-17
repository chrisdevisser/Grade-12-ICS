/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package u2a4_chrisdevisser_students;

import java.awt.Component;
import java.util.Arrays;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/**
 * Provides a cell renderer to display a student's name and mark information.
 */
public class StudentCellRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(
        JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus
    ) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if (value instanceof U2A4_ChrisDeVisser_StudentsView.Student) {
            U2A4_ChrisDeVisser_StudentsView.Student student = (U2A4_ChrisDeVisser_StudentsView.Student)value;
            setText(student.getFullName());

            //tooltip format:
            //Test Marks: xxx
            //Average: yyy
            String tooltip = Arrays.toString(student.testMarks);
            tooltip = tooltip.substring(1, tooltip.length() - 1);
            tooltip = "Test Marks: " + tooltip;
            tooltip += "<br/>Average: " + student.getAverage() + "</html>";
            setToolTipText("<html>" + tooltip + "</html>");
        }

        return this;
    }
}
