
import java.util.*;
public class Main
{

// Number of vertices in the graph
// static int V = 4;

/* A utility function to print solution */
static void printSolution(int[] color,int V)
{
	System.out.println("Solution Exists:" +
					" Following are the assigned colors ");
	for (int i = 0; i < V; i++)
	System.out.print(" " + color[i]);
	System.out.println();
}

// check if the colored
// graph is safe or not
static boolean isSafe(boolean[][] graph, int[] color,int V)
{
	// check for every edge
	for (int i = 0; i < V; i++)
	for (int j = i + 1; j < V; j++)
		if (graph[i][j] && color[j] == color[i])
		return false;
	return true;
}

/* This function solves the m Coloring
	problem using recursion. It returns
	false if the m colours cannot be assigned,
	otherwise, return true and prints
	assignments of colours to all vertices.
	Please note that there may be more than
	one solutions, this function prints one
	of the feasible solutions.*/
static boolean graphColoring(boolean[][] graph, int m,int i, int[] color,int V)
{
	// if current index reached end
	if (i == V) {

	// if coloring is safe
	if (isSafe(graph, color,V))
	{

		// Print the solution
		printSolution(color,V);
		return true;
	}
	return false;
	}

	// Assign each color from 1 to m
	for (int j = 1; j <= m; j++)
	{
	color[i] = j;

	// Recur of the rest vertices
	if (graphColoring(graph, m, i + 1, color,V)){
		return true;
	}
	color[i] = 0;
	}
	return false;
}

// Driver code
public static void main(String[] args)
{
        Scanner l = new Scanner(System.in);
        int V =l.nextInt();
	boolean[][] graph = new boolean[V][V];
        for(int i=0;i<V;i++){
                for(int j =0;j<V;j++){
                       int n=l.nextInt();
                        if(n==0){
                                graph[i][j] = false;   
                        }
                        else{
                               graph[i][j] = true;
                        }
                        
                }
        }
	int m = l.nextInt(); // Number of colors

	// Initialize all color values as 0.
	// This initialization is needed
	// correct functioning of isSafe()
	int[] color = new int[V];
	for (int i = 0; i < V; i++)
	color[i] = 0;
	if (!graphColoring(graph, m, 0, color,V))
	System.out.println("Solution does not exist");
}
}


