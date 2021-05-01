package dev.atharvakulkarni.midas;

import java.util.HashMap;
import java.util.Map;

public class DatabasePOJO
{
    String value;

    public DatabasePOJO(String value)
    {
        this.value = value;
    }

    public DatabasePOJO()
    {}

    void setValue(String value)
    {
        this.value = value;
    }

    public String getData()
    {
        return value;
    }
}
