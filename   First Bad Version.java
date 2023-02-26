/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

// Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

// You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
public class FirstBadVersion {
	  public int firstBadVersion(int n) {	        
	        long bot = 1;
	        long top = n;
	        while(top!=bot) {
	        	int mid = (int) ((bot+top)/2) ;
	        	if (!isBadVersion(mid)) {
	        		bot=mid;
	        	} else if (isBadVersion(mid-1)) {
	        		top = mid;
	        	} else return mid;
	        	if ((bot+1) == n) {bot++; break;}
	        }
	        
	        return (isBadVersion(n) && bot==n)?n:-1;
	}

	  public boolean isBadVersion(int i) {
		  return (i>0)? true:false;
	  }
	  
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			FirstBadVersion s = new FirstBadVersion();
//			A = {4,2,5,8,7,3,7};
			int as = s.firstBadVersion(3);
//			as = s.solution3(A, B);
			System.out.print(as);
		}
}