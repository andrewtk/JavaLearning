package Parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * Created by a.tkachuk on 03.06.2017.
 */
public class LoginServer {

//      /*
//      {
//    "cmd": "loginOwner",
//    "ver": 82,
//    "brandName": "Loyverse",
//    "email": "loyversetester@gmail.com",
//    "passwdHash": "fbO5w+tC0+eoHs03Lw6g5qkzsCL33M2wb/+Ul2aP+VirvmLX+SI5AjvBQ2WzO4U2WQWNgol4fa9JIA2oxSmEprV1uBLoSVsHqIKTqUJAdInWpX4nz0REii9rwlWpDt0s/Hmo5ArTb/j+9E32ZnT3TxL5K3hnEMpw5nyDcIdkRpc=",
//    "devId": "69167bcd9391614f3cb1b900f1f692e6",
//    "devName": "Xiaomi MI PAD 2",
//    "type": "pos",
//    "gcmId": "APA91bGWQU6EeNvL_OZYH6_zbBY-zr7e7cdO8zUiIESJYW22ZJV5qSXcjCptLAc5gnlqjl7xDlNOo_wMQTmkguGnq2tdoedfOyYEcxih5OgN8VJGoMzudNixh0zRnZGVUZuE7ONXHtdN",
//    "devType": "android"
//  }
//      POST data:
//  {
//      "cmd": "sayHello",
//      "devName": "iPhone 6S Plus",
//      "email": "blablabla@mailinator.com",
//      "lang":"rus",
//      "brand":"LOYVERSE",
//      "confirmKey":"GFAHAREJASEDRFHAEDFSHA",
//      "country":"us",
//      "ownerId":"26889"
//  }
//       */

    public String
            cmd = "sayHello",
            devName ="iPhone 6S Plus",
            email ="blablabla@mailinator.com",
            lang="rus",
            brand= "LOYVERSE",
            confirmKey= "GFAHAREJASEDRFHAEDFSHA",
            country= "us",
            ownerId= "26889";
    static int port = 443;
    static String  httpServer = "https://devr.loyverse.com",
            user = "testiro",
            password = "Ntcnbyu16";

    public static void main(String[] args) throws Exception {
        String jsonStringFromServer = loginAndGetJsonFromServer();

    }

    public static String loginAndGetJsonFromServer() throws Exception {
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope(httpServer, port),
                new UsernamePasswordCredentials(user, password));
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsProvider)
                .build();
        try {
            //HttpGet httpget = new HttpGet("https://devr.loyverse.com/data/cabinetlogin");
            //
            HttpPost httpPost = new HttpPost("https://devr.loyverse.com/data/cabinetlogin");
            httpPost.setEntity(new StringEntity("{\"dontRemember\":false,\"devId\":null,\"email\":\"loyversetester@gmail.com\",\"password\":\"qwerty\",\"type\":\"pos\",\"lang\":\"eng\"}"));
            System.out.println("Executing request " + httpPost.getRequestLine());
            CloseableHttpResponse response = httpclient.execute(httpPost);
            try {
                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());
                String responseText = EntityUtils.toString(response.getEntity());
                if (responseText.contains("\"loginResult\":\"ok\"") )
                    System.out.println("Authorisation is passed");
                else
                    System.out.println("Wrong login or password");
                System.out.println(responseText);

                //устанавливаем новый запрос
                HttpPost httpPostReport = new HttpPost("https://devr.loyverse.com/data/ownercab/getearningsreport");
                // отправляем запрос из файла
                String request ="{\"merchantsIds\":\"all\",\"outletsIds\":\"all\",\"startDate\":1460926800000,\"endDate\":1461185999000,\"tzOffset\":10800000,\"tzName\":\"Europe/Kiev\",\"startTime\":0,\"endTime\":6,\"divider\":\"day\",\"limit\":\"10\",\"offset\":0}";//{"merchantsIds":"all","outletsIds":"all","startDate":1460926800000,"endDate":1461185999000,"tzOffset":10800000,"tzName":"Europe/Kiev","startTime":0,"endTime":6,"divider":"day","limit":"10","offset":0};
                httpPostReport.setEntity(new StringEntity(request));
                // получаем ответ
                CloseableHttpResponse responseReport = httpclient.execute(httpPostReport);
                //сравниваем полученный ответ и эталон из файла
                System.out.println("----------------------------------------");
                System.out.println(responseReport.getStatusLine());
                String responseReportText = EntityUtils.toString(responseReport.getEntity());
                System.out.println(responseReportText);
                responseReport.close();

                return responseReportText;
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }

        //отправить Post запрос
        // {"from":1496178000000,"to":1496782740000,"tzOffset":10800000,"startTime":null,"endTime":null,"limit":"10","offset":0,"merchantsIds":"all","outletsIds":"all"}
///*        String url = "https://devr.loyverse.com/data/ownercab/getcategoriesreport";
//
//        HttpClient client = HttpClientBuilder.create().build();
//        HttpPost post = new HttpPost(url);
//
//        // add header
//        post.setHeader("User-Agent", USER_AGENT);
//
//        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
//        urlParameters.add(new BasicNameValuePair("sn", "C02G8416DRJM"));
//        urlParameters.add(new BasicNameValuePair("cn", ""));
//        urlParameters.add(new BasicNameValuePair("locale", ""));
//        urlParameters.add(new BasicNameValuePair("caller", ""));
//        urlParameters.add(new BasicNameValuePair("num", "12345"));
//
//        post.setEntity(new UrlEncodedFormEntity(urlParameters));
//
//        HttpResponse response = client.execute(post);
//        System.out.println("Response Code : "
//                + response.getStatusLine().getStatusCode());
//
//        BufferedReader rd = new BufferedReader(
//                new InputStreamReader(response.getEntity().getContent()));
//
//        StringBuffer result = new StringBuffer();
//        String line = "";
//        while ((line = rd.readLine()) != null) {
//            result.append(line);
//        }
//        // получить ответ
//        //
//        //Request URL:https://devr.loyverse.com/data/ownercab/getcategoriesreport
//        //Request Method:POST
//        //Status Code:200 OK
//        //Remote Address:52.28.50.179:443
//        //Referrer Policy:no-referrer-when-downgrade
//        //
//        //
//        //
//        //
//        //
//
//        //{"result":"ok","merchantId":2731,"reportType":"CATEGORIES","columnsView":[{"name":"categoryName","value":true,"id":1},{"name":"itemsSold","value":true,"id":2},{"name":"grossSales","value":true,"id":3},{"name":"itemsRefunded","value":false,"id":4},{"name":"refunds","value":false,"id":5},{"name":"discounts","value":true,"id":6},{"name":"netSales","value":true,"id":7},{"name":"costOfGoods","value":false,"id":8},{"name":"grossProfit","value":true,"id":9},{"name":"margin","value":false,"id":10},{"name":"taxes","value":false,"id":11}]}
//
//*/
    }

}
