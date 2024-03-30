package basics;

import java.util.Arrays;
import java.util.Scanner;

public class bubble {
    public static void main(String[] args) {
        int n=10;
        int nums[]=new int[n];
        Scanner reader=new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            nums[i]=reader.nextInt();
        }
        for (int j = 0; j < n-1; j++) {
            int min=j;
            for (int k = j+1; k < n; k++) {
                if (nums[k]<nums[min]){
                    min=k;
                }
            }
            if (min!=j){
                int tmp=nums[j];
                nums[j]=nums[min];
                nums[min]=tmp;
            }
        }
        System.out.println(Arrays.toString(nums));

    }
}
