package Parser;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by a.tkachuk on 03.06.2017.
 */
public class GetJSONFromFile {

    private static ObjectMapper mapper = new ObjectMapper();
    public String fileDir = "D:\\loyverseen\\ownercub\\i18";
    public String etalonJsonFileName = "etalonJson.json";

    public static void main(String[] args) throws IOException {

        //получаем список эталонного JSON из файла
        GetJSONFromFile parserEtalon = new GetJSONFromFile();
        parserEtalon.parseEtalon();



        //получаем обычный файл запрос-ответ и сравниваем с эталоном
        GetJSONFromFile parser = new GetJSONFromFile();
        parser.run();
    }

    public  void  parseEtalon() throws IOException {
        String fileName=etalonJsonFileName;
        GetEtalonJSONFromFile getEtalonJson = new GetEtalonJSONFromFile();
        //getEtalonJson.;


    }

    public  void run() throws IOException {
        Stream<Path> files = Files.list(Paths.get(fileDir));
        files.forEach(file -> {
            try {
                String content = Files.readAllLines(file).stream().collect(Collectors.joining());
                JsonNode rootNode = mapper.readTree(content);
                //processFile(rootNode, file.toFile().getName());

                // отпправляем JSON на сервер
                // получаем ответ
                // берем из файла еталонный JSON
                // сравниваем с ответом
                // выдаем результат по запросу
                // переходим к следующему файлу

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
 /*
    private static void processFile(JsonNode rootNode, String name) throws IOException {
        String message;
        String[]st1;
        ObjectNode result = mapper.createObjectNode();;

        for (int i = 0; i< etalonJSON.length; i++){
            if (etalonJSON[i].contains(".")) {
                st1 = etalonJSON[i].split("\\.");
                message = rootNode.get(st1[0])
                        .get(st1[1]).
                                asText(); // получение строки из поля "message"
            }
            else{
                message = rootNode.get(etalonJSON[i]).asText(); // получение строки из поля "message"
            }
            //message=message+"/n";


            //JsonNode childNode =  rootNode.get("place"); // получаем объект Place
            //String place = childNode.get("name").asText(); // получаем строку из поля "name"
            System.out.println(etalonJSON[i] + " " + message); // напечатает "Hi World!"Ovj

            //result = mapper.createObjectNode();

            result.put(etalonJSON[i], message);
        }

        String fileName = "result"+ File.separator+name;
        Files.write(Paths.get(fileName), result.toString().getBytes());
    }
 */

}
