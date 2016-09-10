package com.kyo.lostshopping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstInteractionActivity extends AppCompatActivity {

    Button btnSignIn, btnCreateAccount;
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
    }

    private void addControls() {
        btnSignIn= (Button) findViewById(R.id.btnSignIn);
        btnCreateAccount= (Button) findViewById(R.id.btnCreateAccount);
    }
}
