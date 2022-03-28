package doit;

import java.util.Scanner;

public class IntQueueTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IntQueue intQueue = new IntQueue(64);

        int input = 1;

        while (input != 0) {
            System.out.println("현재 데이터 수 : " + intQueue.size() + "/" + intQueue.capacity());
            System.out.print("(0) 종료 (1) 인큐 (2) 디큐 (3) 피크 (4) 덤프 : ");
            input = scanner.nextInt();

            switch (input) {
                case 0:
                    break;
                case 1: {
                    System.out.print("데이터 : ");
                    int data_input = scanner.nextInt();
                    try {
                        intQueue.enqueue(data_input);
                    } catch (IntStack.OverflowIntStackException ex) {
                        System.out.println("큐가 가득 찼습니다.");
                    }
                    break;
                }
                case 2: {
                    try {
                        System.out.println("디큐 데이터는 " + intQueue.dequeue() + "입니다.");
                    } catch (IntStack.EmptyIntStackException ex) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;
                }
                case 3: {
                    try {
                        System.out.println("피크한 데이터는 " + intQueue.peek() + "입니다.");
                    } catch (IntStack.EmptyIntStackException ex) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;
                }
                case 4:
                    intQueue.dump();
                    break;
            }
            System.out.println();
        }
    }
}
