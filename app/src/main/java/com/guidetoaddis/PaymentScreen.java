package com.guidetoaddis;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PaymentScreen extends AppCompatActivity {

    RadioButton radioVisa, radioMaster, radioPaypal;
    LinearLayout ll_paymentDetail, llpaymentMaster, llpaymentPaypal;
    TextView btnPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_screen);
        radioVisa = findViewById(R.id.radioVisa);
        radioMaster = findViewById(R.id.radioMaster);
        radioPaypal = findViewById(R.id.radioPaypal);
        ll_paymentDetail = findViewById(R.id.ll_paymentDetail);
        llpaymentMaster = findViewById(R.id.ll_payDetailMaster);
        llpaymentPaypal = findViewById(R.id.ll_paymentDetailPaypal);
        btnPay = findViewById(R.id.btnPay);


        radioVisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ll_paymentDetail.setVisibility(View.VISIBLE);
                llpaymentMaster.setVisibility(View.GONE);
                llpaymentPaypal.setVisibility(View.GONE);
            }
        });

        radioMaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ll_paymentDetail.setVisibility(View.GONE);
                llpaymentMaster.setVisibility(View.VISIBLE);
                llpaymentPaypal.setVisibility(View.GONE);

            }
        });

        radioPaypal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ll_paymentDetail.setVisibility(View.GONE);
                llpaymentMaster.setVisibility(View.GONE);
                llpaymentPaypal.setVisibility(View.VISIBLE);
            }
        });

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    final Dialog dialog = new Dialog(PaymentScreen.this, android.R.style.Theme_Light);
                   dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialogue_book);

                TextView btnCloseDialogue = dialog.findViewById(R.id.btnClose);

                btnCloseDialogue.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                             dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }
}