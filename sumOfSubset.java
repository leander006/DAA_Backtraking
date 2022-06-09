import java.util.*;
 
class SubSet{
  int set[];
  int sum;
  
  Stack<Integer> solutionSet;
  boolean hasSolution;
  
  SubSet(int set[], int sum){
      this.set = set;
      this.sum = sum;
      this.solutionSet = new Stack<>();
      hasSolution = false;
  }
  
  public void solve(int s, int idx){   
    //return false if s value exceed sum
    if(s>sum)
        return;
 
    //check if stack has the right subsets of numbers
    if(s==sum){
        hasSolution = true;
 
        //display stack contents
        displaySolutionSet();
 
        //Though found a solution but deliberately returning to find more
        return;
    }
        
    for(int i=idx; i<set.length; i++){
        //Adding element to the stack
        solutionSet.push(set[i]);
 
        //add set[i] to the 's' and recusively start from next number
        solve(s+set[i],i+1);
 
        //Removing element from stack i.e Backtracking
        solutionSet.pop();
    }

  }
  
  //Function to display stack content
  private void displaySolutionSet(){
    for (Integer item: solutionSet){
      System.out.print(item+" ");
    }
        System.out.println();
  }
   
}
 
public class Main
{
    public static void main(String[] args) {
            Scanner l = new Scanner(System.in);
            int n = l.nextInt();
            int set[]= new int[n];
            for(int i=0;i<n;i++){
                set[i]=l.nextInt();    
            }
//       int set[] = {10, 7, 5, 18, 12, 20, 15};
       int size = l.nextInt();;
    
       SubSet ss = new SubSet(set, size);
       ss.solve(0,0);
	    
       if(ss.hasSolution == false)
	  System.out.print("No Solution");
    }
}