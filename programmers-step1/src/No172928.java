import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No172928 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"OSO", "OOO", "OXO", "OOO"}, new String[]{"E 2", "S 3", "W 1"})));
    }
    public static int[] solution(String[] park, String[] routes) {
        int parkR = park.length;
        int parkC = park[0].length();
        int nowR = 0;
        int nowC = 0;
        Map<Character, Integer[]> move = new HashMap<>();
        move.put('N', new Integer[]{-1, 0});
        move.put('S', new Integer[]{1, 0});
        move.put('W', new Integer[]{0, -1});
        move.put('E', new Integer[]{0, 1});
        for (int i = 0; i < parkR; i++) {
            for (int j = 0; j < parkC; j++) {
                if (park[i].charAt(j) == 'S') {
                    nowR = i;
                    nowC = j;

                    break;
                }
            }
        }
        for (int i = 0; i < routes.length; i++) {
            String[] parts = routes[i].split(" ");
            char op = parts[0].charAt(0);
            int n = Integer.parseInt(parts[1]);
            if (nowR + move.get(op)[0]*n >= 0 && nowC + move.get(op)[1]*n >= 0 && nowR + move.get(op)[0]*n < parkR && nowC + move.get(op)[1]*n < parkC) {
                int cnt =0;
                int r = nowR;
                int c = nowC;
                while (cnt<n){
                    if(park[r + move.get(op)[0]].charAt(c + move.get(op)[1])=='X')
                        break;
                    if (cnt==n-1){
                        nowR = nowR+move.get(op)[0]*n;
                        nowC = nowC + move.get(op)[1]*n;
                    }
                    cnt++;
                }
            }
        }

        return new int[]{nowR,nowC};
    }
}
