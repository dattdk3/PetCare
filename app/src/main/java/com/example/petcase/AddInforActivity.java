package com.example.petcase;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.petcase.Domain.HealthRecord;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.petcase.Domain.HealthRecord;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddInforActivity extends AppCompatActivity {
    private Button AddInfor;
    private String healthRecordId;
    private EditText Time, newdescription, Qualify;
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_infor);
        healthRecordId = getIntent().getStringExtra("HEALTHRECORD_ID");
        FirebaseApp.initializeApp(this); // Khởi tạo Firebase
        // Kết nối với Firebase Database
        databaseReference = FirebaseDatabase.getInstance().getReference("HealthRecord");

        Time = findViewById(R.id.add_time);
        newdescription = findViewById(R.id.add_description);
        Qualify = findViewById(R.id.add_Qualify);

        AddInfor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addInforToFirebase();
            }
        });
    }
        private void addInforToFirebase() {
            // Lấy dữ liệu từ các ô nhập liệu
            String time1 = Time.getText().toString().trim();
            String description = newdescription.getText().toString().trim();
            String qualify = Qualify.getText().toString().trim();

            if (time1.isEmpty() || description.isEmpty() || qualify.isEmpty()) {
                makeText(this, "Vui lòng nhập đầy đủ thông tin!", LENGTH_SHORT).show();
                return;
            }
        //HealthRecord healthRecord = new HealthRecord(time, newdescription , qualify);
            // Thêm vào Firebase Database
//            databaseReference.child(healthRecordId).setValue(HealthRecord)
//                    .addOnSuccessListener(aVoid -> {
//                        makeText(AddInfor.this, "Thêm sinh viên thành công!", LENGTH_SHORT).show();
//                        // Xóa dữ liệu sau khi thêm thành công
//                        clearFields();
//                    })
//                    .addOnFailureListener(e -> {
//                        makeText(InsertStudent.this, "Lỗi khi thêm sinh viên: " + e.getMessage(), LENGTH_SHORT).show();
//                    });
//            private void clearFields() {
//                time1.setText("");
//                newdescription.setText("");
//                Qualify.setText("");
//
//            }
    }
}