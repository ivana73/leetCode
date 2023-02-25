// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
package lt;

import java.util.HashMap;

public class Solution {
	//kocka dva niza jednaka suma
	public int solution3(int[] A, int[] B) {
        // Implement your solution here
		this.sort(A);
		this.sort(B);
		
		
	    int sum1 = 0;
        int sum2 = 0;
        
        for (int el : A)
            sum1 += el;
        
        for (int el : B)
            sum2 += el;
        
        int diff = sum1 - sum2;
        int l1 = 0, r1 = A.length - 1;
        int l2 = 0, r2 = B.length - 1;
        int res = 0;
		
        while (l1 <= r1 || l2 <= r2) {
            if (diff == 0) {
 
                break;
            }
             if (diff > 0) {
                 if (l2 <= r2 && l1 <= r1) {
 
                    if (6 - B[l2] < A[r1] - 1) {
 
                        int sub = Math.min(
                            A[r1] - 1, diff);
                        diff -= sub;
                        A[r1] -= sub;
                        r1--;
                    }
                    else {
 
                        int sub = Math.min(
                            6 - B[l2], diff);
                        diff -= sub;
                        B[l2] += sub;
                        l2++;
                    }
                }
                else if (l1 <= r1) {
 
                    int sub = Math.min(
                        A[r1] - 1, diff);
                    diff -= sub;
                    A[r1] -= sub;
                    r1--;
                }else {
                    int sub = Math.min(
                        6 - B[l2], diff);
                    diff -= sub;
                    B[l2] += sub;
                    l2++;
                }
            } else {
                if (l1 <= r1 && l2 <= r2) {
                    if (6 - A[l1]
                        < B[r2] - 1) {
 
                        int sub = Math.min(
                            B[r2] - 1,
                            -1 * diff);
                        diff += sub;
                        B[r2] -= sub;
                        r2--;
                    } else {
 
                        int sub = Math.min(
                            6 - A[l1],
                            -1 * diff);
                        diff += sub;
                        A[l1] -= sub;
                        l1++;
                    }
                }
                else if (l2 <= r2) {
 
                    int sub
                        = Math.min(
                            B[r2] - 1,
                            -1 * diff);
                    diff += sub;
                    B[r2] -= sub;
                    r2--;
                } else {
 
                    int sub = Math.min(
                        6 - A[l1], diff);
                    diff += sub;
                    A[l1] += sub;
                    l1++;
                }
            }
            res++;
        }
        if (diff == 0)
            return res;
        else
            return -1;
    }
	
	public void sort(int[] A) {
		int[] sort1 = {0,0,0,0,0,0};
		
		for (int i = 0; i<A.length ; i++) {
			sort1[A[i]-1]++;
		}
		int j = 0;
		for (int i = 0; i<A.length ; i++) {
			if (sort1[j]-- > 0 ) {
				A[i] = j + 1;
			}
			else {
				j++;
				i--;
			}
		}
		
	}
	
	public int furthestIdenticalDigramsDistance(String s) {
	    int maxDist = -1 ;
	    HashMap<String, Integer> map = new HashMap<String, Integer>();

	    for (int i = 1; i < s.length(); i++) {
	        String word = s.substring(i-1, i + 1);
	        if (map.containsKey(word)) {
	            int distance = i - map.get(word);
	            if (distance > maxDist) {
	            	maxDist = distance;
	            }
	        }
	        else map.put(word, i);
	    }

	    return maxDist;
	}
	
 	public int solution(int[] A) {
        int maxCnt = 0;
 		int cntij = 0;
 		int cntki = 0;
        if(A.length<=1) return maxCnt;
        
        int i = 1;
        int k = 0;
        while (k <  A.length || i<A.length) {
        	if (i <A.length) {
        		if ((A[i]+A[i-1])%2 == 0) {
        			cntij++;
        			i+=2;
        		}
        		else {
        			if ((A[i]+A[(i+1)%A.length])%2 == 0) {
            			cntij++;
            			i+=4;
            		}
            		else {
            			i+=2;
            		}
        		}
        	}
        	if (k<A.length) {
        	if ((A[(A.length+(k-1))%A.length]+A[k])%2 == 0) {
        		cntki++;
    			k = k+2;
        	}
        	else {
        		if ((A[(k+1)%A.length]+A[k])%2 == 0 && (k+1)<A.length) {
            		cntki++;
        			k = k+4;
            	}
            	else {
            		k =k+2;
            		
            	}
        	}
        	}
        }
        if (cntij >= cntki) maxCnt= cntij;
        else maxCnt = cntki;
        
 		return maxCnt;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] A = {4, 2, 5, 8, 7, 3, 7};
		int[] B = {5,4,6};
//		A = {4,2,5,8,7,3,7};
		int as = s.solution(A);
//		as = s.solution3(A, B);
		System.out.print(as);
	}

}

class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        	        int maxCnt = 0;
	 		int cntij = 0;
	 		int cntki = 0;
	        if(A.length<=1) return maxCnt;
	        
	        int i = 0;
	        int j = 1;
	        int ik = 0;
	        int k = A.length-1;
	        
	        while (ik <  A.length) {
	        	if (j<A.length) {
	        		if ((A[i]+A[j])%2 == 0) {
	        			cntij++;
	        			i+=2;
	        			j+=2;
	        		}
	        		else {
	        			i++;
	        			j++;
	        		}
	        	}
	        	if ((A[ik]+A[k])%2 == 0) {
	        		cntki++;
	        		ik+=2;
        			k= (k+2)%A.length;
	        	}
	        	else {
	        		ik+=1;
	        		k = (k+1)%A.length;
	        	}
	        }
	        if (cntij >= cntki) maxCnt= cntij;
	        else maxCnt = cntki;
	        
	 		return maxCnt;
    }
}
