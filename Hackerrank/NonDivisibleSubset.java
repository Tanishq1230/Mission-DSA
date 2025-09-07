import java.io.*;
import java.util.*;

public class Solution {
    static int nonDivisibleSubset(int k, List<Integer> s) {
        int[] freq = new int[k];
        for (int num : s) {
            freq[num % k]++;
        }
        int count = 0;
        if (freq[0] > 0) {
            count++;
        }
        for (int i = 1; i <= k / 2; i++) {
            if (i == k - i) {
                count++;
            } else {
                count += Math.max(freq[i], freq[k - i]);
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int n = Integer.parseInt(firstMultipleInput[0]);
        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] sTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        List<Integer> s = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sItem = Integer.parseInt(sTemp[i]);
            s.add(sItem);
        }

        int result = nonDivisibleSubset(k, s);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
