package DataStructure;

/**
 *
 * @author Marshall
 */
public class Client 
{
    //getclient nom,addresse,tel,mail
    
    String Name, Addr, Phone, Email;
    
    public Client(String Nom, String Addresse, String tel, String Mail)
    {
        this.Addr=Addresse;
        this.Email=Mail;
        this.Name=Nom;
        this.Phone=tel;
    }
    
    public String getAddress()
    {
        return this.Addr;
    }
    
    public String getMail()
    {
        return this.Email;
    }
    
    public String getName()
    {
        return this.Name;
    }
    
    public String getPhone()
    {
        return this.Phone;
    }
}
