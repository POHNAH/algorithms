//Данный класс создан для тестирования различных алгоритмов сортировки
//Сортировать будем числовые массивы
//Задача в том что бы обновить в памяти основные алгоритмы
//А так же создать публичный проект на гитхабе для демонстрации своих навыков потенциальным работодателям

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SortArray {
    public static List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) {
        getArray(numbers,100);
        printArray(numbers);
        Date d1 = new Date();
        bubbleSort(numbers);
        Date d2 = new Date();
        System.out.println("Время выполнения алгоритма сортировка пузырьком: " + (d2.getTime() - d1.getTime()) + " милисекунд.");
        printArray(numbers);
        System.out.println("");

        getArray(numbers,100);
        printArray(numbers);
        d1 = new Date();
        selectionSort(numbers);
        d2 = new Date();
        System.out.println("Время выполнения алгоритма сортировка выбором: " + (d2.getTime() - d1.getTime()) + " милисекунд.");
        printArray(numbers);
        System.out.println("");

        getArray(numbers,100);
        printArray(numbers);
        d1 = new Date();
        selectionSortMinMax(numbers);
        d2 = new Date();
        System.out.println("Время выполнения алгоритма сортировка выбором MinMax: " + (d2.getTime() - d1.getTime()) + " милисекунд.");
        printArray(numbers);
        System.out.println("");

        getArray(numbers,100);
        printArray(numbers);
        d1 = new Date();
        quickSort(numbers,0,numbers.size() - 1);
        d2 = new Date();
        System.out.println("Время выполнения алгоритма быстрая сортировка: " + (d2.getTime() - d1.getTime()) + " милисекунд.");
        printArray(numbers);

    }

//  Метод заполняет наш массив новым набором числе
    public static void getArray(List<Integer> array, int arraySize) {
        array.clear();
        for (int i = 0; i < arraySize; i++) {
            array.add((int) (Math.random() * 10000));
        }
    }

//  Метод выводит на экран содержание массива
    private static void printArray(List<Integer> array) {
        if (array.isEmpty()) return;

        String s = array.get(0).toString();
        for (int i = 1; i < array.size(); i++) {
            s = s + " " + array.get(i);
        }
        System.out.println(s);
    }

//  Обмен элементов по индексу
    private static void swap(List<Integer> array, int indexA, int indexB) {
        if (indexA == indexB) return;

//        System.out.println("Swap: " + indexA + ":" + array.get(indexA) + " c " + indexB + ":" + array.get(indexB));
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

//  Сортировка выбором или Selection Sort
//  Суть сортировки в поискем минимального элемента массива и установки его на его место
//  Далее тоже самое происходит для оствшейся части массива
//  Таким образом мы ставим один элемент на свое место при каждой итерации внешнего цикла
    private static void selectionSort(List<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            int min = array.get(i);
            int indexMin = i;
            for (int j = i + 1; j < array.size(); j++) {
                if (min > array.get(j)) {
                    min = array.get(j);
                    indexMin = j;
                }
            }
            if (indexMin != i) {
                swap(array, i, indexMin);
            }
        }
    }

//  Доработка сортировки выбором которая напрашивается сразу
//  Кажется, что весь неотсартированный массив мы проходим полностью каждый раз
//  Тогда почему нане искать минимально и максимальное число
//  Таким образом мы в каждой итерации внешнего цикла будем ставить на мето 2 элемента вместо одного
//  уменьшим таки образом число шагов внешнего цикла в двое
    private static void selectionSortMinMax(List<Integer> array) {
        for (int i = 0; i < array.size() / 2; i++) {
            int min = array.get(i);
            int indexMin = i;
            int max = array.get(i);
            int indexMax = i;
            for (int j = i + 1; j < array.size() - i; j++) {
                if (min > array.get(j)) {
                    min = array.get(j);
                    indexMin = j;
                }
                if (max < array.get(j)) {
                    max = array.get(j);
                    indexMax = j;
                }
            }
            if (indexMin != i) {
                swap(array, i, indexMin);
            }

            if (indexMax != array.size() - i) {
                swap(array, array.size() - i - 1, indexMax);
            }
        }
    }

//  Пузырьковая сортировка или Bubble Sort
//  Суть алгоритма проста: сравниваем два соседних элемента рядом, если один больше другого,
//  то меняем их местами. Так делаем постонно, до тех пор пока в цикле не проихошло ниодного обмена.
//  Так же я не знаю класический это вариант или нет, но по сути каждая итераци я внешнего цикла
//  ставить в конец, то есть на место самый большой элемент.
//  Следовательно в каждую итерацию внешнего цикла можно прбегать внутренний цикл на одно сравнение меньше.
    private static void bubbleSort(List<Integer> array) {
        boolean f = true;
        int i = 0;
        while (f) {
            f = false;

            for (int j = 1; j < array.size() - i; j++) {
                if (array.get(j) < array.get(j - 1)) {
                    f = true;
                    swap(array, j, j - 1);
                }
            }
            ++i;
        }
    }
}
