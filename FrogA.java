
import java.util.Scanner;

/**
 * 
 * @author Malak Abdelkafy(4025357) Section H and Zineb Alaoui Aziz(40215844) Section F
 * COMP 352
 * Assignment 2
 * Due Date: November 1, 2023
 *
 */
public class FrogA {
	
	/**
	 * @param i Integer indicating the current position of the frog
	 * @param S Array of integers that stores the frog's jumps
	 * @param H Array of integers that represents the heights at each position 
	 * @return Integer indicating the minimum cost and the sequence of jumps the frog should take to reach the end
	 */
	public static int findPath(int i,int [] S, int [] H)
	{
		int n = H.length;
		
		/*
		 * base case
		 * checks if the current position is equal to the last index of the H array
		 * if it is, S[i] is set to 1 (indicating a one-step jump) and returns 0
		 */
		if(i == n - 1) 
		{
			S[i] = 1;
			return 0;
			
		} 
		
		int jumpF = Integer.MAX_VALUE;
		int jumpS = Integer.MAX_VALUE;
		
		//one step jump
		if(i + 1 < n) 
		{

			jumpF = Math.abs(H[i] - H[i + 1]) + findPath(i+1, S, H);
			
		}
		
		//two step jump
		if(i + 2 < n) 
		{

			jumpS = Math.abs(H[i] - H[i + 2]) + findPath(i+2, S, H);

		}
		
		
		//compares the one step and the two step jump to see which costs less
		if (jumpF < jumpS) 
		{
			//indicates a one-step jump
	        S[i] = 1;
            return jumpF;  
        } 
		else 
		{
			//indicating a two-step jump
        	S[i] = 0;
            return jumpS;
        }
		
		
		


		
    }
	
	
	// read two integers separated by space and output their product
    public static void main(String[] args)
    {
    	
    	

            Scanner scan = new Scanner(System.in);

            do {
            	
            	// Reading the input
                int N = scan.nextInt();

                int[] H = new int[N];
                int[] S = new int [N];

                for(int i=0;i<N;++i)
                {
                	 H[i] = scan.nextInt();
                }
                

                // Calling the function that solves the problem
                
                int e = findPath(0, S, H);

                // writing the output
                System.out.println(e);
                
                for(int i=0;i<N;++i)
                {
                    if(i>0)
                        System.out.print(" ");
                    System.out.print(S[i]);
                    
                }
                
                System.out.println();

            }
            
            while(!scan.hasNext());
            scan.close();

	
    	
}}
