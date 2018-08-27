package prototype.shodanappprototype;

import android.content.Context;
import android.content.Intent;
import android.location.Geocoder;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


// Activity Löydetyn tuloksen tietojen näyttöön
public class InformationOfResult extends AppCompatActivity {
    TextView Ip, Server, Country, HostName;
    String ipString,serverString,countryString,hostNameString;
    MyMenu menu;
    Button take_me_to_site_button,Show_more_info,favourites_btn;
    int i;
    ArrayList<FoundDevice> favourites;
    ArrayList<String> FavouritesIpList;
    FoundDevice foundDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_of_result);

        Intent intent = getIntent();
        i = intent.getIntExtra("deviceInformation", 0);
        take_me_to_site_button = findViewById(R.id.TakeToSite);
        Show_more_info = findViewById(R.id.Show_more_info);
        favourites_btn = findViewById(R.id.AddToFavourites_btn);
        //Tarkistetaan onko laite jo Favouritena
        try {
            if(DataHandler.getInstance().getIpList().contains(DataHandler.getInstance().getList().get(i).getIpStr())) {
                favourites_btn.setVisibility(View.GONE);
            }
        }catch (NullPointerException n){

            }


        Ip = findViewById(R.id.ipaddress);
        Server = findViewById(R.id.Server);
        Country = findViewById(R.id.Country);
        HostName = findViewById(R.id.HostName);
        setData();
        menu = new MyMenu(this);


        take_me_to_site_button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                String url ="http://" + DataHandler.getInstance().getList().get(i).getIpStr();
               // String url = "www.google.fi";
               // final String myPackage = getPackageName();
                //Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(url + myPackage));
                Intent browserIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(url));
                startActivity(browserIntent);
              //  startActivity(intent);

            }
        });


        Show_more_info.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(InformationOfResult.this, ExtraInformationOfDevice.class);
                myIntent.putExtra("IndexOfInformation", i);
                InformationOfResult.this.startActivity(myIntent);


            }
        });


        favourites_btn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                //Jos Favourite listaa ei vielä ole niin se luodaan, eli jos yhtään favouritea ei ole vielä valittu
                if(DataHandler.getInstance().getFavouriteslist()== null || DataHandler.getInstance().getIpList() == null ){
                    favourites = new ArrayList<>();
                    FavouritesIpList = new ArrayList<>();
                    DataHandler.getInstance().setIpList(FavouritesIpList);
                    DataHandler.getInstance().setFavouriteslist(favourites); // lista
                }
                // Luodaan FoundDevice-olio, jolle annetaan arvoksi indeksi, jota sitten myöhemmin voidaan käyttää favouritelistaa avatessa, jotta päädytään oikeeseen laitteeseen
                setFoundDevice();
               DataHandler.getInstance().addtofavourites(foundDevice);
               DataHandler.getInstance().addToIpList(DataHandler.getInstance().getList().get(i).getIpStr());
               //Favourite-nappi katoaa, kun sitä kerran painettu, tarkoitus muuttaa vielä niin, että se muuttuu Unfavourite-napiksi ja poistaa listalta.
               favourites_btn.setVisibility(View.GONE);

            }
        });

    }
    // Asetetaan erilaiset datat
    public void setData() {
        ipString = DataHandler.getInstance().getList().get(i).getIpStr();
        serverString = DataHandler.getInstance().getList().get(i).getIsp();
        hostNameString = DataHandler.getInstance().getList().get(i).getTitle();
        countryString = DataHandler.getInstance().getList().get(i).getLocation().toString();
        Ip.setText(ipString);
        Server.setText(serverString);
        HostName.setText(hostNameString);
        Country.setText(countryString);
    }
    //Luodaan FoundDevice-olio
    public void setFoundDevice(){

       foundDevice = new FoundDevice(i);
    }

    //Lisätään menu activityyn
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_menu, menu);
        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        menu.SelectItem(item.getItemId());
        try{
            if(item.getItemId()==R.id.LogOut && item.getIcon().getConstantState().equals(getResources().getDrawable(R.drawable.ic_lock_black_24dp).getConstantState()) ){
                item.setIcon(R.drawable.ic_lock_open_black_24dp);
            }else if(item.getItemId()==R.id.LogOut){
                item.setIcon(R.drawable.ic_lock_black_24dp);
            }

        }catch (Exception e){

        }
        return true;
    }
}




