package simulation;

import java.util.*;

public class Programmers_SQ_Truck {
    static int idx, curr, next, time;

    public int solution(int bridge, int weight, int[] tw) {
        Stack<Integer> trucks = new Stack<>();
        for (int i = tw.length - 1; i >= 0; i--)
            trucks.push(tw[i]);

        int cnt = 0;
        int[] time_remain = new int[tw.length];
        while (true) {

            time++;
            for (int i = 0; i < idx; i++) {
                if (--time_remain[i] == 0)
                    curr -= tw[i];
            }
            if (trucks.empty()) {
                if (time_remain[tw.length - 1] == 0)
                    break;
            } else {
                next = trucks.peek();
                if (curr + next <= weight) {
                    time_remain[idx++] = bridge;
                    curr += next;
                    trucks.pop();
                }
            }

            System.out.println(time + " " + curr);
        }

        return time;
    }

    public static void main(String[] args) {
        System.out.println(
                new Programmers_SQ_Truck().solution(100, 100, new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }));
    }
}
