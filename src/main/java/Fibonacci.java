import javax.swing.*;

public class Fibonacci
{
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
        for (int i = 1; i <= n; i++)
        {
            ans = x + y;
            x = y;
            y = ans;
        }
        return ans;

        }





    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        int order = 20;
        for (int i=-3;i<order;i++){
            System.out.println("число фибоначчи порядка "+i+" равно "+ f.getNumber(i));
        }
        System.out.println("число фибоначчи порядка "+order+" равно "+ f.getNumber(order));

    }


}
      