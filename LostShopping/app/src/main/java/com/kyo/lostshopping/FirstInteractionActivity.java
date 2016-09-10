package com.kyo.lostshopping;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.kyo.model.CUSTOMER;
import com.kyo.task.CreateAccountTask;

public class FirstInteractionActivity extends AppCompatActivity {

    Button btnSignIn, btnCreateAccount;
    EditText txtFirstName, txtLastName, txtAccount, txtEmail, txtPassword;
    Button btnCreateAccountDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_interaction);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FirstInteractionActivity.this,LogInActivity.class);
                startActivity(intent);
            }
        });

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FirstInteractionActivity.this,CreateAccountActivity.class);
                startActivity(intent);
            }
        });
    }

    /*private void handlingCreateAccount() {
        final Dialog dialog=new Dialog(FirstInteractionActivity.this);
        dialog.setContentView(R.layout.create_account);
        dialog.setTitle("Create Account");

        txtFirstName= (EditText) findViewById(R.id.txtFirstName);
        txtLastName= (EditText) findViewById(R.id.txtLastName);
        txtAccount= (EditText) findViewById(R.id.txtAccount);
        txtEmail= (EditText) findViewById(R.id.txtEmail);
        txtPassword= (EditText) findViewById(R.id.txtPassword);
        btnCreateAccountDialog= (Button) findViewById(R.id.btnCreateAccountDialog);
        dialog.show();

        btnCreateAccountDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateAccountTask createAccountTask=new CreateAccountTask(FirstInteractionActivity.this);
                CUSTOMER cus=new CUSTOMER();

                cus.setCUS_FIRSTNAME(txtFirstName.getText().toString());
                cus.setCUS_LASTNAME(txtLastName.getText().toString());
                cus.setCUS_ACCOUNT(txtAccount.getText().toString());
                cus.setCUS_EMAIL(txtEmail.getText().toString());
                cus.setCUS_PASS(txtPassword.getText().toString());

                createAccountTask.execute(cus);

                dialog.dismiss();

                Intent intent=new Intent(FirstInteractionActivity.this,LogInActivity.class);
                startActivity(intent);
            }
        });
    }*/

    private void addControls() {
        btnSignIn= (Button) findViewById(R.id.btnSignIn);
        btnCreateAccount= (Button) findViewById(R.id.btnCreateAccount);
    }

}
