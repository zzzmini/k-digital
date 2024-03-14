package ch06.quiz;

public class SelectionSort01 {
    public static void main(String[] args) {
        int sortData[] = {7,4,5,1,3};
        for(int i=0; i<sortData.length; i++){
            int flag = 0;
            for(int k = i + 1; k < sortData.length; k++){
                if(sortData[i] > sortData[k]){
                    int temp = sortData[i];
                    sortData[i] = sortData[k];
                    sortData[k] = temp;
                    flag = 1;
                }
            }
            if(flag == 0) break;

            System.out.printf(i+1 + "번째 회전 : ");
            for (int data : sortData){
                System.out.printf(data + " ");
            }
            System.out.println();
        }
    }
}
