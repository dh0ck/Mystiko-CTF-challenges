package com.example.kryptonite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


public class MainActivity extends AppCompatActivity {

    public String encryptMsg(String message, SecretKey secret)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidParameterSpecException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        Cipher cipher = null;
        cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secret);
        byte[] cipherText = cipher.doFinal(message.getBytes("UTF-8"));
        return Base64.encodeToString(cipherText, Base64.NO_WRAP);
    }
    public String decryptMsg(String cipherText, SecretKey secret)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidParameterSpecException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        Cipher cipher = null;
        cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secret);
        byte[] decode = Base64.decode(cipherText, Base64.NO_WRAP);
        String decryptString = new String(cipher.doFinal(decode), "UTF-8");
        return decryptString;
    }
    public static SecretKey generateKey(String key)
            throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        SecretKeySpec secret;
        secret = new SecretKeySpec(key.getBytes(), "AES");
        return  secret;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button encryptButton = (Button)findViewById(R.id.encrypt);
        encryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText messageText = (EditText)findViewById(R.id.message);
                EditText keyText = (EditText)findViewById(R.id.key);
                TextView result = (TextView)findViewById(R.id.result);

                String message = messageText.getText().toString();
                String key = keyText.getText().toString();
                if (key.length() == 16 || key.length() == 24 || key.length() == 32){

                }
                else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Wr0Ng k3Y L3n6tH", Toast.LENGTH_SHORT);
                    toast.show();
                }

                Log.e("message: ", message);
                Log.e("key: ", key);



                try{
                    SecretKey secretKey=generateKey(key);
                    String strResult=encryptMsg(message,secretKey);
                    result.setText(strResult);
                    DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
                    databaseAccess.open();
                    DatabaseAccess.setSecret("New User", encryptMsg(message, secretKey));
                    databaseAccess.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

        Button decryptButton = (Button)findViewById(R.id.decrypt);
        decryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText messageText = (EditText)findViewById(R.id.message);
                EditText keyText = (EditText)findViewById(R.id.key);
                TextView result = (TextView)findViewById(R.id.result);

                String message = messageText.getText().toString();
                String key = keyText.getText().toString();
                if (key.length() == 16 || key.length() == 24 || key.length() == 32){

                }
                else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Wr0Ng k3Y L3n6tH", Toast.LENGTH_SHORT);
                    //toast.setMargin(50,50);
                    toast.show();
                }

                try{
                    SecretKey secretKey=generateKey(key);
                    String strResult=decryptMsg(message,secretKey);
                    result.setText(strResult);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });



    }
}