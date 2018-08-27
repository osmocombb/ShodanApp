package prototype.shodanappprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity  {
    Button LogInButton,UseCameraButton;
    EditText ApiKeyText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        LogInButton = (Button)findViewById(R.id.LogInButton);
        UseCameraButton = (Button)findViewById(R.id.OpenCameraButton);
        ApiKeyText = (EditText)findViewById(R.id.ApikeyEditText);



        LogInButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

               if (ApiKeyText.getText().length()>10){
                   AppConstants.KEY_QR_CODE = ApiKeyText.getText().toString();
                   Intent intent = new Intent(LoginActivity.this,SearchActivity.class);
                   startActivity(intent);
                   finish();
               }


            }
        });

        UseCameraButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LoginActivity.this,UseCameraToLogInActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }


}

