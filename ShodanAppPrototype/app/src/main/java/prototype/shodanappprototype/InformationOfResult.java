package prototype.shodanappprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


// Activity Löydetyn tuloksen tietojen näyttöön
public class InformationOfResult extends AppCompatActivity {
TextView Ip,Server,Country,HostName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_of_result);

        Intent intent = getIntent();
        int value = intent.getIntExtra("deviceInformation", 0);
        Ip = findViewById(R.id.ipaddress);
        Server = findViewById(R.id.Server);
        Country = findViewById(R.id.Country);
        HostName = findViewById(R.id.HostName);
        Ip.setText(DataHandler.getInstance().getList().get(value).getIp());
        Server.setText(DataHandler.getInstance().getList().get(value).getServer());
        HostName.setText(DataHandler.getInstance().getList().get(value).getHostName());
        Country.setText(DataHandler.getInstance().getList().get(value).getCountry());
    }
}
