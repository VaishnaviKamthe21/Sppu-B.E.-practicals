import java.util.*;
public class JobSquencing {
    public static void main(String[] args) {
        int[] jobId = {0,1,2,3,4};
        int[] profit = {20,15,10,5,1};
        int[] deadline = {1,1,0,2,2};
        int n = 5;

        //sorting in desc profit

        for(int i = 0; i<n-1; i++){
            for(int j = i+1; j<n;j++){
                if(profit[i]<profit[j]){
                    
                    int temp = profit[i];
                    profit[i]=profit[j];
                    profit[j]=temp;

                    temp = jobId[i];
                    jobId[i]=jobId[j];
                    jobId[j]=temp;

                    temp = deadline[i];
                    deadline[i]=deadline[j];
                    deadline[j]=temp;

                }
            }
        }

        //Max dl
        int max=0;
        for(int i : deadline){
            if(i>max){
                max=i;
            }        
        }

        int[] jobs = new int[max+1];
        Arrays.fill(jobs, -1);

        int totalProfit = 0;

        //job scheduling
        for(int i = 0; i<n; i++){
            for(int j=deadline[i]; j>=0; j--){
                if(jobs[j]==-1){
                    jobs[j]=jobId[i];
                    totalProfit+=profit[i];
                    break;
                }
            }
        }

        for(int i = 0; i<max+1; i++){
            System.out.print(jobs[i]+" ");
        }
        System.out.println(totalProfit);
    }
}
