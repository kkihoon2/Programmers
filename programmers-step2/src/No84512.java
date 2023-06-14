

public class No84512 {
    public static void main(String[] args) {
        System.out.println(solution("AAAAE"));
    }
    public static int solution(String word) {
        String[] MOUM = new String[]{"A", "E", "I", "O", "U"};
        int[] cnt = new int[1];
        StringBuilder sb = new StringBuilder();
        int answer = dfs(word, sb, MOUM, cnt);
        return answer;
    }

    public static int dfs(String word, StringBuilder sb, String[] MOUM, int[] cnt) {
        if (sb.toString().equals(word)) {
            return cnt[0];
        }
        if (sb.length() == 5) {  // 길이가 5인 경우는 더 이상 추가할 수 없으므로 종료
            return -1;
        }
        for (int i = 0; i < MOUM.length; i++) {
            sb.append(MOUM[i]);
            cnt[0]++;
            int result = dfs(word, sb, MOUM, cnt);  // 재귀 호출 결과를 변수에 저장
            if (result != -1) {  // 매칭된 경우에는 결과 반환
                return result;
            }
            sb.deleteCharAt(sb.length() - 1);
            } ;


        return -1;
    }
}
