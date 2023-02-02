public class Main {
    public static void main(String[] args) {
        Solution k = new Solution();
        System.out.println(k.solution(new int[]{1,1,1,1,1},3));
    }
}

class Solution {
    static int answer = 0 ;
    public int solution(int[] numbers, int target) {

        dfs(numbers,target,0,0);
        return answer;
    }
    public void dfs(int[] numbers,int target,int now,int tot){
        if(now==numbers.length)
        {
            if(tot==target){
                answer++;
            }
        }else{
            int temp = tot+numbers[now];
            int next = now+1;
            dfs(numbers,target,next,temp);
            int temp2 = tot-numbers[now];
            dfs(numbers,target,next,temp2);
        }
    }
}