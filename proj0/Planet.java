public class Planet {
	/** instance variables*/
	double xxPos;
	double yyPos;
	double xxVel;
	double yyVel;
	double mass;
	String imgFileName;

	/**First constructor
	* @param 
	*/
	public Planet(double xP, double yP, double xV, double yV, double m, String img){
		xxPos=xP;
		yyPos=yP;
		xxVel=xV;
		yyVel=yV;
		mass=m;
		imgFileName=img;
	}

	public Planet(Planet p){
		xxPos=p.xxPos;
		yyPos=p.yyPos;
		xxVel=p.xxVel;
		yyVel=p.yyVel;
		mass=p.mass;
		imgFileName=p.imgFileName;
	}

	public double calcDistance(Planet forceExertingPlanet){

		double distance = Math.hypot((forceExertingPlanet.xxPos-this.xxPos), (forceExertingPlanet.yyPos-this.yyPos));
		return distance;
	}


	public double calcForceExertedBy(Planet forceExertingPlanet){
		double force, distance;
		distance=this.calcDistance(forceExertingPlanet);
		force = 6.67408e-11*(forceExertingPlanet.mass)*(this.mass)/(distance*distance);
		return force;

	}

	public double calcForceExertedByX(Planet[] forceExertingPlanets){
		double 	totalForce,
				forceX=0,
				distance;

		for(Planet currentPlanet:forceExertingPlanets){
			if(!currentPlanet.equals(this)){
				totalForce=this.calcForceExertedBy(currentPlanet);
				distance=this.calcDistance(currentPlanet);
				forceX+=totalForce*(currentPlanet.xxPos-this.xxPos)/distance;
			}

		}

		return forceX;

	}

	public double calcForceExertedByY(Planet[] forceExertingPlanets){
		double 	totalForce,
				forceY=0,
				distance;

		for(Planet currentPlanet:forceExertingPlanets){
			if(!currentPlanet.equals(this)){
				totalForce=this.calcForceExertedBy(currentPlanet);
				distance=this.calcDistance(currentPlanet);
				forceY+=totalForce*(currentPlanet.xxPos-this.xxPos)/distance;
			}

		}

		return forceY;
	}


	public void update(double time, double xForce, double yForce){
		double 	xAccel,
				yAccel;

		xAccel=xForce/this.mass;
		yAccel=yForce/this.mass;
		this.xxVel+=xAccel*time;
		this.yyVel+=yAccel*time;
		this.xxPos+=time*this.xxVel;
		this.yyPos+=time*this.yyVel;

	}

	public void draw(){
		StdDraw.picture(this.xxPos, this.yyPos, "./images/"+this.imgFileName);
	}



}
