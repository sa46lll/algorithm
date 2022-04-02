package doit;

import java.util.Scanner;

public class SelectionSort {
    // 두 값을 바꾼다.
    static void swap(int[] a, int idx1, int idx2) {
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }

    // 선택 정렬
    static void selectionSort(int[] a, int n) {
        for(int i=0; i<n-1; i++) {
            int min = i;	// 아직 정렬되지 않은 부분에서 가장 작은 요소의 인덱스
            for(int j=i+1; j<n; j++) {
                if(a[j] < a[min])
                    min = j;
            }
            swap(a, i, min);	// 아직 정렬되지 않은 부분의 첫 요소와 가장 작은요소 교환
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("단순 선택 정렬");
        System.out.print("요솟수 : ");
        int nx = scan.nextInt();
        int[] x = new int[nx];

        for(int i=0; i<nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = scan.nextInt();
        }

        selectionSort(x, nx);	// 배열 x를 선택정렬 합니다.
        System.out.println("오름차순으로 정렬 완료.");
        for(int i=0; i<nx; i++)
            System.out.println("x[" + i + "] = " + x[i]);

        scan.close();
    }
}