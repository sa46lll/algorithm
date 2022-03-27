package doit;

import java.util.Scanner;

public class IntStackTester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntStack stack = new IntStack(64);

        while (true) {
            System.out.println("현재 데이터수: " + stack.size() + " /" + stack.capacity());
            System.out.println("(1)푸시  (2)팝  (3)피크  (4)덤프  (5)찾기  (6)비우기  (7)크기확인  (0)종료");

            int menu = sc.nextInt();
            if (menu == 0) break;

            int x;
            switch (menu) {
                case 1:
                    System.out.println("데이터: ");
                    x = sc.nextInt();
                    try {
                        stack.push(x);
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;

                case 2:
                    try {
                        x = stack.pop();
                        System.out.println("팝한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;

                case 3:
                    try {
                        x = stack.peek();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 4:
                    stack.dump();
                    break;

                case 5:
                    System.out.println("찾으시려는 값을 입력해주세요: ");
                    int num = sc.nextInt();
                    int result = stack.indexOf(num);
                    if (result == -1)
                        System.out.println("찾으시는 값은 없습니다.");
                    else
                        System.out.println("찾으시는 값은 (" + result +")위치에 있습니다.");

                case 6:
                    stack.clear();

                case 7:
                    System.out.println("스택 크기는 : " + stack.size());
            }
        }
    }
}