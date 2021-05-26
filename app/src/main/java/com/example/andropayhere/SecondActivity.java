package com.example.andropayhere;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import lk.payhere.androidsdk.PHConfigs;
import lk.payhere.androidsdk.PHConstants;
import lk.payhere.androidsdk.PHMainActivity;
import lk.payhere.androidsdk.model.InitRequest;

public class SecondActivity extends AppCompatActivity {
    private final static int PAYHERE_REQUEST = 11010;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button but3 = findViewById(R.id.button3);

        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InitRequest req = new InitRequest();
                req.setMerchantId("1217375");       // Your Merchant PayHere ID
                req.setMerchantSecret("8QmJ6HGO5jN4eSlsd5r0QX4JG4EDCoZAg8QnZpwEA76J"); // Your Merchant secret (Add your app at Settings > Domains & Credentials, to get this))
                req.setCurrency("LKR");             // Currency code LKR/USD/GBP/EUR/AUD
                req.setAmount(1000.00);             // Final Amount to be charged
                req.setOrderId("230000123");        // Unique Reference ID
                req.setItemsDescription("Door bell wireless");  // Item description title
                req.setCustom1("This is the custom message 1");
                req.setCustom2("This is the custom message 2");
                req.getCustomer().setFirstName("Saman");
                req.getCustomer().setLastName("Perera");
                req.getCustomer().setEmail("samanp@gmail.com");
                req.getCustomer().setPhone("+94771234567");
                req.getCustomer().getAddress().setAddress("No.1, Galle Road");
                req.getCustomer().getAddress().setCity("Colombo");
                req.getCustomer().getAddress().setCountry("Sri Lanka");

                //Optional Params
//                req.getCustomer().getDeliveryAddress().setAddress("No.2, Kandy Road");
//                req.getCustomer().getDeliveryAddress().setCity("Kadawatha");
//                req.getCustomer().getDeliveryAddress().setCountry("Sri Lanka");
//                req.getItems().add(new Item(null, "Door bell wireless", 1, 1000.0));

                Intent intent = new Intent(SecondActivity.this, PHMainActivity.class);
                intent.putExtra(PHConstants.INTENT_EXTRA_DATA, req);
                PHConfigs.setBaseUrl(PHConfigs.SANDBOX_URL); //Use PHConfigs instead. Documentation is wrong.
                startActivityForResult(intent, PAYHERE_REQUEST);
            }
        });

    }
}