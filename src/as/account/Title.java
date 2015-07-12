package as.account;

public class Title
{
    private int id;
    private String name, requirement;

    public Title(int id, String name, String requirement)
    {
        this.id = id;
        this.name = name;
        this.requirement = requirement;
    }
    
    public int id()
    {
        return this.id;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public String getRequirement()
    {
        return this.requirement;
    }

}