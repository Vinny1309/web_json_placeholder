package coms.sparta.waj.webmanagement;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class HttpManager
{
    private CloseableHttpClient httpClient;
    private CloseableHttpResponse httpResponse;


    public HttpManager()
    {
        httpClient = HttpClients.createDefault();
    }




    private void getResponse(HttpGet request)
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
