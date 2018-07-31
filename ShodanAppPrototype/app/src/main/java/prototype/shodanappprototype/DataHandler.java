package prototype.shodanappprototype;

import java.util.ArrayList;

public class DataHandler {

    private static DataHandler handler;
    private ArrayList<FoundDevice> list;

    private DataHandler() {
    }

    public static DataHandler getInstance() {
        if (handler == null)
            handler = new DataHandler();
        return handler;
    }

    public ArrayList<FoundDevice> getList() {
        return list;
    }

    public void setList(ArrayList<FoundDevice> Arraylist) {
        this.list = Arraylist;
}
}