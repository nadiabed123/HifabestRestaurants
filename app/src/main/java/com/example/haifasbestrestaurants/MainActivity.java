package com.example.haifasbestrestaurants;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "FIREBASEAUTH";
    private Button logingBtn, signupBtn;
    private EditText etEmail, etPassword;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logingBtn = findViewById(R.id.logingBtn);
        logingBtn.setOnClickListener(this);
        etEmail = findViewById(R.id.useremail);
        etPassword = findViewById(R.id.password);
        signupBtn = findViewById(R.id.signUpBtn);
        signupBtn.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
    }


    @Override
    public void onClick(View v) {
      if(v == logingBtn) {
          String email = etEmail.getText().toString();
          String password = etPassword.getText().toString();
          if (!email.isEmpty() && !password.isEmpty())
              login(email, password);
          else
              Toast.makeText(this, "Email or Password Empty",
                      Toast.LENGTH_SHORT).show();
      }else{
          if(v == signupBtn){
              Intent intent = new Intent(MainActivity.this , SignUpActivity.class);
              startActivity(intent);

          }
      }
    }
    public void login(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            Intent intent = new Intent(MainActivity.this, ResturantTypeList.class);
                            startActivity(intent);

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }
}