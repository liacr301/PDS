package lab10.Ex1_Iterator;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class VectorGeneric<T> {
    private T[] vec;
    private int nElem;
    private final static int ALLOC = 50;
    private int dimVec = ALLOC;

    @SuppressWarnings("unchecked")
    public VectorGeneric() {
        vec = (T[]) new Object[dimVec];
        nElem = 0;
    }

    public boolean addElem(T elem) {
        if (elem == null)
            return false;
        ensureSpace();
        vec[nElem++] = elem;
        return true;
    }

    private void ensureSpace() {
        if (nElem >= dimVec) {
            dimVec += ALLOC;
            @SuppressWarnings("unchecked")
            T[] newArray = (T[]) new Object[dimVec];
            System.arraycopy(vec, 0, newArray, 0, nElem);
            vec = newArray;
        }
    }

    public boolean removeElem(T elem) {
        for (int i = 0; i < nElem; i++) {
            if (vec[i].equals(elem)) {
                if (nElem - i - 1 > 0) // not last element
                    System.arraycopy(vec, i + 1, vec, i, nElem - i - 1);
                vec[--nElem] = null; // libertar último objecto para o GC
                return true;
            }
        }
        return false;
    }

    public int totalElem() {
        return nElem;
    }

    public T getElem(int i) {
        return (T) vec[i];
    }

    public Iterator<T> iterator() {
        return new VectorIterator<>(this);
    }

    public ListIterator<T> listIterator() {
        return new VectorListIterator<>(this);
    }

    public ListIterator<T> listIterator(int index) {
        return new VectorListIterator<>(this, index);
    }

    private static class VectorListIterator<T> implements ListIterator<T> {
        private int indice;
        private final VectorGeneric<T> vector;

        public VectorListIterator(VectorGeneric<T> vector) {
            this.vector = vector;
            this.indice = 0;
        }

        public VectorListIterator(VectorGeneric<T> vector, int index) {
            if (index < 0 || index > vector.nElem)
                throw new IndexOutOfBoundsException("Index: " + index);
            this.vector = vector;
            this.indice = index;
        }

        public boolean hasNext() {
            return (indice < vector.nElem);
        }

        public boolean hasPrevious() {
            return (indice >= 0);
        }

        public T next() {
            if (hasNext())
                return (T) vector.vec[indice++];
            throw new IndexOutOfBoundsException("only " + vector.nElem + " elements");
        }

        public void remove() {
            throw new UnsupportedOperationException("Operação não suportada!");
        }

        public T previous() {
            if (indice >= 0)
                return (T) vector.vec[indice--];
            throw new NoSuchElementException("only " + vector.nElem + " elements");
        }

        public int nextIndex() {
            if (hasNext())
                return indice++;
            else
                return vector.nElem;
        }

        public int previousIndex() {
            if (hasPrevious())
                return indice--;
            else
                return -1;
        }

        @Override
        public void set(T e) {
            throw new UnsupportedOperationException("Operacao nao suportada!");
        }

        @Override
        public void add(T e) {
            throw new UnsupportedOperationException("Operacao nao suportada!");
        }
    }

    private static class VectorIterator<T> implements Iterator<T> {
        private int currentIndex;
        private final VectorGeneric<T> vector;

        public VectorIterator(VectorGeneric<T> vector) {
            this.vector = vector;
            this.currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < vector.totalElem();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }
            return vector.getElem(currentIndex++);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Operation not supported");
        }
    }
}
