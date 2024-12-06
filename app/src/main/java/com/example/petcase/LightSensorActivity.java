package com.example.petcase;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LightSensorActivity extends AppCompatActivity {
    private LightSensorHandler lightSensorHandler;
    private DatabaseReference firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_sensor);

        // Kết nối Firebase
        firebaseDatabase = FirebaseDatabase.getInstance().getReference("LightSensorData");

        // Khởi tạo cảm biến ánh sáng
        lightSensorHandler = new LightSensorHandler(this);
        lightSensorHandler.startListening(lux -> {
            saveDataToFirebase(lux); // Lưu dữ liệu vào Firebase
            navigateToInputDataSensor(lux); // Chuyển sang màn hình khác
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        lightSensorHandler.stopListening();
    }

    private void saveDataToFirebase(float lightValue) {
        String id = firebaseDatabase.push().getKey();
        if (id != null) {
            firebaseDatabase.child(id).setValue(lightValue).addOnCompleteListener(task -> {
//                if (task.isSuccessful()) {
//                    // Dữ liệu được lưu thành công
//                } else {
//                    // Xử lý lỗi lưu dữ liệu
//                }
            });
        }
    }

    private void navigateToInputDataSensor(float lux) {
        Intent intent = new Intent(LightSensorActivity.this, InputDataSensor.class);
        intent.putExtra("light_value", lux);
        startActivity(intent);
    }
}