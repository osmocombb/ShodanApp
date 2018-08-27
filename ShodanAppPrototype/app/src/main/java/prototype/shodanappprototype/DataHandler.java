package prototype.shodanappprototype;

import com.fooock.shodan.model.banner.Banner;

import java.util.ArrayList;
import java.util.Map;

public class DataHandler {

    private static DataHandler handler;
    private ArrayList<FoundDevice> favouriteslist;
    private ArrayList<Banner> list;
    private ArrayList<String> IpList;

  //  private Map<String,Integer> favouritesmap;

    private DataHandler() {
    }

    public static DataHandler getInstance() {
        if (handler == null)
            handler = new DataHandler();
        return handler;
    }

    public ArrayList<FoundDevice> getFavouriteslist() {
        return favouriteslist;
    }

    public void setFavouriteslist(ArrayList<FoundDevice> Arraylist) {
        this.favouriteslist = Arraylist;
}
    public void addtofavourites(FoundDevice device){
        this.favouriteslist.add(device);
    }
    public ArrayList<Banner> getList() {
        return list;
    }

    public void setList(ArrayList<Banner> Arraylist) {
        this.list = Arraylist;
    }

    public ArrayList<String> getIpList() {
        return IpList;
    }

    public void setIpList(ArrayList<String> ipList) {
        IpList = ipList;
    }

    public void addToIpList(String s){
        IpList.add(s);
    }







 /*   public Map<String,Integer> getFavouritesmap() {
        return favouritesmap;
    }
*/
   /* public void setFavouritesmap(Map<String,Integer> map) {
        this.favouritesmap = map;
    }*/

  //  public void addToFavourites (String s, int i){this.favouritesmap.put(s,i);} // map ei toimi, pitää saada jotenkin listana siten että myös integer löytyy listasta, ehkäpä ipstr + i, josta i otetaan pois muutakäyttöä varten, toinen tapa olisi
} // kahtena listana tai sitten siirtää i jotain muuta kautta favourites-luokan tietoon, mahdollisesti myös FoundDevice luokka voisi tulla tässäkohtaa käyttöön sisältäen integerin