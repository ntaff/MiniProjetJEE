package DataStructure;

/**
 *
 * @author Marshall
 */
public class ChiffreAff 
{
    String produit;
    float vente;
    
    public ChiffreAff(String prod, float sales)
    {
        this.produit=prod;
        this.vente=sales;
    }
    
    public String getProd()
    {
        return this.produit;
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
