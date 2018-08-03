package prototype.shodanappprototype;

import android.content.Context;
import android.content.Intent;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Locale;


// Activity Löydetyn tuloksen tietojen näyttöön
public class InformationOfResult extends AppCompatActivity {
TextView Ip,Server,Country,HostName;
int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_of_result);

        Intent intent = getIntent();
        int value = intent.getIntExtra("deviceInformation", 0);
        i = value;
        Ip = findViewById(R.id.ipaddress);
        Server = findViewById(R.id.Server);
        Country = findViewById(R.id.Country);
        HostName = findViewById(R.id.HostName);
        setData();

    }

    public void setData(){

        Ip.setText(DataHandler.getInstance().getList().get(i).getIpStr());
        Server.setText(DataHandler.getInstance().getList().get(i).getIsp());
        HostName.setText(DataHandler.getInstance().getList().get(i).getTitle());
        Country.setText(DataHandler.getInstance().getList().get(i).getLocation().toString());
    }



}
