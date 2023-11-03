/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mycollection;

//**
 *
 * @author Денис

   import java.util.Arrays;

public abstract class MyCollection {
    public abstract void add(int element);
    public abstract void add(int index, int element);
    public abstract void clear();
    public abstract boolean contains(int element);
    public abstract int get(int index);
    public abstract int indexOf(int element);
    public abstract void insertElementAt(int element, int index);
    public abstract boolean isEmpty();
    public abstract void removeAt(int index);
    public abstract void remove(int element);
    public abstract void removeAll(int element);
    public abstract void reverse();
    public abstract void set(int index, int element);
    public abstract int size();
    public abstract void sort();
    public abstract int[] toArray();
    public abstract String toString();
}

public class MyVector extends MyCollection {
    private int[] vector;
    private int size;

    public MyVector() {
        vector = new int[10]; // Initial capacity
        size = 0;
    }

    public MyVector(int[] a) {
        vector = Arrays.copyOf(a, a.length);
        size = a.length;
    }

    @Override
    public void add(int element) {
        if (size == vector.length) {
            // If the vector is full, double its capacity
            int[] newVector = new int[size * 2];
            for (int i = 0; i < size; i++) {
                newVector[i] = vector[i];
            }
            vector = newVector;
        }
        vector[size] = element;
        size++;
    }

    @Override
    public void add(int index, int element) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index out of bounds");
        }
    @Override
    public void clear() {
        Arrays.fill(vector, 0, size, 0);
        size = 0;
    }

    @Override
    public boolean contains(int element) {
        return indexOf(element) != -1;
    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return vector[index];
    }

    @Override
    public int indexOf(int element) {
        for (int i = 0; i < size; i++) {
            if (vector[i] == element) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void insertElementAt(int element, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        add(index, element);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        for (int i = index; i < size - 1; i++) {
            vector[i] = vector[i + 1];
        }

        size--;
    }

    @Override
    public void remove(int element) {
        int index = indexOf(element);
        if (index != -1) {
            removeAt(index);
        }
    }

    @Override
    public void removeAll(int element) {
        int index;
        while ((index = indexOf(element)) != -1) {
            removeAt(index);
        }
    }

    @Override
    public void reverse() {
        int[] reversedVector = new int[size];
        for (int i = 0; i < size; i++) {
            reversedVector[size - 1 - i] = vector[i];
        }
        vector = reversedVector;
    }

    @Override
    public void set(int index, int element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        vector[index] = element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (vector[j] > vector[j + 1]) {
                    int temp = vector[j];
                    vector[j] = vector[j + 1];
                    vector[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public int[] toArray() {
        return Arrays.copyOf(vector, size);
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(vector[i]);
            sb.append(", ");
        }
        sb.append(vector[size - 1]);
        sb.append("]");
        return sb.toString();
    }
}
