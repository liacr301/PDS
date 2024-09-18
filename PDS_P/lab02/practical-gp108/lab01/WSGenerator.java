import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class WSGenerator {
    static int size;
    static String inputFileName;
    static int numWords=0; 
    static String newFile;
    static boolean createFile=false;
    public static void main(String[] args) throws FileNotFoundException { 
        
        checkArgs(args);
        String[] wordsList = readFiles(inputFileName);
        String[] used_words = new String[numWords];
        char [][] sdl = new char[size][size];
        createSDL(wordsList,size,sdl,used_words);
        
        if (createFile){
            printAndSave(numWords,wordsList,size,sdl, newFile);
        }
        else{
            printSDL(numWords,wordsList,size,sdl);
        }

    }

    private static void checkArgs(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-i") && i + 1 < args.length) {
                inputFileName = args[i + 1];
                i++; 
            }
            else if (args[i].equals("-s") && i + 1 < args.length) {
                try {
                    size = Integer.parseInt(args[i + 1]);
                    if (size>40){
                        System.out.println("Erro: o tamanho deve ser um número inteiro menor ou igual a 40.");
                        return;
                    }
                    i++;
                } catch (NumberFormatException e) {
                    System.err.println("Erro: o tamanho deve ser um número inteiro.");
                    return;
                }
            }
            else if ( args[i].equals("-o" ) && i + 1 < args.length){
                newFile = args[i + 1];
                i++;
                createFile=true;
            }
        }
    }

    private static String[] readFiles(String filename) throws FileNotFoundException{
        
        File wordsFile = new File(filename);
        if (!wordsFile.exists()) {
            System.out.println("O arquivo " + filename + " nao existe.");
            System.exit(1);
        }
        
        Scanner sc = new Scanner(wordsFile);
        String line = sc.nextLine();

        String[] WordList = new String[1000];
        numWords = 0;
        boolean nextLine=true;
        while (nextLine){
            String words[] = line.split("[,;\\s]+");
            for (int i = 0; i < words.length; i++){
                if (words[i].length()>size){
                    System.out.println("Erro: a palavra " + words[i] + " não cabe na sopa de letras. O máximo são " + size + " letras.");
                    System.exit(1);
                }
                WordList[numWords] = words[i];
                if(WordList[numWords]!=null){
                    numWords++;
                }
            }
            if(!(sc.hasNextLine())){
                nextLine=false;
                break;
            }
            line=sc.nextLine();
        }
        sc.close();
        return WordList;
    }

    public static void createSDL(String[] words, int size, char[][] sop, String[] used_words){
        int wordsInserted=0;
        int tries=0;
        while (wordsInserted<numWords) {
            tries++;
            if (tries>size*size){
                wordsInserted=0;
                tries=0;
                for (int i=0;i<size;i++){
                    for (int j=0;j<size;j++){
                        sop[i][j]='\u0000';
                    }
                }
            }
            int x = generateRandomNumber(numWords);
            int y = generateRandomNumber(numWords);
            String ORI_position=Orient.randomOrientacao[generateRandomNumber(7)];
            String word=words[wordsInserted];
            if (valid_word(x, y, ORI_position, word, size, sop, used_words)){
                for (int i=0; i<word.length(); i++){
                    char letra = Character.toUpperCase(word.charAt(i));
                    switch (ORI_position) {
                        case "Horizontal":				
                            sop[x][y+i]=letra;
                            break;
                        case "Vertical":
                            sop[x+i][y]=letra;
                            break;
                        case "Diagonal Direita":
                            sop[x+i][y+i]=letra;
                            break;
                        case "Diagonal Esquerda":
                            sop[x+i][y-i]=letra;
                            break;
                        case "Horizontal invertido":				
                            sop[x][y-i]=letra;
                            break;
                        case "Vertical invertido":
                            sop[x-i][y]=letra;
                            break;
                        case "Diagonal Direita invertido":
                            sop[x-i][y+i]=letra;
                            break;
                        case "Diagonal Esquerda invertido":
                            sop[x-i][y-i]=letra;
                            break;
                        }			
                    }
                used_words[wordsInserted]=word;
                wordsInserted++;
            }
            
            }
            for (int x = 0; x < size; x++) {
                for (int y = 0; y < size; y++) {
                    char rndLetra = (char) ((int) (Math.random() * 26) + 'A');
                    if (letterPossible(x, y, size, rndLetra, sop)) {
                        sop[x][y] = rndLetra;
                    }
                }
            }
            
    }
    
    public static int generateRandomNumber(int size){
        Random generate=new Random();
        return generate.nextInt(size);
    }

    public static boolean valid_word(int x, int y, String orientacao, String word, int size, char[][] sop, String[] used_words) {
        if (x < 0 || y < 0 || x >= size || y >= size) {
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            char letra = word.charAt(i);
            switch (orientacao) {
                case "Horizontal":
                    if (!letterPossible(x, y + i, size, letra, sop)) {
                        return false;
                    }
                    break;
                case "Vertical":
                    if (!letterPossible(x + i, y, size, letra, sop)) {
                        return false;
                    }
                    break;
                case "Diagonal Direita":
                    if (!letterPossible(x+i, y + i, size, letra, sop)) {
                        return false;
                    }
                    break;
                case "Diagonal Esquerda":
                    if (!letterPossible(x+i, y - i, size, letra, sop)) {
                        return false;
                    }
                    break;
                case "Horizontal invertido":
                    if (!letterPossible(x, y - i, size, letra, sop)) {
                        return false;
                    }
                    break;
                case "Vertical invertido":
                    if (!letterPossible(x-i, y , size, letra, sop)) {
                        return false;
                    }
                    break;
                case "Diagonal Direita invertido":
                    if (!letterPossible(x-i, y + i, size, letra, sop)) {
                        return false;
                    }
                    break;
                case "Diagonal Esquerda invertido":
                    if (!letterPossible(x-i, y - i, size, letra, sop)) {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }
        return true;
    }
                
    public static boolean letterPossible( int x, int y,int size, char letra,char[][] sop) {
        if(x >= size || y >= size || x < 0 || y < 0) {
            return false;
        }
        if(sop[x][y] != '\u0000' && sop[x][y] != letra) {
			return false;
		}
        return true;
    }
                

    public static class Orient {
        public static final int HORIZONTAL = 0;
        public static final int VERTICAL = 1;
        public static final int DIAGONAL_ESQ = 2;
        public static final int DIAGONAL_DRC = 3;
        
        public static final int INV_HORIZONTAL = 4;
        public static final int INV_VERTICAL = 5;
        public static final int INV_DIAGONAL_ESQ = 6;
        public static final int INV_DIAGONAL_DRC = 7;
        
        public static final String[] randomOrientacao = 
            {
                "Horizontal",
                "Vertical",
                "Diagonal Esquerda",
                "Diagonal Direita",
                "Horizontal invertido",
                "Vertical invertido",
                "Diagonal Esquerda invertido",
                "Diagonal Direita invertido"
            };
    }

    private static void printSDL(int numWords, String WordList[], int size,char[][] sopa) {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(" " + Character.toUpperCase(sopa[i][j]));
            }
            System.out.println();
        }

        for (int i = 0; i < numWords; i++) {
            if (WordList[i] != null) {
                if (i == numWords - 1) {
                    String infoWord = WordList[i];
                    System.out.print(infoWord);
                } else {
                    if (i == numWords - 1) {
                        String infoWord = WordList[i];
                        System.out.print(infoWord);
                    } else {
                    String infoWord = WordList[i] + ", ";
                    System.out.print(infoWord);
                    }
                }
            }
        }
        System.out.println();

    }

    private static void printAndSave(int numWords, String WordList[], int size, char sopa[][], String newFile) {
        File file = new File(newFile);
        try {

            FileWriter writer = new FileWriter(file);

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    writer.write(Character.toUpperCase(sopa[i][j]));
                    System.out.print(Character.toUpperCase(sopa[i][j]));
                }
                writer.write("\n");
                System.out.println();
            }

            for (int i = 0; i < numWords; i++) {
                if (WordList[i] != null) {
                    if (i == numWords - 1) {
                        String infoWord = WordList[i];
                        writer.write(infoWord);
                        System.out.print(infoWord);
                    } else {
                        String infoWord = WordList[i] + ", ";
                        writer.write(infoWord);
                        System.out.print(infoWord);
                    }
                }
            }

            System.out.println();
            writer.write("\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Erro ao criar ficheiro");
        }
    }
}