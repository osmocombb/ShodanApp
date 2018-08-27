package prototype.shodanappprototype;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.fooock.shodan.model.banner.Banner;

import java.util.ArrayList;

public class FavouritesActivity extends AppCompatActivity {
    CustomListAdapter adapter;
    ListView listView;
    MyMenu menu;
    ArrayList<String> ListForFavourites;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);
        menu = new MyMenu(this);
        // Jos lista on olemassa niin se asetetaan ListViewiin
        if (DataHandler.getInstance().getFavouriteslist() != null){
           // CreateListViewForAdapter();
            adapter = new CustomListAdapter(FavouritesActivity.this, DataHandler.getInstance().getIpList());
            listView = (ListView) findViewById(R.id.ListViewForFavourites);
            listView.setAdapter(adapter);
            // ListItemille laitetaan kuuntelija
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent myIntent = new Intent(FavouritesActivity.this, InformationOfResult.class);
                    // Laitetaan extraksi
                    myIntent.putExtra("deviceInformation", DataHandler.getInstance().getFavouriteslist().get(position).getIndex()); //Optional parameters
                    FavouritesActivity.this.startActivity(myIntent);
            //        Toast.makeText(FavouritesActivity.this, ListForFavourites.get(position).toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }






    }

    // Lisätään menu activityyn
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_menu, menu );
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

  /*  public void CreateListViewForAdapter(){
        int i = 0;

        while(i<DataHandler.getInstance().getFavouriteslist().size()){
            if (i == DataHandler.getInstance().getFavouriteslist().get(i).getIndex()){



            }
            i++;

        }




}*/
}
