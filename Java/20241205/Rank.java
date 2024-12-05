package basic.sort;

import java.util.Arrays;

public class Rank {
    public static void main(String[] args) {
        int[] score = {85, 50, 90, 75, 85, 60, 89, 98, 83, 65};
        int[] rank = new int[score.length];
        for (int i = 0; i < score.length; i++) {
            rank[i] = 1;
            for (int j = 0; j < score.length; j++) {
                if (score[i] < score[j]) {
                    rank[i]++;
                }
            }
        }
        System.out.println("성적 : " + Arrays.toString(score));
        System.out.println("Rank : " + Arrays.toString(rank));
    }
}
