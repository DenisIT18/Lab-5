/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arraylist;

/**
 *
 * @author Денис 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

 class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numericals = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Введите количество целых чисел: ");
        int N = scanner.nextInt();
        
        System.out.println("Введите " + N + " целых чисел:");
        for (int i = 0; i < N; i++) {
            int numerical = scanner.nextInt();
            numericals.add(numerical);
        }
        
        // Задание a буду писать комментарии для разделения работ и честности 
        Integer maxNumerical = max(numericals);
        System.out.println("Максимальный элемент: " + maxNumerical);
        
        // Задание b
        sort(numericals);
        System.out.println("Отсортированные числа: ");
        for (int num : numericals) {
            System.out.print(num + " ");
        }
        
        // Задание c
        shuffle(numericals);
        System.out.println("\nПеремешанные числа: ");
        for (int numerical : numericals) {
            System.out.print(numerical + " ");
        }
        
        // Задание d
        Integer[] arr = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30};
        Integer n = 15;
        int id = binarySearch(arr, n);
        System.out.println("\nПозиция элемента " + n + " в данном массиве: " + id);
    }

    public static <E extends Comparable<E>> E max(ArrayList<E> list) {
        if (list.isEmpty()) {
            return null;
        }

        E maxElement = list.get(0);

        for (E element : list) {
            if (element.compareTo(maxElement) > 0) {
                maxElement = element;
            }
        }

        return maxElement;
    }

    public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
        Collections.sort(list);
    }

    public static <E> void shuffle(ArrayList<E> list) {
        Collections.shuffle(list);
    }

    public static <E extends Comparable<E>> int binarySearch(E[] list, E key) {
        int low = 0;
        int high = list.length - 1;

        while (low <= high) {
            int middle = (low + high) / 2;
            int dif = key.compareTo(list[middle]);

            if (dif == 0) {
                return middle; 
            } else if (dif < 0) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        return -1; 
    }
}
