import java.util.*;

public class FrogB {

    /**
     * The main function to drive the program.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Continuously read test cases until no input is left
        do {
            // Read the number of stones
            int N = scan.nextInt();

            // Create an array to store the height of each stone
            int[] H = new int[N];

            // Create an array to store whether the frog visits each stone
            int[] S = new int[N];

            // Read the height of each stone
            for (int i = 0; i < N; ++i) {
                H[i] = scan.nextInt();
            }

            // Create an instance of the FrogB class
            FrogB F = new FrogB();

            // Calculate the minimum energy required for the frog to reach the last stone
            int e = F.findPath(S, H);

            // Print the minimum energy
            System.out.println(e);

            // Print whether the frog visits each stone (1 for visited, 0 for not visited)
            for (int i = 0; i < N; ++i) {
                if (i > 0) {
                    System.out.print(" ");
                }
                System.out.print(S[i]);
            }
            System.out.println();

        } while (!scan.hasNext()); // Continue until there's no more input
        scan.close();
    }

    /**
     * Function to calculate the minimum energy required for the frog to reach the last stone
     * and to determine the path the frog takes.
     */
    public int findPath(int[] S, int[] H) {
        int N = H.length;

        // Memoization array to store the minimum energy required to reach each stone
        int[] memo = new int[N];
        Arrays.fill(memo, -1);  // Initialize the memoization array with -1

        /**
         * Local class to calculate the energy required to jump to a particular stone.
         */
        class EnergyCalculator {

            // Recursive function to compute the energy required to jump to a particular stone
            int getEnergy(int idx) {
                // Base case: if the stone is the first one, no energy is required
                if (idx == 0) return 0;

                // If the energy for this stone has been calculated before, return the cached value
                if (memo[idx] != -1) return memo[idx];

                // Initialize the energy required to jump from the previous stone and the stone before that
                int oneStep = Integer.MAX_VALUE;
                int twoStep = Integer.MAX_VALUE;

                // Calculate the energy if the frog jumps from the previous stone
                if (idx - 1 >= 0) {
                    oneStep = getEnergy(idx-1) + Math.abs(H[idx] - H[idx-1]);
                }

                // Calculate the energy if the frog jumps from the stone before the previous one
                if (idx - 2 >= 0) {
                    twoStep = getEnergy(idx-2) + Math.abs(H[idx] - H[idx-2]);
                }

                // Store the minimum energy required to reach this stone in the memoization array
                memo[idx] = Math.min(oneStep, twoStep);
                return memo[idx];
            }
        }

        // Create an instance of the EnergyCalculator
        EnergyCalculator calculator = new EnergyCalculator();

        // Compute the minimum energy required to reach the last stone
        int energy = calculator.getEnergy(N-1);

        // Backtrack to determine the path the frog takes
        int idx = N - 1;
        while (idx > 0) {
            S[idx] = 1;
            int jumpFrom = idx - 1;
            if (idx >= 2 && calculator.getEnergy(idx-2) + Math.abs(H[idx] - H[idx-2]) <= calculator.getEnergy(idx-1) + Math.abs(H[idx] - H[idx-1])) {
                jumpFrom = idx - 2;
            }
            idx = jumpFrom;
        }

        S[0] = 1; // The starting position is always visited

        return energy;  // Return the minimum energy required
    }
}

///Input:
//4 10 20 5 20
//3 0 2 3
//2 1 2
//Output:
//10 1 1 0 1
//3 1 0 1
//1 1 1