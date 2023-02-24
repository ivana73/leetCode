class Solution {

// Merge nums1 and nums2 into a single array sorted in non-decreasing order.
public void merge(int[] nums1, int m, int[] nums2, int n) {
		   int i=m;
	       int j=n;
	       int k=m+n;
	       while(i>0 && j>0){
	           if(nums1[i-1] > nums2[j-1]){
	               nums1[--k] = nums1[--i];
	           }
	           else{
	               nums1[--k]=nums2[--j];
	           }
	       }
	       while(j>0){
	           nums1[--k]=nums2[--j];
	       }  
}
}
