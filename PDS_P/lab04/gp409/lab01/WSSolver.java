package lab01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Character.*;
// fazer trim nas linhas
// args[0] para ter o nome do ficheiro

public class WSSolver {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> lines= new ArrayList<String>();
        ArrayList<String> words= new ArrayList<String>();

        File data= new File(args[0]);
        Scanner reader = new Scanner(data);

        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            if (IsUpper(line)) {
                lines.add(line);
            } else {
                String[] result = line.split("[;,\\s]", 0);
                for (String sub : result) {
                    words.add(sub);
                }
            }
        }
        reader.close();

        Soup dispersedSoup= new Soup(lines);
        ArrayList<Word> FindInSoup = new ArrayList<>();

        for(int i=0; i< words.size(); i++){
            Word find= new Word(words.get(i));
            FindInSoup.add(find);
        }
        //verificar a existencia de subpalavras na sopa
        for(Word subword: FindInSoup){
            IsSubword(subword, FindInSoup);
        }

        //encontrar as palavras na sopa de letras
        dispersedSoup.FindWords(FindInSoup);
        String result = dispersedSoup.printSoup();

        System.out.printf("%s",result);


    }

    public static boolean IsUpper(String line){
        for(int i=0; i < line.length(); i++){
            Character c= line.charAt(i);
            if(isLetter(c) && !isUpperCase(c)){
                return false;
            }
        }
        return true;
    }
     public static void IsSubword(Word subword, ArrayList<Word> words) {
         for (Word word : words) {
             if(word.getSize()>subword.getSize()){
                 if(word.getWord().contains(subword.getWord())){
                     subword.removeCount();
                 }
             }
         }
     }


}
