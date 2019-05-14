package coms.sparta.waj.deserialisers;

import com.fasterxml.jackson.databind.ObjectMapper;
import coms.sparta.waj.dtos.UserDto;

import java.io.File;
import java.io.IOException;

public class UserDeserialiser
{
    private UserDto userDto;

    public UserDeserialiser(String fileLocation)
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

    public UserDto getUserDto()
    {
        return userDto;
    }
}
