package prototype.shodanappprototype;

import com.fooock.shodan.model.banner.Banner;

import java.util.ArrayList;

public class DataHandler {

    private static DataHandler handler;
   // private ArrayList<FoundDevice> list;
    private ArrayList<Banner> list;

    private DataHandler() {
    }

    public static DataHandler getInstance() {
        if (handler == null)
            handler = new DataHandler();
        return handler;
    }

    public ArrayList<Banner> getList() {
        return list;
    }

    public void setList(ArrayList<Banner> Arraylist) {
        this.list = Arraylist;
}
}