
public class test {
	 
	public static void main(String[] args) {
		int array1[] = {1,2,3,4,5,6,7,8,9,10};
		Algorithm1 testObject = new Algorithm1(array1);
		int total = testObject.addElements(array1);
		System.out.println(total);
	}

}
