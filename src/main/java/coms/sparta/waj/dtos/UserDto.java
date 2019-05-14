package coms.sparta.waj.dtos;

public class UserDto
{
    int id;
    String name;
    String username;
    String email;
    AddressDto address;
    String phone;
    String website;
    CompanyDto company;

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getUsername()
    {
        return username;
    }

    public String getEmail()
    {
        return email;
    }

    public AddressDto getAddress()
    {
        return address;
    }

    public String getPhone()
    {
        return phone;
    }

    public String getWebsite()
    {
        return website;
    }

    public CompanyDto getCompany()
    {
        return company;
    }
}
