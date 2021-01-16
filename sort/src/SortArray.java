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
//        numbers.clear();
//        numbers.add(10);
//        numbers.add(9);
//        numbers.add(8);
//        numbers.add(7);
//        numbers.add(6);
//        numbers.add(5);
//        numbers.add(4);
//        numbers.add(3);
//        numbers.add(2);
//        numbers.add(1);
//        numbers.add(0);
        getArray(numbers,100);
        printArray(numbers);
        Date d1 = new Date();
        heapSort(numbers);
        Date d2 = new Date();
        System.out.println("Время выполнения алгоритма пирамидальная сортировка: " + (d2.getTime() - d1.getTime()) + " милисекунд.");
        printArray(numbers);
        System.out.println("");

        getArray(numbers,100);
        printArray(numbers);
        d1 = new Date();
        gnomeSort(numbers);
        d2 = new Date();
        System.out.println("Время выполнения алгоритма гномья сортировка: " + (d2.getTime() - d1.getTime()) + " милисекунд.");
        printArray(numbers);
        System.out.println("");

        getArray(numbers,100);
        printArray(numbers);
        d1 = new Date();
        treeSort(numbers);
        d2 = new Date();
        System.out.println("Время выполнения алгоритма сортировка деревом: " + (d2.getTime() - d1.getTime()) + " милисекунд.");
        printArray(numbers);
        System.out.println("");

        getArray(numbers,100);
        printArray(numbers);
        d1 = new Date();
        insertionSort(numbers);
        d2 = new Date();
        System.out.println("Время выполнения алгоритма сортировка вставками: " + (d2.getTime() - d1.getTime()) + " милисекунд.");
        printArray(numbers);
        System.out.println("");

        getArray(numbers,100);
        printArray(numbers);
        d1 = new Date();
        combSort(numbers);
        d2 = new Date();
        System.out.println("Время выполнения алгоритма сортировка расческой: " + (d2.getTime() - d1.getTime()) + " милисекунд.");
        printArray(numbers);
        System.out.println("");

        getArray(numbers,100);
        printArray(numbers);
        d1 = new Date();
        shakerSort(numbers);
        d2 = new Date();
        System.out.println("Время выполнения алгоритма шейкерная сортировка: " + (d2.getTime() - d1.getTime()) + " милисекунд.");
        printArray(numbers);
        System.out.println("");

        getArray(numbers,100);
        printArray(numbers);
        d1 = new Date();
        bubbleSort(numbers);
        d2 = new Date();
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
    public static void printArray(List<Integer> array) {
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

        array.set(indexA, array.get(indexA) + array.get(indexB));
        array.set(indexB, array.get(indexA) - array.get(indexB));
        array.set(indexA, array.get(indexA) - array.get(indexB));
    }

//  QuickSort или быстрая сортировка.
//  Рекурсивынй алгоритм на каждом проходе выставляет выбранный элемент с индексом mid на свое место.
//  После чего запускает себя для массивов слева и справа от этого индекса.
    public static void quickSort(List<Integer> array, int leftIndex, int rightIndex) {
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
    public static void selectionSort(List<Integer> array) {
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
    public static void selectionSortMinMax(List<Integer> array) {
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

            if ((indexMax != array.size() - i) && (indexMax != i)) {
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
    public static void bubbleSort(List<Integer> array) {
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

//  Шейкерная сортировка или Shaker sort.
//  Модификация пузырьковой сортировки. Идея в том, что мы наш алгоритм по переменно
//  из начала в конец и из конца в начало. При каждом проходе выставляя по концам массива
//  максимальный и минимальный элемент неосортированной части.
    public static void shakerSort(List<Integer> array) {
        boolean f = true;
        int left = 0;
        int right = array.size() - 1;

        while (f) {
            f = false;

            for (int i = left + 1; i <= right; i++) {
                if (array.get(i) < array.get(i - 1)) {
                    f = true;
                    swap(array, i, i - 1);
                }
            }
            --right;

            for (int i = right - 1; i >= left; i--) {
                if (array.get(i) > array.get(i + 1)) {
                    f = true;
                    swap(array, i, i + 1);
                }
            }
            ++left;
        }
    }

//  Сортировка расческой или Comb sort.
//  Идея алгоритма ускореть доставку элементов "черепах" в нужное место.
//  Сортируемый массив подвергается более грубым итерациям с большим шагом.
//  При этом шаг постояно уменьшается на 1,247, пока не дойдет до 1.
//  Тогда проходит итерация аналогичная пузырьковой сортировке.
    public static void combSort(List<Integer> array) {
        boolean f = true;
        int delta = array.size() - 1;
        while (delta > 1 || f) {
            if (delta > 1) {
                delta = (int) (delta / 1.247);
            }

            f = false;
            int i = 0;
            while (i + delta < array.size()) {
                if (array.get(i) > array.get(i + delta)) {
                    f = true;
                    swap(array, i, i + delta);
                }
                ++i;
            }
        }
    }

//  Сортировка вставками или Insertion Sort.
//  Суть сортировка в том, что мы на каждой итерации ставим элемент
//  в уже отсортированную часть на то место где он должен быть.
    public static void insertionSort(List<Integer> array) {
        for (int i = 1; i < array.size(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (array.get(i) >= array.get(j)) {
//                  Если найден элемент меньше или равный обрабатываемому вставляем перд ним.
                    int buf = array.get(i);
                    array.remove(i);
                    array.add(j + 1,buf);
                    break;
                } else if (j == 0){
//                  Если такой элемент не найден, то наш элемент меньше всех и мы вставляем его в начало.
                    int buf = array.get(i);
                    array.remove(i);
                    array.add(j ,buf);
                }
            }
        }
    }

//  Сортировка деревом или Tree Sort
//  При сортировке мы строим бинарное дерево.
//  Перебираем все элементы массива и каждый помещается в узел дерева по принципу:
//  если в узле нет значения, то мы в него пишем, если есть то мы сравниваем текущее значение со
//  значением хранящимся в узле и если больше то отправлем его в правый узел, а меньше - левый.
//  После чего мы делаем обход дерева и заносим значение по порядку в массив.
//  Необходимо создать класс узел дерева и написать процедуру обхода дерева.
    public static void treeSort(List<Integer> array) {
        BinaryTree tree = new BinaryTree();
        for (int i = 0; i < array.size(); i++) {
            tree.insertNode(array.get(i));
        }
        array.clear();
        array.addAll(tree.traversal());
    }

//  Гномья сортировка или Gnome Sort.
//  СВ цикле мы сравниваем соседние элементы, если происходит обмен,
//  то мы делаем шаг назад. Таким образом все элементы в начале списка отсортированы.
    public static void gnomeSort(List<Integer> array) {
        for (int i = 1; i < array.size(); i++) {
            if (i <= 0) {
                i = 1;
            }

            if (array.get(i - 1) > array.get(i)) {
                swap(array, i - 1, i);
                i -= 2;
            }
        }
    }

//  Пирамидальная сортировка или Heap sort.
//  Помещаем весь массив в двоичную кучу, затем извлекаем все элементы из кучи попорядку,
//  помещая их в конец массива.
    public static void heapSort(List<Integer> array) {
        BinaryHeap binaryHeap = new BinaryHeap();

        for (int i = 0; i < array.size(); i++) {
            binaryHeap.insert(array.get(i));
        }

        for (int i = array.size() -1 ; i >= 0; i--) {
            array.set(i, binaryHeap.removeMax());
        }
    }
}
