public class No12951 {
    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed me"));
    }

    public static String solution(String s) {
        String[] strings = s.split(" ");
        String answer = "";
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() == 0) {
                answer += " ";
            }
            String now = strings[i];


                answer += now.substring(0, 1).toUpperCase();
                // 1번째 문자부터 마지막까지는 소문자로
                answer += now.substring(1, now.length()).toLowerCase();
                // 마지막에 " " 추가
                answer += " ";
        }
        if(s.substring(s.length()-1, s.length()).equals(" ")){
            return answer;
        }

        // 맨 마지막 " " 제거하고 answer 반환
        return answer.substring(0, answer.length()-1);
    }
}
