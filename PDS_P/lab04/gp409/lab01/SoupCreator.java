package lab01;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import lab01.SoupCreator;


public class SoupCreator {

    private final int MAX = 40;
    private int height;
    private int width;
    private ArrayList<ArrayList<Character>> Soup;

    public SoupCreator(int height) {
        if(height<=this.MAX){
            ArrayList<ArrayList<Character>> soup= new ArrayList<ArrayList<Character>>();
            this.height=height;
            this.width=height;
            for(int y=0; y<height;y++){
                ArrayList<Character> line= new ArrayList<Character>();
                for(int x=0; x<width;x++){
                    line.add('0');
                }
                soup.add(line);
            }          
            this.Soup=soup; 
        }
        else{
            System.out.println("Invalid Size\n");
        }
    }

  
    public void InsertWords(ArrayList<String> words) {
        int x, tempX = 0;
        int y, tempY = 0;
        SIDE orientation = SIDE.R;

        for (String word : words) {
            word=word.toUpperCase();
            int count=0;
            boolean put=false;
            while(!put){
                if( count > 500){
                    System.out.printf("ERROR: Failed at inserting %s \n",word);
                    System.exit(1);
                }
                count++;
                orientation=SIDE.values()[(int) (Math.random()*7)];
                x = (int) (Math.random() * (this.width-1));
                y = (int) (Math.random() * (this.height-1));
                tempY=y;
                tempX=x;
                boolean canInsert=true;
                if(isValidPosition(x, y, orientation, word)){
                    Character SoupLetter= this.getLetter(tempX, tempY);
                    for(int letter=0; letter<word.length();letter++){
                        if(!checkLetter(SoupLetter, word.charAt(letter))){
                            canInsert=false;
                            break;
                        }
                        if(letter!=word.length()-1){
                            int[] nextPos= getNextPosition(tempX, tempY, orientation);
                            tempX=nextPos[0];
                            tempY=nextPos[1];
                            SoupLetter= this.getLetter(tempX, tempY);
                        }
                    }

                } else{ canInsert=false;}
                if(canInsert){
                    for(int letter=0; letter<word.length();letter++){
                        setLetter(x,y, word.charAt(letter));
                        if(letter!=word.length()-1){
                            int[] nextPos= getNextPosition(x, y, orientation);
                            x=nextPos[0];
                            y=nextPos[1];
                        }
                    }
                    put=true;
                }
            }

            
        }
    }

    public void fillBlanks(){
        char[] Letters="ABCDEFGHIJKLMNOPRSTUVXZ".toCharArray();
        for(int y=0; y<height;y++){
            for(int x=0; x<width; x++){
                if(getLetter(x, y).equals('0')){
                    setLetter(x, y, getRandomLetter(Letters));
                }
            }
        }
    }


    public void WriteInFile(String FileName, ArrayList<String> Words){
        try{
            File write = new File(FileName);
            FileWriter writer = new FileWriter(FileName);
            write.createNewFile();
            System.out.println("File created: " + write.getName());
            
            for (ArrayList<Character> line : Soup) {
                for (Character character : line) {
                    writer.write(character);
                }
                writer.write("\n");
            }
            for (String string : Words) {
                writer.write(string+"\n");
            }
            writer.close();

        }
        catch(IOException e){
            System.out.println("Error creating file");
        }
    }

    public void printf(ArrayList<String> Words){
        for (ArrayList<Character> line : Soup) {
            for (Character character : line) {
                System.out.printf("%s", character);
            }
            System.out.printf("\n");
        }
        for (String string : Words) {
            System.out.println(string);
        }
    }


    public int[] getNextPosition(int x, int y, SIDE orientation) {
        assert (x < this.height && y < this.width && x >= 0 && y >= 0);
        int[] pos= new int[2];
        try {
            switch (orientation) {
                case L:
                    pos[0]=x-1; pos[1]=y;   
                    return pos;
                case R:
                    pos[0]=x+1; pos[1]=y;  
                    return pos;
                case T:
                    pos[0]=x; pos[1]=y-1;   
                    return pos;
                case B:
                    pos[0]=x; pos[1]=y+1;  
                    return pos;
                case TL:
                    pos[0]=x-1; pos[1]=y-1;  
                    return pos;
                case TR:
                    pos[0]=x+1; pos[1]=y-1;  
                    return pos;
                case BL:
                    pos[0]=x-1; pos[1]=y+1;  
                    return pos;
                case BR:
                    pos[0]=x+1; pos[1]=y+1;  
                    return pos;
                default:
                    return null;
                
            }
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Out of bounds");
        }
 
    }

    public boolean isValidPosition(int x, int y, SIDE orientation, String Word) {
        switch (orientation) {
            case L:
                return x - Word.length() >= 0;
            case R:
                return x + Word.length() < this.width;
            case T:
                return y - Word.length() >= 0;
            case B:
                return y + Word.length() < this.height;
            case TL:
                return x - Word.length() >= 0 && y - Word.length() >= 0;
            case TR:
                return x + Word.length() < this.width && y - Word.length() >= 0;
            case BL:
                return x - Word.length() >= 0 && y + Word.length() < this.height;
            case BR:
                return x + Word.length() < this.width && y + Word.length() < this.height;
            default:
                return false;
        }
    }


    public boolean checkLetter(Character SoupLetter, Character letter){
        return ((SoupLetter.equals('0')) || SoupLetter.equals(letter));
    }
    
    public static Character getRandomLetter(char[] array) {
        int rand = new Random().nextInt(array.length);
        return array[rand];
    }


    public Character getLetter(int x, int y) {
        assert (x < this.height && y < this.width && x >= 0 && y >= 0);
        return this.Soup.get(y).get(x);
    }

    public void setLetter(int x, int y, Character letter) {
        assert (x < this.height && y < this.width && x >= 0 && y >= 0);
        ArrayList<Character> line= this.Soup.get(y);
        line.set(x, letter);
        this.Soup.set(y, line);
    }

   

}

