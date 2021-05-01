package dev.atharvakulkarni.midas;

public class UserModel
{
    static String village = "कोनांबे";

    public static String getVillage()
    {
        return village;
    }

    public static void setVillage(String village)
    {
        UserModel.village = village;
    }
}
