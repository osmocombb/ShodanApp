package prototype.shodanappprototype;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;

import java.util.Locale;

public class MyMenu {
    Activity current_activity;
    public static String ln;

    public MyMenu(Activity activity) {
        current_activity = activity;
        // Asetetaan kieli defaultiksi, jos sitä ei ole asetettu vielä
        if(ln == null)ln = Locale.getDefault().getLanguage();
    }


/*
    public void MenuFlag(MenuItem lang, String ln ) {
        switch(ln){
            case "sv":
                lang.setIcon(m_activity.getResources().getDrawable(R.mipmap.ruotsi_item));
                break;
            case "en":
                lang.setIcon(m_activity.getResources().getDrawable(R.mipmap.englanti_item));
                break;
            default:
                lang.setIcon(m_activity.getResources().getDrawable(R.mipmap.suomi_item_2));
                break;
        }
    }*/


    public void SelectItem(int id) {
        switch (id) {
            case (R.id.en_language):
                Locale locale = new Locale("en");
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                current_activity.getBaseContext().getResources().updateConfiguration(config,
                        current_activity.getBaseContext().getResources().getDisplayMetrics());
                ln = "en";
                current_activity.recreate();
                break;

            case (R.id.fi_language):
                locale = new Locale("fi");
                Locale.setDefault(locale);
                config = new Configuration();
                config.locale = locale;
                current_activity.getBaseContext().getResources().updateConfiguration(config,
                        current_activity.getBaseContext().getResources().getDisplayMetrics());
                ln = "fi";
                current_activity.recreate();
                break;

            case (R.id.sv_language):
                locale = new Locale("sv");
                Locale.setDefault(locale);
                config = new Configuration();
                config.locale = locale;
                current_activity.getBaseContext().getResources().updateConfiguration(config,
                        current_activity.getBaseContext().getResources().getDisplayMetrics());
                ln = "sv";
                current_activity.recreate();
                break;
            case (R.id.LogOut):
              Intent intent1 = new Intent(current_activity, LoginActivity.class);
               if(AppConstants.KEY_QR_CODE.length()>2) {
                   AppConstants.KEY_QR_CODE = "";
               }

                current_activity.startActivity(intent1);

                break;
            case (R.id.favourites):
                intent1 = new Intent(current_activity, FavouritesActivity.class);
                current_activity.startActivity(intent1);
                break;

           /* case (R.id.Search):
                intent1 = new Intent(current_activity, Main2Activity.class);
                intent1.putExtra(key, "KEYlinkit");
                current_activity.startActivity(intent1);
                break;
                */
            case (R.id.main):
                intent1 = new Intent(current_activity, SearchActivity.class);
                current_activity.startActivity(intent1);
                break;
            case (R.id.Settings):

                break;
            case (R.id.About):
                intent1 = new Intent(current_activity, AboutActivity.class);
                current_activity.startActivity(intent1);
                break;

        }

    }
}
