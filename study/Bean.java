// this is a JavaBean

import java.io.Serializable;

public class Bean implements Serializable
{
    private String name;
    private int id;
    private boolean isTrue;

    public Bean(){}

    public String getName()
    {return name;}
    public int getid()
    {return id;}
    public boolean getisTrue()
    {return isTrue;}

    public void setName(String name)
    {this.name = name;}
    public void setid(int id)
    {this.id = id;}
    public void setisTrue(boolean isTrue)
    {this.isTrue = isTrue;}
}
