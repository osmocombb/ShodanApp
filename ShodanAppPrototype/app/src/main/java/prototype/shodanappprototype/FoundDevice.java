package prototype.shodanappprototype;
import java.util.ArrayList;

public class FoundDevice {
    private String HostName;
    private String Ip;
    private String Country;
   // private String EverythingElse;
   private String Server;
   private int index;

    private  ArrayList<String> data;
    // FoundDevice ei sisällä muuta kuin indexin, tätä indexiä käytetään Favourite-activityssä jossa kyseisellä indexillä haetaan kaikkien laitteiden listasta oikea laite
    public FoundDevice(int index){

        this.index = index;
     //   this.EverythingElse = everythingElse;
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
    public String getServer(){return Server;}
    public String getEverythingElse(){
   //     return EverythingElse;
        return "";
    }
    //Palautetaan indexi
    public int getIndex(){
        return this.index;
    }



}
