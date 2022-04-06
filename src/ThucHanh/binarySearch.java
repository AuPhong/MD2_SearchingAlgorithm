package ThucHanh;

public class binarySearch {
    public static int search(int[] arr, int target){
        int low = 0;
        int high = arr.length-1;
        while (low<=high){
            int middle = (low+high)/2;
            if (arr[middle]<target){
                low = middle+1;
            }
            else if (arr[middle]>target){
                high = middle-1;
            }
            else
                return middle;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
         System.out.println(search(list,45));
    }
}
