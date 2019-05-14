package coms.sparta.waj.webmanagement;

import coms.sparta.waj.Utility.PropertiesReader;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpManager
{
    private CloseableHttpClient httpClient;
    private CloseableHttpResponse httpResponse;
    private PropertiesReader propertiesReader;


    public HttpManager()
    {
        httpClient = HttpClients.createDefault();
    }

    public String getSingleUserJson()
    {
        String apiTarget = propertiesReader.getSingleUserUrl();
        HttpGet httpGet = new HttpGet(apiTarget);
        updateResponse(httpGet);
        return getResponseBody();
    }

    public String getAllUserJson()
    {
        String apiTarget = propertiesReader.getAllUsersUrl();
        HttpGet httpGet = new HttpGet(apiTarget);
        updateResponse(httpGet);
        return getResponseBody();
    }



    private void updateResponse(HttpGet request)
    {
        try
        {
            httpResponse = httpClient.execute(request);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private String getResponseBody()
    {
        String responseBody = null;

        try
        {
            //Entity Utils is an apache http utility class
            responseBody = EntityUtils.toString(httpResponse.getEntity());
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return responseBody;

    }

    //close http elements at the end of the process.
    public void close()
    {
        try
        {
            httpResponse.close();
            httpClient.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
