import java.util.Random;

public class HibridSortingAlgorithms {

    private static final int SELECT_SORT_ARGORITM = 79;
    private void swap(int[] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }

    private boolean lengthCheck(int[] arr){
        if (arr == null || arr.length < 2) return false;
        return true;
    }

    public int[] sort(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        if (len >= SELECT_SORT_ARGORITM){
            result = mergeSort(arr);
        }
        else{
            result = insertionSort(arr);
        }
        return result;
    }

    public int[] bubbleSort(int[] arr) {
        if (lengthCheck(arr)) {
            while (true) {
                boolean was_swap = false;
                for (int i = 0; i < arr.length - 1; ++i) {
                    if (arr[i + 1] < arr[i]) {
                        swap(arr, i, i + 1);
                        was_swap = true;
                    }
                }
                if (!was_swap) {
                    break;
                }
            }
        }
        return arr;
    }

    public int[] selectionSort(int[] arr) {
        if (lengthCheck(arr)) {
            for (int i = 0; i < arr.length; ++i) {
                int min_pos = i;
                for (int j = i + 1; j < arr.length; ++j) {
                    if (arr[j] < arr[min_pos]) {
                        min_pos = j;
                    }
                }
                int tmp = arr[i];
                arr[i] = arr[min_pos];
                arr[min_pos] = tmp;
            }
        }
        return arr;
    }
    public int[] insertionSort(int[] arr) {
        if (lengthCheck(arr)) {
            for (int i = 0; i < arr.length; ++i) {
                for (int j = i; j > 0; --j) {
                    if (arr[j] < arr[j - 1]) {
                        swap(arr, j - 1, j);
                    }
                }
            }
        }
        return arr;
    }
    public int[] mergeSort(int[] arr) {
        if (lengthCheck(arr)) {
            int[] left = new int[arr.length / 2];
            System.arraycopy(arr, 0, left, 0, arr.length / 2);
            int[] right = new int[arr.length - arr.length / 2];
            System.arraycopy(arr, arr.length / 2, right, 0, arr.length - arr.length / 2);
            if (left.length >= SELECT_SORT_ARGORITM)
                left = mergeSort(left);
            else
                left = insertionSort(left);
            if (right.length >= SELECT_SORT_ARGORITM)
                right = mergeSort(right);
            else
                right = insertionSort(right);

            return mergeArray(left, right);
        }
        else{
            return arr;
        }
    }

    private int[] mergeArray(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0;
        int resultIndex = 0;
        while (i < left.length || j < right.length) {
            if (i < left.length && (j == right.length || left[i] < right[j])) {
                result[resultIndex] = left[i];
                i++;
            } else {
                result[resultIndex] = right[j];
                j++;
            }
            resultIndex++;
        }
        return result;
    }
}
