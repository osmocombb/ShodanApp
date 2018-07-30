package prototype.shodanappprototype;
import java.util.ArrayList;

public class FoundDevice {
    private String HostName;
    private String Ip;
    private String Country;
   // private String EverythingElse;
   private String Server;

    private  ArrayList<String> data;
    public FoundDevice(String Name, String Ip, String Country, String Server){
        this.HostName = Name;
        this.Ip = Ip;
        this.Country = Country;
        this.Server = Server;
     //   this.EverythingElse = everythingElse;
    }

    public void setData(String Name, String Ip, String Country, String EverythingElse){
            this.data.add(Name);
            this.data.add(Ip);
            this.data.add(Country);
            this.data.add(EverythingElse);
    }
    public void setHostName(String Name){
        this.HostName = Name;
    }
    public void setIp(String Ip){
        this.Ip = Ip;
    }
    public void setCountry(String Country){
        this.Country = Country;
    }
    public void setEverythingElse(String EverythingElse){
  //      this.EverythingElse = EverythingElse;
    }


    public String getHostName(){
        return HostName;
    }
    public String getIp(){
        return Ip;
    }
    public String getCountry(){
        return Country;
    }
    public String getEverythingElse(){
   //     return EverythingElse;
        return "";
    }

    public ArrayList<String> getData(){

        return data;
    }

}
