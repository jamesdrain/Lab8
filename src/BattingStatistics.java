import java.util.Scanner;

public class BattingStatistics {

	public static void main(String[] args) {

		System.out.println("Welcome to batting average calculator!!");

		Scanner scnr = new Scanner(System.in);
		String cont = "y";
		int atBats;
		int result;
		int hits = 0;
		int bases = 0;

		while (cont.equalsIgnoreCase("y")) {

			System.out.println("How many at-bats did the player have? ");
			atBats = scnr.nextInt();
			
			// ask for input
			
			if (atBats < 1) {
				System.out.println("Only positive numbers please.");
				continue;
			}
			int[] resultArr = new int[atBats];
			System.out.println("Ok, for batting results: " + "\n0=out, 1=single, 2=double, 3=triple, 4=home-run");
			for (int i = 0; i < resultArr.length; i++) {

				// input players results per at-bat
				
				System.out.println("Result for at-bat " + (i + 1) + ": ");
				result = scnr.nextInt();
				if (result < 0 || result > 4) {
					System.out.println("Only 0, 1, 2, 3, or 4 please.");
					i--;
					continue;
				}
				resultArr[i] = result;
				if (result > 0) {
					hits++;
					bases = bases + result;
				}
			}
			// averages calculated by comparing against array length

			double battingAvg = hits / (double) (resultArr.length);
			double sluggingAvg = bases / (double) (resultArr.length);

			// print results

			System.out.print("\nBatting Average: ");
			System.out.printf("%1$.3f", battingAvg);
			System.out.print("\nSlugging Percentage: ");
			System.out.printf("%1$.3f", sluggingAvg);
			System.out.println("\n");

			// body of code(calculations) ends

			System.out.println("Want to calculate averages for another player? y/n ");
			cont = scnr.next();
			while (!cont.equalsIgnoreCase("y") && !cont.equalsIgnoreCase("n")) {
				System.out.println("Enter \"y\" to continue or \"n\" to quit...");
				cont = scnr.next();
				continue;
			}

		}

		System.out.println("Ok, bye. ");
		scnr.close();

	} // end of main

}
