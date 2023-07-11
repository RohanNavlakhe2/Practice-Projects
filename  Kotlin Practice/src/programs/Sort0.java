package programs;

public class Sort0 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 1,0,0, 0 ,1,1,0, 0,1};

        int indexOfFirstOne = -1;

        for(int i=0;i<arr.length;i++){

            if(arr[i] == 1 && arr[i-1]==0){
                indexOfFirstOne = i;
            }

            if(arr[i] == 0 && indexOfFirstOne!=-1){
                int temp = arr[indexOfFirstOne];
                arr[indexOfFirstOne] = 0;
                arr[i] = temp;

                indexOfFirstOne++;

            }
        }
    }
}
