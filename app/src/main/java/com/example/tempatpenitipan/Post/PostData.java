package com.example.tempatpenitipan.Post;


import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tempatpenitipan.MainPage;
import com.example.tempatpenitipan.R;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;

import javax.net.ssl.HttpsURLConnection;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PostData extends AppCompatActivity {
    private ProgressDialog progress;
    Dialog dia;

     Spinner spNamen2;
    Spinner spNamen3;
    Spinner spNamen4;



    TextView tvnamaanak;
    @BindView(R.id.rbLaki2)
    RadioButton rbLaki;
    @BindView(R.id.rbWanita2)
    RadioButton rbWanita;
    @BindView(R.id.input_jenis_kelamin)
    RadioGroup jenis_kelamin;
    TextView tvtgl;
    TextView tvanakke;
    TextView tvjumlah;
    TextView tvagama;
    TextView tvbahasa;
    @BindView(R.id.rdwni)
    RadioButton rbwni;
    @BindView(R.id.rdwna)
    RadioButton rbwna;
    @BindView(R.id.input_warga)
    RadioGroup warga_negara;
    TextView tvkelainan;
    TextView tvbakat;
    TextView tvgolongan;
    TextView tvmakanan;
    TextView tvalerge;
    TextView tvalamat;
    TextView tvjarak;
    @BindView(R.id.rdmotor)
    RadioButton rbmotor;
    @BindView(R.id.rdmobil)
    RadioButton rbmobil;
    @BindView(R.id.input_kendaraan)
    RadioGroup input_menggunakan;
    TextView tvortu;
    TextView tvName;
    TextView tvCountry;
    Button button;
    Button buttonok;
    String nama_anak;
    String kelamin = "";
    String tempat_tanggal_lahir;
    String anak_ke;;
    String jumlah_saudara;
    String agama = "";
    String bahasa_sehari;
    String warga_negar1 = "";
    String kelainan_jasmani;
    String bakat;
    String golongan_darah = "";
    String makanan_disukai;
    String makanan_alergi;
    String alamat;
    String jarak_dari_tempat_tinggal;
    String menggunakan_kendaraan = "";
    String nama_orangtua;
    String tempat_tanggal_lahir1;
    String agama1 = "";
    String name;
    String country;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);

        ActionBar menu = getSupportActionBar();
        menu.setDisplayShowHomeEnabled(true);
        menu.setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this);



        button=(Button)findViewById(R.id.btn_signup);

        tvnamaanak=(EditText)findViewById(R.id.input_nama_anak);

        tvtgl=(EditText)findViewById(R.id.input_tempat_tanggal);
        tvanakke=(EditText)findViewById(R.id.input_anakke);
        tvjumlah=(EditText)findViewById(R.id.input_jumlahsau);
        spNamen4 = (Spinner) findViewById(R.id.spinner3);
        tvbahasa=(EditText)findViewById(R.id.input_bahasasehari);
        spNamen2 = (Spinner) findViewById(R.id.spinner);
        tvkelainan=(EditText)findViewById(R.id.input_kelainanjasmani);
        tvbakat=(EditText)findViewById(R.id.input_bakatt);
        spNamen2 = (Spinner) findViewById(R.id.spinner);
        tvmakanan=(EditText)findViewById(R.id.input_makanandisukai);
        tvalerge=(EditText)findViewById(R.id.input_makananalergi);
        tvalamat=(EditText)findViewById(R.id.input_alamatt);
        tvjarak=(EditText)findViewById(R.id.input_jaraktempat);

        tvortu=(EditText)findViewById(R.id.input_namaorangtua);
        tvName=(EditText)findViewById(R.id.input_tggl);
        spNamen3 = (Spinner) findViewById(R.id.spinner2);





        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





                showCustomDialog();




                int selectedId = jenis_kelamin.getCheckedRadioButtonId();
                if (selectedId == rbLaki.getId()){
                    kelamin = rbLaki.getText().toString();
                } else if (selectedId == rbWanita.getId()){
                    kelamin = rbWanita.getText().toString();
                }

                int selec = warga_negara.getCheckedRadioButtonId();
                if (selec == rbwni.getId()){
                    warga_negar1 = rbwni.getText().toString();
                } else if (selec == rbwna.getId()){
                    warga_negar1 = rbwna.getText().toString();
                }


                int sel = input_menggunakan.getCheckedRadioButtonId();
                if (sel == rbmotor.getId()){
                    menggunakan_kendaraan = rbmotor.getText().toString();
                } else if (sel == rbmobil.getId()){
                    menggunakan_kendaraan = rbmobil.getText().toString();
                }



                nama_anak = tvnamaanak.getText().toString();
                tempat_tanggal_lahir =  tvtgl.getText().toString();
                anak_ke = tvanakke.getText().toString();
                jumlah_saudara = tvjumlah.getText().toString();
                agama =  spNamen4.getSelectedItem().toString();
                bahasa_sehari = tvbahasa.getText().toString();

                kelainan_jasmani = tvkelainan.getText().toString();
                bakat = tvbakat.getText().toString();
                golongan_darah = spNamen2.getSelectedItem().toString();
                makanan_disukai = tvmakanan.getText().toString();
                makanan_alergi = tvalerge.getText().toString();
                alamat = tvalamat.getText().toString();
                jarak_dari_tempat_tinggal = tvjarak.getText().toString();

                nama_orangtua = tvortu.getText().toString();
                tempat_tanggal_lahir1 = tvName.getText().toString();
                agama1 = spNamen3.getSelectedItem().toString();


                new SendRequest().execute();
            }

        }   );




    }


    private void showCustomDialog() {

        dia = new Dialog(PostData.this);
        dia.setContentView(R.layout.my_dialog);
        dia.setCancelable(false);
        dia.show();

        Button but = (Button) dia.findViewById(R.id.buttonOk);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentku = new Intent(PostData.this, MainPage.class);
                startActivity(intentku);
                dia.dismiss();
            }
        });




}






    public class SendRequest extends AsyncTask<String, Void, String> {


        protected void onPreExecute(){}

        protected String doInBackground(String... arg0) {

            try{
                //Change your web app deployed URL or u can use this for attributes (name, country)
                URL url = new URL("https://script.google.com/macros/s/AKfycbynF1kWPs4HG1XOtyhGF6QQwZJBuydYPvbZpFxssQCO5CbseYUx/exec");

                JSONObject postDataParams = new JSONObject();

                //int i;
                //for(i=1;i<=70;i++)


                //    String usn = Integer.toString(i);

                String id= "1f0gLTaaHSYaUgw_TzIlKK9ViYSmTbIP0eHaWqOzN_2o";

                postDataParams.put("nama_anak",nama_anak);
                postDataParams.put("jenis_kelamin",kelamin);
                postDataParams.put("tempat_tanggal_lahir",tempat_tanggal_lahir);
                postDataParams.put("anak_ke",anak_ke);
                postDataParams.put("jumlah_saudara",jumlah_saudara);
                postDataParams.put("agama",agama);
                postDataParams.put("bahasa_sehari",bahasa_sehari);
                postDataParams.put("warga_negara",warga_negar1);
                postDataParams.put("kelainan_jasmani",kelainan_jasmani);
                postDataParams.put("bakat",bakat);
                postDataParams.put("golongan_darah",golongan_darah);
                postDataParams.put("makanan_disukai",makanan_disukai);
                postDataParams.put("makanan_alergi",makanan_alergi);
                postDataParams.put("alamat",alamat);
                postDataParams.put("jarak_dari_tempat_tinggal",jarak_dari_tempat_tinggal);
                postDataParams.put("menggunakan_kendaraan",menggunakan_kendaraan);
                postDataParams.put("nama_orangtua",nama_orangtua);
                postDataParams.put("tempat_tanggal_lahir1",tempat_tanggal_lahir1);
                postDataParams.put("agama1",agama1);
                postDataParams.put("id",id);


                Log.e("params",postDataParams.toString());

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(15000 /* milliseconds */);
                conn.setConnectTimeout(15000 /* milliseconds */);
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);

                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(getPostDataString(postDataParams));

                writer.flush();
                writer.close();
                os.close();

                int responseCode=conn.getResponseCode();

                if (responseCode == HttpsURLConnection.HTTP_OK) {

                    BufferedReader in=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuffer sb = new StringBuffer("");
                    String line="";

                    while((line = in.readLine()) != null) {

                        sb.append(line);
                        break;
                    }

                    in.close();
                    return sb.toString();

                }
                else {
                    return new String("false : "+responseCode);
                }
            }
            catch(Exception e){
                return new String("Exception: " + e.getMessage());
            }
        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getApplicationContext(), result,
                    Toast.LENGTH_LONG).show();

        }
    }

    public String getPostDataString(JSONObject params) throws Exception {

        StringBuilder result = new StringBuilder();
        boolean first = true;

        Iterator<String> itr = params.keys();

        while(itr.hasNext()){

            String key= itr.next();
            Object value = params.get(key);

            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(key, "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(value.toString(), "UTF-8"));

        }
        return result.toString();
    }

}
