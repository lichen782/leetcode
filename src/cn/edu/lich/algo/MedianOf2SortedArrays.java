package cn.edu.lich.algo;

public class MedianOf2SortedArrays {

	/**
	 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. 
	 * The overall run time complexity should be O(log (m+n)).
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = {1,5};
		int[] B = {2};
		double value = findMedianSortedArrays(A,B);
		System.out.println(value);

	}
    public static double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	//return findMiddleValue(A,B);//this is o(m+n)
    	int n = A.length + B.length;
    	if(n%2 == 0){
    		return (double)(findKth(A,0,A.length, B,0,B.length,n/2) +findKth(A,0,A.length, B,0,B.length,n/2 + 1))/(double)2;
    	}else {
    		return findKth(A,0,A.length, B,0,B.length,n/2 + 1);
    	}
    }
    
    private static int findKth(int A[], int aoffset, int m, int B[],int boffset, int n,int k){
    	if(m > n) return findKth(B, boffset, n, A, aoffset, m, k);
    	if(m==0)return B[k-1];
    	if(k==1)return Math.min(A[aoffset], B[boffset]);
    	int pa = Math.min(k/2, m);
    	int pb = k - pa;
    	if(A[aoffset + pa - 1] >= B[boffset + pb - 1])
    		return findKth(A,aoffset, m, B, boffset + pb, n - pb, k-pb);
    	else return findKth(A, aoffset + pa, m - pa, B, boffset, n, k - pa);
    }
    
//    
//    private static double findMiddleValue(int A[], int B[]){
//    	int midIdx = (A.length + B.length)/2;
//    	int midIdxPre = (A.length + B.length)%2==0 ? midIdx - 1 : -1;
//    	int[] AB = new int[A.length + B.length];
//        int i = 0;
//        int j = 0;
//        int k = 0;
//        while(i<A.length && j < B.length) {
//        	if(A[i] < B[j]) {
//        		AB[k++] = A[i++];
//        	}else {
//        		AB[k++] = B[j++];
//        	}
//        }
//        if(i >= A.length){
//        	while(j<B.length)AB[k++] = B[j++];
//        }else while(i < A.length)AB[k++] = A[i++];
//        return midIdxPre == -1 ? AB[midIdx] : (double)(AB[midIdxPre] + AB[midIdx])/(double)2;
//    }
}
