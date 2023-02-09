
public class AlgProj1
{
   public static void main(String args[])
   {
      
      //Randomly defining the size of the matrices we create for testing speed.
      //Row and col size can range anywhere from 1-100. We can also hardcode m and n
      int m = (int)(Math.random() * 101);
      int n = (int)(Math.random() * 101);
      
      //Populating the matrices with random digits between 1-100
      int entries = (int)(Math.random() * 101);
      
      //this is how you test matrices of different sizes. You can change the 100s.
      int A[][] = makeMatrix(m, n);            
     
      //printing the matrix with nice spacing for organization
      for (int i = 0; i < m; i++){
         for (int j = 0; j < n; j++){
            System.out.printf("%5d", A[i][j]);
         }
         System.out.println();
      }
      
      //Randomly assigning a scalar to multiply the matrix by. Values range
      //from 1-100
      int b = (int)(Math.random() * 101);
      
      
      long w = scalarmatmult(b, A);  
      System.out.println(); 
      printMatrix(A);
      System.out.println();
      System.out.println("This took " + w + " nanoseconds to complete");
}
   
   public static int[][] makeMatrix(int m, int n) {
      int[][] A = new int[m][n];
      for (int i = 0; i < m; i++){
         for (int j = 0 ; j < n; j++){
            //populating each cell in the matrix w a random int
            int entries = (int)(Math.random() * 101);
            A[i][j] = entries;
         }
      }
      return A;

   }
   
   public static void printMatrix(int[][] matrix) {
         //printing the scaled matrix
      for (int i = 0; i < matrix.length; i++){
         for (int j = 0; j < matrix[0].length; j++){
            System.out.printf("%5d", matrix[i][j]);
         }
         System.out.println();
      }
   }
  
   
   static long scalarmatmult(int b, int A[][]){
   long startTime = System.nanoTime();
               for (int i = 0; i < A.length; i++){
             for(int j = 0; j < A[0].length; j++){
                 A[i][j] = A[i][j] * b;
             }
      
          }
      long endTime = System.nanoTime();
      long duration = (endTime - startTime);
      return duration;
      }
      
}
