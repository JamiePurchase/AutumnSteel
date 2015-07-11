package as.maths;

public class Range
{
    private int rangeMin, rangeMax;

    public Range(int min, int max)
    {
        this.rangeMin = min;
        this.rangeMax = max;
    }

    public boolean contains(int check)
    {
        if(check >= this.rangeMin && check <= rangeMax) {return true;}
        return false;
    }

}