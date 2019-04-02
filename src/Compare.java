import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import javax.swing.SwingUtilities;

public class Compare {

    public static void Sort(String algorithm, String cases){
        int n=10000;
        int inputnumber = 1;
        long start = 0, stop = 0;
        Integer[] array;
        Integer[] array1;


        // creating objects for algorithm classes which have non-static methods
        Random rand = new Random();
        BinarySearch binary = new BinarySearch();
        MergeSort merge = new MergeSort();
        InsertionSort insertion = new InsertionSort();
        SelectionSort selection = new SelectionSort();


        /* RUNS WITH LIBRARY
        // starting line chart
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LineChart("Analysis the Algorithms").setVisible(true);
            }
        });
        */


        // loop stops the when array n reach the written value
        while (n <= 80000) {

        Integer[] a = new Integer[n];
		array=a.clone();
        // creating random array
        for(int i = 0; i < n; i++) {
            a[i] = rand.nextInt(n);
        }

        if (cases.equals("best")){  //best case
            array = a.clone();
            Arrays.sort(array);
        }
        else if (cases.equals("worst")){ //worst case
            array = a.clone();
            Arrays.sort(array, Comparator.reverseOrder());

        }else if (cases.equals("avr")){ //average case
            array=a.clone();
        }

        if (algorithm.equals("selection")) {
            start = System.currentTimeMillis();
            selection.selectionSort(array);
            stop = System.currentTimeMillis();

        }

        else if (algorithm.equals("merge")) {
                start = System.currentTimeMillis();
                merge.split(array,0,a.length-1);
                stop = System.currentTimeMillis();
        }

        else if(algorithm.equals("radix")){
            start = System.currentTimeMillis();
            RadixSort.radixsort(array,n);
            stop = System.currentTimeMillis();
        }

        else if(algorithm.equals("insertion")){
            start = System.currentTimeMillis();
            insertion.insertionSort(array);
            stop = System.currentTimeMillis();
        }


        else if(algorithm.equals("binary")){
            array1 = a.clone();
            Arrays.sort(array1);


            if(cases.equals("best")) {
                start = System.currentTimeMillis();
                binary.binarySearch(array1, 0 ,n-1, array1[n/2]);
                stop = System.currentTimeMillis();

            }
            else if(cases.equals("worst")) {
                start = System.currentTimeMillis();
                binary.binarySearch(array1, 0 , n-1, array1[n-1]);
                stop = System.currentTimeMillis();
            }
            else  { //average case
                    start = System.currentTimeMillis();
                    binary.binarySearch(array1, 0 ,n-1, array1[n/4]);
                    stop = System.currentTimeMillis();
                }
            }


            double sec = ((stop-start)*0.001);

            DecimalFormat df = new DecimalFormat("#.####");
            String str = df.format(sec);

        try {
            WriteFile.append(inputnumber + ". " + str);
        } catch (IOException e) {
            e.printStackTrace();
        }


        /* RUNS WITH LIBRARY
        LineChart.dataset.addValue(stop-start, algorithm+ " " +cases, Integer.toString(n));
        */

        n*=2;
        inputnumber+=1;
    }
  }
}


