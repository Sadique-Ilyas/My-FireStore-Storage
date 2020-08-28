package com.example.myfirestorestorageimagestext;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.squareup.picasso.Picasso;

public class ImagesActivity extends AppCompatActivity {
    private FirebaseFirestore database;
    private DocumentReference documentReference;
    private TextView myName;
    private ImageView myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        myName = findViewById(R.id.myName);
        myImage = findViewById(R.id.myImage);
        database = FirebaseFirestore.getInstance();
        documentReference = database.document("Users Info/My Info");

        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    Toast.makeText(ImagesActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    return;
                }
                if (value.exists()) {
                    Upload upload = value.toObject(Upload.class);
                    String name = upload.getName();
                    myName.setText(name);
                    Picasso.get().load(upload.getImageUrl()).into(myImage);
                }
            }
        });
    }
}