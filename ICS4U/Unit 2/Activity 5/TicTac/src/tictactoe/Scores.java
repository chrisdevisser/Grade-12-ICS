package tictactoe;

import javax.swing.ImageIcon;

/**
 * A dialog to display the scores.
 * Besides the frame for the base class constructor, does not rely on anything.
 * As such, its constants are localized.
 * @author Chris DeVisser
 */
public class Scores extends javax.swing.JDialog {
    private Integer _p1score;
    private Integer _p2score;
    private Integer _catscore;

    public Scores(Integer p1score, Integer p2score, Integer catscore) {
        super(Game.frame, false);
        initComponents();

        _p1score = p1score;
        p1.setText(p1score.toString());

        _p2score = p2score;
        p2.setText(p2score.toString());

        _catscore = catscore;
        cat.setText(catscore.toString());

        setLocationRelativeTo(null); //centre
        setResizable(false);
    }

    public void p1win() {
        ++_p1score;
        p1.setText(_p1score.toString());
        p1pic.setIcon(new ImageIcon("res/happy.png"));
        p2pic.setIcon(new ImageIcon("res/flipdesk.png"));
        setSize(600, 350);
    }

    public void p2win() {
        ++_p2score;
        p2.setText(_p2score.toString());
        p2pic.setIcon(new ImageIcon("res/happy.png"));
        p1pic.setIcon(new ImageIcon("res/flipdesk.png"));
        setSize(600, 350);
    }

    public void catwin() {
        ++_catscore;
        cat.setText(_catscore.toString());
        catpic.setIcon(new ImageIcon("res/happy-cat.jpg"));
        setSize(600, 450);
    }

    public void newgame() {
        p1pic.setIcon(new ImageIcon("res/gamer.png"));
        p2pic.setIcon(new ImageIcon("res/gamer.png"));
        catpic.setIcon(new ImageIcon("res/grumpy-cat.jpg"));
        setSize(500, 350);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        p1pic = new javax.swing.JLabel();
        p2pic = new javax.swing.JLabel();
        catpic = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        p1 = new javax.swing.JLabel();
        p2 = new javax.swing.JLabel();
        cat = new javax.swing.JLabel();

        setTitle("Scores");
        setBackground(java.awt.Color.white);
        setIconImage(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        p1pic.setIcon(new javax.swing.ImageIcon("F:\\Desktop\\ICS4U\\Unit 2\\Activity 5\\TicTac\\res\\gamer.png")); // NOI18N

        p2pic.setIcon(new javax.swing.ImageIcon("F:\\Desktop\\ICS4U\\Unit 2\\Activity 5\\TicTac\\res\\gamer.png")); // NOI18N

        catpic.setIcon(new javax.swing.ImageIcon("F:\\Desktop\\ICS4U\\Unit 2\\Activity 5\\TicTac\\res\\grumpy-cat.jpg")); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel4.setText("PLAYER 1");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel5.setText("PLAYER 2");

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 255));
        jLabel6.setText("THE CAT");

        p1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p1.setText("24");

        p2.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        p2.setText("24");

        cat.setFont(new java.awt.Font("Comic Sans MS", 0, 48)); // NOI18N
        cat.setForeground(new java.awt.Color(0, 0, 255));
        cat.setText("56");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addComponent(p1pic, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(p1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(catpic)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(cat)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(p2pic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(p2)
                        .addGap(42, 42, 42))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(p2pic))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(catpic)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cat))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(p1pic)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(p1)
                            .addComponent(p2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private javax.swing.JLabel cat;
    private javax.swing.JLabel catpic;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel p1;
    private javax.swing.JLabel p1pic;
    private javax.swing.JLabel p2;
    private javax.swing.JLabel p2pic;
    // End of variables declaration//GEN-END:variables
}
