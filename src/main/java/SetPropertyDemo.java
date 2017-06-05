import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * Created by a.tkachuk on 05.04.2017.
 */
/*public class SetPropertyDemo {

    // Установка вывода консольных сообщений в нужной кодировке
        /*try {
        System.setOut(new CodepagePrintStream(System.out, System.getProperty("console.encoding", "Cp866")));
    } catch (UnsupportedEncodingException e) {
        System.out.println("Unable to setup console codepage: " + e);
    }
*/
  /*  public static void main(String[] args)

    {

        System.out.println("file.encoding before="+System.getProperty("file.encoding"));

        System.out.println("console.encoding before="+System.getProperty("console.encoding"));

        System.setProperty("file.encoding","Cp866");

        System.setProperty("console.encoding","Cp866");

        System.out.println("file.encoding after="+System.getProperty("file.encoding"));

        System.out.println("console.encoding after="+System.getProperty("console.encoding"));

        String s1 = "АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЬЫЪЭЮЯ";

        String s2 = "абвгдежзийклмнопрстуфхцчшщьыъэюя";

        System.out.println(s1);

        System.out.println(s2);

    }

    private static class CodepagePrintStream extends PrintStream {
        public CodepagePrintStream(PrintStream out, String cp866) {
            super();
        }
    }

    public class Msg
    {
        static String cp = System.getProperty("console.encoding","Cp866");
        public static void message(String msg)
        {
            msg += "\n";
            byte[] b;
            try { b = msg.getBytes(cp); }
            catch( UnsupportedEncodingException e )
            {
                b = msg.getBytes();       // В случае отсутствия нужной кодировки,
                // делаем преобразование по умолчанию
            }
            System.out.write(b);
        }
         //Msg.message("Сообщение");
    }











}
*/