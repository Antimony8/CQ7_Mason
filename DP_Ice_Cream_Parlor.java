import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import  javafx.util.Pair;

class Result {

    public static Integer icecreamParlor(int m, List<Integer> arr) {
        int n = arr.size();
        int[][] dp = new int[n + 1][m + 1];

        // Base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // Fill the array using the recursive formula
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= arr.get(i - 1)) {
                    dp[i][j] += dp[i - 1][j - arr.get(i - 1)];
                }
            }
        }
        return dp[n][m];
    }
}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int m = Integer.parseInt(bufferedReader.readLine().trim());

                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                Integer result = Result.icecreamParlor(m, arr);
                bufferedWriter.write(result.toString() + "\n");
                
                // bufferedWriter.write(
                //     result.stream()
                //         .map(Object::toString)
                //         .collect(joining(" "))
                //     + "\n"
                // );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
