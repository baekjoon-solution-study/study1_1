import java.io.*;
import java.util.*;

/**
 * Class 없이 풀다가 너무 복잡해서 오래걸림. Class 구현하며 해결
 * 출력에 관해 문제 설명이 불친절해서 로직보다 출력에 시간을 많이 할애함.
 */

public class Main {

    static int max;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int playerNum = Integer.parseInt(st.nextToken());
        max = Integer.parseInt(st.nextToken());

        ArrayList<Room> rooms = new ArrayList<>();

        for (int i = 0; i < playerNum; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int level =  Integer.parseInt(st1.nextToken());
            String name =  st1.nextToken();
            Player player = new Player(name, level);

            boolean isFound = false;
            for (int j = 0; j < rooms.size(); j++) {
                Room room = rooms.get(j);
                if (room.players.isEmpty() == false && room.isMax() == false) {
                    Player king = room.players.get(0);
                    int maxLevel = Math.min(king.level + 10, 500);
                    int minLevel = Math.max(king.level - 10, 1);
                    if (level >= minLevel && level <= maxLevel) {  // 입력받은 player 가 방장의 레벨 범위에 있어야함
                        room.addPlayer(player);
                        isFound = true;
                        break;
                    }
                }
            }
            if (!isFound) {
                Room room = new Room();
                room.addPlayer(player);
                rooms.add(room);
            }
        }
        for (Room room : rooms) {
            room.print();
        }

        if (sb.length() > 0) {
            sb.delete(sb.length() - 1, sb.length());
        }
        bw.write(sb.toString());
        bw.flush();


    }
    public static class Room {
        List<Player> players = new ArrayList<>();
        public Room() {
        }
        public void addPlayer(Player player) {
            players.add(player);
        }
        public boolean isMax() {
            if (players.size() >= max) {
                return true;
            }
            return false;
        }
        public void print() {
            if (isMax()) {
                sb.append("Started!").append("\n");
            }
            else {
                sb.append("Waiting!").append("\n");
            }

            players.sort((o1, o2) -> o1.name.compareTo(o2.name));
            for (Player p : players) {
                sb.append(p.level).append(" ").append(p.name).append("\n");
            }
        }
    }

    public static class Player {
        String name;
        int level;
        public Player(String name, int level) {
            this.name = name;
            this.level = level;
        }
    }

}