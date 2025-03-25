import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Room> rooms = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();
            Player player = new Player(level, nickname);

            boolean flag = false;

            for (Room room : rooms) {
                if (room.players.size() >= m) {
                    continue;
                }
                if (!room.players.isEmpty() && room.players.get(0).level - 10 <= level &&
                room.players.get(0).level + 10 >= level) {
                    flag = true;
                    room.players.add(player);
                    break;
                }
            }

            if (!flag) {
                Room room = new Room();
                room.players.add(player);
                rooms.add(room);
            }
        }

        for (Room room : rooms) {
            room.players.sort((o1, o2) -> o1.nickname.compareTo(o2.nickname));
        }

        for (Room room : rooms) {
            if (room.players.size() == m) {
                sb.append("Started!").append("\n");
            }
            else sb.append("Waiting!").append("\n");

            for (Player player : room.players) {
                sb.append(player.level).append(" ").append(player.nickname).append("\n");
            }
        }

        System.out.println(sb);
    }

    static class Player {
        int level;
        String nickname;

        public Player(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }
    }

    static class Room {
        List<Player> players = new ArrayList<>();
    }

}
