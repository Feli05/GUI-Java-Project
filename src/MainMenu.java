import java.awt.*;
<<<<<<< Updated upstream
import javax.swing.*;
=======
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class MainMenu {
    // frames and panels
    JFrame frame = new JFrame("Main Menu");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    GridBagConstraints constraints = new GridBagConstraints();

    // buttons
    JButton TICTACTOE_Button = new JButton("TicTacToe");
    JButton GAME2048_Button = new JButton("2048");
    JButton RETURN_Button = new JButton("Back to Main Menu");

    // Main Menu internal variables and logic
    int FrameHeight = 600;
    int FrameWidth = 900;

    MainMenu() {
        // configure the main menu frame
        frame.setResizable(true);
        frame.setSize(FrameWidth, FrameHeight);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // configure the text label
        textLabel.setBackground(Color.gray);
        textLabel.setForeground(Color.black);
        textLabel.setFont(new Font("Arial", Font.BOLD, 38));
        textLabel.setText("Main Menu: Choose game");
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setVerticalAlignment(JLabel.NORTH);
        textLabel.setOpaque(true);

        // configure the text panel
        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel, BorderLayout.NORTH);
        
        // configure the button panel to match text panel
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.setBackground(Color.gray);
    
        // config for button 1 (TicTacToe button)
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.ipadx = 100;
        constraints.ipady = 100;
        TICTACTOE_Button.setBackground(Color.darkGray);
        TICTACTOE_Button.setForeground(Color.white);
        buttonPanel.add(TICTACTOE_Button, constraints);

        // config for button 2 (2048 game button)
        constraints.gridx = 1;
        constraints.gridy = 0;
        GAME2048_Button.setBackground(Color.darkGray);
        GAME2048_Button.setForeground(Color.white);
        buttonPanel.add(GAME2048_Button, constraints);
        frame.add(buttonPanel);

        // use ActionListener to record when the user clicks the button then call the game
        TICTACTOE_Button.addActionListener(e -> openTicTacToe());
        GAME2048_Button.addActionListener(e -> openGame2048());
    }

    private void openTicTacToe() {
        TicTacToe ticTacToe = new TicTacToe();
    }

    private void openGame2048() {
        // call the 2048 game when it's ready
    }

}

