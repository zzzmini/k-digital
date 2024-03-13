package ch06.quiz;

public class BubbleSort {
    public static void main(String[] args) {
        int sortData[] = {7,4,5,1,3};
        for(int i=0; i<sortData.length-1; i++){
            boolean flag = true;
            for(int k=0; k<sortData.length -1 - i;k++){
                if(sortData[k] > sortData[k+1]){
                    int temp = sortData[k];
                    sortData[k] = sortData[k+1];
                    sortData[k+1] = temp;
                    flag = false;
                }
            }
            if(flag == true) break;

            System.out.printf(i+1 + "번째 회전 : ");
            for (int data : sortData){
                System.out.printf(data + " ");
            }
            System.out.println();
        }
    }
}
