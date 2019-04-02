public class InsertionSort {
    public void insertionSort(Integer[] a) {
        for(int i = 1; i<a.length; i++) {
            int index = a[i];
            int j = i;
            while( j > 0 && a[j-1] > index) {
                a[j] = a[j-1];
                j--;
            }
            a[j] = index;
        }
    }
}
