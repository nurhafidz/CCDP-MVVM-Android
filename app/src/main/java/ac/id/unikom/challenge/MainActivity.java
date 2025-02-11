package ac.id.unikom.challenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText meter;
    private EditText kilometer;
    private EditText centimeter;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        initView();
        observeViewModel();
    }

    private void observeViewModel() {
        viewModel.getKilometer().observe(this, kilometer -> this.kilometer.setText(kilometer));
        viewModel.getCentimeter().observe(this, centimeter -> this.centimeter.setText(centimeter));
    }

    private void initView() {
        meter = findViewById(R.id.meter);
        kilometer = findViewById(R.id.kilometer);
        centimeter = findViewById(R.id.centimeter);

        meter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                String input = editable.toString();
                if (!input.isEmpty()) {
                    viewModel.setMeter(Double.parseDouble(input));
                }
            }
        });
    }
}
