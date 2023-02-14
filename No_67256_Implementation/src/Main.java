public class Main {
    public static void main(String[] args) {
        Solution k = new Solution();
        System.out.println(k.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5},"right"));
    }
}
class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int leftNow = 10;
        int rightNow = 12;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i]==1||numbers[i]==4||numbers[i]==7)
            {
                answer = answer + "L";
                leftNow =numbers[i];
            }else if(numbers[i]==3||numbers[i]==6||numbers[i]==9)
            {
                answer = answer + "R";
                rightNow =numbers[i];
            }else
            {
                if(numbers[i]==0)
                {
                    numbers[i]=11;
                }
                int leftDistance = Math.abs(numbers[i]-leftNow)/3+Math.abs(numbers[i]-leftNow)%3;
                int rightDistance = Math.abs(numbers[i]-rightNow)/3+Math.abs(numbers[i]-rightNow)%3;
                if(leftDistance==rightDistance){
                    if(hand.equals("right"))
                    {
                        answer = answer + "R";
                        rightNow = numbers[i];
                    }else {
                        answer = answer + "L";
                        leftNow = numbers[i] ;
                    }
                }else {
                    if(rightDistance>leftDistance){
                        answer = answer + "L";
                        leftNow = numbers[i] ;
                    }else {
                        answer = answer+"R";
                        rightNow = numbers[i];
                    }
                }

            }
        }
        return answer;
    }
}