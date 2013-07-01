import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Tuenti Contest 2012. Challenge 1
 * 
 * @author Antonio Borrero Granell
 * 
 */
public class Challenge1 {
  

	//Characters of each button
	private char[] b1 = { ' ', '1' };
	private char[] b2 = { 'a', 'b', 'c', '2' };
	private char[] b3 = { 'd', 'e', 'f', '3' };
	private char[] b4 = { 'g', 'h', 'i', '4' };
	private char[] b5 = { 'j', 'k', 'l', '5' };
	private char[] b6 = { 'm', 'n', 'o', '6' };
	private char[] b7 = { 'p', 'q', 'r', 's', '7' };
	private char[] b8 = { 't', 'u', 'v', '8' };
	private char[] b9 = { 'w', 'x', 'y', 'z', '9' };
	//Index i (row), and index j (column)
	private int posi, posj;
	//Elapsed time for writing the line
	private long time;
	//True if caps lock, false otherwise
	private boolean caps;

	/**
	 * Keypad Constructor 
	 * - Initial position: [3,1] (Button 0) 
	 * - Capital Letters: false 
	 * - Initial time: 0
	 */
	public Challenge1() {
		time = 0;
		caps = false;
		posi = 3;
		posj = 1;
	}

	/**
	 * Resets attributes to default
	 */
	public void reset() {
		time = 0;
		caps = false;
		posi = 3;
		posj = 1;
	}

	/**
	 * Move the finger one position up
	 */
	private void up() {
		if (posi - 1 >= 0) {
			posi--;
			time += 300;
		}

	}

	/**
	 * Move the finger one position up and one position right
	 */
	private void upR() {
		if (posi - 1 >= 0 && posj + 1 <= 2) {
			posi--;
			posj++;
			time += 350;
		}
	}

	/**
	 * Move the finger one position right
	 */
	private void right() {
		if (posj + 1 <= 2) {
			posj++;
			time += 200;
		}

	}

	/**
	 * Move the finger one position down and one position right
	 */
	private void downR() {
		if (posi + 1 <= 3 && posj + 1 <= 2) {
			posi++;
			posj++;
			time += 350;
		}
	}

	/**
	 * Move the finger one position down
	 */
	private void down() {
		if (posi + 1 <= 3) {
			posi++;
			time += 300;
		}
	}

	/**
	 * Move the finger one position down and one position left
	 */
	private void downL() {
		if (posi + 1 <= 3 && posj - 1 >= 0) {
			posi++;
			posj--;
			time += 350;
		}
	}

	/**
	 * Move the finger one position left
	 */
	private void left() {
		if (posj - 1 >= 0) {
			posj--;
			time += 200;
		}

	}

	/**
	 * Move the finger one position up and one position left
	 */
	private void upL() {
		if (posi - 1 >= 0 && posj - 1 >= 0) {
			posi--;
			posj--;
			time += 350;

		}
	}

	/**
	 * Press the button located in the actual position
	 */
	private void press() {
		time += 100;
		if (posi == 3 && posj == 2)
			caps = !caps;
	}

	/**
	 * @param s The string that is going to be processed
	 * @return The needed time to write the String s
	 */
	public long calculate(String s) {
		char c;
		for (int k = 0; k < s.length(); k++) {
			c = s.charAt(k);;
			nextChar(c);
		}
		return time;
	}

	/**
	 * This function process the next character we have to write
	 * 
	 * @param c char to process
	 */
	/**
	 * @param c
	 */
	private void nextChar(char c) {
		char ch;
		int k;
		//Check if Caps Lock is set in the right state, if don't, it changes it
		if ((Character.isUpperCase(c) && !caps)
				|| (Character.isLowerCase(c) && caps)) {
			move(3, 2);
			press();
		}
		//Select the next position, and press the button the right number of times
		switch (ch = Character.toLowerCase(c)) {
		case ' ':
		case '1':
			move(0, 0);
			k = 0;
			while (b1[k] != ch) {
				press();
				k++;
			}
			press();
			break;
		case 'a':
		case 'b':
		case 'c':
		case '2':
			move(0, 1);
			k = 0;
			while (b2[k] != ch) {
				press();
				k++;
			}
			press();
			break;
		case 'd':
		case 'e':
		case 'f':
		case '3':
			move(0, 2);
			k = 0;
			while (b3[k] != ch) {
				press();
				k++;
			}
			press();
			break;
		case 'g':
		case 'h':
		case 'i':
		case '4':
			move(1, 0);
			k = 0;
			while (b4[k] != ch) {
				press();
				k++;
			}
			press();
			break;
		case 'j':
		case 'k':
		case 'l':
		case '5':
			move(1, 1);
			k = 0;
			while (b5[k] != ch) {
				press();
				k++;
			}
			press();
			break;
		case 'm':
		case 'n':
		case 'o':
		case '6':
			move(1, 2);
			k = 0;
			while (b6[k] != ch) {
				press();
				k++;
			}
			press();
			break;
		case 'p':
		case 'q':
		case 'r':
		case 's':
		case '7':
			move(2, 0);
			k = 0;
			while (b7[k] != ch) {
				press();
				k++;
			}
			press();
			break;
		case 't':
		case 'u':
		case 'v':
		case '8':
			move(2, 1);
			k = 0;
			while (b8[k] != ch) {
				press();
				k++;
			}
			press();
			break;
		case 'x':
		case 'y':
		case 'z':
		case 'w':
		case '9':
			move(2, 2);
			k = 0;
			while (b9[k] != ch) {
				press();
				k++;
			}
			press();
			break;
		case '0':
			move(3, 1);
			press();
			break;

		}

	}



	/**
	 * This function add 500ms to the elapsed time. The user had to wait 500ms
	 * because the next character is located in the same button as the previous
	 * one
	 */
	private void wait500() {
		time += 500;
	}

	/**
	 * This function moves the finger from the actual position
	 *  to the position [nexti, nextj]
	 * @param nexti next position of index i (row)
	 * @param nextj next position of index j (column)
	 */
	private void move(int nexti, int nextj) {
		if (nexti == posi && nextj == posj)
			wait500();
		int disti;
		int distj;
		//Select the right movement in each different case
		while (nexti != posi || nextj != posj) {
			disti = posi - nexti;
			distj = posj - nextj;
			if (disti > 0) {
				if (distj > 0)
					upL();
				else if (distj < 0)
					upR();
				else
					up();
			} else if (disti < 0) {
				if (distj > 0)
					downL();
				else if (distj < 0)
					downR();
				else
					down();
			} else {
				if (distj > 0)
					left();
				else if (distj < 0)
					right();

			}

		}
	}
	

	
	public static void main (String args[]) throws IOException{
		//Keypad
		Challenge1 keypad = new Challenge1();
		//Array with the times of each line. Time of line i in position i
		long[] times;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line;
		line = reader.readLine();
		int i;
		int max = Integer.parseInt(line);
		times = new long[max];
		for (i = 0; i < max; i++){
			line = reader.readLine();
			keypad.reset();
			times[i] = keypad.calculate(line);
		}
		for (i = 0; i < max; i++)
			System.out.println(times[i]);


	}

}
