import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.reverseOrder;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(3,4,new int[]{1, 2, 3, 1, 2, 3, 1}));
        System.out.println(new Solution().solution(4,3,new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2}));
    }
}class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            if(score[i]<=k)
                list.add(score[i]);
        }
        Collections.sort(list);
        Collections.reverse(list);
        int [] temp = new int[m];
        int cnt = 0;
        for(int i = 0;i< list.size();i++){
            temp[cnt++]=list.get(i);

            if(cnt==m){
                answer=answer+m*temp[m-1];
                temp = new int[m];
                cnt=0;
            }
        }
        return answer;
    }
}