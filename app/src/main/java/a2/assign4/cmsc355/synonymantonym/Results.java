package a2.assign4.cmsc355.synonymantonym;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


/**
 * Created by Kevin on 3/21/18.
 */

public class Results extends Activity{
    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);
        String word = getIntent().getStringExtra("Word");
        String[] results = helper.searchThesaurus(word);

        TextView tv = (TextView)findViewById(R.id.PTword);
        tv.setText(word);
        TextView tvSyn = (TextView)findViewById(R.id.PTsyn);
        tvSyn.setText(results[0]);
        TextView tvAnt = (TextView)findViewById(R.id.PTant);
        tvAnt.setText(results[1]);
    }

    public void onBackClick(View v){
        if(v.getId() == R.id.BbackFrom){
            Intent i = new Intent(Results.this, MainActivity.class);
            startActivity(i);
        }
    }

}
