public class BinarySearch {
    public int binarySearch(Integer [] arr, int first, int last, int key) {
        while( first <= last ){
            int mid = (first + last)/2;
            if ( arr[mid] < key ){
                first += 1;
            }else if ( arr[mid] > key ){
                last+= -1;
            }else{
                return mid;
            }
        }
        System.out.println("Element not found");
        return -1;
    }
}
