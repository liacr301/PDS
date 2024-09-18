package lab04.gp409.lab03;

public class Game implements JGaloInterface {

    private int playNum;
    private char actualPlayer;
    private char playerX='X';
    private char playerO='O';
    private char[][] board;


    public Game(char player){
        this.playNum=0;
        this.actualPlayer=player;
        this.board= new char[3][3];
        fillBoard();
    }

    public void fillBoard(){
        for(int y=0; y<3; y++){
            for(int x=0; x<3;x++){
                this.board[y][x]='0';
            }
        }
    }

    public boolean setJogada(int lin, int col) {
        if(this.board[lin-1][col-1] == '0'){
            if(this.actualPlayer == 'X'){
                this.board[lin-1][col-1] = 'X';
                this.actualPlayer = 'O';
            }else{
                this.board[lin-1][col-1] = 'O';
                this.actualPlayer = 'X';
            }
            playNum++;
            return true;
        }
        return false;
    }

    public char checkResult(){
        for(int y=0; y<3; y++){
            if(board[y][0] != '0' && board[y][0] == board[y][1] && board[y][1] == board[y][2]){
                return board[y][0];
            }
        }
        for(int x=0; x<3;x++){
            if(board[0][x] != '0' && board[0][x] == board[1][x] && board[1][x] == board[2][x]){
                return board[0][x];
            }
        }
        if(checkDiagonals()){
            return board[1][1];
        }
        return ' ';
    }

    public boolean checkDiagonals(){
        if(board[0][0] != '0' && board[0][0] == board[1][1] && board[1][1] == board[2][2]){
            return true;
        }
        if (board[0][2] != '0' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
        return false;
    }


    public char getActualPlayer(){
        return this.actualPlayer;
    }

    public boolean isFinished(){
        if(playNum >=9 || checkResult() != ' '){
            return true;
        }
        return false;
    }
}
