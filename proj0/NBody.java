public class NBody {

	public static double readRadius(String fileDir){
		In inputStream= new In(fileDir);
		int numOfPlanets=inputStream.readInt();
		double radius=inputStream.readDouble();
		return radius;
	}

	public static int readNumOfPlanets(String fileDir){
		In inputStream= new In(fileDir);
		int numOfPlanets=inputStream.readInt();
		return numOfPlanets;
	}

	public static Planet[] readPlanets(String fileDir){
		In inputStream= new In(fileDir);
		int numOfPlanets=inputStream.readInt();
		double radius=inputStream.readDouble();	

		Planet[] outPutPlanets= new Planet[numOfPlanets];

		for(int counter=0;counter<numOfPlanets;counter++){
			double xxPos=inputStream.readDouble();
			double yyPos=inputStream.readDouble();
			double xxVel=inputStream.readDouble();
			double yyVel=inputStream.readDouble();
			double mass=inputStream.readDouble();
			String imgFileName=inputStream.readString();
			outPutPlanets[counter]=new Planet(xxPos,yyPos,xxVel,yyVel,mass,imgFileName);
		}

		return outPutPlanets;

	}


	//**recursion method
	/* First step is the base case
	/* Second step is the recursion step
	*/
	public int size(){
		if(this.rest==null){
			return 1;
		}else{
			return 1+this.rest.size();
		}

	}

	/** Interative step
	*
	*
	*/
	public int interativeSize(){
		int counter=1;
		IntList currentList=this;
		while(currentList.rest!=null){
			counter++;
			currentList=currentList.rest;
		}

		return counter;

	}


	/**recursive
	*
	*/

	public int get(int i){
		if(i==1){
			return this.first;
		}

		i--;
		if(this.rest!=null){
			return this.rest.get(i);
		}else{
			System.out.prinln("the index given is out of the bound");
			return 0;
		}


	}

	/**
	*Iterative method
	*/
	public int get(int i){
		IntList currentList=this;
		while(i>1){
			i--;
			if(currentList.rest!=null){
				currentList=currentList.rest;

			}else{
				System.out.println("index exeeds the bound");
				return 0;
			}
		}
		return currentList.first;

	}



	public static void main(String[] args){
		double T=Double.parseDouble(args[0]);
		double dt=Double.parseDouble(args[1]);
		String filename=args[2];
		int numOfPlanets=NBody.readNumOfPlanets(filename);
		Planet[] allPlanets= NBody.readPlanets(filename);
		double radius=NBody.readRadius(filename);



		double[] xForces= new double[numOfPlanets];
		double[] yForces=new double[numOfPlanets];

		double currentTime=0;
		StdAudio.play("./audio/2001.mid");
		
		while(currentTime<T){

			for(int counter=0;counter<numOfPlanets;counter++){
				xForces[counter]=allPlanets[counter].calcForceExertedByX(allPlanets);
				yForces[counter]=allPlanets[counter].calcForceExertedByY(allPlanets);
			}

			for(int counter=0;counter<numOfPlanets;counter++){
				allPlanets[counter].update(dt, xForces[counter], yForces[counter]);
			}

			StdDraw.clear();
			StdDraw.setScale(-radius, radius);
			StdDraw.picture(0, 0, "./images/starfield.jpg");
			
			for(int counter=0;counter<numOfPlanets;counter++){
				allPlanets[counter].draw();
			}

			StdDraw.show(10);	
			currentTime+=dt;
		}




	}

}
