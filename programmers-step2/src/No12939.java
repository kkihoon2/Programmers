public class No12939 {
    public static void main(String[] args) {
        System.out.println(solution("-1 -2 -3 -4"));
    }
    public static String solution(String s) {
        String[] strings = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <strings.length ; i++) {
            int num = Integer.parseInt(strings[i]);
            if(num>max){
                max = num;
            }
            if(num<min){
                min = num;
            }
        }

        return min+" "+max;
    }
}
