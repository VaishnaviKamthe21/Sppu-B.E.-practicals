import java.util.Scanner;

public class FractionalKnapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter the Number of items: ");
        int n = sc.nextInt();

        int[] profit = new int[n];
        int[] weight = new int[n];
        double[] pwRatio = new double[n];

        for(int i = 0; i<n; i++){
            System.out.println("\nItem "+(i+1)+" : " );
            System.out.print("profit: ");
            profit[i]=sc.nextInt();
            System.out.print("\nweight: ");
            weight[i]=sc.nextInt();
            pwRatio[i]=(double)profit[i]/(double)weight[i];
        }

        System.out.print("\nEnter the capacity of knapsack: ");
        int w = sc.nextInt();

        double totalProfit=0;

        //sorting based on pw ratio desc
        int tempi;
        double tempd;
        for(int i = 0; i<n-1;i++){
            for(int j = i+1; j<n; j++){
                if(pwRatio[j]>pwRatio[i]){
                    tempd = pwRatio[j];
                    pwRatio[j]=pwRatio[i];
                    pwRatio[i]=tempd;

                    tempi = profit[j];
                    profit[j]=profit[i];
                    profit[i]=tempi;

                    tempi = weight[j];
                    weight[j]=weight[i];
                    weight[i]=tempi;
                }
            }
        }

        //greedy approach
        for (int i = 0; i < n; i++) {
            if(w>=weight[i]){
                totalProfit+=profit[i];
                w-=weight[i];
            }
            else{
                double frac = (double)w/(double)weight[i];
                totalProfit+=profit[i]*frac;
                w=0;
                break;
            }
        }

        System.err.print("\nTotal Profit: "+totalProfit);
        System.err.print("\nCapacity left: "+w);
    }
}
