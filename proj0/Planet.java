public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	private static final double G = 6.67e-11;

	public Planet(double xP, double yP, double xV, 
		          double yV, double m, String img) {
		this.xxPos = xP;
		this.yyPos = yP;
		this.xxVel = xV;
		this.yyVel = yV;
		this.mass = m;
		this.imgFileName = img;
	}

	public Planet(Planet p) {
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p) {
		double xDiff = p.xxPos - this.xxPos;
		double yDiff = p.yyPos - this.yyPos;
		double distance;

		distance = Math.sqrt(xDiff * xDiff + yDiff * yDiff);
		
		return distance;
	}

	public double calcForceExertedBy(Planet p) {
		double force;
		double distance = calcDistance(p);
		force = G * this.mass * p.mass / (distance * distance);
		return force;
	}

	public double calcForceExertedByX(Planet p) {
		double totalForce = calcForceExertedBy(p);
		double distance = calcDistance(p);
		double xDiff = p.xxPos - this.xxPos;
		
		double xForce;
		xForce = totalForce * xDiff / distance;

		return xForce;
	}

	public double calcForceExertedByY(Planet p) {
		double totalForce = calcForceExertedBy(p);
		double distance = calcDistance(p);
		double yDiff = p.yyPos - this.yyPos;
		
		double yForce;
		yForce = totalForce * yDiff / distance;

		return yForce;
	}

	public double calcNetForceExertedByX(Planet[] pList) {
		double xNetForce = 0;
		int i = 0;

		while (i < pList.length) {
			if (this.equals(pList[i])) {
				i += 1;
				continue;
			}

			xNetForce += calcForceExertedByX(pList[i]);
			i += 1;
		}
		return xNetForce;
	}

	public double calcNetForceExertedByY(Planet[] pList) {
		double yNetForce = 0;
		int i = 0;

		while (i < pList.length) {
			if (this.equals(pList[i])) {
				i += 1;
				continue;
			}

			yNetForce += calcForceExertedByY(pList[i]);
			i += 1;
		}
		return yNetForce;
	}

	public void update(double dt, double fX, double fY) {
		double aX = fX / this.mass;
		double aY = fY / this.mass;

		this.xxVel += aX * dt;
		this.yyVel += aY * dt;

		this.xxPos += this.xxVel * dt;
		this.yyPos += this.yyVel * dt;
	}

	public void draw() {
		StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
	}
}