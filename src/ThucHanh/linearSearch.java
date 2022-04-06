package ThucHanh;

import java.util.*;

public class linearSearch {
    public static void main(String[] args) {

        long start1, start2, end1, end2, start3, end3;
        List<Integer> integerList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for (Integer i = 1; i < 100000; i++) {
            integerList.add(i);
        }
        int target = 10000;
        //System.out.println(integerList);
        System.out.println("Input target to search linear: ");
        //int target = sc.nextInt();

        start1 = System.nanoTime();
        System.out.println(Collections.binarySearch(integerList, target));
        ;
        end1 = System.nanoTime();

        System.out.println("Collection search time =====" + (end1 - start1));

        //System.out.println("Input target to search binary: ");
        //int target1 = sc.nextInt();
        start2 = System.nanoTime();
        System.out.println(binarySearch5(integerList, 10000));
        end2 = System.nanoTime();
        System.out.println("Binary search time =====" + (end2 - start2));

        start3 = System.nanoTime();
        System.out.println(binarySearch2(integerList, 0, integerList.size() - 1, 10000));
        end3 = System.nanoTime();
        System.out.println("Recursion search time=====" + (end3 - start3));

        ;

    }

    private static int binarySearch5(List<Integer> integerList, int target1) {
        int low = 0;
        int high = integerList.size() - 1;
        while (low < high) {
            int middle = (low + high) / 2;
            if (integerList.get(middle) > target1) {
                high = middle - 1;
            } else if (integerList.get(middle) < target1) {
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    private static int linearSearch1(List<Integer> arr, int target) {
        int index = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).equals(target)) {
                index = i;
                return index;
            }
        }
        return -1;
    }

    private static int interpolationSearch(List<Integer> arr, int value) {
        int high = arr.size() - 1;
        int low = 0;

        while (value >= arr.get(low) && value <= arr.get(high) && low <= high) {
            int probe = low + (high - low) * (value - arr.get(low)) / (arr.get(high) - arr.get(low));
            //System.out.println("probe=  " + probe);
            //System.out.println("check ---> "+(arr[probe] == value));
            if (arr.get(probe) == value) {
                return probe;
            } else if (value >= arr.get(probe)) {
                low = probe + 1;
            } else {
                high = probe - 1;
            }
        }
        return -1;
    }

    private static int binarySearch2(List<Integer> arr, int low, int high, int target) {
        int middle = (low + high) / 2;
        if (low > high)
            return -1;
        if (arr.get(middle) == target) {
            return middle;
        }
        if (arr.get(middle) < target) {
            return binarySearch2(arr, middle + 1, high, target);
        }
        if (arr.get(middle) > target) {
            return binarySearch2(arr, low, middle - 1, target);
        }
        return 0;
    }

}
