package coms.sparta.waj.deserialisers;

import com.fasterxml.jackson.databind.ObjectMapper;
import coms.sparta.waj.dtos.UserDto;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class UsersDeserialiser
{
    private UserDto[] userDto;

    public UsersDeserialiser(String fileLocation)
    {
        ObjectMapper userMapper = new ObjectMapper();

        try
        {
            userDto = userMapper.readValue(new File(fileLocation), UserDto[].class);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public UserDto[] getUsersDto()
    {
        return userDto;
    }

    public List<UserDto> getUsersAsList()
    {
        return Arrays.asList(userDto);
    }
}
