package io.github.kobakei.inversebindingsample;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import io.github.kobakei.inversebindingsample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public ObservableInt checkedPosition = new ObservableInt(0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setActivity(this);

        String[] items = {
                "Pen",
                "Pineapple",
                "Apple",
                "Pen"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, items);
        binding.listView.setAdapter(adapter);
    }
}
