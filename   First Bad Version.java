/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int m = 0;
        int oldM = m;
        int k = (m+n)/2 - 1;
        while(k) {
            if (!isBadVersion(k)) {
                oldM = m;
                m=k+1;
            }
            else {
               if (isBadVersion(k-1)) {
                   n=k-1;
                   m=oldM;
               }
               else {
                    return k;
                }
            }
            k = (m+n)/2 - 1;
        }
        return -1;
}

}