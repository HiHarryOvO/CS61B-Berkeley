public class TestPlanet {
	public static void main(String[] args) {
		testPlanet();
	}

	public static void testPlanet() {
		Planet p1 = new Planet(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
        Planet p2 = new Planet(2.0, 1.0, 3.0, 4.0, 4e11, "jupiter.gif");

        System.out.println("Verifying that forces exerted to each other (2 planets) are equal in amounts");

        double p1ExertedByP2 = p1.calcForceExertedBy(p2);
        double p2ExertedByP1 = p2.calcForceExertedBy(p1);

        if (p1ExertedByP2 - p2ExertedByP1 < 0.01 && p1ExertedByP2 - p2ExertedByP1 > -0.01) {
        	System.out.println("PASSED: forces exerted to each other (2 planets) are equal in amounts");
        }
	}
}