package by.it.protsko.jd01_11;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class SetC<T> implements Set<T> {

    private T[] collectionElements = (T[]) new Object[10];
    private int size = 0;


    @Override                     ///////////////////////////////////////////////////////////
    public boolean add(T element) {
        if (!contains(element)) {
            if (collectionElements.length <= size) {
                collectionElements = Arrays.copyOf(collectionElements, collectionElements.length * 3 / 2 + 1);
            }
            collectionElements[size++] = element;
            return true;
        }
        return false;
    }

    @Override                     ///////////////////////////////////////////////////////////
    public boolean remove(Object o) {
        boolean isRemove = false;
        for (int index = 0; index < size; index++) {
            if (o.equals(collectionElements[index])) {
                System.arraycopy(collectionElements, index + 1, collectionElements, index, (--size - index));
                isRemove = true;
                break;
            }
        }
        return isRemove;
    }

    @Override                     ///////////////////////////////////////////////////////////
    public boolean contains(Object o) {
        boolean isContains = false;
        if (size > 0 && o != null) {
            for (int index = 0; index < size; index++) {
                if (o.equals(collectionElements[index])) {
                    isContains = true;
                    break;
                }
            }
        }
        return isContains;
    }

    @Override                     ///////////////////////////////////////////////////////////
    public int size() {
        return size;
    }

    @Override                     ///////////////////////////////////////////////////////////
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override                     ///////////////////////////////////////////////////////////TODO
    public boolean addAll(Collection<? extends T> c) {
        boolean isAllAdd = false;
        Object[] collectionToArray = c.toArray();
        for (int i = 0; i < collectionToArray.length; i++) {
            if (!contains(collectionToArray[i])) {
                add((T) collectionToArray[i]);
                isAllAdd = true;
            }
        }
        return isAllAdd;
    }

    @Override                     ///////////////////////////////////////////////////////////TODO
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override                     ///////////////////////////////////////////////////////////TODO
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override                     ///////////////////////////////////////////////////////////
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                sb.append(collectionElements[i]);
            } else {
                sb.append(", ").append(collectionElements[i]);
            }
        }
        sb.append("]");
        return sb.toString();
    }


    //Stubs

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
