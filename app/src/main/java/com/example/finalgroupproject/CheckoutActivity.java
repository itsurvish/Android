package com.example.finalgroupproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CheckoutActivity extends AppCompatActivity {

    int numberOfItems = 1;
    Product product;
    private Button buttonConfirm, buttonContact;
    private EditText FirstName,email,LastName,Phone,txtNoItems;
    private RadioGroup rdGrp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

//        this.txtEmail = (TextView) findViewById(R.id.txtEmail);
        this.email = (EditText) findViewById(R.id.email);
        //      this.txtFnm = (TextView) findViewById(R.id.txtFnm);
        FirstName = (EditText) findViewById(R.id.FirstName);
        //      this.txtLnm = (TextView) findViewById(R.id.txtLnm);
        this.LastName = (EditText) findViewById(R.id.LastName);
        //      this.txtNum = (TextView) findViewById(R.id.txtNum);
        this.Phone = (EditText) findViewById(R.id.Phone);
        this.txtNoItems = (EditText) findViewById(R.id.txtNoItems);
        //       this.txtPayment = (TextView) findViewById(R.id.txtPayment);
        this.rdGrp = (RadioGroup) findViewById(R.id.rdGrp);
        buttonConfirm = (Button) findViewById(R.id.buttonConfirm);
        buttonContact= (Button) findViewById(R.id.buttonContact);
        final Intent intent = getIntent();
        if (intent != null) {
            product = new Product();
            product.setName(intent.getStringExtra("name"));
            product.setImg(intent.getStringExtra("img"));
            product.setPrice(intent.getFloatExtra("price",0));

        }

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(FirstName.getText().toString().isEmpty()){
                    FirstName.setError("This Field is Required");
                }if(email.getText().toString().isEmpty()){
                    email.setError("This Field is Required");
                }if(LastName.getText().toString().isEmpty()){
                    LastName.setError("This Field is Required");
                }if(Phone.getText().toString().isEmpty()){
                    Phone.setError("This Field is Required");
                }if(txtNoItems.getText().toString().isEmpty()){
                    txtNoItems.setError("This Field is Required");
                }if(rdGrp.getCheckedRadioButtonId() == -1){
                    //not selected
                }else {
                    Toast.makeText(CheckoutActivity.this, "Your Test Drive has been Booked.", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), IndexActivity.class));
                }
            }
        });
        buttonContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CheckoutActivity.this, ContactUs.class);
                startActivity(intent);
            }
        });
    }

}
