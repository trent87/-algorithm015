package homework;

public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] bucket = new int[1001];
        int[] res = new int[arr1.length];
        for(int data : arr1){
            bucket[data]++;
        }
        int j=0;
        for(int data : arr2){
            while(bucket[data] -- > 0){
                res[j++]=data;
            }
        }
        for(int i =0;i<1001;i++){
            while(bucket[i] -- > 0){
                res[j++]=i;
            }
        }
        return res;
    }

}
