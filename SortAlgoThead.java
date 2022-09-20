import java.util.*;
import java.util.concurrent.Semaphore;

public class SortAlgoThead implements Runnable {

    int algoNum = -1;
    int minN = 0;
    int maxN = 10;
    int repeatCount = 10;
    Semaphore sem;
    public SortAlgoThead(int _algoNum, int _minN, int _maxN, int _repeatCount, Semaphore _sem){
        algoNum = _algoNum;
        minN = _minN;
        maxN = _maxN;
        repeatCount = _repeatCount;
        sem = _sem;
    }

    public void run() {
        try{
            SortedMap<Integer, Double> result = new TreeMap<>();
            for (int n = minN; n <= maxN; n++){
                double[] repertResult = new double[repeatCount];
                for(int repeat = 0; repeat < repeatCount; repeat++) {
                    int[] arr = new int[n];
                    Random rn = new Random();
                    for (int i = 0; i < n; i++) {
                        arr[i] = rn.nextInt(Integer.MAX_VALUE);
                    }
                    SortingAlgorithms sa = new SortingAlgorithms();
                    int[] newArr = arr.clone();
                    long startTime = 0;
                    long endTime = 0;
                    switch (algoNum){
                        case 1:
                            startTime = System.nanoTime();
                            sa.insertionSort(newArr);
                            endTime = System.nanoTime();
                            break;
                        case 2:
                            startTime = System.nanoTime();
                            sa.bubbleSort(newArr);
                            endTime = System.nanoTime();
                            break;
                        case 3:
                            startTime = System.nanoTime();
                            sa.mergeSort(newArr);
                            endTime = System.nanoTime();
                            break;
                        case 4:
                            startTime = System.nanoTime();
                            sa.quickSort(newArr, 0, arr.length - 1);
                            endTime = System.nanoTime();
                            break;
                    }
                    double duration = (endTime - startTime) / 1000000.0;
                    repertResult[repeat] = duration;
                }
                double avr = Arrays.stream(repertResult).sum()/repertResult.length;
                double scale = Math.pow(10, 3);
                //result.put(n,Math.ceil(Arrays.stream(repertResult).average().orElse(Double.NaN) * scale) / scale);
                result.put(n,Math.ceil(avr * scale) / scale);
            }
            sem.acquire();
            switch (algoNum) {
                case 1:
                    System.out.println("Insertion Sorter");
                    break;
                case 2:
                    System.out.println("Bubble Sorter");
                    break;
                case 3:
                    System.out.println("Merge Sorter");
                    break;
                case 4:
                    System.out.println("Quick Sorter");
                    break;
            }
            for(Map.Entry<Integer, Double> item : result.entrySet()){
                System.out.println(item.getKey() + ";" + item.getValue().toString().replace('.', ','));
            }
            System.out.println();
            sem.release();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            sem.release();
        }
    }
}
