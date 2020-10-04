import java.util.HashSet;
import java.util.Set;

public class Test1 {

    /**
     * 机器人
     * 理解转向的计算
     * 理解题解中对障碍物的编码
     * @param commands
     * @param obstacles
     * @return
     */
    public int robotSim(int[] commands, int[][] obstacles) {

        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int x = 0, y = 0, di = 0;
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }
        int ans = 0;

        for (int command : commands) {
            if (command == -2) {
                //turn left
                di = (di + 3) % 4;
            } else if (command == -1) {
                //true right
                di = (di + 1) % 4;
            } else {
                //go ahead
                for (int k = 0; k < command; k++) {
                    int nx = x + dx[di];
                    int ny = y + dy[di];
                    String code = nx + "," + ny;
                    if (!obstacleSet.contains(code)) {
                        x = nx;
                        y = ny;
                        ans = Math.max(ans, x * x + y * y);
                    } else {
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
