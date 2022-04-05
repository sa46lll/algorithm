package doit;

import java.util.Scanner;

public class InsertionSort {

    // 단순 삽입 정렬
    static void insertionSort(int[] a, int n) {
        for(int i=1; i<n; i++) {
            int temp = a[i];	// 선택한 요소 값 복사해놓기,
            int j;

            // 반복조건
            // 1) 정렬된 열의 가장 왼쪽끝에 도달하거나(j=0)
            // 2) 요소보다 작거나 값은 값을 같는 요소를 발견할 때 까지
            // 1 4 6 7 3 9 8
            for(j=i; j>0 && a[j-1] > temp; j--)
                a[j] = a[j-1];	// 왼쪽값 -> 오른쪽값으로 복사
            a[j] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("단순 삽입 정렬");
        System.out.print("요솟수: ");
        int nx = scan.nextInt();
        int[] x = new int[nx];

        for(int i=0; i<nx; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = scan.nextInt();
        }

        insertionSort(x, nx);	// 배열 x 단순 삽입 정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for(int i=0; i<nx; i++)
            System.out.println("x[" + i + "] = " + x[i]);

        scan.close();
    }

}
