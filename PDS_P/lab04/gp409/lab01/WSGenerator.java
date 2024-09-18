package lab01;
import java.util.Scanner;
import java.io.File; 
import java.io.FileNotFoundException;
import java.util.ArrayList;


public class WSGenerator {
    public static void main(String[] args) {
        String RFile=null;
        String WFile=null;
        int size=0;
        int side=0;

        CheckArgsNumber(args.length);

        //Lê e analisa os argumentos passados, verificando as opções e guardando o argumento de cada
        for(int i=0; i<args.length-1; i++){
            switch(args[i]){
                case "-i":
                    RFile=args[i+1];
                    i++;
                    break;
                case "-s":
                    try{
                        side=Integer.parseInt(args[i+1]) ;
                        size=side * side;
                        i++;
                    }
                    catch(Error e){
                        ThrowError("Invalid Arguments");
                    }
                    break;
                case "-o":
                    WFile=args[i+1];
                    break;
                default:
                    ThrowError("Usage: java WSGenerator -i <FileWordList> -s <SoupSize> optional(-o <OutputFile>)");
                    break;
            }
        }
        ArrayList<String> WordsList= ReadFile(RFile,size);
        SoupCreator soup= new SoupCreator(side);
        if(soup!=null){
            soup.InsertWords(WordsList);
            soup.fillBlanks();
        } 
        if(WFile!=null){
            soup.WriteInFile(WFile, WordsList);
        }
        else{
            soup.printf(WordsList);
        }

    } 

    public static ArrayList<String> ReadFile(String RFile, int size){
        try{
            File read = new File(RFile);
            Scanner reader = new Scanner(read);
            ArrayList<String> words= new ArrayList<String>();
            while(reader.hasNextLine()){
                String line= reader.nextLine();
                String[] result= line.split("[;,\\s]",0);
                //Adiciona cada palavra da linha a uma lista
                for(String sub: result){
                    if(sub.length()>size){
                        ThrowError("Invalid Words");
                    }
                    words.add(sub);
                }
            }
            reader.close();
            return words;
            
        }
        catch(FileNotFoundException e){
            ThrowError("The file does not exist");
        }
        return null;
    }

    

    public static void CheckArgsNumber(int number){
        if(number>6 || number%2 !=0 || number<4){
            ThrowError("Usage: java WSGenerator -i <FileWordList> -s <SoupSize> optional(-o <OutputFile>)");
        }
    }

    public static void ThrowError(String err){
        System.err.printf("%s\n", err);
        System.exit(1);
    }
}