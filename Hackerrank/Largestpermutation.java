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

class Result {

    /*
     * Complete the 'largestPermutation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY arr
     */

  public static List<Integer> largestPermutation(int k, List<Integer> arr) {
        if(arr.size() == 1) return arr; //no permutations possible
        
=        Map<Integer, Integer> valMap = new HashMap<>();
        for(int i = 0; i < arr.size(); i++) valMap.put(arr.get(i), i);
        
=        int max = arr.size(), j = 0;
        
        while(j < arr.size() && k > 0){
            if(arr.get(j) != max){
                int temp = arr.get(j);
                arr.set(j, max);
                arr.set(valMap.get(max), temp);
                valMap.put(temp, valMap.get(max));
                k--;
            }
            max--;
            j++;
        }
        return arr;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.largestPermutation(k, arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
