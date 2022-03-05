import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToe implements ActionListener {
    Random rand = new Random();
    JFrame frame = new JFrame();
    JPanel titlePanel = new JPanel();
    JPanel btnPannel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] btns = new JButton[9];
    boolean player1;

    TicTacToe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(25, 255, 0));
        textField.setFont(new Font("Damion", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("TicTacToe");
        textField.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 600, 100);

        btnPannel.setLayout(new GridLayout(3, 3));
        btnPannel.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < 9; i++) {
            btns[i] = new JButton();
            btnPannel.add(btns[i]);
            btns[i].setFont(new Font("Damion", Font.BOLD, 120));
            btns[i].setFocusable(false);
            btns[i].addActionListener(this);
        }
        titlePanel.add(textField);
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(btnPannel);
        firstPlayer();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == btns[i]) {
                if (player1) {
                    if (btns[i].getText() == "") {
                        btns[i].setBackground(new Color(155, 0, 0));
                        btns[i].setText("X");
                        player1 = false;
                        textField.setText("O Turn");
                        checkWin();
                    }
                } else {
                    if (btns[i].getText() == "") {
                        btns[i].setBackground(new Color(0, 0, 155));
                        btns[i].setText("O");
                        player1 = true;
                        textField.setText("X Turn");
                        checkWin();
                    }
                }
            }
        }
    }

    public void firstPlayer() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (rand.nextInt(2) == 0) {
            player1 = true;
            textField.setText("X Turn");
        } else {
            player1 = false;
            textField.setText("O Turn");
        }
    }

    public void checkWin() {
        /*
         * X Wins
         */
        if ((btns[0].getText() == "X") && (btns[1].getText() == "X") && (btns[2].getText() == "X")) {
            xWin(0, 1, 2);
        } else if ((btns[3].getText() == "X") && (btns[4].getText() == "X") && (btns[5].getText() == "X")) {
            xWin(3, 4, 5);
        } else if ((btns[6].getText() == "X") && (btns[7].getText() == "X") && (btns[8].getText() == "X")) {
            xWin(6, 7, 8);
        } else if ((btns[0].getText() == "X") && (btns[3].getText() == "X") && (btns[6].getText() == "X")) {
            xWin(0, 3, 6);
        } else if ((btns[1].getText() == "X") && (btns[4].getText() == "X") && (btns[7].getText() == "X")) {
            xWin(1, 4, 7);
        } else if ((btns[2].getText() == "X") && (btns[5].getText() == "X") && (btns[8].getText() == "X")) {
            xWin(2, 5, 8);
        } else if ((btns[0].getText() == "X") && (btns[4].getText() == "X") && (btns[8].getText() == "X")) {
            xWin(0, 4, 8);
        } else if ((btns[2].getText() == "X") && (btns[4].getText() == "X") && (btns[6].getText() == "X")) {
            xWin(2, 4, 6);
        }
        /*
         * O Wins
         */
        if ((btns[0].getText() == "O") && (btns[1].getText() == "O") && (btns[2].getText() == "O")) {
            oWin(0, 1, 2);
        } else if ((btns[3].getText() == "O") && (btns[4].getText() == "O") && (btns[5].getText() == "O")) {
            oWin(3, 4, 5);
        } else if ((btns[6].getText() == "O") && (btns[7].getText() == "O") && (btns[8].getText() == "O")) {
            oWin(6, 7, 8);
        } else if ((btns[0].getText() == "O") && (btns[3].getText() == "O") && (btns[6].getText() == "O")) {
            oWin(0, 3, 6);
        } else if ((btns[1].getText() == "O") && (btns[4].getText() == "O") && (btns[7].getText() == "O")) {
            oWin(1, 4, 7);
        } else if ((btns[2].getText() == "O") && (btns[5].getText() == "O") && (btns[8].getText() == "O")) {
            oWin(2, 5, 8);
        } else if ((btns[0].getText() == "O") && (btns[4].getText() == "O") && (btns[8].getText() == "O")) {
            oWin(0, 4, 8);
        } else if ((btns[2].getText() == "O") && (btns[4].getText() == "O") && (btns[6].getText() == "O")) {
            oWin(2, 4, 6);
        }
    }

    public void xWin(int a, int b, int c) {
        btns[a].setBackground(Color.GREEN);
        btns[b].setBackground(Color.GREEN);
        btns[c].setBackground(Color.GREEN);
        for (int i = 0; i < 9; i++) {
            btns[i].setEnabled(false);
        }
        textField.setText("X Wins !");
    }

    public void oWin(int a, int b, int c) {
        btns[a].setBackground(Color.GREEN);
        btns[b].setBackground(Color.GREEN);
        btns[c].setBackground(Color.GREEN);
        for (int i = 0; i < 9; i++) {
            btns[i].setEnabled(false);
        }
        textField.setText("O Wins !");
    }

    public void gameTied() {
        for (int i = 0; i < 9; i++) {
            btns[i].setEnabled(false);
        }
        textField.setText("Tie !");

    }
}
