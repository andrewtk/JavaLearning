import java.util.Arrays;
import java.util.Random;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by a.tkachuk on 11.11.2016.
 */
public class MyfirstClass
    {
        public static void main(String[] args) {
            String messageIfNotFound = "в данном массиве нет такого числа";
            String messageIfFound = "мы нашли данное число на позиции- ";
            int[] ar1 = new int[1000]; //1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,};


            //количество циклов поиска
            long quantityCicles = 1000000;

            String messageAboutSearch="";
            Random random = new Random();
            //переменная которую ищем
            int lookingForDigits =random.nextInt(500);

            //присваиваем элементам массива случайные переменные
            for(int i = 0; i < 1000; i++){
                ar1[i] = random.nextInt(1000);
            }
            Arrays.sort(ar1); //сортируем массив по возрастанию

            for(int i = 0; i < 1000; i++)
            {
               // System.out.println(ar1[i]);
            }



            //засекаем время поиска переменной
            long start = System.nanoTime();
            //цикл для создания соизмерений 100 000 000 раз прогоняем цикл чтобы просуммировать итоговое времяcounter.countPrimes(1000000);
            for (int i = 1; i < quantityCicles; i++) {
                messageAboutSearch = directSearchArray(ar1, lookingForDigits );
            }
            long end = System.nanoTime();
            System.out.println(messageAboutSearch);
            System.out.println("Время которое потребовалось для "+ quantityCicles +" раз прямого метода ");
            System.out.println("Took: " + ((end - start) / 1000000) + "ms");
            //--------------------------------------------------------------------------------------------------------
            // позиция которую ищем
            int lookingPosition=0;

            //бнарный поиск элемента
            start = System.nanoTime();

            //цикл для создания соизмерений 10 000 раз прогоняем цикл чтобы просуммировать итоговое времяcounter.countPrimes(1000000);
            for (int i = 1; i < quantityCicles; i++) {
                //messageAboutSearch = binarSearchArray(ar1, lookingForDigits );
                lookingPosition=binarSearchArray(ar1, lookingForDigits );
            }

            end = System.nanoTime();
            if (lookingPosition == -1){
                System.out.println("данного числа в диапазоне нет");
            }else
                System.out.println("мы нашли данное число на позиции- "+lookingPosition);

            //System.out.println(messageAboutSearch);
            System.out.println("Время которое потребовалось для "+ quantityCicles +" раз бинарного метода ");
            System.out.println("Took: " + ((end - start) / 1000000) + "ms");
        }
        //метод поиска прямым методом ==================================================================================

        public static String directSearchArray(int[] myArray, int myVar) {          //, int b, String messageIfNotFound
            String messageIfNotFound = "в данном массиве нет такого числа";
            String messageIfFound = "мы нашли данное число на позиции - ";

            // Перебираем все элементы массива.
            for (int i = 0; i < myArray.length; i++) {
                // Сравниваем значение переменной myVar со значениями элемента массива.
                // Если значение элемента массива равно значения переменной myVar,
                // то присваиваем значение переменной myVar будет равно значению этого элемента.
                if (myArray[i] == myVar) {
                    messageIfFound=messageIfFound+i;
                    return messageIfFound;
                }
            }
            return messageIfNotFound;
        }

        //метод поиска бинарным методом ================================================================================
        public static Integer binarSearchArray(int[]  myArray, int myVar){
            String messageIfNotFound = "в данном массиве нет такого числа";
            String messageIfFound = "мы нашли данное число на позиции- ";
            //иyдекс начала и конца поиска
            int start=0,
                end=(myArray.length-1),
                middle=myArray.length/2;
            int searchItem =myArray[myArray.length/2];

            // Перебираем все элементы массива.
            int i = 0;
            while  ( (end-start) > 1)  {
                // Сравниваем значение переменной myVar со значениями элемента массива.
                // Если значение элемента массива равно значения переменной myVar,
                // то присваиваем значение переменной myVar будет равно значению этого элемента.

                if (myArray[middle] == myVar){
                    //System.out.println(" количество итераций "+i);
                    return middle;
                } else if (myVar > myArray[middle]){
                    start=middle+1;
                    middle=middle+(end-middle)/2;
                } else if (myVar< myArray[middle]){
                          end=middle;
                          middle=middle-(middle-start)/2;
                      }
             i++;
            }
            messageIfNotFound = messageIfNotFound +" количество итераций "+(i-1);
            if (myArray[start]==myVar) return start;
            else if (myArray[end]== myVar) return end;
            return -1; //напишите тут ваш код
        }
    }
