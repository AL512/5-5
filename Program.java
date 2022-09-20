import java.util.*;
import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class Program {
    public static void main(String[] args) {

        /*Semaphore sem = new Semaphore(1);
        new Thread(new SortAlgoThead(1, 2, 120, 1000000, sem)).start();
        new Thread(new SortAlgoThead(2, 2, 120, 1000000, sem)).start();
        new Thread(new SortAlgoThead(3, 2, 120, 1000000, sem)).start();
        new Thread(new SortAlgoThead(4, 2, 120, 1000000, sem)).start();*/

        int n = 1000;
        int[] arr = new int[n];
        Random rn = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rn.nextInt(1000);
        }
        System.out.println(Arrays.toString(arr));
        HibridSortingAlgorithms hsa = new HibridSortingAlgorithms();
        System.out.println(Arrays.toString(hsa.sort(arr)));

    }

}