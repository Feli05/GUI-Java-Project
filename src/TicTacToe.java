import java.awt.*;
import javax.swing.*;

public class TicTacToe {

    int boardWidth = 600;
    int boardHeight = 650; // 50px for the text panel at the top

    // main frame, panels and labels
    JFrame frame = new JFrame("Tic Tac Toe!");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();

    // buttons
    JButton[][] board = new JButton[3][3];
    String playerX = "X";
    String playerO = "O";
    String currPlayer = playerX;

    // game logic
    boolean gameOver = false;
    int total_turns = 0;

    TicTacToe(){
        // configure the frame that shows all the panels
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // configure the text and background for the text label (title of the game)
        textLabel.setBackground(Color.darkGray);
        textLabel.setForeground(Color.white);
        textLabel.setFont(new Font("Arial", Font.BOLD, 50));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Tic Tac Toe");
        textLabel.setOpaque(true);

        // configure the position of the text panel
        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
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
