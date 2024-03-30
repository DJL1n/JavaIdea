package first;

import java.util.Arrays;
import java.util.Scanner;

public class Sort {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=scanner.nextInt();
        }
        for (int j = 0; j < n - 1; j++) {
            int max_index=j;
            for (int k = j+1; k < n; k++) {
                if (nums[k]>nums[max_index]){
                    max_index=k;
                }
            }
            if (max_index!=j){
                int tmp=nums[j];
                nums[j]=nums[max_index];
                nums[max_index]=tmp;
            }
        }
        //System.out.println(Arrays.toString(nums));
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
