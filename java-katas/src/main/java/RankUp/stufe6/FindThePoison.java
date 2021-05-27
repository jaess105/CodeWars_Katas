import java.util.Arrays;
public class FindThePoison {

    public int find(int[] rats) {
      return Arrays.stream(rats)
        .map(x -> (int)Math.pow(2,x))
        .sum();
    }
}