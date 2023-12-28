package com.example.pocketguide;

import android.content.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.view.inputmethod.*;
import android.widget.*;

import androidx.appcompat.app.*;

import com.google.zxing.*;
import com.google.zxing.common.*;
import com.journeyapps.barcodescanner.*;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Button for generating QR code
        Button btnGenerate = findViewById(R.id.btnGenerate);
        //Text will be entered here to generate QR code
        EditText etText = findViewById(R.id.etText);
        //ImageView for generated QR code
        ImageView imageCode = findViewById(R.id.imageCode);
        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myText = etText.getText().toString().trim();
                //initializing MultiFormatWriter for QR code
                MultiFormatWriter mWriter = new MultiFormatWriter();
                try {
                    //BitMatrix class to encode entered text and set Width & Height
                    BitMatrix mMatrix = mWriter.encode(myText, BarcodeFormat.QR_CODE, 400,400);
                    BarcodeEncoder mEncoder = new BarcodeEncoder();
                    Bitmap mBitmap = mEncoder.createBitmap(mMatrix);//creating bitmap of code
                    imageCode.setImageBitmap(mBitmap);//Setting generated QR code to imageView
                    // to hide the keyboard
                    InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    manager.hideSoftInputFromWindow(etText.getApplicationWindowToken(), 0);
                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }
            //getting text from input text field.

        });
    }
}