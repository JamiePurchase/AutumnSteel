package as.battle.stats;

public class ValuePortion extends Value
{
    private int valueMax;

    public ValuePortion(int value, int max)
    {
        super(value);
        this.valueMax = max;
    }

    public float asPercent()
    {
        return (float)this.getValue() / (float)this.getValueMax() * 100f;
    }
    
    public int getValueMax()
    {
        return this.valueMax;
    }

}