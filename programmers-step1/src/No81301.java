import java.util.HashMap;
import java.util.Map;
import java.util.*;
public class No81301 {
    public int solution(String s) {
//        s=s.replace("one","1");
//        s=s.replace("two","2");
//        s=s.replace("three","3");
//        s=s.replace("four","4");
//        s=s.replace("five","5");
//        s=s.replace("six","6");
//        s=s.replace("seven","7");
//        s=s.replace("eight","8");
//        s=s.replace("nine","9");
//        //런타임에러
        Map<String,String>alpToNum=new HashMap<>();
        alpToNum.put("zero","0");
        alpToNum.put("one","1");
        alpToNum.put("two","2");
        alpToNum.put("three","3");
        alpToNum.put("four","4");
        alpToNum.put("five","5");
        alpToNum.put("six","6");
        alpToNum.put("seven","7");
        alpToNum.put("eight","8");
        alpToNum.put("nine","9");
        // 영어단어를 숫자로 변경
        for (String eng : alpToNum.keySet()) {
            s = s.replace(eng, String.valueOf(alpToNum.get(eng)));
        }

        return Integer.parseInt(s);

    }
}
