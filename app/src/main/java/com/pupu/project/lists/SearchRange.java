package com.pupu.project.lists;

public class SearchRange {


    public int[] searchRange (int[] A, int target) {
        int [] res={-1,-1};
        int left=getLeftIndex(A,target);
        if(left==-1){
            return res;
        }
        res[0]=left;
        for(int i=left+1;i<A.length-1;i++){
            if(A[i]!=target){
                res[1]=i-1;
                break;
            }
        }
        return res;
    }

    private int getLeftIndex(int[] arr,int target){
        int left=-1;
        int right=arr.length;
        while(left<right){
            int mid=(right+left>>1)+left;
            if(arr[mid]>=target){
                right=mid;
            }else if(arr[mid]<target){
                left=mid+1;
            }
        }
        if(left>arr.length||left<0){
            return -1;
        }
        return left;
    }
}
