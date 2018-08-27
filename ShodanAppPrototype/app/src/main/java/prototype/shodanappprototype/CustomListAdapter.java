package prototype.shodanappprototype;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;


public class CustomListAdapter extends ArrayAdapter<FoundDevice>{


    private List items;
    TextView text;

    public CustomListAdapter (Context context, List devices){
        super(context,0, devices);

        items = devices;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent){
        View mView = v;

        /*if (mView == null){
            LayoutInflater vi = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = vi.inflate(id, null);
        }*/

        if (mView == null) {

            LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = vi.inflate(R.layout.device_item, null);

           // mView = LayoutInflater.from(getContext()).inflate(R.layout.device_item, parent, false);
        }

         text = (TextView)mView.findViewById(R.id.DeviceItem);
        text.setText(items.get(position).toString());

        return mView;
    }

}
