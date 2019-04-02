public class MergeSort {

    public void merge(Integer[] a, int first, int mid, int last) {
        Integer[] temp = new Integer[a.length];
        int i,j,k = -1;
        i = first;
        j = mid;
        //Check first part and second part simultaneously
        while(i <= mid-1 && j<=last) {
            //If value in first split is greater then second add it to temp
            if(a[i] <= a[j]) {
                k++;
                temp[k] = a[i];
                i++;
            } //If value in second split is greater then first add it to temp
            else {
                k++;
                temp[k] = a[j];
                j++;
            }
        }
        //If second part is added completely to the temp but first part still contains some elements
        if(i <= mid-1 ) {
            for(int itr = i; itr <= mid-1; itr++) {
                k++;
                temp[k] = a[itr];
            }
        }
        //If first part is added completely to the temp but second part still contains some elements
        if(j <= last) {
            for(int itr = j; itr <= last; itr++) {
                k++;
                temp[k] = a[itr];
            }
        }
        //copy the temp array back to a
        for(int itr = 0; itr <= k; itr++) {
            a[first+itr] = temp[itr];
        }
    }


    public void split(Integer a[], int leftIndex, int rightIndex) {
        if (leftIndex != rightIndex) {
            int mid = (leftIndex + rightIndex) / 2;
            //recursively split the array
            split(a, leftIndex, mid);
            //recursively split the array
            split(a, mid+1, rightIndex);
            //merge left and right portions
            merge(a,leftIndex, mid+1, rightIndex);
        }
    }
}
