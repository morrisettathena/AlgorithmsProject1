
public class Algorithm1 {


	public Algorithm1(){
		int[] userArray; 
	}
	
	 public Algorithm1(int[] a){
		 int[] userArray = a;
	}
	
	public long addElements(int[] userArray){
		long start = System.nanoTime();
		int total = 0;
		for(int i = 0; i <= userArray.length-1; i++ ) {
			 total += userArray[i];
		}
		long end = System.nanoTime();
		long time = start - end
		System.out.println("\n Time of the algorithm: " + time + " Nanoseconds");
		return total, ;
	}



	
	
	
	
	
	
	
	
	
	
	
	
}
