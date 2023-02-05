package com.info.mvvmkullanimi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.info.mvvmkullanimi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding tasarim;   //binding sinifimiz olustu ondan bir nesne olusturdum.


       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tasarim = DataBindingUtil.setContentView(this,R.layout.activity_main); //bu aşamayla tasarımımı yukarıdaki binding nesneme bağlamış oluyorum.
        //ve artik tasarim. dedigimde gorsel nesnelere bagli metotlara erisebilecegim.

        tasarim.textViewSonuc.setText("0");

        //daha sonra butonlara tıkladıgım zaman toplama ve carpma islemi yapacagım. setOnClickListener() kullanacagim.
        tasarim.buttonToplama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String alinanSayi1 = tasarim.editTextSayi1.getText().toString(); //diyerek içerisindeki bilgiyi string olarak alabiliyorum.
                String alinanSayi2 = tasarim.editTextSayi2.getText().toString();

                //daha sonra gelen stringleri integera donusturmem lazım.
                int sayi1 = Integer.parseInt(alinanSayi1);   //Integer.parseInt() metodu integer'a donusturur.
                int sayi2 = Integer.parseInt(alinanSayi2);

                //simdi toplama işlemini yapacagım.
                int toplam = sayi1 + sayi2;

                //artık toplam sonucunu textView içine aktarmam gerekiyor. bu nedenle yeniden stringe donusturuyorum.
                tasarim.textViewSonuc.setText(String.valueOf(toplam));

            }
        });


        //yukarıdaki yapının aynısı carpma için de olacak. kopyalıyorum.
        tasarim.buttonCarpma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String alinanSayi1 = tasarim.editTextSayi1.getText().toString();
                String alinanSayi2 = tasarim.editTextSayi2.getText().toString();

                int sayi1 = Integer.parseInt(alinanSayi1);
                int sayi2 = Integer.parseInt(alinanSayi2);


                int carpim = sayi1 * sayi2;

                tasarim.textViewSonuc.setText(String.valueOf(carpim));

            }
        });

        /*
        butonlari da olusturduktan sonra ilk amacım editTextlerden bilgileri string olarak alıp bunları integera
        cevirmektir. daha sonra toplama ve carpma işlemi yapıp bunları textview'e aktarmak olmalı.
        bu işlemleri onClick'ten sonra yapıyorum.
         */


    }


}