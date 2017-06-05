import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import static java.awt.Color.green;

/**
 * Created by a.tkachuk on 02.03.2017.
 */
public class MyApple {
    public  double weight;
    public  String color;
    public  String dateOfGathering;
    public  int size;

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String sDate = sdf.format(new Date(System.currentTimeMillis()));
        //Date uDate = sdf.parse("23.01.1999 06:34");
        System.out.println("current date time: " + sDate+"\n");

        MyApple[] boxOfApple = new MyApple[10];
        String[] colorList = {"зеленое","красное","желтое","гнилое"};
        Random random = new Random();
        for (int i=0; i<10; i++){
            boxOfApple[i] = new MyApple();
            boxOfApple[i].size=random.nextInt(25)+1;
            boxOfApple[i].weight=(10+i)*11.12;
           boxOfApple[i].dateOfGathering= sdf.format(new Date(1000*60*60*24*random.nextInt(30)+System.currentTimeMillis()));

            boxOfApple[i].color=colorList[random.nextInt(4)];
            System.out.print("размер яблока "+(i+1)+"="+ boxOfApple[i].size+"\t"+" вес:");
            System.out.format(" %-10.2f",boxOfApple[i].weight);
            System.out.println("цвет"+"\t"+ boxOfApple[i].color+"\t\t"+"Дата сбора: "+(boxOfApple[i].dateOfGathering));
        }
        //сортировка массива яблок по размеру
        MyApple exchangeSwap;
        int length = boxOfApple.length;

        for (int i = 0; i < length-1; i++) {
            for (int j=i+1;j<length;j++) {
                if (boxOfApple[i].size > boxOfApple[j].size) {
                    exchangeSwap = boxOfApple[i];
                    boxOfApple[i] = boxOfApple[j];
                    boxOfApple[j] = exchangeSwap;

                };
            }
        }
        System.out.println("=================отсортировали яблоки по размеру===============================");

        for (int i=0; i<10; i++){
            System.out.print("размер яблока "+"="+ boxOfApple[i].size+"\t"+" вес");
            System.out.format(" %-10.2f",boxOfApple[i].weight);
            System.out.println("цвет"+"\t"+ boxOfApple[i].color+"\t\t"+"Дата сбора: "+(boxOfApple[i].dateOfGathering));
        }

    }

}
