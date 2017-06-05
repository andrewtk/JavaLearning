package Parser;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;
import org.w3c.dom.NameList;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by a.tkachuk on 03.06.2017.
 */
public class GetEtalonJSONFromFile {
    static String[] keysEtalonJson;
 //  /*static String etalonJson[] = {
 //     //   "EMAIL",
 //     //   "DONT_REMEMBER",
 //     //   "enter",
 //     //   "registration",
 //     //   "forgot_pass",
 //     //   "SELECT_COUNTRY",
 //     //   "pass_repeat",
 //     //   "SHOP_NAME",
 //     //   "COUNTRY",
 //     //   "LICENCE_ACCEPT",
 //     //   "to_registration",
 //     //   "HAVE_YOU_ACCOUNT",
 //     //   "ON_ENTER",
 //     //   "pass",
 //     //   "return_to_main",
 //     //   "change_pass",
 //     //   "help_restore_mess",
 //     //   "send_pass",
 //     //   "PROM_PAGE.TITLE",
 //     //   "PROM_PAGE.DOWN_SOFT_TEXT",
 //     //   "PROM_PAGE.ENTER_WEB_CUB",
 //     //   //"PROM_PAGE.BUTTON_TEX"
 //  };

    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        String fileName = "etalonJson.json";
        EtalonJson(fileName);

    }

    public static JsonNode EtalonJson( String etalonJsonFileName) {

        String fileDir = "D:\\loyverseen\\ownercub\\i18";
        JsonNode rootNode1 = mapper.createObjectNode();
        ObjectNode rootNode = mapper.createObjectNode();

        try {
            String fileName = fileDir + File.separator + etalonJsonFileName;
            String content = Files.readAllLines(Paths.get(fileName)).stream().collect(Collectors.joining());
            rootNode1 = mapper.readTree(content);
            rootNode = (ObjectNode) rootNode1;
            processFile(rootNode, fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return rootNode;
    }

    private static String[] processFile(ObjectNode rootNode, String name) throws IOException {
        String message;
        String[]st1;
        ObjectNode result = mapper.createObjectNode();

        //формируем массив ключей эталонного Json
        int lengthJson=rootNode.size();
        //keysEtalonJson;
        Iterator<String> list = rootNode.getFieldNames();
        ArrayList<String> keys = new ArrayList<String>();

        //проходим по json и собираем ключи и значения
        while (list.hasNext()){
            String fieldName= list.next();

            keys.add(rootNode.get(fieldName).asText());



        }

        for (int i = 0; i< lengthJson; i++){
            if (keysEtalonJson[i].contains(".")) {
                st1 = keysEtalonJson[i].split("\\.");
                message = rootNode.get(st1[0])
                        .get(st1[1]).
                                asText(); // получение строки из поля "message"
            }
            else{
                message = rootNode.get(keysEtalonJson[i]).asText(); // получение строки из поля "message"
            }
            //message=message+"/n";


            //JsonNode childNode =  rootNode.get("place"); // получаем объект Place
            //String place = childNode.get("name").asText(); // получаем строку из поля "name"
            System.out.println(keysEtalonJson[i] + " " + message); // напечатает "Hi World!"Ovj

            //result = mapper.createObjectNode();

            result.put(keysEtalonJson[i], message);
        }
        return keysEtalonJson;



        //String fileName = "result"+ File.separator+name;
        //Files.write(Paths.get(fileName), result.toString().getBytes());


    }


}
