package lab10.Ex3_Command;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        List<String> testList = new ArrayList<>();

        CommandAdd<String> add = new CommandAdd<String>(testList);
        CommandRemove<String> remove = new CommandRemove<String>(testList);

        add.execute("Primeiro");
        add.execute("Segundo");
        add.execute("Terceiro");
        add.execute("Quarto");
        add.execute("Quinto");
        add.execute("Sexto");

        System.out.println("After execute adds: " + testList);

        add.undo();
        add.undo();
        add.undo();

        System.out.println("After execute 3 undos: " + testList);

        remove.execute("Primeiro");
        remove.execute("Segundo");

        System.out.println("After execute Primeiro and Segundo removes: " + testList);

        remove.undo();
        remove.undo();

        System.out.println("After execute 2 undos: " + testList);

        List<Integer> integerList = new ArrayList<>();

        CommandAdd<Integer> addInteger = new CommandAdd<Integer>(integerList);
        CommandRemove<Integer> removeInteger = new CommandRemove<Integer>(integerList);

        addInteger.execute(1);
        addInteger.execute(2);
        addInteger.execute(3);
        addInteger.execute(4);
        addInteger.execute(5);
        addInteger.execute(6);

        System.out.println("After execute adds: " + integerList);

        addInteger.undo();
        addInteger.undo();
        addInteger.undo();

        System.out.println("After execute 3 undo: " + integerList);

        removeInteger.execute(1);
        removeInteger.execute(2);

        System.out.println("After execute 1 and 2 removes: " + integerList);

        removeInteger.undo();

        System.out.println("After execute 1 undo: " + integerList);

        SortedSet<String> sortedSet = new TreeSet<String>();

        CommandAdd<String> addsorted = new CommandAdd<String>(sortedSet);
        CommandRemove<String> removesorted = new CommandRemove<String>(sortedSet);

        addsorted.execute("D");
        addsorted.execute("F");
        addsorted.execute("C");
        addsorted.execute("E");
        addsorted.execute("B");
        addsorted.execute("A");

        System.out.println("After execute adds: " + sortedSet);

        addsorted.undo();
        addsorted.undo();
        addsorted.undo();

        System.out.println("After execute 3 undo: " + sortedSet);

        removesorted.execute("D");
        removesorted.execute("F");

        System.out.println("After execute D and F removes: " + sortedSet);

        removesorted.undo();
        removesorted.undo();

        System.out.println("After execute 2 undos: " + sortedSet);

        System.out.println();
    }
}
