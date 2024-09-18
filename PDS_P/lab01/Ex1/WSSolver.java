package lab01.Ex1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WSSolver {
    public static void main(String[] args) {
        Map<String, Map<Integer, Integer>> up = new HashMap<>();
        Map<String, Map<Integer, Integer>> down = new HashMap<>();
        Map<String, Map<Integer, Integer>> right = new HashMap<>();
        Map<String, Map<Integer, Integer>> left = new HashMap<>();
        Map<String, Map<Integer, Integer>> downright = new HashMap<>();
        Map<String, Map<Integer, Integer>> downleft = new HashMap<>();
        Map<String, Map<Integer, Integer>> upright = new HashMap<>();
        Map<String, Map<Integer, Integer>> upleft = new HashMap<>();
        List<String> puzzle = new ArrayList<>();
        ArrayList<String> listaPalavras = new ArrayList<>();

        final int max = 40;
        char[][] sopa = new char[max][max];

        try (Scanner sc = new Scanner(new File(args[0]))) {
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                if (linha.length() <= max && upper(linha)) {
                    puzzle.add(linha); // adicionar cada linha do ficheiro à lista puzzle
                } else if (!upper(linha)) {
                    String[] linhaComPalavras = linha.split(";|\\,|\\ ");
                    for (int i = 0; i < linhaComPalavras.length; i++) {
                        listaPalavras.add(linhaComPalavras[i]); // adicionar à listaPalavras as palavras a encontrar
                    }
                }
            }
            if (!checkSquare(puzzle)) { // verificar se o puzzle é quadrado
                System.err.println("ERRO:Puzzle with a ilegal size, should be in maximum 40x40");
                System.exit(1);
            }

            if(findDuplicates(listaPalavras)) {
                System.err.println("ERRO: Palavras duplicadas encontradas");
                System.exit(1);
            }
    
            sc.close();
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }

        for (int i = 0; i < puzzle.size(); i++) { // preencher array bidimencional, cada [][] = uma letra de puzzle
            sopa[i] = puzzle.get(i).toCharArray();
        }

        solverFunction(sopa, listaPalavras, up, down, left, right, downright, downleft, upright, upleft );


    }

    public static void solverFunction(char[][] sopaLetras, List<String> listaPalavras,Map<String, Map<Integer, Integer>> up,Map<String, Map<Integer, Integer>> down, Map<String, Map<Integer, Integer>> right,  Map<String, Map<Integer, Integer>> left, Map<String, Map<Integer, Integer>> downright, Map<String, Map<Integer, Integer>> downleft, Map<String, Map<Integer, Integer>> upright, Map<String, Map<Integer, Integer>> upleft) {
        for (String palavra : listaPalavras) {// percorrer todas as palavras da listaPlavras
            char primeiraLetra = palavra.toUpperCase().charAt(0);
            for (int linha = 0; linha < sopaLetras.length; linha++) {
                for (int coluna = 0; coluna < sopaLetras[linha].length; coluna++) { // percorrer todas as letras da sopaLetras
                    if (primeiraLetra == sopaLetras[linha][coluna]) { // se a primeira letra == a letra da sopa, testamos as 8 possibilidades de direção à sua volta
                        if (checkDirections(sopaLetras, palavra.toUpperCase(), linha, coluna, 0, 1)) {
                            if (!right.containsKey(palavra)) {
                                right.put(palavra, new HashMap<>());
                            }                            
                            right.get(palavra).put(linha+1,coluna+1);
                            System.out.printf("%-15s\t%3d\t%4d,%2d\t  %-10s\n", palavra, palavra.length(), linha + 1, coluna + 1, "Right");
                            continue; // os if todos tem o continue pq assim caso entrem num escusam de ir testar os de baixo
                        }
                        if (checkDirections(sopaLetras, palavra.toUpperCase(), linha, coluna, 0, -1)) {
                            if (!left.containsKey(palavra)) {
                                left.put(palavra, new HashMap<>());
                            }                                
                            left.get(palavra).put(linha+1, coluna+1);
                            System.out.printf("%-15s\t%3d\t%4d,%2d\t  %-10s\n", palavra, palavra.length(), linha + 1, coluna + 1, "Left");
                            continue;
                        }
                        if (checkDirections(sopaLetras, palavra.toUpperCase(), linha, coluna, 1, 0)) {
                            if (!down.containsKey(palavra)) {
                                down.put(palavra, new HashMap<>());
                            }                                
                            down.get(palavra).put(linha+1, coluna+1);
                            System.out.printf("%-15s\t%3d\t%4d,%2d\t  %-10s\n", palavra, palavra.length(), linha + 1, coluna + 1, "Down");
                            continue;
                        }
                        if (checkDirections(sopaLetras, palavra.toUpperCase(), linha, coluna, -1, 0)) {
                            if (!up.containsKey(palavra)) {
                                up.put(palavra, new HashMap<>());
                            }                                
                            up.get(palavra).put(linha+1, coluna+1);
                            System.out.printf("%-15s\t%3d\t%4d,%2d\t  %-10s\n", palavra, palavra.length(), linha + 1, coluna + 1, "Up");
                            continue;
                        }
                        if (checkDirections(sopaLetras, palavra.toUpperCase(), linha, coluna, 1, 1)) {
                            if (!downright.containsKey(palavra)) {
                                downright.put(palavra, new HashMap<>());
                            }                                
                            downright.get(palavra).put(linha+1, coluna+1);
                            System.out.printf("%-15s\t%3d\t%4d,%2d\t  %-10s\n", palavra, palavra.length(), linha + 1, coluna + 1, "DownRight");
                            continue;
                        }
                        if (checkDirections(sopaLetras, palavra.toUpperCase(), linha, coluna, 1, -1)) {
                            if (!downleft.containsKey(palavra)) {
                                downleft.put(palavra, new HashMap<>());
                            }                                
                            downleft.get(palavra).put(linha+1, coluna+1);
                            System.out.printf("%-15s\t%3d\t%4d,%2d\t  %-10s\n", palavra, palavra.length(), linha + 1, coluna + 1, "DownLeft");
                            continue;
                        }
                        if (checkDirections(sopaLetras, palavra.toUpperCase(), linha, coluna, -1, 1)) {
                            if (!upright.containsKey(palavra)) {
                                upright.put(palavra, new HashMap<>());
                            }                                
                            upright.get(palavra).put(linha+1, coluna+1);
                            System.out.printf("%-15s\t%3d\t%4d,%2d\t  %-10s\n", palavra, palavra.length(), linha + 1, coluna + 1, "UpRight");
                            continue;
                        }
                        if (checkDirections(sopaLetras, palavra.toUpperCase(), linha, coluna, -1, -1)) {
                            if (!upleft.containsKey(palavra)) {
                                upleft.put(palavra, new HashMap<>());
                            }                                
                            upleft.get(palavra).put(linha+1, coluna+1);
                            System.out.printf("%-15s\t%3d\t%4d,%2d\t  %-10s\n", palavra, palavra.length(), linha + 1, coluna + 1, "UpLeft");
                            continue;
                        }
                    }
                }
            }
        }
        
        System.out.print("\n");

        //fazer print da sopa de letras
        char [][] printsopa=new char[sopaLetras[0].length][sopaLetras[0].length];
        
        // a tabela toda vai ficar com "."
        for (int i = 0; i < printsopa.length; i++) {
            Arrays.fill(printsopa[i], '.');
        }

        for (Map.Entry<String, Map<Integer, Integer>> entry_up : up.entrySet()) {
            String key = entry_up.getKey();
            Map<Integer, Integer> mapa_interno_h = entry_up.getValue();
            Integer linha=0;
            Integer coluna=0;

            for (Map.Entry<Integer, Integer> valores_internos_up: mapa_interno_h.entrySet()) {
                linha = valores_internos_up.getKey()-1;
                coluna = valores_internos_up.getValue()-1;
            }

            for(int i=0; i<key.length(); i++) {
                printsopa[linha][coluna]=key.toUpperCase().charAt(i);
                linha--;   
            }
        }

        for (Map.Entry<String, Map<Integer, Integer>> entry_down : down.entrySet()) {
            String key = entry_down.getKey();
            Map<Integer, Integer> mapa_interno_h = entry_down.getValue();
            Integer linha=0;
            Integer coluna=0;

            for (Map.Entry<Integer, Integer> valores_internos_up: mapa_interno_h.entrySet()) {
                linha = valores_internos_up.getKey()-1;
                coluna = valores_internos_up.getValue()-1;
            }

            for(int i=0; i<key.length(); i++) {
                printsopa[linha][coluna]=key.toUpperCase().charAt(i);
                linha++;   
            }
        }

        for (Map.Entry<String, Map<Integer, Integer>> entry_right : right.entrySet()) {
            String key = entry_right.getKey();
            Map<Integer, Integer> mapa_interno_h = entry_right.getValue();
            Integer linha=0;
            Integer coluna=0;

            for (Map.Entry<Integer, Integer> valores_internos_up: mapa_interno_h.entrySet()) {
                linha = valores_internos_up.getKey()-1;
                coluna = valores_internos_up.getValue()-1;
            }

            for(int i=0; i<key.length(); i++) {
                printsopa[linha][coluna]=key.toUpperCase().charAt(i);
                coluna++;   
            }
        }

        for (Map.Entry<String, Map<Integer, Integer>> entry_left : left.entrySet()) {
            String key = entry_left.getKey();
            Map<Integer, Integer> mapa_interno_h = entry_left.getValue();
            Integer linha=0;
            Integer coluna=0;

            for (Map.Entry<Integer, Integer> valores_internos_up: mapa_interno_h.entrySet()) {
                linha = valores_internos_up.getKey()-1;
                coluna = valores_internos_up.getValue()-1;
            }

            for(int i=0; i<key.length(); i++) {
                printsopa[linha][coluna]=key.toUpperCase().charAt(i);
                coluna--;   
            }
        }

        for (Map.Entry<String, Map<Integer, Integer>> entry_downright : downright.entrySet()) {
            String key = entry_downright.getKey();
            Map<Integer, Integer> mapa_interno_h = entry_downright.getValue();
            Integer linha=0;
            Integer coluna=0;

            for (Map.Entry<Integer, Integer> valores_internos_up: mapa_interno_h.entrySet()) {
                linha = valores_internos_up.getKey()-1;
                coluna = valores_internos_up.getValue()-1;
            }

            for(int i=0; i<key.length(); i++) {
                printsopa[linha][coluna]=key.toUpperCase().charAt(i);
                linha++;
                coluna++;  
            }
        }

        for (Map.Entry<String, Map<Integer, Integer>> entry_downleft : downleft.entrySet()) {
            String key = entry_downleft.getKey();
            Map<Integer, Integer> mapa_interno_h = entry_downleft.getValue();
            Integer linha=0;
            Integer coluna=0;

            for (Map.Entry<Integer, Integer> valores_internos_up: mapa_interno_h.entrySet()) {
                linha = valores_internos_up.getKey()-1;
                coluna = valores_internos_up.getValue()-1;
            }

            for(int i=0; i<key.length(); i++) {
                printsopa[linha][coluna]=key.toUpperCase().charAt(i);
                linha++;
                coluna--;  
            }
        }

        for (Map.Entry<String, Map<Integer, Integer>> entry_upright : upright.entrySet()) {
            String key = entry_upright.getKey();
            Map<Integer, Integer> mapa_interno_h = entry_upright.getValue();
            Integer linha=0;
            Integer coluna=0;

            for (Map.Entry<Integer, Integer> valores_internos_up: mapa_interno_h.entrySet()) {
                linha = valores_internos_up.getKey()-1;
                coluna = valores_internos_up.getValue()-1;
            }

            for(int i=0; i<key.length(); i++) {
                printsopa[linha][coluna]=key.toUpperCase().charAt(i);
                linha--;
                coluna++;  
            }
        }

        for (Map.Entry<String, Map<Integer, Integer>> entry_upleft : upleft.entrySet()) {
            String key = entry_upleft.getKey();
            Map<Integer, Integer> mapa_interno_h = entry_upleft.getValue();
            Integer linha=0;
            Integer coluna=0;

            for (Map.Entry<Integer, Integer> valores_internos_up: mapa_interno_h.entrySet()) {
                linha = valores_internos_up.getKey()-1;
                coluna = valores_internos_up.getValue()-1;
            }

            for(int i=0; i<key.length(); i++) {
                
                printsopa[linha][coluna]=key.toUpperCase().charAt(i);
                linha--;
                coluna--;  
            }
        }

        for (int i = 0; i < printsopa.length; i++) {
            for (int j = 0; j < printsopa[i].length; j++) {
                System.out.print(printsopa[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean checkDirections(char[][] sopa, String palavra, int linha, int coluna, int linhaIncremnto,
            int colunaIncremento) {
        for (int i = 0; i < palavra.length(); i++) {
            // condicoes para que não seja a direcao certo: sair fora do "puzzle" ou a letra
            // na sopa nao ser a mesma da palavra
            if (linha < 0 || coluna < 0 || linha >= sopa.length || coluna >= sopa[linha].length || sopa[linha][coluna] != palavra.charAt(i)) {
                return false;
            }
            linha += linhaIncremnto;
            coluna += colunaIncremento;
        }
        return true;
    }

    public static boolean upper(String palavra) { // verifica se as letras estão em maisculo
        for (int i = 0; i < palavra.length(); i++) {
            if (!Character.isUpperCase(palavra.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkSquare(List<String> array) { // verifica se o puzzle é quadrado
        if (array.get(0).length() != array.size()) {
            return false;
        }
        return true;
    }

    public static boolean findDuplicates(List<String> words) {
        for (int k = 0; k < words.size(); k++) {
            for (int j = k + 1; j < words.size(); j++) {
                if (words.get(k).contains(words.get(j)) || words.get(j).contains(words.get(k))) {
                    return true;
                }
            }
        }
        return false;
    } 
}
