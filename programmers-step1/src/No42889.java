import java.util.*;

public class No42889 {
    public static void main(String[] args) {
        Solution k = new Solution();
        System.out.println(Arrays.toString(k.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
    }
}
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N+1];
        int[] up = new int[stages.length+1];
        up[0]=0;
        int[] down = new int[stages.length+1];
        down[0]=0;
        down[1]=8;
        for(int i = 1;i<stages.length;i++){
            up[stages[i]]++;
        }
        for (int i = 2; i < stages.length ; i++) {
            down[i]=down[i-1]-up[i-1];
        }
        Map<Integer,Double> answerMap = new HashMap<>();
        for (int i = 1; i < stages.length-1; i++) {
            answerMap.put(i, (double) up[i]/down[i]);
        }
        System.out.println(Collections.unmodifiableMap(answerMap));
//        List<Map.Entry<Integer, Double>> sortedList = new ArrayList<>(answerMap.entrySet());
//        sortedList.sort(Map.Entry.comparingByValue());
//
//        // 정렬된 리스트에서 키(key) 값을 출력
//        for (int i = 0; i < answer.length; i++) {
//            answer[i]= sortedList.get(i).getKey();
//        }
        return answer;
    }
}
