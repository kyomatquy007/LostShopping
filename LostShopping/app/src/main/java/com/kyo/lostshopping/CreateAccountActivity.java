package com.kyo.lostshopping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.kyo.model.CUSTOMER;
import com.kyo.task.CreateAccountTask;

public class CreateAccountActivity extends AppCompatActivity {

    EditText txtFirstName, txtLastName, txtAccount, txtEmail, txtPassword;
    Button btnCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handlingCreateAccount();
            }
        });
    }

    private void handlingCreateAccount() {
        CreateAccountTask createAccountTask=new CreateAccountTask(CreateAccountActivity.this);
        CUSTOMER cus=new CUSTOMER();

        cus.setCUS_FIRSTNAME(txtFirstName.getText().toString());
        cus.setCUS_LASTNAME(txtLastName.getText().toString());
        cus.setCUS_ACCOUNT(txtAccount.getText().toString());
        cus.setCUS_EMAIL(txtEmail.getText().toString());
        cus.setCUS_PASS(txtPassword.getText().toString());

        createAccountTask.execute(cus);

    }

    private void addControls() {
        txtFirstName= (EditText) findViewById(R.id.txtFirstName);
        txtLastName= (EditText) findViewById(R.id.txtLastName);
        txtAccount= (EditText) findViewById(R.id.txtAccount);
        txtEmail= (EditText) findViewById(R.id.txtEmail);
        txtPassword= (EditText) findViewById(R.id.txtPassword);
        btnCreateAccount= (Button) findViewById(R.id.btnCreateAccount);
    }
}
