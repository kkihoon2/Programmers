import java.security.Key;
import java.util.*;

public class No92334 {//step1.신고 결과 받기

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2)));
    }
    public static int[] solution(String[] id_list, String[] report, int k) {
        Map<String, List<String>> totList = new HashMap<>();
        Map<String, Integer>banList = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            totList.put(id_list[i], null);
        }
        //누가 누구들 신고?
        for (int i = 0; i < report.length; i++) {
            String[] repSplit = report[i].split(" ");
            if (totList.get(repSplit[0]) != null) {
                List<String> tempList = totList.get(repSplit[0]);
                tempList.add(repSplit[1]);
                totList.put(repSplit[0], tempList);
            } else {
                totList.put(repSplit[0], new ArrayList<>(Arrays.asList(repSplit[1])));
            }
        }
        //신고한것들 unique하게
        for (String key : totList.keySet()) {
            if (totList.get(key) != null) {
                List<String> tempList = totList.get(key);
                List<String> uniqueList = new ArrayList<>(new HashSet<>(tempList));
                totList.put(key, uniqueList);
            }
        }

        for(String key:totList.keySet()){
            if(totList.get(key)!=null)
            {List<String>tempList=totList.get(key);
            for (int i = 0; i < tempList.size(); i++) {
                if(!banList.containsKey(tempList.get(i))&&banList.get(tempList.get(i))==null) banList.put(tempList.get(i),1);
                else if(banList.containsKey(tempList.get(i))){
                    int tempInt = banList.get(tempList.get(i))+1;
                    banList.put(tempList.get(i),tempInt);
                }
            }}
        }


        int[]answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            int count = 0;
            List<String> reportList = totList.get(id);
            if (reportList != null) {
                for (String r : reportList) {
                    if (banList.containsKey(r) && banList.get(r) >= k) {
                        count++;
                    }
                }
            }
            answer[i] = count;
        }
        return answer;
        //        for(String key:banList.keySet()){
//            if(banList.get(key)>=k){
//                for (String key2:totList.keySet()) {
//                    if(totList.get(key2).contains(banList.get(key))){
//
//                    }
//                }
//            }
//        }
    }
}
