import java.util.*;
import java.io.*;

public class Partition3 {

    private static int partitionRecursion(int[] A, int i, int sum1, int sum2, int sum3, int TotalSum) {

        if (sum1 > TotalSum / 3 || sum2 > TotalSum / 3 || sum3 > TotalSum / 3) {
            return 0;
        }

        if (i == A.length -1) {
            // Last index , Add A[i] to each sum to check if Equal;
            if (sum1 + A[i] == sum2 && sum2 == sum3) return 1;
            if (sum1 == sum2 + A[i] && sum1 == sum3) return 1;
            if (sum1 == sum3 + A[i] && sum1 == sum2) return 1;
            return 0;
        }

        else {
            // At the Ith element Add to each sum and recursively check if partition is Possible

            int a1 = partitionRecursion(A, i+1, sum1 + A[i], sum2, sum3, TotalSum);
            if (a1 == 1) return 1;

            int a2 = partitionRecursion(A, i+1, sum1, sum2 + A[i], sum3, TotalSum);
            if (a2 == 1) return 1;

            int a3 = partitionRecursion(A, i+1, sum1, sum2, sum3 + A[i], TotalSum);
            if (a3 == 1) return 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        int totalSum = Arrays.stream(A).reduce(0, (a1,a2) -> a1 + a2);
        System.out.println(partitionRecursion(A,0,0,0,0, totalSum));
    }
}

