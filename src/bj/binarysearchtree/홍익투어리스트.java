package bj.binarysearchtree;

import java.io.*;
import java.util.*;

public class 홍익투어리스트 {

    static int numAreas;
    static TreeSet<Integer> treeSet;
    static int currentPosition = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        numAreas = Integer.parseInt(st.nextToken());
        int numQueries = Integer.parseInt(st.nextToken());
        treeSet = new TreeSet<>();
        st = new StringTokenizer(br.readLine());

        for (int area = 1; area <= numAreas; area++) {
            int status = Integer.parseInt(st.nextToken());
            if (status == 0) {
                continue;
            }
            treeSet.add(area);
        }

        for (int i = 0; i < numQueries; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            switch (command) {
                case 1: {
                    int position = Integer.parseInt(st.nextToken());
                    updatePositionStatus(position);
                    break;
                }
                case 2: {
                    int stepsToMove = Integer.parseInt(st.nextToken());
                    move(stepsToMove);
                    break;
                }
                case 3: {
                    printMinimumMoves();
                }
            }
        }
    }

    static void updatePositionStatus(int position) {
        if (!treeSet.contains(position)) {
            treeSet.add(position);
            return;
        }
        treeSet.remove(position);
    }

    static void move(int stepsToMove) {
        currentPosition = (currentPosition + stepsToMove) % numAreas;
        if (currentPosition == 0) {
            currentPosition = numAreas;
        }
    }

    static void printMinimumMoves() {
        if (treeSet.isEmpty()) {
            System.out.println(-1);
            return;
        }
        Integer nearestPosition = treeSet.ceiling(currentPosition);
        nearestPosition = nearestPosition == null ? treeSet.first() + numAreas : nearestPosition;

        int minimumMoves = nearestPosition - currentPosition;
        System.out.println(minimumMoves);
    }
}
