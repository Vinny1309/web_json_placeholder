package coms.sparta.waj.WebManagementTests;

import coms.sparta.waj.Utility.PropertiesReader;
import coms.sparta.waj.deserialisers.UserDeserialiser;
import coms.sparta.waj.deserialisers.UsersDeserialiser;
import coms.sparta.waj.dtos.UserDto;
import coms.sparta.waj.webmanagement.HttpManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class ComponentIntegrationTests
{
    private static HttpManager manager;
    private static PropertiesReader reader;

    @BeforeClass
    public static void setUp()
    {
        manager = new HttpManager();
        reader = new PropertiesReader();
    }


    //Test checks that addition can be performed on the returned id.
    //This confirms that an integer has been returned.
    @Test
    public void testSingleDto()
    {
        String userUrl = reader.getSingleUserUrl();
        UserDeserialiser singleDeserialiser = new UserDeserialiser(userUrl);
        Assert.assertTrue(singleDeserialiser.getUserDto().getId() +1 >0);
    }


    @Test
    public void testMultiDtoReturns()
    {
        String usersUrl = reader.getAllUsersUrl();
        UsersDeserialiser multiDeserialiser = new UsersDeserialiser(usersUrl);

        List<UserDto> userList = multiDeserialiser.getUsersAsList();
        UserDto[] userArray = multiDeserialiser.getUsersDto();

        Assert.assertEquals(userArray.length, userList.size());
    }

    


}
