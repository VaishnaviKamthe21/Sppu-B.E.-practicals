import java.util.Scanner;

public class Fibonacci{
    
    void fibo_itter(int n){
        int sum = 0, steps = 0;
        if(n<0){
            sum+=-1;
            steps++;
        }
        if(n==1 || n==0){
            sum+=n;
            steps++;
        }

        int a=0, b=1;

        for(int i=2;i<=n;i++){
            sum = a+b;
            a = b;
            b = sum;

            steps++;
        }

        System.out.println("Sum = "+sum);
        System.out.println("Steps = "+steps);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length: ");
        int n = sc.nextInt();
        Fibonacci f = new Fibonacci();
        f.fibo_itter(n);
    }
}