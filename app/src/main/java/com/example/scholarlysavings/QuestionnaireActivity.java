package com.example.scholarlysavings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseClassName;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

@ParseClassName("User")
public class QuestionnaireActivity extends AppCompatActivity {

    public static final String TAG = "QuestionnaireActivity";
   // EditText Name;
    EditText Email;
    EditText Phone;
    EditText College;
    EditText Income;
    EditText Expenses;
    EditText Balance;
    Button Next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);

        //Name = findViewById(R.id.NameEt);
        Email = findViewById(R.id.EmailEt);
        Phone = findViewById(R.id.PhoneEt);
        College = findViewById(R.id.CollegeEt);
        Income =  findViewById(R.id.IncomeEt);
        Expenses = findViewById(R.id.ExpensesEt);
        Balance = findViewById(R.id.BalanceEt);
        Next = findViewById(R.id.Nextbtn);

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // String name = Name.getText().toString();
                String email = Email.getText().toString();
                String college = College.getText().toString();
                String phone = Phone.getText().toString();
                String income = Income.getText().toString();
                String expenses = Expenses.getText().toString();
                String balance = Balance.getText().toString();

                ParseUser currentUser = ParseUser.getCurrentUser();
                UserInformation(email, college, phone, income, expenses, balance, currentUser);
            }
        });
    }

    private void goMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    private void UserInformation(String email, String college, String phone, String income, String expenses, String balance, ParseUser currentUser) {
        UserInfo info = new UserInfo();
        info.setUser(currentUser);
        info.setEmail(email);
        info.setCollege(college);
        info.setPhone(phone);
        info.setIncome(income);
        info.setBalance(balance);
        info.setExpenses(expenses);
        info.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                Log.e(TAG, "Error");
            }
        });

        goMainActivity();
    }
}