package ch06.quiz;

public class SelectionSort02 {
    public static void main(String[] args) {
        int sortData[] = {7,4,5,1,3};
        int min = 999;
        int index;
        for(int i = 0; i < sortData.length-1; i++){
            min = sortData[i];
            index = i;
            for(int k = i + 1; k < sortData.length; k++){
                if(min > sortData[k]){
                    min = sortData[k];
                    index = k;
                }
            }
            if(index == i) break;
            int temp = sortData[i];
            sortData[i] = sortData[index];
            sortData[index] = temp;

            System.out.printf(i+1 + "번째 회전 : ");
            for (int data : sortData){
                System.out.printf(data + " ");
            }
            System.out.println();
        }
    }
}
