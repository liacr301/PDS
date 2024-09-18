package lab10.Ex3_Command;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CommandAdd<E> implements Command<E> {
    private Collection<E> collection;
    private List<E> list = new ArrayList<E>();

    public CommandAdd(Collection<E> collection){
        this.collection = collection;
    }

    @Override
    public boolean execute(E element) {
        if (collection.add(element)) {
            list.add(element);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void undo() {
        if (list != null) {
            collection.remove(list.get(list.size() - 1));
            list.remove(list.get(list.size() - 1));
        }
    }
}
