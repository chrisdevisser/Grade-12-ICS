package tictactoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Makes a menu for the Tic-Tac-Toe game.
 * @author Chris DeVisser
 */
public final class Menu {
    /**
     * Creates menu bar. The menu bar consists of File and Options
     */
    public static void create() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(makeFileMenu());
        menuBar.add(makeOptionsMenu());
        Game.frame.setJMenuBar(menuBar);
    }

    /**
     * Creates file menu. The file menu consists of New Game and Exit.
     * @return The file menu
     */
    private static JMenu makeFileMenu() {
        JMenu file = new JMenu(Constant.Menu.M0);
        file.setMnemonic(Constant.Menu.M0_KEY);

        JMenuItem file_newgame = new JMenuItem(
            Constant.Menu.M00,
            Constant.Menu.M00_KEY
        );
        
        file_newgame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Game.end();
                Game.start();
            }
        });

        JMenuItem file_exit = new JMenuItem(
            Constant.Menu.M01,
            Constant.Menu.M01_KEY
        );
        
        file_exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        file.add(file_newgame);
        file.add(file_exit);
        return file;
    }

    /**
     * Creates options menu. The options menu consists of Size, Number to Win,
     * Icon, Always show score, and Open score at end of game.
     * @return The options menu
     */
    private static JMenu makeOptionsMenu() {
        JMenu options = new JMenu(Constant.Menu.M1);
        options.setMnemonic(Constant.Menu.M1_KEY);
        options.add(makeOptionsSizeMenu());
        options.add(makeOptionsNumberToWinMenu());
        options.add(makeOptionsIconMenu());

        JCheckBoxMenuItem options_alwaysScore = new JCheckBoxMenuItem(
            Constant.Menu.M13
        );
        options_alwaysScore.setMnemonic(Constant.Menu.M13_KEY);

        options_alwaysScore.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JCheckBoxMenuItem item = (JCheckBoxMenuItem)e.getSource();

                if (item.isSelected()) {
                    Game.scores.setDefaultCloseOperation(
                        Scores.DO_NOTHING_ON_CLOSE
                    );
                    Game.scores.setVisible(true);
                } else {
                    Game.scores.setDefaultCloseOperation(
                        Scores.HIDE_ON_CLOSE
                    );
                    Game.scores.setVisible(false);
                }
            }
        });

        JCheckBoxMenuItem options_openAtEnd = new JCheckBoxMenuItem(
            Constant.Menu.M14,
            true
        );
        options_openAtEnd.setMnemonic(Constant.Menu.M14_KEY);

        options_openAtEnd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JCheckBoxMenuItem item = (JCheckBoxMenuItem)e.getSource();
                Options.setOpenAtEnd(item.isSelected());
            }
        });

        options.add(options_alwaysScore);
        options.add(options_openAtEnd);

        return options;
    }

    /**
     * Creates options size menu. The size menu consists of sizes from 3 to 8.
     * @return The options size menu
     */
    private static JMenu makeOptionsSizeMenu() {
        JMenu options_size = new JMenu(Constant.Menu.M10);
        options_size.setMnemonic(Constant.Menu.M10_KEY);

        ButtonGroup buttons = new ButtonGroup();
        
        for (
            Integer i = Constant.Game.MIN_DIMS;
            i <= Constant.Game.MAX_DIMS;
            ++i
        ) {
            JRadioButtonMenuItem options_size_i = 
                new JRadioButtonMenuItem(i.toString());
            
            options_size_i.setMnemonic(KeyEvent.VK_0 + i);
            options_size_i.addActionListener(new SizeAction());
            buttons.add(options_size_i);
            options_size.add(options_size_i);
        }

        options_size.getItem(0).setSelected(true);
        return options_size;
    }

    /**
     * Creates options number to win menu. The menu includes values from 3 to 8.
     * @return The options number to win menu
     */
    private static JMenu makeOptionsNumberToWinMenu() {
        JMenu options_number_to_win = new JMenu(Constant.Menu.M11);
        options_number_to_win.setMnemonic(Constant.Menu.M11_KEY);

        ButtonGroup buttons = new ButtonGroup();
        
        for (
            Integer i = Constant.Game.MIN_DIMS;
            i <= Constant.Game.MAX_DIMS;
            ++i
        ) {
            JRadioButtonMenuItem options_num2win_i =
                new JRadioButtonMenuItem(i.toString());

            options_num2win_i.setMnemonic(KeyEvent.VK_0 + i);
            options_num2win_i.addActionListener(new NumberToWinAction());
            buttons.add(options_num2win_i);
            options_number_to_win.add(options_num2win_i);
        }

        options_number_to_win.getItem(0).setSelected(true);
        return options_number_to_win;
    }

    /**
     * Creates options icon menu. The icons menu consists of Empty, Player 1,
     * Player 2, and Themes.
     * @return The options icon menu
     */
    private static JMenu makeOptionsIconMenu() {
        JMenu options_icon = new JMenu(Constant.Menu.M12);
        options_icon.setMnemonic(Constant.Menu.M12_KEY);

        JMenuItem options_icons_empty = new JMenuItem(
            Constant.Menu.M120,
            Constant.Menu.M120_KEY
        );
        
        options_icons_empty.addActionListener(new IconAction());

        JMenuItem options_icons_p1 = new JMenuItem(
            Constant.Menu.M121,
            Constant.Menu.M121_KEY
        );
        
        options_icons_p1.addActionListener(new IconAction());

        JMenuItem options_icons_p2 = new JMenuItem(
            Constant.Menu.M122,
            Constant.Menu.M122_KEY
        );
        
        options_icons_p2.addActionListener(new IconAction());

        options_icon.add(options_icons_empty);
        options_icon.add(options_icons_p1);
        options_icon.add(options_icons_p2);
        options_icon.add(makeOptionsIconThemeMenu());

        return options_icon;
    }

    /**
     * Creates options icon theme menu. The theme menu consists of Emotions,
     * Classic, and Tictac.
     * @return The options icon theme menu
     */
    static JMenu makeOptionsIconThemeMenu() {
        JMenu options_icon_theme = new JMenu(Constant.Menu.M123);
        options_icon_theme.setMnemonic(Constant.Menu.M123_KEY);

        JMenuItem options_icon_theme_emotions = new JMenuItem(
            Constant.Menu.M1230,
            Constant.Menu.M1230_KEY
        );

        options_icon_theme_emotions.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Options.setIcon(
                    Constant.Icon.EMPTY_INDEX,
                    new ImageIcon(Constant.Icon.EMOTIONS_EMPTY)
                );

                Options.setIcon(
                    Constant.Icon.P1_INDEX,
                    new ImageIcon(Constant.Icon.EMOTIONS_P1)
                );

                Options.setIcon(
                    Constant.Icon.P2_INDEX,
                    new ImageIcon(Constant.Icon.EMOTIONS_P2)
                );
            }
        });

        JMenuItem options_icon_theme_classic = new JMenuItem(
            Constant.Menu.M1231,
            Constant.Menu.M1231_KEY
        );

        options_icon_theme_classic.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Options.setIcon(
                    Constant.Icon.EMPTY_INDEX,
                    new ImageIcon(Constant.Icon.CLASSIC_EMPTY)
                );

                Options.setIcon(
                    Constant.Icon.P1_INDEX,
                    new ImageIcon(Constant.Icon.CLASSIC_P1)
                );

                Options.setIcon(
                    Constant.Icon.P2_INDEX,
                    new ImageIcon(Constant.Icon.CLASSIC_P2)
                );
            }
        });

        JMenuItem options_icon_theme_tictac = new JMenuItem(
            Constant.Menu.M1232,
            Constant.Menu.M1232_KEY
        );

        options_icon_theme_tictac.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Options.setIcon(
                    Constant.Icon.EMPTY_INDEX,
                    new ImageIcon(Constant.Icon.TICTAC_EMPTY)
                );

                Options.setIcon(
                    Constant.Icon.P1_INDEX,
                    new ImageIcon(Constant.Icon.TICTAC_P1)
                );

                Options.setIcon(
                    Constant.Icon.P2_INDEX,
                    new ImageIcon(Constant.Icon.TICTAC_P2)
                );
            }
        });

        options_icon_theme.add(options_icon_theme_emotions);
        options_icon_theme.add(options_icon_theme_classic);
        options_icon_theme.add(options_icon_theme_tictac);

        return options_icon_theme;
    }

    /**
     * Implementation of generic size change.
     */
    private static class SizeAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof JMenuItem) {
                JMenuItem item = (JMenuItem)e.getSource();
                int size = 0;

                try {
                    size = Integer.parseInt(item.getText());
                } catch (NumberFormatException ex) {
                    return;
                }

                Options.setDimensions(size);
            }
        }
    }

    /**
     * Implementation of generic number to win change.
     */
    private static class NumberToWinAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof JMenuItem) {
                JMenuItem item = (JMenuItem)e.getSource();
                int num = 0;

                try {
                    num = Integer.parseInt(item.getText());
                } catch (NumberFormatException ex) {
                    return;
                }

                Options.setNumberToWin(num);
            }
        }
    }

    /**
     * Implementation of icon change.
     */
    private static class IconAction implements ActionListener {
        /**
         * Sets an icon by letting the user choose a file.
         * @param index The index of the icon to set
         */
        private void changeIcon(int index) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(
                new FileNameExtensionFilter(
                    Constant.Icon.FILTERNAME,
                    Constant.Icon.FILTER0,
                    Constant.Icon.FILTER1,
                    Constant.Icon.FILTER2,
                    Constant.Icon.FILTER3,
                    Constant.Icon.FILTER4
                )
            );

            if (fileChooser.showOpenDialog(Game.frame)
                == JFileChooser.APPROVE_OPTION
            ) {
                ImageIcon icon = new ImageIcon(
                    fileChooser.getSelectedFile().getAbsolutePath()
                );
                
                if (icon.getIconWidth() > 
                        Constant.Icon.MAX_COMBINED_WIDTH
                        / Options.getDimensions()
                    || icon.getIconHeight() > 
                        Constant.Icon.MAX_COMBINED_HEIGHT
                        / Options.getDimensions()
                ) {
                    JOptionPane.showMessageDialog(
                        null, "That icon is too large."
                    );
                    
                    return;
                }

                Options.setIcon(index, icon);
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals(Constant.Menu.M120)) {
                changeIcon(Constant.Icon.EMPTY_INDEX);
            } else if (e.getActionCommand().equals(Constant.Menu.M121)) {
                changeIcon(Constant.Icon.P1_INDEX);
            } else if (e.getActionCommand().equals(Constant.Menu.M122)) {
                changeIcon(Constant.Icon.P2_INDEX);
            }
        }
    }
}
