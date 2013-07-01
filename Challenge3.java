import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Tuenti Contest 2012. Challenge 3
 * @author Antonio Borrero Granell
 *
 */
public class Challenge3 {

  //Store the stock values 
	private static ArrayList<Integer> stock = new ArrayList<Integer>();

	public static void main(String args[]) throws IOException {

		Scanner reader = new Scanner(System.in);

		while (reader.hasNextInt()) {
			int i = reader.nextInt();
			stock.add(i);

		}
		
		//Actual Min value in stock
		int min = Integer.MAX_VALUE;
		//Actual Max difference between two values moments x and y. Y > X
		int maxDiff = 0;
		//Index of the min value that we choose as result
		int kmin = 0;
		//Index of the min value in the stock list
		int kmin2 = 0;
		//Index of the max value chosen as result
		int kmax = 1;
		//Auxiliar var to compare difference
		int diff;
		//Actual index in the stocklist
		int k = 0;
		for (int i : stock) {
			
			if (i < min) {
				min = i;
				kmin2 = k;
			}
			diff = i - min;
			if (diff > maxDiff) {
				kmax = k;
				maxDiff = diff;
				//if kmin2 is greater than kmax, it is not a possible result
				if (kmin2 > kmax)
					kmin2 = kmin;
				else
					kmin = kmin2;
			}

			k++;
		}

		System.out.println((kmin * 100) + " " + (kmax * 100) + " " + maxDiff);

	}

}
