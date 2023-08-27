import java.awt.*;
import javax.swing.*;

public class MainMenu {
    // frames and panels
    JLabel topTextLabel = new JLabel();
    JPanel topTextPanel = new JPanel();
    JLabel bottomTextLabel = new JLabel();
    JPanel bottomTextPanel = new JPanel();
    JPanel gamesPanel = new JPanel();

    // buttons
    JButton TICTACTOE_Button = new JButton();
    JButton PLACEHOLDER_Button = new JButton();

    // Main Menu extra variables
    int FrameHeight = 600;
    int FrameWidth = 900;

    MainMenu(JFrame frame) {
        // configure the main menu frame
        frame.setResizable(false);
        frame.setSize(FrameWidth, FrameHeight);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Main Menu");
        frame.setLayout(new BorderLayout(0, 0));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // configure the top text label
        topTextLabel.setBackground(Color.lightGray);
        topTextLabel.setForeground(Color.black);
        topTextLabel.setFont(new Font("Arial", Font.BOLD, 38));
        topTextLabel.setText("Main Menu: Choose game");
        topTextLabel.setHorizontalAlignment(JLabel.CENTER);
        topTextLabel.setOpaque(true);

        // configure the top text panel
        topTextPanel.setLayout(new BorderLayout());
        topTextPanel.add(topTextLabel, BorderLayout.CENTER);
        frame.add(topTextPanel, BorderLayout.NORTH);

        // configure the bottom text label
        bottomTextLabel.setBackground(Color.lightGray);
        bottomTextLabel.setForeground(Color.black);
        bottomTextLabel.setFont(new Font("Arial", Font.BOLD, 24));
        bottomTextLabel.setText("GUI made by: Feli05");
        bottomTextLabel.setHorizontalAlignment(JLabel.CENTER);
        bottomTextLabel.setOpaque(true);

        // configure the bottom text panel
        bottomTextPanel.setLayout(new GridLayout(1, 3));
        bottomTextPanel.add(bottomTextLabel);
        frame.add(bottomTextPanel, BorderLayout.SOUTH);
        
        // configure the games panel
        gamesPanel.setLayout(new FlowLayout());
        gamesPanel.setBackground(new Color(0x312F2C));
    
        // config for button 1 (TicTacToe button)
        TICTACTOE_Button.setBackground(new Color(0xF9F6F0));
        TICTACTOE_Button.setForeground(new Color(0x493E2D));
        TICTACTOE_Button.setPreferredSize(new Dimension(175, 100));
        TICTACTOE_Button.setFont(new Font("Montserrat Black", Font.PLAIN, 18));
        TICTACTOE_Button.setText("TicTacToe");
        TICTACTOE_Button.setFocusable(false);
        TICTACTOE_Button.setBorder(BorderFactory.createRaisedBevelBorder());
        gamesPanel.add(TICTACTOE_Button);

        // config for button 2 (Placeholder for now)
        PLACEHOLDER_Button.setBackground(new Color(0xF9F6F0));
        PLACEHOLDER_Button.setForeground(new Color(0x493E2D));
        PLACEHOLDER_Button.setPreferredSize(new Dimension(175, 100));
        PLACEHOLDER_Button.setFont(new Font("Montserrat Black", Font.PLAIN, 18));
        PLACEHOLDER_Button.setText("Placeholder");
        PLACEHOLDER_Button.setFocusable(false);
        PLACEHOLDER_Button.setBorder(BorderFactory.createRaisedBevelBorder());
        gamesPanel.add(PLACEHOLDER_Button);
        frame.add(gamesPanel, BorderLayout.CENTER);

        // use ActionListener to record when the user clicks the button then call the game
        TICTACTOE_Button.addActionListener(e -> openTicTacToe(frame));
        PLACEHOLDER_Button.addActionListener(e -> openPlaceholder());
    }

    private void openTicTacToe(JFrame frame) {
        frame.getContentPane().removeAll();
        new TicTacToe(frame);
    }

    private void openPlaceholder() {
        // call the placeholder game
    }

}

