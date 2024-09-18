import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class WSSolver{
    static String line;
    static int numWords;
    public static void main(String[] args) throws FileNotFoundException{

        File sdl = verifyInput(args);

        Scanner sc = new Scanner(sdl);
        line = sc.nextLine();
        int sizeLine = line.length();

        char [][] sopa = new char[sizeLine][sizeLine];
        sopa = storeSopa(sizeLine, sopa, sc);

        String WordList[][] = new String[100][4]; 
        WordList = getWordList(sc, line, sizeLine, sopa);
        WordList = findWords(WordList, sopa, sizeLine, numWords);
        char sopaResol[][] = solvedSoup(WordList, sopa, sizeLine, numWords);
        printAndSave(numWords, WordList, sizeLine, sopaResol);

    }

    private static File verifyInput(String args[]){
        if (args.length != 1) {
            System.out.println("Ficheiro nao introduzido");
            System.exit(1);
        }
        
        String ficheiro= args[0];
        
        File sdl = new File(ficheiro);
        if (!sdl.exists()) {
            System.out.println("O arquivo " + ficheiro + " nao existe.");
            System.exit(1);
        }
        return sdl;
    }
    
    private static char[][] storeSopa(int sizeLine, char sopa[][], Scanner sc){
        int xLine = 0;
        while (xLine<sizeLine){
            for (int i = 0; i<sizeLine; i++){
                char letra = line.charAt(i);
                sopa[xLine][i] = letra;
            }
            xLine++;
            line = sc.nextLine();
        }
        return sopa;
    }
    private static String[][] getWordList(Scanner sc, String line, int sizeLine, char sopa[][]){
        String WordList[][] = new String[100][4];
        boolean nextLine = true;
        while (nextLine){
            String words[] = line.split("[,;\\s]+");
            for (int i = 0; i < words.length; i++){
                WordList[numWords][0] = words[i];
                WordList[numWords][1] = Integer.toString(words[i].length());
                numWords++;
            }
            if(!(sc.hasNextLine())){
                nextLine=false;
                break;
            }
            line=sc.nextLine();
        }
        return WordList;
    }

    private static String[][] findWords(String WordList[][], char sopa[][], int sizeLine, int numWords){
        for(int k=0;k<numWords;k++){
            int letra=0;
            for(int x=0;x< sizeLine;x++){
                for(int y=0;y<sizeLine;y++){
                    if(Character.toUpperCase(sopa[x][y])==Character.toUpperCase(WordList[k][0].charAt(letra))){
                        int posX = x+1;
                        int posY = y+1;
                        for (int sideX = -1; sideX <= 1; sideX++){
                            for (int sideY = -1; sideY <= 1; sideY++){
                                if (sideX == 0 && sideY == 0){
                                    continue;
                                }
                                int x1 = x + sideX;
                                int y1 = y + sideY;
                                int letra1 = 1;
                                while (letra1 < Integer.parseInt(WordList[k][1])){
                                    if (x1 < 0 || x1 >= sizeLine || y1 < 0 || y1 >= sizeLine){
                                        break;
                                    }
                                    if (Character.toUpperCase(sopa[x1][y1]) != Character.toUpperCase(WordList[k][0].charAt(letra1))){
                                        break;
                                    }

                                    x1 += sideX;
                                    y1 += sideY;
                                    letra1++;
                                }
                                if (letra1 == Integer.parseInt(WordList[k][1])){
                                    if (letra1 == Integer.parseInt(WordList[k][1])){
                                        if (sideX == 1 && sideY == 1){
                                            WordList[k][3] = "DownRight";
                                        }
                                        if (sideX == 1 && sideY == 0){
                                            WordList[k][3] = "Down";
                                        }
                                        if (sideX == 1 && sideY == -1){
                                            WordList[k][3] = "DownLeft";
                                        }
                                        if (sideX == 0 && sideY == 1){
                                            WordList[k][3] = "Right";
                                        }
                                        if (sideX == 0 && sideY == -1){
                                            WordList[k][3] = "Left";
                                        }
                                        if (sideX == -1 && sideY == 1){
                                            WordList[k][3] = "UpRight";
                                        }
                                        if (sideX == -1 && sideY == 0){
                                            WordList[k][3] = "Up";
                                        }
                                        if (sideX == -1 && sideY == -1){
                                            WordList[k][3] = "UpLeft";
                                        }
                                    String pos = Integer.toString(posX) + "," + Integer.toString(posY);
                                    WordList[k][2] = pos;
                                }
                            }
                            }
                        }    
                    }
                }
            }
        }
        return WordList;
    }
    private static char[][] solvedSoup(String WordList[][], char sopa[][], int sizeLine, int numWords){
        char[][] sopaResol = new char[sizeLine][sizeLine];
        for (int i = 0; i < sizeLine; i++){
            for (int j = 0; j < sizeLine; j++){
                sopaResol[i][j] = '.';
            }
        }
        for (int i = 0; i < numWords; i++){
            int x = Integer.parseInt(WordList[i][2].split(",")[0]) - 1;
            int y = Integer.parseInt(WordList[i][2].split(",")[1]) - 1;
            int tamanho = Integer.parseInt(WordList[i][1]);
            for (int j = 0; j < tamanho; j++){
                sopaResol[x][y] = sopa[x][y];
                if (WordList[i][3].equals("DownRight")){
                    x++;
                    y++;
                }
                if (WordList[i][3].equals("Right")){
                    y++;
                }
                if (WordList[i][3].equals("UpRight")){
                    x--;
                    y++;
                }
                if (WordList[i][3].equals("Down")){
                    x++;
                }
                if (WordList[i][3].equals("Up")){
                    x--;
                }
                if (WordList[i][3].equals("DownLeft")){
                    x++;
                    y--;
                }
                if (WordList[i][3].equals("Left")){
                    y--;
                }
                if (WordList[i][3].equals("UpLeft")){
                    x--;
                    y--;
                }
            }
        }
        return sopaResol;
    
    }
    private static void printAndSave(int numWords, String WordList[][], int sizeLine, char sopa[][]){
        File file = new File("out3.txt");
        try{
        FileWriter writer = new FileWriter(file);
        for (int i = 0; i < numWords; i++){
            String infoWord = String.format("%-13s %-2s %-10s %-10s\n", WordList[i][0], WordList[i][1], WordList[i][2], WordList[i][3]);
            writer.write(infoWord);
            System.out.print(infoWord);
        }
        for (int i = 0; i < sizeLine; i++){
            for (int j = 0; j < sizeLine; j++){
                writer.write(" "+sopa[i][j]+"");
                System.out.print(" "+sopa[i][j]+"");
            }
            writer.write("\n");
            System.out.println();
        }
        writer.close();
    }
    catch (IOException e){
        System.out.println("Erro ao criar ficheiro");
    }
}
}
