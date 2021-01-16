//Двоичная куча реализация на основе массива.

import java.util.ArrayList;
import java.util.List;

public class BinaryHeap {
    private static List<Integer> list;

    public BinaryHeap() {
        list = new ArrayList<>();
    }

    public int getSize() {
        return list.size();
    }

//  Обмен элементов по индексу
    private static void swap(List<Integer> array, int indexA, int indexB) {
        if (indexA == indexB) return;

        array.set(indexA, array.get(indexA) + array.get(indexB));
        array.set(indexB, array.get(indexA) - array.get(indexB));
        array.set(indexA, array.get(indexA) - array.get(indexB));
    }


    public static void insert(int volume) {
        list.add(volume);
        int i = list.size() - 1;
        int parent = (i - 1) / 2;

        while ((i > 0) && (list.get(parent) < list.get(i))) {
            swap(list, i, parent);

            i = parent;
            parent = (i - 1) / 2;
        }
    }

    public static int removeMax() {
        int max = list.get(0);

        list.remove(0);

        int i = 0;
        int indexLeft = 2 * i + 1;
        int indexRight = indexLeft + 1;

        while (true/*(i < list.size() - 1) &&
                (indexLeft) &&
                () &&
                ((list.get(i) < list.get(indexLeft)) || (list.get(i) < list.get(indexRight)))*/) {
            int indexMax;

            if ((indexLeft < list.size()) && (indexRight < list.size())) {
                if (list.get(indexLeft) > list.get(indexRight))
                    indexMax = indexLeft;
                else
                    indexMax = indexRight;

            }
            else if (indexLeft < list.size()) {
                indexMax = indexLeft;
            }
            else
                break;

            if (list.get(i) < list.get(indexMax)) {
                swap(list, i, indexMax);

                i = indexMax;
                indexLeft = 2 * i + 1;
                indexRight = indexLeft + 1;
            }
            else
                break;
        }

        return max;
    }
}
