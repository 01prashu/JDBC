import java.util.*;

class Solution {
    public int maxBananasEaten(int[] bananas, int[] days) {
        int n = bananas.length;
        List<int[]> ripeningList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ripeningList.add(new int[]{days[i], bananas[i]});
        }
        Collections.sort(ripeningList, (a, b) -> Integer.compare(a[0], b[0])); // Sort in ascending order of ripening days

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int totalBananas = 0;

        for (int[] ripening : ripeningList) {
            int duration = ripening[0];
            int quantity = ripening[1];
            pq.offer(quantity);
            if (pq.size() > duration) {
                totalBananas += pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            totalBananas += pq.poll();
        }

        return totalBananas;
    }

    public static void main(String[] args) {
        int[] bananas = {3 , 0 , 0, 0 , 0 , 2};
        int[] days = {3,0 , 0 , 0 , 0 , 2};
        Solution solution = new Solution();
        int result = solution.maxBananasEaten(bananas, days);
        System.out.println("Maximum bananas eaten: " + result); // Expected output: 7
    }
}
