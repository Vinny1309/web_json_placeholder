package coms.sparta.waj.Utility;

import coms.sparta.waj.exceptions.PropertyUndefinedException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader
{
    private static final String PROP_LOC = "resources/placeholder.properties";
    private Properties properties;

    public PropertiesReader()
    {
        properties = new Properties();

        try
        {
            properties.load(new FileReader(PROP_LOC));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public String getSingleUserUrl()
    {
        String propertyId = "user_id";
        String userId = properties.getProperty(propertyId);
        if (userId.equals(""))
        {
            throw new PropertyUndefinedException("Value not found for property: " + propertyId);
        }
        return getBaseUrl() + getUserEndpoint() + userId;
    }

    public String getAllUsersUrl()
    {
        return getBaseUrl() + getUserEndpoint();
    }

    private String getBaseUrl()
    {
        return properties.getProperty("base_url");
    }

    private String getUserEndpoint()
    {
        return properties.getProperty("user_endpoint");
    }

    public Properties getProperties()
    {
        return properties;
    }


}
