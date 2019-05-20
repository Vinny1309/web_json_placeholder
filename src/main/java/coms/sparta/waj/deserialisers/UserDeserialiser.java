package coms.sparta.waj.deserialisers;

import com.fasterxml.jackson.databind.ObjectMapper;
import coms.sparta.waj.dtos.UserDto;
import coms.sparta.waj.webmanagement.HttpManager;

import java.io.File;
import java.io.IOException;

public class UserDeserialiser extends Deserialiser
{
    private UserDto userDto;

    public UserDeserialiser(String fileLocation)
    {
        ObjectMapper userMapper = new ObjectMapper();

        try
        {
            if(isUrl(fileLocation))
            {
                HttpManager httpManager = new HttpManager();
                String jsonString = httpManager.getJsonFromUrl(fileLocation);
                userDto = userMapper.readValue(jsonString, UserDto.class);
            }
            else
            {
                userDto = userMapper.readValue(new File(fileLocation), UserDto.class);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void constructFromFile(String fileLocation)
    {
        ObjectMapper userMapper = new ObjectMapper();

        try
        {
            userDto = userMapper.readValue(new File(fileLocation), UserDto.class);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void constructFromWeb(String webLocation)
    {

    }

    public UserDto getUserDto()
    {
        return userDto;
    }
}
