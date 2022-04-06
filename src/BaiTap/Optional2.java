package BaiTap;

public class Optional2 {
    public static void main(String[] args) {
        int[] arr = {-1,1,2,3,4,5,6,7,8,99};
        int low = 0;
        int high = arr.length -1;

        System.out.println(binarySearch2(arr,  low,  high, 99));;

    }

    private static int binarySearch2(int[] arr, int low, int high, int target) {
        int middle = (low+high)/2;
        if (low>high)
            return -1;
        if (arr[middle]==target){
            return middle;
        }
        if (arr[middle]<target){
            return binarySearch2(arr, middle+1, high, target);
        }
        if (arr[middle]>target){
            return binarySearch2(arr, low, middle-1, target);
        }
        return 0;
    }


}
