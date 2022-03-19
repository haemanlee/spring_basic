package hello.hellospring.hello.zip;

import java.util.*;

public class Report {
    public static void main(String[] args) {

        String[] id_list = new String[]{"muzi", "frodo", "apeach", "neo"};
        String[] reports = new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};

        Map<String, Integer> reportMap = new HashMap<>();
        for (String id : id_list) {
            reportMap.put(id, 0);
        }

        Set<String> duplicateCheckSet = new HashSet<>();
        for (String report : reports) {
            String[] splitedReport = report.split(" ");

            if(reportMap.containsKey(splitedReport[1])){
                if(!duplicateCheckSet.contains(report)){
                    reportMap.put(splitedReport[1], reportMap.getOrDefault(splitedReport[1],0) + 1);
                    duplicateCheckSet.add(report);
                }
            }

        }
        System.out.println(reportMap);

        Map<String,Integer> sendingCountMap = new HashMap<>();
        // 1.신고메일 횟수 처리
        System.out.println(sendingCountMap);


        // 2.처리메일 횟수 처리
        for (String checkSet : duplicateCheckSet) {
            String[] splitedReport = checkSet.split(" ");

            if(reportMap.get(splitedReport[1]) >= 2){
               sendingCountMap.put(splitedReport[0], sendingCountMap.getOrDefault(splitedReport[0],0) + 1);
            }
        }

        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            if(sendingCountMap.containsKey(id_list[i])) {
                answer[i] = sendingCountMap.get(id_list[i]);
            }
        }

        System.out.println(sendingCountMap);
        System.out.println(Arrays.toString(answer));

    }

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        return answer;
    }
}
