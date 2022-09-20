import java.util.Random;

public class SortingAlgorithms {

    private void swap(int[] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }

    private boolean lengthCheck(int[] arr){
        if (arr == null || arr.length < 2) return false;
        return true;
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
            left = mergeSort(left);
            right = mergeSort(right);

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

    public int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = Partition(arr, left, right);
            quickSort(arr, left, mid);
            quickSort(arr, mid + 1, right);
        }
        return arr;
    }
    int Partition(int[] arr, int left, int right) {
        Random rn = new Random();
        int pivotInd = rn.nextInt(right - left) + left;
        int pivot = arr[pivotInd];
        int i = left, j = right;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(arr, i++, j--);
        }
        return j;
    }
}
