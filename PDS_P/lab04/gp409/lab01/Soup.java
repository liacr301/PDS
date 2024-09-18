package lab01;

import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Soup {
    private final int MAX = 40;
    private final String regex = "[A-Z]";
    private int height;
    private int width;
    public ArrayList<Word> wordsFound = new ArrayList<>();
    private ArrayList<ArrayList<Character>> letters = new ArrayList<>();

    // constructor
    public Soup(ArrayList<String> soupChars) {
        this.height = soupChars.size();
        assert(isValidSoup(soupChars));
        this.width = this.height;
        for (String line : soupChars) {
            ArrayList<Character> lineChars = new ArrayList<Character>();
            for (int i = 0; i < line.length(); i++) {

                lineChars.add(line.charAt(i));
            }
            this.letters.add(lineChars);
        }
    }

    public boolean isValidSoup(ArrayList<String> soupChars) {
        if (soupChars.size() > MAX) {
            return false;
        }
        for (String line : soupChars) {
            if (line.length() > MAX) {
                return false;
            }
            if (line.length() != this.height) {
                return false;
            }
        }
        return true;
    }

    // word found
    public void FindWords(ArrayList<Word> dic) {
        //find each word of the dictionary
            for (int i = 0; i < this.height; i++) {
                for (int j = 0; j < this.width; j++) {
                    for (Word w : dic) {
                        Character firstLetter = w.toUpperCase().charAt(0);
                        int wordSize = w.getSize();
                        Character SoupLetter = this.getLetter(j, i);
                        if (SoupLetter == firstLetter) {
                            for (SIDE orient : SIDE.values()) {
                                boolean found = true;
                                //coordinates of the first letter of the word
                                int x = j;
                                int y = i;
                                if (this.isValidPosition(x,y, orient, w)) {

                                    for (int k = 0; k < wordSize ; k++) {

                                        Character letter = this.getLetter(x, y);
                                        if (letter != w.toUpperCase().charAt(k)) {
                                            found = false;
                                            break;
                                        }
                                        int[] nextPos= getNextPosition(x, y, orient);
                                        x = nextPos[0];
                                        y = nextPos[1];

                                    }
                                    if (found) {
                                        //contar a palavra
                                        w.addCount();
                                        w.setOrientation(orient);
                                        w.setCoordinates(j,i);
                                        this.wordsFound.add(w);
                                        break;
                                    }


                                }
                            }
                        }
                        //word has been found, and it doesn't need to be checked again for other position in the soup

                    }
                }
            }


    }

    public Character getLetter(int x, int y) {
        assert (x < this.height && y < this.width && x >= 0 && y >= 0);
        return this.letters.get(y).get(x);
    }

    public int[] getNextPosition(int x, int y, SIDE orientation) {
        assert (y < this.height && x < this.width && x >= 0 && y >= 0);
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
    public boolean isValidPosition(int x, int y, SIDE orientation, Word w) {
        switch (orientation) {
            case L:
                return x - (w.getSize()-1) >= 0;
            case R:
                return x + (w.getSize()-1) < this.width;
            case T:
                return y - (w.getSize()-1) >= 0;
            case B:
                return y + (w.getSize()-1) < this.height;
            case TL:
                return x - (w.getSize()-1) >= 0 && y - (w.getSize()-1) >= 0;
            case TR:
                return x + (w.getSize()-1) < this.width && y - (w.getSize()-1) >= 0;
            case BL:
                return x - (w.getSize()-1) >= 0 && y + (w.getSize()-1) < this.height;
            case BR:
                return x + (w.getSize()-1) < this.width && y + (w.getSize()-1) < this.height;
            default:
                return false;
        }
    }

    public String printSoup() {
        StringBuilder sb = new StringBuilder();
        ArrayList<ArrayList<Character>> newSoup = new ArrayList<>();
        //preenchimento do arraylist com pontos
        for (int i = 0; i < this.height; i++) {
            ArrayList<Character> line = new ArrayList<>();
            for (int j = 0; j < this.width; j++) {
                line.add('.');
            }
            newSoup.add(line);
        }
        for(Word word : this.wordsFound)
        {
            int x = word.getCoordinates()[0];
            int y = word.getCoordinates()[1];
            int size = word.getSize();
            SIDE orient = word.getOrientation();
            for (int i = 0; i < size; i++) {
                int[] nextPos= getNextPosition(x, y, orient);
                newSoup.get(y).set(x, word.getWord().toUpperCase().charAt(i));

                x = nextPos[0];
                y = nextPos[1];
            }
            sb.append(word.toString());
        }
        sb.append("\n");
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                sb.append(newSoup.get(i).get(j));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}