import java.awt.*;
import javax.swing.*;

public class TicTacToe {

    int boardWidth = 600;
    int boardHeight = 650; // 50px for the text panel at the top

    // main frame, panels and labels
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();

    // buttons
    JButton[][] board = new JButton[3][3];
    JButton MAINMENU_Button =  new JButton();

    // game logic
    boolean gameOver = false;
    int total_turns = 0;
    String playerX = "X";
    String playerO = "O";
    String currPlayer = playerX;

    TicTacToe(JFrame frame){
        // configure the frame that shows all the panels
        frame.setTitle("Tic Tac Toe!");
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        // configure the text and background for the text label (title of the game)
        textLabel.setBackground(Color.darkGray);
        textLabel.setForeground(Color.white);
        textLabel.setFont(new Font("Arial", Font.BOLD, 50));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Tic Tac Toe");
        textLabel.setOpaque(true);

        // configure the 'go back to main menu' button that is inside the text panel
        MAINMENU_Button.setBackground(new Color(0xF9F6F0));
        MAINMENU_Button.setForeground(new Color(0x493E2D));
        MAINMENU_Button.setFont(new Font("Montserrat Black", Font.PLAIN, 18));
        MAINMENU_Button.setText("Go Back");
        MAINMENU_Button.setFocusable(false);
        MAINMENU_Button.setBorder(BorderFactory.createRaisedBevelBorder());

        // configure the position of the text panel
        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel, BorderLayout.CENTER);
        textPanel.add(MAINMENU_Button, BorderLayout.EAST);
        frame.add(textPanel, BorderLayout.NORTH);

        // initialize the layout for the buttons
        boardPanel.setLayout(new GridLayout(3, 3));
        boardPanel.setBackground(Color.darkGray);
        frame.add(boardPanel);

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                // initialize each tile in the board
                JButton tile = new JButton();
                board[i][j] = tile;
                boardPanel.add(tile);

                // configure the colors and text for each tile in the board
                tile.setBackground(Color.darkGray);
                tile.setForeground(Color.white);
                tile.setFont(new Font("Arial", Font.BOLD, 120));
                tile.setFocusable(false);

                // action listener checks for users input
                tile.addActionListener(e -> {

                    // check if the game is over
                    if(gameOver){
                        return;
                    }

                    JButton tile1 = (JButton) e.getSource();

                    // if the tile is empty
                    if(tile1.getText().isEmpty()){
                        tile1.setText(currPlayer);
                        total_turns++;
                        // check if there is a winner after every turn
                        checkWinner();
                        // if the game is over the user is not allowed to input again
                        if(!gameOver){
                            // switch the current player by checking last player
                            if(currPlayer.equals(playerX)){
                                currPlayer = playerO;
                            } else {
                                currPlayer = playerX;
                            }
                            // change the *title* text to show the current players turn
                            textLabel.setText(currPlayer + "'s turn.");
                        }
                    }
                });
            }
        }

        // if you press the button you remove all the current panels and open the MainMenu
        MAINMENU_Button.addActionListener(e -> {
            frame.getContentPane().removeAll();
            new MainMenu(frame);
        });

    }

    private void checkWinner(){
        // check for win conditions in every row (horizontally)
        for(int i = 0; i < 3; i++){
            if(board[i][0].getText().equals(board[i][1].getText()) &&
               board[i][1].getText().equals(board[i][2].getText()) &&
               !board[i][0].getText().isEmpty()){
                gameOver = true;
                // modify the color and text of the row to highlight winner
                for(int w = 0; w < 3; w++){
                    setWinner(board[i][w]);
                }
            }
        }
        // checks for win conditions in every column (vertically)
        for(int j = 0; j < 3; j++){
            if(board[0][j].getText().equals(board[1][j].getText()) &&
               board[1][j].getText().equals(board[2][j].getText()) &&
               !board[0][j].getText().isEmpty()){
               gameOver = true;
               // modify the color and text of the column to highlight winner
               for(int w = 0; w < 3; w++){
                   setWinner(board[w][j]);
               }
            }
        }
        // checks for win conditions from top right to bottom left (diagonally)
        if(board[0][0].getText().equals(board[1][1].getText()) &&
           board[1][1].getText().equals(board[2][2].getText()) &&
           !board[0][0].getText().isEmpty()){
            gameOver = true;
            // modify the color and the text of the diagonal tiles to highlight winner
            for(int w = 0; w < 3; w++){
                setWinner(board[w][w]);
            }
        }
        // check for win conditions from top left to bottom right (diagonally)
        if(board[0][2].getText().equals(board[1][1].getText()) &&
           board[1][1].getText().equals(board[2][0].getText()) &&
           !board[0][2].getText().isEmpty()){
            gameOver = true;
            // modify the color and text of the diagonal tiles to highlight the winner
            setWinner(board[0][2]);
            setWinner(board[1][1]);
            setWinner(board[2][0]);
        }
        // if there is no winner, but a tie instead, modify color and text of all the tiles
        if(total_turns == 9){
            // set the tie conditions for every tile in the board
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    setTie(board[i][j]);
                }
            }
            gameOver = true;
        }
    }

    private void setWinner(JButton tile){
        tile.setBackground(Color.gray);
        tile.setForeground(Color.green);
        textLabel.setText(tile.getText() + " is the winner!");
    }

    private void setTie(JButton tile){
        tile.setBackground(Color.gray);
        tile.setForeground(Color.pink);
        textLabel.setText("There is a tie!");
    }

}
