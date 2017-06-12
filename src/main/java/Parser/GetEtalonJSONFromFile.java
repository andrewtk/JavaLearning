package Parser;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.util.JSONPObject;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;
import org.codehaus.jackson.type.TypeReference;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompare;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.JSONCompareResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

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

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws Exception {
        String fileName = "etalonJson.json";
        String jsonStringFromServer="";
        //Map<String,String> jsonFromFile = loadEtalonJson(fileName);
        //Map<String,String> jsonFromServer = loadJsonFromServer();
        String jsonFromFile = loadEtalonJson(fileName);
        String jsonFromServer = loadJsonFromServer();

        JSONCompareResult result =
                JSONCompare.compareJSON(jsonFromFile, jsonFromServer, JSONCompareMode.STRICT);
        System.out.println("RESULT: "+result.toString());


        return;


/*        String message;
        ArrayList<String> keysString = new ArrayList<String>(); // ключи эталонного json
        ArrayList<String> keyStringArray = new ArrayList<String>(); // ключи эталонного json составного массива
        JsonNode rootNode = mapper.readTree(jsonFromFile);
        ObjectNode result = mapper.createObjectNode();

        Iterator<String> names = rootNode.getFieldNames();

        System.out.println(ANSI_RED + "This text is red!" + ANSI_RESET);
        System.out.println(ANSI_GREEN_BACKGROUND + "This text has a green background but default text!" + ANSI_RESET);
        System.out.println(ANSI_RED + "This text has red text but a default background!" + ANSI_RESET);
        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_RED + "This text has a green background and red text!" + ANSI_RESET);

        while (names.hasNext()) {
            keysString.add(names.next());
            System.out.println("ключ" + keysString+" "+keysString.size());
        }

        //цикл по проверке полученного json с сервера

        for (String key: keysString){
            System.out.println("ключ " + key);
            JsonNode element=rootNode.get(key);

            if (element.isArray()){
                System.out.println("элементы по ключу "+ key + " это массив "+ element);
                message="это массив";

                ArrayNode arr = (ArrayNode) element;
                for (int i=0; i<arr.size();i++){
                    //obj.getJSONArray("posts");
                    //String post_id = arr.getJSONObject(i).getString("post_id");
                    String elementOfArray = arr.getTextValue();
                    System.out.println(arr.get(i));


                    //String currentElemenArray = element.get(key);
                }


                   //contains(".")) {
             *//*   keyStringArray = keysString.split("\\.");
                message = rootNode.get(keyStringArray)
                        .get(keyStringArray).
                                asText(); // получение строки из поля "message"
*//*
            }
            else{
                if (element.isObject()){
                    System.out.println("элементы по ключу "+ key + " это JSON "+ element);
                    message="это массив";
                }
                else {
                    System.out.println("одиночный элемент " + element);
                    message = rootNode.get(key).asText(); // получение строки из поля "message"


                }
            }
            //message=message+"/n";


            //JsonNode childNode =  rootNode.get("place"); // получаем объект Place
            //String place = childNode.get("name").asText(); // получаем строку из поля "name"
            //System.out.println(keysString[i] + " " + message); // напечатает "Hi World!"Ovj

            //result = mapper.createObjectNode();

            //result.put(element, message);
        }*/

    }

    public static String loadEtalonJson(String etalonJsonFileName) {
        //String fileDir = "D:\\loyverseen\\ownercub\\i18";
        String fileDir = "D:\\JSON test case";

        Map<String, String> map = new HashMap<>();

        String fileName = fileDir + File.separator + etalonJsonFileName;
        String content = "";
        try {
            content = Files.readAllLines(Paths.get(fileName)).stream().collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //return convertJsonToMap(content);

        return content;
    }

    public static String loadJsonFromServer() throws Exception {
        //TODO: Load data from server
        String data = "";
        data = LoginServer.loginAndGetJsonFromServer();
        //convertJsonToMap(data);


        return data;
    }

    static Map<String,String> convertJsonToMap(String json){
        Map<String, String> map = new HashMap<>();


        try {
            ObjectMapper mapper = new ObjectMapper();
            // convert JSON string to Map
            map = mapper.readValue(json, new TypeReference<Map<String, String>>(){});
            System.out.println("===============map==================");
            System.out.println(map);
            System.out.println("===============map==================");

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }


}
