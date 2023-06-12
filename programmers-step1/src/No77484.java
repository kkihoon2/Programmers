public class No77484 {
    public static void main(String[] args) {

        System.out.println();
    }
    class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            int zeroNum = 0;
            int equalNum = 0;
            int [] rank = new int[]{6,6,5,4,3,2,1};
            for(int i = 0 ; i<lottos.length;i++){
                if(lottos[i]==0)zeroNum++;
                for (int j = 0; j < win_nums.length; j++) {
                    if(win_nums[j]==lottos[i])equalNum++;
                }
            }
            return new int[]{rank[equalNum],rank[equalNum+zeroNum]};
        }
    }
}
