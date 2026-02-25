import java.util.LinkedHashMap;
import java.util.Map;
import java.util.random.RandomGenerator;

public class frequency {

    public static int[] generate(int start, int end, int sz) {
        RandomGenerator generator = RandomGenerator.getDefault();
        int[] numbers = new int[sz];

        for (int i = 0; i < sz; ++i)
            numbers[i] = generator.nextInt(start, end);

        return numbers;
    }

    public static void printArray(int[] numbers) {
        for (int n : numbers) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    // Method to count frequency passing though the array.
    public static LinkedHashMap<Integer, Integer> countFrequency(int[] numbers) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        for (int num : numbers) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        return map;// it will display the numbers and their frquency in the order
    }

    // this for calculating the mean using the frequency map
    // in mathematics mean = (x1*f1 + x2*f2 + ... + xn*fn) / N.... if x is accuring more than once
    public static double calculate_mean(int[] numbers){
        LinkedHashMap<Integer, Integer> map = countFrequency(numbers);
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            sum += entry.getKey() * entry.getValue();
        }
        return (double) sum / numbers.length;
    }

    // this for calculating the standard deviation using the frequency map
    public static double calculate_std(int[] numbers){
        LinkedHashMap<Integer,Integer> map = countFrequency(numbers);
        double mean = calculate_mean(numbers);
        double sum = 0;
        for (Map.Entry<Integer, Integer> entry :map.entrySet()) {
            sum += entry.getValue() * Math.pow(entry.getKey() - mean, 2);
        }
        return Math.sqrt(sum / numbers.length);
    }
    
    // this for calculating the variance using the frequency map
    public static double calculate_variance(int[] numbers){
        LinkedHashMap<Integer,Integer> map = countFrequency(numbers);
        double mean = calculate_mean(numbers);
        double sum = 0;
        for (Map.Entry<Integer, Integer> entry :map.entrySet()) {
            sum += entry.getValue() * Math.pow(entry.getKey() - mean, 2);
        }
        return sum / numbers.length;
    }
    // this for calculating the median value using the frequency map
    public static double calculate_median(int[] numbers){
        int totalCount = numbers.length;
        int middleIndex = totalCount / 2;
        if (middleIndex % 2 == 0){
            return (double) (numbers[middleIndex] + numbers[middleIndex+ 1]) / 2;
        } else {
            return numbers[middleIndex];
        }
    } 

    // for finding the highest frequency value in the array using the frequency map 
    public static void highest_frequency(int[] numbers){
        LinkedHashMap<Integer,Integer> map = countFrequency(numbers);

        int maxkey = 0;
        int maxvalue = 0; 

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){ 
            if (entry.getValue() > maxvalue){
                maxvalue = entry.getValue();
                maxkey = entry.getKey();
            }
        }

        System.out.println("\nHighest frequency:"  +maxkey+" = "+maxvalue);
    }
    // Here we display what we have written above 😀some calculations.
    public static void main(String[] args) {
        int[] numbers = generate(1, 20, 30);

        System.out.println("Generated Numbers:");
        printArray(numbers);

        LinkedHashMap<Integer, Integer> map = countFrequency(numbers);
        System.out.println("\nFrequencies:");
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "= " + entry.getValue());
        }
        // Displaying the mean, standard deviation, variance and median value.
        System.out.print("\nthe mean is: " + calculate_mean(numbers));
        System.out.print("\nthe standard deviation is: " + calculate_std(numbers));
        System.out.print("\nthe variance: " + calculate_variance(numbers));
        System.out.print("\nthe median value is: " + calculate_median(numbers));

        highest_frequency(numbers);

    }
}
