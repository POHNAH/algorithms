//Данный класс создан для тестирования различных алгоритмов сортировки
//Сортировать будем числовые массивы
//Задача в том что бы обновить в памяти основные алгоритмы
//А так же создать публичный проект на гитхабе для демонстрации своих навыков потенциальным работодателям

import java.util.List.*;
import java.lang.Math.*;

public class TestSort {
    public static List<int> numbers = new ArrayList<>();

    public static void main(String[] args) {
        getArray(20);
        printArray();

    }

//  Метод заполняет наш массив новым набором числе
    public static void getArray(List<int> array, int arraySize) {
        array.removeAll;
        for (int i = 0; i < arraySize; i++) {
            array.add((int) Math.random() * 1000 - 500);
        }
    }

//  Метод выводит на экран содержание массива
    public static printArray(List<int> array) {
        if (array.isEmpty()) return;

        String s = array.get(0);
        for (int i = 1; i < array.size(); i++) {
            s += " " + array.get(i);
        }
        System.out.println(s);
    }

//  Обмен элементов по индексу
    private static swap(List<int> array, int indexA, int indexB) {
        array.set(indexA, array.get(indexA) + array.get(indexB));
        array.set(indexB, array.get(indexA) - array.get(indexB));
        array.set(indexA, array.get(indexA) - array.get(indexB));
    }

    private static void QuickSort(List<int> array, int leftIndex, int rightIndex) {
        if (rightIndex <= leftIndex) return;

        int mid = (rightIndex - leftIndex) / 2;
        int right = rightIndex;

        while (left < right) {
            for (int left = leftIndex; left < mid; left++) {

            }
        }
    }
}
