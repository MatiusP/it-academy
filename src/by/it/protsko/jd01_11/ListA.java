package by.it.protsko.jd01_11;

import java.util.*;

public class ListA<T> implements List<T> {

    private T[] elementsArray = (T[]) new Object[1];
    private int size = 0;

    @Override
    public boolean add(T element) {
        if (elementsArray.length <= size) {
            elementsArray = Arrays.copyOf(elementsArray, elementsArray.length * 3 / 2 + 1);
        }
        elementsArray[size++] = element;
        return true;
    }

    @Override
    public T remove(int index) {
        T removeElement = elementsArray[index];
        System.arraycopy(elementsArray, index + 1, elementsArray, index, (--size - index));
        return removeElement;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public T get(int index) {
        return elementsArray[index];
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                sb.append(elementsArray[i]);
            } else {
                sb.append(", ").append(elementsArray[i]);
            }
        }
        sb.append("]");
        return sb.toString();
    }


    //Stubs

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

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
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
