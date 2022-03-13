/*
Color Change Exercise 1
Bruce Black
Liberty University
CSIS 505: Software Development
Dr. James Dollens
June 06, 2021
 */
package ColorChangeGUI;

import colorselect.ColorSelect;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ColorChangeGUI {
    //manual GUI components
    private JFrame mainWindowFrame;
    private JLabel titleLabel;
    private JPanel colorJList;

    public ColorChangeGUI() {
        prepareGUI();
    }

    public static void main(String[] args) {
        ColorChangeGUI colorChangeGUI = new ColorChangeGUI();
        colorChangeGUI.showListDemo();
    }
    //manual GUI design
    private void prepareGUI() {
        mainWindowFrame = new JFrame("Select a color to change the background");
        mainWindowFrame.setSize(500,500);
        mainWindowFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        titleLabel = new JLabel("", JLabel.CENTER);

        colorJList = new JPanel();
        colorJList.setLayout(new FlowLayout());

        mainWindowFrame.add(titleLabel);
        mainWindowFrame.add(colorJList);
        mainWindowFrame.setVisible(true);
    }

    private void showListDemo() {

        titleLabel.setText("Select a color to change the background");

        final HashMap<String, Color> colorMap = new ColorSelect().getAllColors();

        final JList jlist = new JList(new Vector(colorMap.keySet()));
        jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jlist.setSelectedIndex(0);
        jlist.setVisibleRowCount(13);

        JScrollPane listScrollPane = new JScrollPane(jlist);

        jlist.addListSelectionListener((ListSelectionEvent listSelectionEvent) -> {
            String selected = (String) jlist.getSelectedValue();
            colorJList.setBackground(colorMap.get(selected));
        });

        colorJList.add(listScrollPane);

        mainWindowFrame.setVisible(true);
    }
}
