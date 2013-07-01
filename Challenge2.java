import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Tuenti Contest 2012. Challenge 2
 * 
 * @author Antonio Borrero Granell
 * 
 */
public class Challenge2 {

  // Store the results of the different inputs
	private static int[] results;


	public static long lower_power_of_two (long n) {
		int leadZ = Long.numberOfLeadingZeros(n);
		leadZ = leadZ + 1;
		int ones = 64 - leadZ;
		return (long) Math.pow((long) 2, (long) ones);
	}
	
	public static int calculate (long n) {
		long lower = lower_power_of_two(n);
		return Long.bitCount(lower - 1) + Long.bitCount(n - lower + 1);
	}

	public static void main(String[] args) throws IOException {

		
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String line;
		line = reader.readLine();
		int i;
		int times = Integer.parseInt(line);
		results = new int[times];
		for (i = 0; i < times; i++) {
			line = reader.readLine();
			results[i] = calculate(Long.parseLong(line));
		}
		for (i = 0; i < times; i++)
			System.out.println("Case #" + (i + 1) + ": " + results[i]);
	}

}
