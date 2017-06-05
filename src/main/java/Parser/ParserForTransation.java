package Parser;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.Files.exists;

/**
 * Created by a.tkachuk on 31.05.2017.
 */
public class ParserForTransation {
    static String  keys[] = {
            "EMAIL",
            "DONT_REMEMBER",
            "enter",
            "registration",
            "forgot_pass",
            "SELECT_COUNTRY",
            "pass_repeat",
            "SHOP_NAME",
            "COUNTRY",
            "LICENCE_ACCEPT",
            "to_registration",
            "HAVE_YOU_ACCOUNT",
            "ON_ENTER",
            "pass",
            "return_to_main",
            "change_pass",
            "help_restore_mess",
            "send_pass",
            "PROM_PAGE.TITLE",
            "PROM_PAGE.DOWN_SOFT_TEXT",
            "PROM_PAGE.ENTER_WEB_CUB",
            //"PROM_PAGE.BUTTON_TEX"
    };

    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {

        String fileDir = "D:\\loyverseen\\ownercub\\i18";
        Stream<Path> files = Files.list(Paths.get(fileDir));
        files.forEach(file -> {
            try {
                String content = Files.readAllLines(file).stream().collect(Collectors.joining());
                JsonNode rootNode = mapper.readTree(content);
                processFile(rootNode, file.toFile().getName());

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private static void processFile(JsonNode rootNode, String name) throws IOException {
        String message;
        String[]st1;
        ObjectNode result = mapper.createObjectNode();;

        for (int i=0; i<keys.length; i++){
            if (keys[i].contains(".")) {
                st1 = keys[i].split("\\.");
                message = rootNode.get(st1[0])
                        .get(st1[1]).
                                asText(); // получение строки из поля "message"
            }
            else{
                message = rootNode.get(keys[i]).asText(); // получение строки из поля "message"
            }
            //message=message+"/n";


            //JsonNode childNode =  rootNode.get("place"); // получаем объект Place
            //String place = childNode.get("name").asText(); // получаем строку из поля "name"
            System.out.println(keys[i] + " " + message); // напечатает "Hi World!"Ovj

            //result = mapper.createObjectNode();

            result.put(keys[i], message);
        }



        String fileName = "result"+File.separator+name;
        Files.write(Paths.get(fileName), result.toString().getBytes());
    }


}
