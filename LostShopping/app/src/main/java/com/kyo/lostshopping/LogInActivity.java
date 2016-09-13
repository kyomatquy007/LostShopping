package com.kyo.lostshopping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.kyo.task.SignInTask;

public class LogInActivity extends AppCompatActivity {

    Button btnSignIn, btnCreateAccount;
    EditText txtAccount, txtPassword;
    TextView txtForgotPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handlingSignIn();
            }
        });

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LogInActivity.this,CreateAccountActivity.class);
                startActivity(intent);
            }
        });
    }

    private void handlingSignIn() {
        SignInTask signInTask=new SignInTask(LogInActivity.this);
        signInTask.execute(txtAccount.getText().toString(),txtPassword.getText().toString());
    }

    private void addControls() {
        btnSignIn= (Button) findViewById(R.id.btnSignIn);
        btnCreateAccount= (Button) findViewById(R.id.btnCreateAccount);
        txtAccount= (EditText) findViewById(R.id.txtAccount);
        txtPassword= (EditText) findViewById(R.id.txtPassword);
        txtForgotPassword= (TextView) findViewById(R.id.txtForgotPassword);
    }
}
