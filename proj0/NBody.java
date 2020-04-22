public class NBody {
	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];

		double radiusUniverse = readRadius(filename);
		Planet[] planets = readPlanets(filename);

		/* Set the scale */
		StdDraw.setScale(-1 * radiusUniverse, radiusUniverse);

		/* Draw the background */
		StdDraw.picture(0, 0, "images/starfield.jpg");
		// StdDraw.show();

		/* Play the background music*/
		StdAudio.play("audio/2001.mid");

		for(int i = 0; i < planets.length; i++) {
			planets[i].draw();
		}

		StdDraw.show();
		
		StdDraw.enableDoubleBuffering();

		for(int t = 0; t < T; t += dt) {
			double[] xForces = new double[planets.length];
			double[] yForces = new double[planets.length];

			/*Loop over all planets*/
			for(int i = 0; i < planets.length; i++) {
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}

			/*Update all planets*/
			for(int i = 0; i < planets.length; i++) {
				planets[i].update(dt, xForces[i], yForces[i]);
			}

			StdDraw.picture(0, 0, "images/starfield.jpg");

			for(int i = 0; i < planets.length; i++) {
				planets[i].draw();
			}

			StdDraw.show();
		
			StdDraw.pause(10);
		}

		StdAudio.close();

		/* Print the universe */
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radiusUniverse);
		for(int i = 0; i < planets.length; i++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n", 
						  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
						  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
		}
	}

	public static double readRadius(String fileName) {
		In file = new In(fileName);

		int numberPlanets = file.readInt();
		double radius = file.readDouble();

		return radius;
	}

	public static Planet[] readPlanets(String fileName) {
		In file = new In(fileName);
		int numberPlanets = file.readInt();
		double radiusUniverse = file.readDouble();

		Planet[] planets = new Planet[numberPlanets];

		for (int i = 0; i < numberPlanets; i++) {
			double xPos = file.readDouble();
			double yPos = file.readDouble();
			double xVel = file.readDouble();
			double yVel = file.readDouble();
			double mass = file.readDouble();
			String imgFileName = file.readString();

			planets[i] = new Planet(xPos, yPos, xVel, yVel, mass, imgFileName);
		}

		return planets;
	}
}