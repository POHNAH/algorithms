//Данный класс создан для тестирования различных алгоритмов сортировки
//Сортировать будем числовые массивы
//Задача в том что бы обновить в памяти основные алгоритмы
//А так же создать публичный проект на гитхабе для демонстрации своих навыков потенциальным работодателям

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestSort {
    public static List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) {
        getArray(numbers,20);
        printArray(numbers);
        Date d1 = new Date();
        quickSort(numbers,0,numbers.size() - 1);
        Date d2 = new Date();
        System.out.println(d2.getTime() - d1.getTime());
        printArray(numbers);

    }

//  Метод заполняет наш массив новым набором числе
    public static void getArray(List<Integer> array, int arraySize) {
        array.clear();
        for (int i = 0; i < arraySize; i++) {
            array.add((int) (Math.random() * 100));
        }
    }

//  Метод выводит на экран содержание массива
    private static void printArray(List<Integer> array) {
        if (array.isEmpty()) return;

        String s = array.get(0).toString();
        for (int i = 1; i < array.size(); i++) {
            s += " " + array.get(i);
        }
        System.out.println(s);
    }

//  Обмен элементов по индексу
    private static void swap(List<Integer> array, int indexA, int indexB) {
        if (indexA == indexB) return;

        System.out.println("Swap: " + indexA + ":" + array.get(indexA) + " c " + indexB + ":" + array.get(indexB));
        array.set(indexA, array.get(indexA) + array.get(indexB));
        array.set(indexB, array.get(indexA) - array.get(indexB));
        array.set(indexA, array.get(indexA) - array.get(indexB));
    }

//  QuickSort или быстрая сортировка.
//  Рекурсивынй алгоритм на каждом проходе выставляет выбранный элемент с индексом mid на свое место.
//  После чего запускает себя для массивов слева и справа от этого индекса.
    private static void quickSort(List<Integer> array, int leftIndex, int rightIndex) {
        if (rightIndex <= leftIndex) return;

        int mid = (rightIndex + leftIndex) / 2;
        int left = leftIndex;
        int right = rightIndex;

        while (left <= right) {
            boolean fLeft = false;
            while (left < mid) {
                if (array.get(left) >= array.get(mid)) {
                    fLeft = true;
                    break;
                }
                ++left;
            }

            boolean fRight = false;
            while (right >= mid) {
                if (array.get(right) < array.get(mid)) {
                    fRight = true;
                    break;
                }
                --right;
            }

            if (fLeft && fRight) {
                swap(numbers, left, right);
            } else if (fLeft) {
                swap(numbers,left,mid);
                mid = left;
            } else if (fRight) {
                swap(numbers,mid,right);
                mid = right;
            }
        }

        quickSort(numbers,leftIndex,left - 1);
        quickSort(numbers, left + 1, rightIndex);
    }
}
