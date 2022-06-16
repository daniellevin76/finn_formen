import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DistanceCalculator {

    private ArrayList<double []> points;

    public DistanceCalculator(ArrayList<double[]> points) {
        this.points = points;
    }


    private void helper(List<int[]> combinations, int data[], int start, int end, int index) {
        if (index == data.length) {
            int[] combination = data.clone();
            combinations.add(combination);
        } else if (start <= end) {
            data[index] = start;
            helper(combinations, data, start + 1, end, index + 1);
            helper(combinations, data, start + 1, end, index);
        }
    }
    public List<int[]> generate(int n, int r) {
        List<int[]> combinations = new ArrayList<>();
        helper(combinations, new int[r], 0, n-1, 0);
        return combinations;
    }

    double[] calculateDistanceBetweenPoints(ArrayList<double[]> points) {


     //   Set<Set<Integer>> combinations = Sets.combinations(ImmutableSet.of(0, 1, 2, 3, 4, 5), 3);


        int N = 4;
        int r = 2;
        List<Double> distances = new ArrayList<>();
        List<int[]> combinations = generate(N, r);

        System.out.println(combinations.get(0));
        for (int[] combination : combinations) {
            for (int i = 0; i < points.get(0).length-1; i++) {
                double diffPowers = Math.pow(points.get(combination[0])[i] - points.get(combination[1])[i], 2);
                distances.add(Math.sqrt(Math.abs(diffPowers)));
            }


        }
        System.out.println("distances" + distances);
        return new double[0];
    }



}
