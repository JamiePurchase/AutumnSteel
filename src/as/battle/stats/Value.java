package as.battle.stats;

public class Value
{
    private int value;

    public Value(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return this.value;
    }
    
    public void setValue(int value)
    {
        this.value += value;
    }

}