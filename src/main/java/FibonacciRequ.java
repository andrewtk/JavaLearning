/**
 * Created by a.tkachuk on 04.04.2017.
 */
public class FibonacciRequ {
    //за
    public long getNumber(int position){
        long n=position;
        if (n<=0) return -1;
        //F(n-2)
        long x = 1;
        //F(n-1)
        long y = 0;
        //F(n)
        long ans=0;
        for (int i = 1; i <= n; i++) {
            ans = x + y;
            x = y;
            y = ans;
        }
        return ans;

    }

    public static int Fibonacci1 (int n) {
        if(n==0||n==1){
            return 1;
        }
        return Fibonacci1(n-1)+Fibonacci1(n-2);
    }





    public static void main(String[] args) {
        //Fibonacci f = new Fibonacci();
        //Fibonacci1 f=new Fibonacci1();
        int order = 40;
        /*for (int i=0;i<=order;i++){
            //System.out.println("число фибоначчи порядка "+i+" равно "+ f.getNumber(i));
            System.out.println("число фибоначчи порядка "+i+" равно "+ Fibonacci1(i));
        }*/


    }


}

