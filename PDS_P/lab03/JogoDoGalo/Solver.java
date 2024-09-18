package lab03.JogoDoGalo;

public class Solver implements JGaloInterface{
	private char player1;
	private char player2;
    private int sum = 0;
    private char[][] table;
    private int line;
    
    //construtor
    public Solver() {
	//atribuição inicial de jogador
		this.player1 = 'X'; //ou 'O', dependendo de como deseja iniciar
		this.player2 = (player1 == 'X') ? 'O' : 'X'; //define o segundo jogador automaticamente
		//criacao de uma tabela 3x3 vazia
		this.table = new char[3][3];
		for(int i = 0; i< table.length; i++) {
			for(int j = 0; j < table.length; j++) {
				table[i][j] = '*';
			}
		}
    }
    
	public char getActualPlayer() {
		// pares e o joagador1  impares e o jogador2
		if(sum%2 == 0){
			return player1;
		}
		else{
			return player2;
		}
	}
	
	//contagem das jogadas e colocacao nos quadrados da tabela
	public boolean setJogada(int lin, int col) {
		if(table[col - 1][lin - 1] == '*'){
            table[col - 1][lin - 1] = getActualPlayer();
            sum++;
            return true;
        }
        else {
            return false;
        }
	}
	
	//condicoes para termos o fim do jogo
	public boolean isFinished() {
		if ((this.sum == 9 && checkResult() == '*') || (this.sum >= 5 && checkResult() != '*')) {
			return true;
		}
		return false;
	}

	public char checkResult() {
		//ver horizontalmente
		for (line = 0; line < 3; line++) {
			if (table[line][0] != '*' && table[line][0] == table[line][1] && table[line][1] == table[line][2] ) {
				return table[line][0];
			}
		}
		
		//ver verticalmente
		for (line = 0; line < 3; line++) {
			if (table[0][line] != '*' && table[0][line] == table[1][line] && table[1][line] == table[2][line] ) {
				return table[0][line];
			}
		}
		
		//ver diagonalmente
        if (table[2][0] != '*' && table[2][0] == table[1][1] && table[1][1] == table[0][2]) {
            return table[2][0];
        }
        
        if (table[0][0] != '*' && table[0][0] == table[1][1] && table[1][1] == table[2][2]) {
            return table[0][0];
        }
        return '*';
		
	}

}
