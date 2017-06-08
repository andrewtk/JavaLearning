package Parser;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

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

    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws Exception {
        String fileName = "etalonJson.json";
        String jsonStringFromServer="";
        Map<String,String> jsonFromFile = loadEtalonJson(fileName);
        Map<String,String> jsonFromServer = loadJsonFromServer();

        while  ( !(jsonFromServer.isEmpty())){
            System.out.print(jsonFromServer.get(jsonStringFromServer));
        }
        System.out.print(jsonFromServer);


    }

    public static Map<String,String> loadEtalonJson(String etalonJsonFileName) {
        //String fileDir = "D:\\loyverseen\\ownercub\\i18";
        String fileDir = "D:\\";

        Map<String, String> map = new HashMap<>();

        String fileName = fileDir + File.separator + etalonJsonFileName;
        String content = "";
        try {
            content = Files.readAllLines(Paths.get(fileName)).stream().collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return convertJsonToMap(content);
    }

    public static Map<String,String> loadJsonFromServer() throws Exception {
        //TODO: Load data from server
        String data = "";
        data = LoginServer.loginAndGetJsonFromServer();

        return convertJsonToMap(data);
    }

    static Map<String,String> convertJsonToMap(String json){
        Map<String, String> map = new HashMap<>();


        try {
            ObjectMapper mapper = new ObjectMapper();
            // convert JSON string to Map
            map = mapper.readValue(json, new TypeReference<Map<String, String>>(){});

            System.out.println(map);

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
