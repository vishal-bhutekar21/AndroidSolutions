package com.example.smssender; // Change this to your package name

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class ContactSaver extends AppCompatActivity {

    private EditText editTextName, editTextPhone;
    private Button buttonSave;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_saver);

        editTextName = findViewById(R.id.editTextName);
        editTextPhone = findViewById(R.id.editTextPhone);
        buttonSave = findViewById(R.id.buttonSave);

        // Initialize Firebase Database
        databaseReference = FirebaseDatabase.getInstance().getReference("contacts");

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveContact();
            }
        });
    }

    private void saveContact() {
        String name = editTextName.getText().toString().trim();
        String phone = editTextPhone.getText().toString().trim();
        Log.d("ContactSaver", "Attempting to save contact: Name = " + name + ", Phone = " + phone);

        if (!name.isEmpty() && !phone.isEmpty()) {
            String contactId = databaseReference.push().getKey(); // Generate unique ID
            Map<String, String> contact = new HashMap<>();
            contact.put("name", name);
            contact.put("phone", phone);

            if (contactId != null) {
                databaseReference.child(contactId).setValue(contact)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                Toast.makeText(ContactSaver.this, "Contact Saved", Toast.LENGTH_SHORT).show();
                                editTextName.setText(""); // Clear the input fields
                                editTextPhone.setText("");
                            } else {
                                Toast.makeText(ContactSaver.this, "Failed to Save Contact", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        } else {
            Toast.makeText(this, "Please enter both name and phone number", Toast.LENGTH_SHORT).show();
        }
    }
}
