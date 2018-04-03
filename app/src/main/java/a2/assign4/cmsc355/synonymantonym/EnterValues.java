package a2.assign4.cmsc355.synonymantonym;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;

/**
 * Created by Kevin on 3/21/18.
 */

public class EnterValues extends Activity{
    String word;
    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_values);
        this.word = getIntent().getStringExtra("Word");
    }

    public void onEnterClick(View v){
        if(R.id.BvaluesToEnter == v.getId()){
            EditText syn = (EditText) findViewById(R.id.PTsynonym);
            EditText ant = (EditText) findViewById(R.id.PTantonym);

            String synonym = syn.getText().toString();
            String antonym = ant.getText().toString();

            Thesaurus t = new Thesaurus();
            t.setWord(word);
            t.setSyn(synonym);
            t.setAnt(antonym);

            helper.insertThesaurus(t);

            Intent i = new Intent(EnterValues.this, MainActivity.class);
            startActivity(i);
        }
    }
}
