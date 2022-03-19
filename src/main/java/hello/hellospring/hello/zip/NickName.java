package hello.hellospring.hello.zip;

import java.util.*;

public class NickName {

    public static void main(String[] args) {
        String[] records = new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        // 유저 아이디와 닉네임의 길이는 1 이상 10 이하이다.
        System.out.println(records);
        // key value 형태로 id : nickname 만든다.
        Map<String,String> nameMap = new HashMap<>();
        for (String record : records) {
            String[] splitedRecord = record.split(" ");
            // 채팅방을 나간 후, 새로운 닉네임으로 다시 들어간다.
            // 채팅방에서 닉네임을 변경한다.
            if("Enter".equals(splitedRecord[0]) || "Change".equals(splitedRecord[0])){
                if(!checkLength(splitedRecord[1]) || !checkLength(splitedRecord[2])){
                    throw new IllegalArgumentException("길이가 1이상 10이하여야 합니다.");
                }
                nameMap.put(splitedRecord[1], splitedRecord[2]);
            }
        }
        System.out.println(nameMap);

        //makeChatlog
        List<String> results = new ArrayList<>();
        for (String record : records) {
            String[] splitedRecord = record.split(" ");
            StringBuilder sb = new StringBuilder();
            if("Enter".equals(splitedRecord[0])){
                sb.append(nameMap.get(splitedRecord[1]));
                sb.append("님이 들어왔습니다.");
                results.add(sb.toString());
            }

            if("Leave".equals(splitedRecord[0])){
                sb.append(nameMap.get(splitedRecord[1]));
                sb.append("님이 나갔습니다.");
                results.add(sb.toString());
            }
        }
        String[] answer = new String[results.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = results.get(i);

        }
        System.out.println(Arrays.toString(answer));

//        enterChangeNick(record, nameMap);


    }

    private static void enterChangeNick(String[] record) {

    }

    private static boolean checkLength(String input){
        if (input.length() > 0 && input.length() <= 10){
            return true;
        } else {
            return false;
        }
    }
}
