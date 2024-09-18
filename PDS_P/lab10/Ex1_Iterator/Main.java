package lab10.Ex1_Iterator;
import java.util.Iterator;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        VectorGeneric<String> vector = new VectorGeneric<>();

        vector.addElem("joao");
        vector.addElem("matilde");
        vector.addElem("hugo");
        vector.addElem("lia");
        vector.addElem("marta");
        vector.addElem("rui");
        vector.addElem("ana");
        vector.addElem("pedro");
        vector.addElem("maria");
        vector.addElem("carlos");

        System.out.println("Elementos usando Iterator:");
        Iterator<String> iterator = vector.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();

        System.out.println("Elementos a partir do índice 7 usando ListIterator:");
        ListIterator<String> listIterator = vector.listIterator(7);
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
        System.out.println();

        System.out.println("Removendo o elemento 'joao' do vetor");
        vector.removeElem("joao");
        System.out.println();

        System.out.println("Elementos usando Iterator após a remoção:");
        iterator = vector.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();

        System.out.println("Total de elementos no vetor após a remoção: " + vector.totalElem());

        System.out.println();

        System.out.println("Elemento no índice 2: " + vector.getElem(2));
    }
}
