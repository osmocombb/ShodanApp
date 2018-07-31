package prototype.shodanappprototype;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.ListView;

import com.fooock.shodan.model.host.HostReport;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
//This list will contain found devices


public class SearchThread extends Thread{

    ArrayList<String> Temp,ListOfIPS;
    ArrayList<FoundDevice> ArrayOfDevices;
    FoundDevice foundDevice;
   private String newText;
   private Activity m_activity;
   HostReport GetHostReport;
    ConnectionHandler connectionHandler;
   private boolean deviceSearchMade = false;
   private ArrayList mlist;

   // CustomUserAdapter adapter;
    public int GetAnswer;
    public SearchThread(String text, Activity activity ){

        newText = text;
        m_activity = activity;

        //First search devices, then put this true, then use search bar as "Search from results" with filter style, then if done search again make it as deviceSearch



    }

    public void run() {
        if (!deviceSearchMade && newText.length() > 0) {
            connectionHandler = new ConnectionHandler(newText, m_activity);
            GetAnswer = connectionHandler.ConnectToShodanFacetReport();
            GetHostReport = connectionHandler.ConnectToShodanHostReport();
            CreateListDeviceList();




        } else {

            if (newText.length() > 1) {

                //katkaise hakumerkkijono valilyöntien kohdalta
                // ja muodosta taulukko

                String searchArray[] = newText.split("\\s");


                //reset array list


             //   ArrayOfDevices = new ArrayList<String>();

                //loop all devices
                for (int i = 0; i < ArrayOfDevices.size(); i++) {
                    try {

                        //get single article object
                      //  foundDevice.toString() = ArrayOfDevices.get(i);

                        //get article title
                        //note: change this string to lower case to avoid case sensitive issue
                        String title = ArrayOfDevices.get(i).getIp();

                        boolean trigger = true;

                        //if title contains the search string...
                        //note: change this string to lower case too
                        for (int i2 = 0; i2 < searchArray.length; i2++) {
                            if (title.contains(searchArray[i2].toLowerCase()) && trigger == true) {
                                trigger = true;

                            } else {
                                trigger = false;
                            }
                        }
                        if (trigger == true) {
                            ArrayOfDevices.add(foundDevice);
                        }

                    } catch (final Exception e) {
                        Log.e("DEBUG", "Json parsing error: " + e.getMessage());
                    }
                }


            }
        }
    }

    public int ReturnAnswer(){
        return GetAnswer;
    }

    public void CreateListDeviceList(){
        ArrayOfDevices = new ArrayList<>();
        Temp = new ArrayList<>();
        ListOfIPS = new ArrayList<>();
        int i = 0;
        if(GetHostReport.getBanners() != null){


        while(i<GetHostReport.getBanners().size()){
        Temp.add(GetHostReport.getBanners().get(i).toString());
        i++;
        }
        i = 0;
        while(i<Temp.size()){
            String CurrentString = Temp.get(i);
            //ipStr='ip'
            String[] separateLeft = CurrentString.split("ipStr='");
            String[] separateRight = separateLeft[1].split("'");
            String ip = separateRight[0];
            foundDevice = new FoundDevice("Name",ip,"Country", "Server"); // tämä kesken, tehdään samalla tavalla kuin ip-osoite
            ArrayOfDevices.add(foundDevice);
            ListOfIPS.add(foundDevice.getIp());
            i++;
        }
            DataHandler.getInstance().setList(ArrayOfDevices);

        }

    }



}