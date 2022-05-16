package lamtv.code.tranvanlam;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import lamtv.code.tranvanlam.database.AppDatabase;
import lamtv.code.tranvanlam.database.FeedBackEntity;

public class MainActivity extends AppCompatActivity {
    EditText edName, edEmail, edDes;
    Spinner spSpinner;
    CheckBox ckCheck;
    Button btSave;
    List<FeedBackEntity> feedback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SaveFeedBack();
            }
        });

    }
    private void SaveFeedBack(){
        String strName = edName.getText().toString().trim();
        String strEmail = edEmail.getText().toString().trim();
        String strDes = edEmail.getText().toString().trim();
        String strSpec = spSpinner.getSelectedItem().toString();

        if(TextUtils.isEmpty(strName) || TextUtils.isEmpty(strEmail) || TextUtils.isEmpty(strDes)){
            return;
        }
        FeedBackEntity feedBackEntity = new FeedBackEntity(strName, strEmail, strDes, strSpec );
        AppDatabase.getAppDatabase(this).feedBackDaoDAO().insertFeedBack(feedBackEntity);
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        edName.setText("");
        edEmail.setText("");
        edDes.setText("");

        hideKeyBoard();


    }
    private void initView(){
        edName = findViewById(R.id.edName);
        edEmail = findViewById(R.id.edEmail);
        edDes = findViewById(R.id.edDes);
        ckCheck = findViewById(R.id.ckCheck);
        btSave = findViewById(R.id.btSave);

        String[] species = {"Gripe, Yasuo, Zed"};
        spSpinner = (Spinner) findViewById(R.id.spSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,species);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSpinner.setAdapter(adapter);

    }
    public void hideKeyBoard(){
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }catch (NullPointerException ex){
            ex.printStackTrace();
        }
    }
}