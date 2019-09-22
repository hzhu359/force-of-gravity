public class FGsolver {
	public static void main(String[] args) {

		// Object 1 is acted on by Object 2
		double mass1 = 2*1.6e-19;
		double mass2 = 1.6e-19;

		double[] pos1 = new double[]{4.4e-9, 0, 3.8e-9};
		double[] pos2 = new double[]{0, 0, -3e-9};

		double deltaT = 1e6;
		final double G = 6.7e-11;

		// r = r1 - r2
		double[] r = new double[]{pos1[0] - pos2[0], pos1[1] - pos2[1], pos1[2] - pos2[2]};

		System.out.println("Here's the r vector!");
		for (int i = 0; i < 3; i++) {
			System.out.print(r[i] + ", ");
		}
		System.out.println();


		//calculating magR
		double magR = Math.sqrt(Math.pow(r[0], 2) + Math.pow(r[1], 2) + Math.pow(r[2], 2));
		//calculating magFg
		double magFg = Math.abs(G * mass1 * mass2 / (Math.pow(magR, 2)));
		//calculating rHat
		double[] rHat = new double[]{r[0]/magR, r[1]/magR, r[2]/magR};

		System.out.println("Here's magR!\n" + magR);

		//rHat
		System.out.println("Here's rHat!");
		for (int i = 0; i < 3; i++) {
			System.out.print(rHat[i] + ", ");
		}
		System.out.println();

		//magFg
		System.out.println("magFg = " + magFg);
		double[] fg = new double[] {-rHat[0] * magFg, -rHat[1] * magFg, -rHat[2] * magFg};

		//Fg
		System.out.println("Here's Fg!");
		for (int i = 0; i < 3; i++) {
			System.out.printf("%.4e   ",fg[i]);
		}
		System.out.println();

		//deltap
		double[] deltaP = new double[] {fg[0] * deltaT, fg[1] * deltaT, fg[2] * deltaT};
		System.out.println("Here's deltaP!");
		for (int i = 0; i < 3; i++) {
			System.out.printf("%.4e   ",deltaP[i]);
		}
		System.out.println();

		//deltaV
		double[] deltaV = new double[] {deltaP[0] / mass1, deltaP[1] / mass1, deltaP[2] / mass1};
		System.out.println("Here's deltaV!");
		for (int i = 0; i < 3; i++) {
			System.out.printf("%.4e   ",deltaV[i]);
		}
		System.out.println();

		//deltaR
		double[] deltaR = new double[] {deltaV[0] * deltaT, deltaV[1] * deltaT, deltaV[2] * deltaT};
		System.out.println("Here's deltaR!");
		for (int i = 0; i < 3; i++) {
			System.out.printf("%.4e   ",deltaR[i]);
		}
		System.out.println();
	}
}