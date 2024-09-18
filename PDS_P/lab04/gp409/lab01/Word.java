package lab01;

import java.util.Arrays;

public class Word {

    private int size;
    private String content;
    private SIDE orientation;
    //verifica se a palavra ja foi encontrada na sopa de letras
    private int count = -1;
    //coordenadas da palavra na sopa de letras
    private int[] coordinates;

    public Word(String word) {
        this.size = word.length();
        this.content = word;
    }

    public SIDE getOrientation() {
        return this.orientation;
    }

    public void setOrientation(SIDE orientation) {
        this.orientation = orientation;
    }

    public int getSize() {
        return this.size;
    }

    public String getWord() {
        return this.content;
    }

    public int[] getCoordinates() {
        return this.coordinates;
    }

    public void setCoordinates(int x, int y ) {
        this.coordinates = new int[]{x, y};
    }
    public void addCount() {
        this.count++;
    }
    public void removeCount() {
        this.count--;
    }

    public int getCount() {
        return count;
    }

    public String toUpperCase() {
            return this.content.toUpperCase();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String coordinates = Arrays.toString(this.getCoordinates());
        String line = String.format("%-20s %-2d  %-10s  %-3s " , this.getWord(), this.getSize(),coordinates ,this.getOrientation().toString());
        sb.append(line);
        sb.append("\n");
        return sb.toString();
    }
}