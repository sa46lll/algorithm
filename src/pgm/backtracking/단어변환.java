package pgm.backtracking;

public class 단어변환 {

    static class Solution {

        static boolean[] visited;
        static int answer = 0;

        public static int solution(String begin, String target, String[] words) {
            visited = new boolean[words.length];
            dfs(begin, target, words, 0);
            return answer;
        }

        private static void dfs(String begin, String target, String[] words, int count) {
            if (begin.equals(target)) {
                answer = count;
                return;
            }
            for (int i = 0; i < words.length; i++) {
                if (visited[i]) {
                    continue;
                }
                String word = words[i];
                int sameChar = 0;
                for (int c = 0; c < word.length(); c++) {
                    if (begin.charAt(c) == word.charAt(c)) {
                        sameChar++;
                    }
                }
                // 하나만 제외하고 모두 같으면
                if (sameChar == begin.length() - 1) {
                    visited[i] = true;
                    dfs(word, target, words, count + 1);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(
                solution.solution(
                        "hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}
                )
        );
        System.out.println(
                solution.solution(
                        "hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}
                )
        );
    }
}
