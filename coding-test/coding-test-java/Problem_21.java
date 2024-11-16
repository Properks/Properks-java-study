import util.PrintUtil;

import java.util.*;

// 오픈 채팅방
// 채팅방 들어오는 것 기록하기
public class Problem_21 {
    public static void main(String[] args) {
        String[] input = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};

        String[] result1 = solution(input);
        String[] result2 = solutionWithQueue(input);

        PrintUtil.printStringArray(result1);
        PrintUtil.printStringArray(result2);
    }

    // list 두번 사용
    // 책에서는 map에 미리 uid 관련 Enter와 Change만 다 처리하여 uid와 username을 매핑하고 명령어를 순서대로 넣음 -> list 한번 사용
    public static String[] solution(String[] record) {
        Map<String, String> users = new HashMap<>();
        List<String> action = new ArrayList();
        for (String string: record) {
            String[] command = string.split(" ");
            if (command[0].equals("Enter")) {
                String uid = command[1].substring(3);
                String nickname = command[2];
                users.put(uid, nickname);
                action.add(uid + "님이 들어왔습니다.");
            }
            else if (command[0].equals("Leave")) {
                String uid = command[1].substring(3);
                action.add(uid + "님이 나갔습니다.");
            }
            else if (command[0].equals("Change")) {
                String uid = command[1].substring(3);
                String nickname = command[2];
                users.put(uid, nickname);
            }
        }
        List<String> result = new ArrayList<>();
        action.stream().forEach(string -> {
            String uid = string.substring(0, string.indexOf("님"));
            result.add(string.replace(uid, users.get(uid)));
        });

        return result.toArray(String[]::new);
    }

    // queue 사용
    public static String[] solutionWithQueue(String[] record) {
        Map<String, String> users = new HashMap<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (String string: record) {
            String[] command = string.split(" ");
            if (command[0].equals("Enter")) {
                String uid = command[1].substring(3);
                String nickname = command[2];
                users.put(uid, nickname);
                queue.addLast(uid + "님이 들어왔습니다.");
            }
            else if (command[0].equals("Leave")) {
                String uid = command[1].substring(3);
                queue.addLast(uid + "님이 나갔습니다.");
            }
            else if (command[0].equals("Change")) {
                String uid = command[1].substring(3);
                String nickname = command[2];
                users.put(uid, nickname);
            }
        }
        for (int i = 0; i < queue.size(); i++) {
            String string = queue.pollFirst();
            String uid = string.substring(0, string.indexOf("님"));
            queue.addLast(string.replace(uid, users.get(uid)));
        }
        return queue.toArray(String[]::new);
    }

    // 재풀이
    public String[] solution1(String[] record) {
        Map<String, String> name = new HashMap<>();
        List<String> orders = new ArrayList<>();
        for (String oper : record) {
            String[] operation = oper.split(" ");
            if (operation[0].equals("Enter")) {
                name.put(operation[1], operation[2]);
                orders.add(operation[0] + " " + operation[1]);
            }
            else if (operation[0].equals("Leave")) {
                orders.add(operation[0] + " " + operation[1]);
            }
            else if (operation[0].equals("Change")) {
                name.put(operation[1], operation[2]);
            }
            else {

            }
        }

        List<String> answer = new ArrayList<>();
        for (String order : orders) {
            String[] operation = order.split(" ");
            StringBuilder sb = new StringBuilder();
            sb.append(name.get(operation[1]));
            if (operation[0].equals("Enter")) {
                sb.append("님이 들어왔습니다.");
            }
            else if (operation[0].equals("Leave")) {
                sb.append("님이 나갔습니다.");
            }
            answer.add(sb.toString());
        }
        return answer.stream().toArray(String[]::new);
    }
}
