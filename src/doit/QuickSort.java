package doit;

import java.util.Scanner;

public class QuickSort {

    // 값 교환
    static void swap(int[] a, int idx1, int idx2) {
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }

    // 퀵 정렬
    static void quickSort(int[] a, int left, int right) {
        int pl = left;	// 왼쪽 커서
        int pr = right;	// 오른쪽 커서
        int x  = a[(pl + pr) / 2];	// 피벗

        // 배열 a를 피벗 x를 기준으로 나눕니다.
        do {
            while(a[pl] < x) pl++;
            while(a[pr] > x) pr--;
            if(pl <= pr)
                swap(a, pl++, pr--);
        }while(pl <= pr);

        if(left < pr)
            quickSort(a, left, pr);
        if(pl < right)
            quickSort(a, pl, right);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("퀵 정렬");
        System.out.println("요솟수: ");
        int nx = scan.nextInt();
        int[] x = new int[nx];

        for(int i=0; i<nx; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = scan.nextInt();
        }

        quickSort(x, 0, nx - 1);	// 배열 x 퀵정렬
        System.out.println("오름차순으로 정렬 했습니다.");
        for(int i=0; i<nx; i++)
            System.out.println("x[" + i + "]= " + x[i]);


        scan.close();
    }

}
