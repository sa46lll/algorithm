package doit;

import java.util.Scanner;

public class BubbleSort {

    // 두 값을 바꾼다.
    static void swap(int[] a, int idx1, int idx2) {
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }

    // 버블 정렬
    static void bubbleSort(int[] a, int n) {

        // n-1개 요소의 정렬이 끝나면 마지막 요소는 이미 끝에 놓이기 때문에 n-1회 수행
        for(int i=0; i<n-1; i++)
            for(int j=n-1; j>i; j--)
                if(a[j-1] > a[j])
                    swap(a, j-1, j);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("버블 정렬(버전 1)");
        System.out.print("요솟수 : ");
        int nx = scan.nextInt();
        int[] x = new int[nx];

        for(int i=0; i<nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = scan.nextInt();
        }

        bubbleSort(x, nx);	// 배열 x를 버블 정렬합니다.
        System.out.println("오름차순으로 정렬 완료.");
        for(int i=0; i<nx; i++)
            System.out.println("x[" + i + "] = " + x[i]);

        scan.close();
    }

}