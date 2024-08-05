package com.example.eternal_bloom2;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ECommerce extends AppCompatActivity {

    private TextView textView34, textView47, textView49, textView52;
    private Button button2;

    private int quantity1 = 0, quantity2 = 0, quantity3 = 0, quantity4 = 0;
    private int price1 = 100, price2 = 200, price3 = 500, price4 = 250;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecommerce);

        textView34 = findViewById(R.id.textView34);
        textView47 = findViewById(R.id.textView47);
        textView49 = findViewById(R.id.textView49);
        textView52 = findViewById(R.id.textView52);
        button2 = findViewById(R.id.button2);

        textView34.setText(String.valueOf(quantity1));
        textView47.setText(String.valueOf(quantity2));
        textView49.setText(String.valueOf(quantity3));
        textView52.setText(String.valueOf(quantity4));


        // Find the buttons for increment and decrement
        TextView textView40 = findViewById(R.id.textView40);
        TextView textView54 = findViewById(R.id.textView54);
        TextView textView48 = findViewById(R.id.textView48);
        TextView textView46 = findViewById(R.id.textView46);
        TextView textView51 = findViewById(R.id.textView51);
        TextView textView50 = findViewById(R.id.textView50);
        TextView textView45 = findViewById(R.id.textView45);
        TextView textView53 = findViewById(R.id.textView53);


        ImageView imageView21 = findViewById(R.id.imageView21);
        ImageView imageView20 = findViewById(R.id.imageView20);
        ImageView imageView19 = findViewById(R.id.imageView19);

// Set OnClickListener for each shop
        imageView21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Campus Store selected", Toast.LENGTH_SHORT).show();
            }
        });

        imageView20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Shop 6(SP) selected", Toast.LENGTH_SHORT).show();
            }
        });

        imageView19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Shop 8(SP) selected", Toast.LENGTH_SHORT).show();
            }
        });

        // Set click listeners for increment and decrement buttons
        textView40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementQuantity(v);
            }
        });

        textView54.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrementQuantity(v);
            }
        });

        textView48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementQuantity(v);
            }
        });

        textView46.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrementQuantity(v);
            }
        });

        textView50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrementQuantity(v);
            }
        });

        textView51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementQuantity(v);
            }
        });

        textView45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrementQuantity(v);
            }
        });

        textView53.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementQuantity(v);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTotalPriceDialog();
            }
        });
    }

    public void incrementQuantity(View view) {
        int id = view.getId();
        if (id == R.id.textView40) {
            quantity1++;
            textView34.setText(String.valueOf(quantity1));
        } else if (id == R.id.textView48) {
            quantity2++;
            textView47.setText(String.valueOf(quantity2));
        } else if (id == R.id.textView51) {
            quantity3++;
            textView49.setText(String.valueOf(quantity3));
        } else if (id == R.id.textView53) {
            quantity4++;
            textView52.setText(String.valueOf(quantity4));
        }
    }

    public void decrementQuantity(View view) {
        int id = view.getId();
        if (id == R.id.textView54) {
            if (quantity1 > 0) {
                quantity1--;
                textView34.setText(String.valueOf(quantity1));
            }
        } else if (id == R.id.textView46) {
            if (quantity2 > 0) {
                quantity2--;
                textView47.setText(String.valueOf(quantity2));
            }
        } else if (id == R.id.textView50) { // Corrected here
            if (quantity3 > 0) {
                quantity3--;
                textView49.setText(String.valueOf(quantity3));
            }
        } else if (id == R.id.textView45) {
            if (quantity4 > 0) {
                quantity4--;
                textView52.setText(String.valueOf(quantity4));
            }
        }
    }

    private void showTotalPriceDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_total_price, null);
        builder.setView(dialogView);

        TextView totalPriceTextView = dialogView.findViewById(R.id.totalPriceTextView);
        TextView itemDetailsTextView = dialogView.findViewById(R.id.itemDetailsTextView);

        int total = calculateTotalPrice();
        totalPriceTextView.setText("Total Price: " + total + " Rs");

        String itemDetails = "Sanitary Napkin: " + quantity1 + " x " + price1 + " Rs\n" +
                "Tampon: " + quantity2 + " x " + price2 + " Rs\n" +
                "Menstrual Cup: " + quantity3 + " x " + price3 + " Rs\n" +
                "Heating Pad: " + quantity4 + " x " + price4 + " Rs";
        itemDetailsTextView.setText(itemDetails);

        builder.setPositiveButton("OK", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private int calculateTotalPrice() {
        return quantity1 * price1 + quantity2 * price2 + quantity3 * price3 + quantity4 * price4;
    }
}
