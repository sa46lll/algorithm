package pgm.backtracking;

import java.util.*;

public class 단체사진찍기 {

    private final char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    private Map<Character, Integer> friendMap = new HashMap<>(); // char을 integer로 다루기 위함
    private int[] positions; // 현재 친구들 위치
    private boolean[] visited;
    private int result = 0;

    public static void main(String[] args) {
        new 단체사진찍기().solution(2, new String[]{"N~F=0", "R~T>2"});
        new 단체사진찍기().solution(2, new String[]{"M~C<2", "C~M>1"});
    }

    public int solution(int n, String[] data) {
        initialize();
        dfs(data, 0);
        return result;
    }

    private void initialize() {
        visited = new boolean[friends.length];
        positions = new int[friends.length];
        for (int i = 0; i < friends.length; i++) {
            friendMap.put(friends[i], i);
        }
    }

    private void dfs(String[] condition, int depth) {
        if (depth == friends.length) {
            for (int i = 0; i < condition.length; i++) {
                if (!isConditionSatisfied(condition[i])) {
                    return;
                }
            }
            result++;
            return;
        }
        for (int i = 0; i < friends.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                positions[depth] = i;
                dfs(condition, depth + 1);
                visited[i] = false;
            }
        }
    }

    private boolean isConditionSatisfied(String condition) {
        char[] conditionArray = condition.toCharArray();
        char friend1 = conditionArray[0];
        char friend2 = conditionArray[2];
        char symbol = conditionArray[3];
        int value = conditionArray[4] - '0' + 1;
        switch (symbol) {
            case '>' -> {
                if (getPositionDifference(friend1, friend2) <= value) {
                    return false;
                }
            }
            case '<' -> {
                if (getPositionDifference(friend1, friend2) >= value) {
                    return false;
                }
            }
            case '=' -> {
                if (getPositionDifference(friend1, friend2) != value) {
                    return false;
                }
            }
            default -> throw new IllegalArgumentException();
        }
        return true;
    }

    private int getPositionDifference(char friend1, char friend2) {
        return Math.abs(positions[friendMap.get(friend1)] - positions[friendMap.get(friend2)]);
    }
}
