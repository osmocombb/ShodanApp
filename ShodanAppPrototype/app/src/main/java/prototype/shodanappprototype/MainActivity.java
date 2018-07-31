package prototype.shodanappprototype;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.fooock.shodan.ShodanRestApi;
import com.fooock.shodan.model.banner.Banner;
import com.fooock.shodan.model.host.FacetReport;
import com.fooock.shodan.model.host.HostReport;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.observers.DisposableObserver;

public class MainActivity extends AppCompatActivity {
    TextView text;
    EditText searchText;
    HostReport reportHostData;
    String SearchString;
    int FoundData;
    FoundDevice device;
    ArrayList list;
    CustomListAdapter adapter;
    SearchThread mysearch;
    ListView listView;
    static ArrayList<FoundDevice> ArrayOfDevices = new ArrayList<FoundDevice>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        searchText = (EditText)findViewById(R.id.Search);
        text = (TextView)findViewById(R.id.Text);
        list = new ArrayList();

        mysearch = null;

        Button SearchButton = (Button)findViewById(R.id.btnSearch);

        SearchButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

              //  ConnectionHandler connectionHandler = new ConnectionHandler(searchText.getText().toString(),MainActivity.this);
                SearchString = searchText.getText().toString();
               StartSearchThread();
               String homo = Integer.toString(FoundData);
               String x = homo + getString(R.string.Found_results);
               text.setText(x);


                if(reportHostData != null && list != null){
                   adapter = new CustomListAdapter(MainActivity.this, list);
                   listView = (ListView)findViewById(R.id.DeviceList);
                   listView.setAdapter(adapter);

                }

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                        Intent myIntent = new Intent(MainActivity.this, InformationOfResult.class);
                        myIntent.putExtra("deviceInformation", position); //Optional parameters
                        MainActivity.this.startActivity(myIntent);
                        Toast.makeText(MainActivity.this,list.get(position).toString(),Toast.LENGTH_SHORT).show();
                    }
                });

        }

        });



    }
        // 100 tulosta maksimi ilmaisella shodan-tilillä
    public void StartSearchThread(){
        mysearch = new SearchThread(SearchString,MainActivity.this);
        mysearch.run();
        FoundData = mysearch.GetAnswer;
        reportHostData = mysearch.GetHostReport;
        list = mysearch.ListOfIPS;
    }





    }
