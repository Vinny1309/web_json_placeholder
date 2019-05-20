package coms.sparta.waj.deserialisers;

abstract class Deserialiser
{
    Deserialiser()
    {

    }

    //default access, to be used by child classes
    boolean isUrl(String fileLocation)
    {
        if (fileLocation.contains("http"))
        {
            return true;
        }
        return false;
    }
}
