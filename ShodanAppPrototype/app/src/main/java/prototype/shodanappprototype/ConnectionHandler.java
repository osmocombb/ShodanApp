package prototype.shodanappprototype;

import android.content.Context;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;

import com.fooock.shodan.ShodanRestApi;
import com.fooock.shodan.model.banner.Banner;
import com.fooock.shodan.model.host.FacetReport;
import com.fooock.shodan.model.host.HostReport;

import java.util.List;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by Azumi on 24.3.2018.
 */

public class ConnectionHandler {
    private String query;
    private ShodanRestApi apikey = new ShodanRestApi(AppConstants.KEY_QR_CODE);
    private int total;
    private List<Banner> banners;
    private FacetReport facet;
    public HostReport hostsreport;
    private Context context;
    private int answerHost,answerFacet;


    public ConnectionHandler(String query, Context context){
        this.query = query;
        this.context = context;
      //  ConnectToShodan();
    }

        public HostReport ConnectToShodanHostReport(){


        apikey.hostSearch(this.query)
                .subscribe(new DisposableObserver<HostReport>() {

        @Override
        public void onError(Throwable e) {
            // called if an error occurs
            Toast toast = Toast.makeText(context,"Error! " + e ,Toast.LENGTH_LONG);
            toast.show();
            Log.d("ERROR", e.toString());

        }

        @Override
        public void onComplete() {
            Toast toast = Toast.makeText(context,"OnComplete "+ total,Toast.LENGTH_LONG);
            toast.show();

        }

        @Override
        public void onNext(HostReport hostReport) {
            // result of the query
            Toast toast = Toast.makeText(context,"OnNext",Toast.LENGTH_LONG);
            toast.show();
            hostsreport = hostReport;
            total = hostReport.getTotal();
            banners = hostReport.getBanners();
            facet = hostReport.getFacet();
            answerHost = total;
        }
    });
        return hostsreport;
        }

    public int ConnectToShodanFacetReport(){


        apikey.hostCount(this.query)
                .subscribe(new DisposableObserver<FacetReport>() {

                    @Override
                    public void onError(Throwable e) {
                        // called if an error occurs
                        Toast toast = Toast.makeText(context,"Error! " + e ,Toast.LENGTH_LONG);
                        toast.show();
                        Log.d("ERROR", e.toString());

                    }

                    @Override
                    public void onComplete() {
                        Toast toast = Toast.makeText(context,"OnComplete "+ total,Toast.LENGTH_LONG);
                        toast.show();

                    }

                    @Override
                    public void onNext(FacetReport facetReport) {
                        // result of the query
                        Toast toast = Toast.makeText(context,"OnNext",Toast.LENGTH_LONG);
                        toast.show();
                        total = facetReport.getTotal();
                        answerFacet = total;
                    }
                });
        return answerFacet;
    }


}
