package com.example.projectapp;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends ComponentActivity {
    private EditText inputField;
    private TextView validationResultTextView;
    private TextView malwareRiskTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputField = findViewById(R.id.inputField);
        Button validateButton = findViewById(R.id.validateButton);
        validationResultTextView = findViewById(R.id.validationResultTextView);
        malwareRiskTextView = findViewById(R.id.malwareRiskTextView);

        // Set up edge-to-edge insets compatibility
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (view, insets) -> {
            Insets systemInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            view.setPadding(systemInsets.left, systemInsets.top, systemInsets.right, systemInsets.bottom);
            return insets;
        });
        validateButton.setOnClickListener(v -> {
            String input = inputField.getText().toString();
            if (InputValidator.isValidUrl(input)) {
                validationResultTextView.setText("Valid URL");
                new MalwareCheckTask(malwareRiskTextView, true).execute(input); // is URL
            } else if (InputValidator.isValidIPAddress(input)) {
                validationResultTextView.setText("Valid IP Address");
                new MalwareCheckTask(malwareRiskTextView, false).execute(input); // is IP Address
            } else {
                validationResultTextView.setText("Invalid input");
                malwareRiskTextView.setText("");
            }
        });
    }
}
