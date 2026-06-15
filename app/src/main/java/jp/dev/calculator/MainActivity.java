package jp.dev.calculator;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // Code à ajouter
        EditText editTextAmount=findViewById(R.id.editTextAmount);
        Button btnCompute=findViewById(R.id.btnCompute);
        TextView textViewResult=findViewById(R.id.textViewResult);
        ListView listViewResult=findViewById(R.id.listViewResults);
        List<String> data=new ArrayList<>();
        ArrayAdapter<String> stringArrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,data);
        listViewResult.setAdapter(stringArrayAdapter);
        btnCompute.setOnClickListener((view)->{
            double amount=Double.parseDouble(editTextAmount.getText().toString());
            double result=amount*11;
            textViewResult.setText(String.valueOf(result));
            data.add(amount+"=>"+result);
            stringArrayAdapter.notifyDataSetChanged();
            editTextAmount.setText("");


        });





        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
    }
}