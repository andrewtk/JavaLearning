package Parser;

import java.io.IOException;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Created by a.tkachuk on 03.06.2017.
 */
public class LoginServer {
    /*
    {
  "cmd": "loginOwner",
  "ver": 82,
  "brandName": "Loyverse",
  "email": "loyversetester@gmail.com",
  "passwdHash": "fbO5w+tC0+eoHs03Lw6g5qkzsCL33M2wb/+Ul2aP+VirvmLX+SI5AjvBQ2WzO4U2WQWNgol4fa9JIA2oxSmEprV1uBLoSVsHqIKTqUJAdInWpX4nz0REii9rwlWpDt0s/Hmo5ArTb/j+9E32ZnT3TxL5K3hnEMpw5nyDcIdkRpc=",
  "devId": "69167bcd9391614f3cb1b900f1f692e6",
  "devName": "Xiaomi MI PAD 2",
  "type": "pos",
  "gcmId": "APA91bGWQU6EeNvL_OZYH6_zbBY-zr7e7cdO8zUiIESJYW22ZJV5qSXcjCptLAc5gnlqjl7xDlNOo_wMQTmkguGnq2tdoedfOyYEcxih5OgN8VJGoMzudNixh0zRnZGVUZuE7ONXHtdN",
  "devType": "android"
}
    POST data:
{
    "cmd": "sayHello",
    "devName": "iPhone 6S Plus",
    "email": "blablabla@mailinator.com",
    "lang":"rus",
    "brand":"LOYVERSE",
    "confirmKey":"GFAHAREJASEDRFHAEDFSHA",
    "country":"us",
    "ownerId":"26889"
}
     */
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
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope(httpServer, port),
                new UsernamePasswordCredentials(user, password));
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsProvider)
                .build();
        try {
            HttpGet httpget = new HttpGet(httpServer);

            System.out.println("Executing request " + httpget.getRequestLine());
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());
                System.out.println("Authorisation is passed");
                //System.out.println(EntityUtils.toString(response.getEntity()));
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }


    }

}
