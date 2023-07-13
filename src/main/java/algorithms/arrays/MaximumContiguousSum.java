package algorithms.arrays;

public class MaximumContiguousSum {
    /** Maximum contguous sum in an array */

    public static void main(String[] args) {
        int[] arr1 =  {2,-1,4,-2,3};
        int[] arr2 =  {1,2,3,4,5,6};
        int[] arr3 =  {-1,-2,-3,-4,-5,-6};
        int[] arr4 =  {2,-2,4,-4,8};
        System.out.println(maxContigousSum(arr1));
        System.out.println(maxContigousSum(arr2));
        System.out.println(maxContigousSum(arr4));
        System.out.println(maxContigousSum(arr3));
    }

    public static int maxContigousSum( int[] arr) {
        int start = 0, end = 0 ;
        int maxSum = 0;
        if(arr == null ) return maxSum;
        else if ( arr.length == 1 ) return arr[0];
        int sum = arr[start];

        for ( ; end < arr.length && start <= end ; ) {
            if ( sum > maxSum ) { maxSum = sum ; }
            if(end < arr.length -1 ) {
                if (arr[end+1] + sum > sum) { sum = sum + arr[end+1];}
                end++;
                continue;
            }
            else if(start <= end -1  ) {
                if ( sum - arr[start] > sum ) { maxSum = sum - arr[start]; }
                start++;
                continue;
            } else if ( end < arr.length) { end++ ; }
            else if ( start < arr.length) { start++ ; }
        }
        return maxSum;
    }
}