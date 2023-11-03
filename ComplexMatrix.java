/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.complexmatrix;

/**
 *
 * @author Денис
 */
import java.util.Scanner;

class GenericMatrixOperations<T extends ComplexNumber> {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество строк матрицы: ");
        int n = scanner.nextInt();
        System.out.print("Введите количество столбцов матрицы: ");
        int m = scanner.nextInt();

        System.out.println("Введите элементы первой матрицы:");
        T[][] matrix1 = readComplexMatrix(n, m);

        System.out.println("Введите элементы второй матрицы:");
        T[][] matrix2 = readComplexMatrix(n, m);

        T[][] sumResult = addComplexMatrices(matrix1, matrix2);
        T[][] productResult = multiplyComplexMatrices(matrix1, matrix2);

        System.out.println("Результат сложения матриц:");
        printComplexMatrix(sumResult);

        System.out.println("Результат умножения матриц:");
        printComplexMatrix(productResult);
    }

    public static <T extends ComplexNumber> T[][] readComplexMatrix(int n, int m) {
        Scanner scanner = new Scanner(System.in);
        T[][] matrix = (T[][]) new ComplexNumber[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("Введите вещественную часть для элемента (" + (i + 1) + "," + (j + 1) + "): ");
                double real = scanner.nextDouble();
                System.out.print("Введите мнимую часть для элемента (" + (i + 1) + "," + (j + 1) + "): ");
                double imaginary = scanner.nextDouble();
                matrix[i][j] = (T) new ComplexNumber(real, imaginary);
            }
        }

        return matrix;
    }

    public static <T extends ComplexNumber> T[][] addComplexMatrices(T[][] matrix1, T[][] matrix2) {
        int n = matrix1.length;
        int m = matrix1[0].length;
        T[][] result = (T[][]) new ComplexNumber[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = (T) matrix1[i][j].add(matrix2[i][j]);
            }
        }

        return result;
    }

    public static <T extends ComplexNumber> T[][] multiplyComplexMatrices(T[][] matrix1, T[][] matrix2) {
        int n = matrix1.length;
        int m = matrix2[0].length;
        T[][] result = (T[][]) new ComplexNumber[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = (T) new ComplexNumber(0, 0);
                for (int k = 0; k < matrix1[0].length; k++) {
                    result[i][j] = (T) result[i][j].add(matrix1[i][k].multiply(matrix2[k][j]));
                }
            }
        }

        return result;
    }

    public static <T extends ComplexNumber> void printComplexMatrix(T[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(this.real + other.real, this.imaginary + other.imaginary);
    }

    public ComplexNumber multiply(ComplexNumber other) {
        double newReal = this.real * other.real - this.imaginary * other.imaginary;
        double newImaginary = this.real * other.imaginary + this.imaginary * other.real;
        return new ComplexNumber(newReal, newImaginary);
    }

    @Override
    public String toString() {
        return real + " + " + imaginary + "i";
    }
}

// Все данные для матрицы, точнее математическую базу, взял из книги под названием "Конспект лекций по высшей математике", в которой прописаны все свойства матриц и операции над ними. Пытался решить через generics, не получилось, честно сидел и решал эту задачу 2 часа, не получилось(( Решил использовать знания C++ и Java и решил через двумерные массивы. Хотелось бы на уроке узнать процесс решения!

