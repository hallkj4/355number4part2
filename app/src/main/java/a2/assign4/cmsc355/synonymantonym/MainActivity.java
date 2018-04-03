package a2.assign4.cmsc355.synonymantonym;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    DatabaseHelper helper= new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onResultsClick(View v){
        if(v.getId() == R.id.Bresults){
            EditText e = (EditText)findViewById(R.id.PTenter);
            String str = e.getText().toString();
            String word = helper.searchWord(str);
            if (!word.equals(str)) {
                Toast.makeText(MainActivity.this, "Word not found, please enter values", Toast.LENGTH_LONG).show();
            }
            else {
                Intent i = new Intent(MainActivity.this, Results.class);
                i.putExtra("Word", str);
                startActivity(i);
            }
        }
    }

    public void onEnterValuesClick(View v){
        if(v.getId() == R.id.Bentervalues) {
            EditText e = (EditText)findViewById(R.id.PTenter);
            String str = e.getText().toString();
            String word = helper.searchWord(str);
            if (word.equals(str)) {
                Toast.makeText(MainActivity.this, "Word already in Thesaurus, click results", Toast.LENGTH_LONG).show();
            }
            else {
                Intent i = new Intent(MainActivity.this, EnterValues.class);
                i.putExtra("Word", str);
                startActivity(i);
            }
        }
    }
}
