# Frog Jump Problem - Dynamic Programming

## Overview
This project implements two different approaches to solve the **Frog Jump Problem**, where a frog moves from one stone to another while minimizing the energy cost. The frog can jump either **one step** or **two steps** at a time.

The two implementations are:
1. **FrogA.java** - Uses a **recursive approach** without memoization.
2. **FrogB.java** - Uses a **memoization-based dynamic programming approach** for optimization.

## File Structure
```
├── FrogA.java   # Recursive approach without memoization
├── FrogB.java   # Optimized approach using dynamic programming
```

## Problem Statement
Given an array `H` of length `N`, where `H[i]` represents the height of the `i-th` stone, the goal is to find the **minimum energy required** for the frog to reach the last stone while also determining the path taken.

The energy cost of a jump is calculated as:
\[ E = |H[i] - H[j]| \]
where `i` and `j` are the indices of the stones the frog jumps between.

## Compilation and Execution
### 1. Compile the Java files
```bash
javac FrogA.java FrogB.java
```

### 2. Run the programs
```bash
java FrogA
java FrogB
```

## Input Format
The program reads input from the console in the following format:
```
N
H[0] H[1] H[2] ... H[N-1]
```
where:
- `N` is the number of stones.
- `H[i]` represents the height of the `i-th` stone.

### Example Input
```
4
10 20 5 20
```

## Output Format
Each program outputs:
1. **The minimum energy required** for the frog to reach the last stone.
2. **The path taken by the frog** (represented as `1` for visited and `0` for skipped stones).

### Example Output
```
10
1 1 0 1
```

## Approaches
### **FrogA.java (Recursive Approach)**
- Uses a **recursive** function to determine the minimum energy.
- Recursively calculates the cost for both **one-step** and **two-step** jumps.
- **Time Complexity**: Exponential \( O(2^N) \), inefficient for large `N`.

### **FrogB.java (Optimized Dynamic Programming Approach)**
- Uses **memoization** to store previously computed results.
- Avoids redundant calculations by caching results.
- Uses **backtracking** to reconstruct the path taken.
- **Time Complexity**: \( O(N) \), significantly faster.

## Performance Analysis
| Approach  | Time Complexity | Space Complexity |
|-----------|---------------|----------------|
| FrogA.java (Recursive) | \( O(2^N) \) | \( O(N) \) |
| FrogB.java (Memoization) | \( O(N) \) | \( O(N) \) |

## Contributions
Feel free to fork the repository and submit pull requests for improvements!


