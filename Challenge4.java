import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Tuenti Contest 2012. Challenge 4
 * 
 * @author Antonio Borrero Granell
 * 
 */
public class Challenge4 {

  /**
	 * @param K
	 *            number of karts
	 * @param R
	 *            number of races
	 * @param G
	 *            number of groups
	 * @param groups
	 *            array of G numbers, each of them is the size of each existing
	 *            group
	 * @return the total fuel needed for the day
	 */
	private static int calculate(int K, int R, int G, int[] groups) {
		// index of the next group
		int iGroup = 0;
		// number of karts available
		int kAv = K;
		// total of fuel we have to buy
		int fuel = 0;
		// first group in one race. We use it in order to not to repit one group
		// in the same race
		int aGroup;
		// we use it to calculate aGroup;
		int k = 0;
		for (int i = 0; i < R; i++) {
			aGroup = -1;
			k = 0;
			while (kAv >= groups[iGroup] && iGroup != aGroup) {
				if (k == 0)
					aGroup = iGroup;
				kAv -= groups[iGroup];
				iGroup++;
				iGroup = iGroup % G;
				k++;

			}

			fuel += K - kAv;
			kAv = K;

		}
		return fuel;
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String line;
		StringTokenizer st;
		int R, K, G;
		int times = Integer.parseInt(reader.readLine());
		int[] groups;
		for (int i = 0; i < times; i++) {
			line = reader.readLine();
			st = new StringTokenizer(line);
			R = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			G = Integer.parseInt(st.nextToken());
			groups = new int[G];
			line = reader.readLine();
			st = new StringTokenizer(line);
			for (int k = 0; k < G; k++)
				groups[k] = Integer.parseInt(st.nextToken());
			System.out.println(calculate(K, R, G, groups));
		}

	}
}
