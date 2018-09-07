package com.example.enc.httpmethoddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.enc.httpmethoddemo.pojo.FormSubmitResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText formName, formMobileNum;
    Button submitButton;
    //    List<Person> person;
    ApiInterface apiInterface;
    String name, mobNum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        formName = findViewById(R.id.formName);
        formMobileNum = findViewById(R.id.formMobileNum);
        submitButton = findViewById(R.id.submitButton); // button
        submitButton.setOnClickListener(this);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.submitButton) {
            name = formName.getText().toString();
            mobNum = formMobileNum.getText().toString();


            Call<FormSubmitResponse> call1 = apiInterface.setFormValues(mobNum,name);
            call1.enqueue(new Callback<FormSubmitResponse>() {
                @Override
                public void onResponse(Call<FormSubmitResponse> call,
                                       Response<FormSubmitResponse> response) {


                    if (response.isSuccessful()) {
                        if(response.body()!=null) {
                            if (response.body().getResult().equals("success") ) {

                                Toast.makeText(MainActivity.this, response.body().getName()
                                        + " " + response.body().getMobile(), Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(MainActivity.this, response.body().getStatus(),
                                        Toast.LENGTH_LONG).show();

                            }
                        }
                    }


                }

                @Override
                public void onFailure(Call<FormSubmitResponse> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Failure..!!!", Toast.LENGTH_LONG).show();
                    call.cancel();

                }
            });
        }


    }
}
