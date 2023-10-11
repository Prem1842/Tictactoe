import java.util.*;

public class TickTac {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        char [][]Board =new char[3][3];
        for(int i=0;i<Board.length;i++){
            for (int j=0;j<Board[0].length;j++){
                Board[i][j]=' ';
            }
        }
        char Player='X';
        Boolean isGameOver=false;
        while(!isGameOver){
            printBoard(Board);
            System.out.println();
            System.out.println("Player "+ Player +" Enter your Move : ");
            System.out.println();
            int row,col;
            while(true) {
                try {
                    row = scanner.nextInt();
                    col = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Enter valid input ,\" Integer is needed\"");
                    scanner.nextLine();
                }
            }
            if(row<3 || col<3) {


                if (Board[row][col] == ' ') {
                    Board[row][col] = Player;
                    isGameOver = havewon(Board, Player) || isBoardEmpty(Board);
                    if (isGameOver) {
                        printBoard(Board);
                        System.out.println();
                        if(havewon(Board,Player)) {

                            System.out.println("Player " + Player + " has won the game.");
                        }
                        else{
                            System.out.println("Game has ended ,Please restart the game.");
                        }
                    } else {
                        Player = (Player == 'X') ? '0' : 'X';
                    }

                } else {
                    System.out.println("Invalid");
                }
            }
            else{
                System.out.println("Enter valid position");
            }
        }
    }

    private static Boolean havewon(char[][] board, char player) {
        for(int row=0;row<board.length;row++){
            if(board[row][0]==player && board[row][1]==player && board[row][2]==player){
                return true;
            }
        }
        for(int col=0;col<board[0].length;col++){
            if(board[0][col]==player && board[1][col]==player && board[2][col]==player){
                return true;
            }
        }
        if(board[0][0]==player && board[1][1]==player && board[2][2]==player){
            return true;
        }
        if(board[0][2]==player && board[1][1]==player && board[2][0]==player){
            return true;
        }
        return false;
    }

    private static void printBoard(char[][] board) {
        System.out.println("Here is your tic tac toe board");
        System.out.println();
        for(int i=0;i< board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j]+" | ");
            }
            System.out.println();
        }
    }

    public static Boolean isBoardEmpty(char [][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==' '){
                    return false;
                }
            }
        }
        return true;
    }


}

