package DataStructure;

/**
 *
 * @author Marshall
 */
public class ChiffreAff 
{
    String description;
    float vente;
    
    public ChiffreAff(String desc, float sales)
    {
        this.description=desc;
        this.vente=sales;
    }
    
    public String getProd()
    {
        return this.description;
    }
    
    public float getSales()
    {
        return this.vente;
    }
    
    public void addToSales(float num)
    {
        this.vente+=num;
    }
}
