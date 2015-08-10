package org.kod5.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {
    

	//Spinner içerisine koyacağımız verileri tanımlıyoruz.
	private String[] iller={"İSTANBUL","ANKARA"};
	private String[] ilceler0={"ADALAR","ARNAVUTKÖY","ATAŞEHİR","AVCILAR","BAğCILAR","BAHÇELİEVLER","BAKIRKÖY","BAŞAKŞEHİR","BAYRAMPAŞA","BEŞİKTAŞ","BEYLİKDÜZÜ","BEYOĞLU","BÜYÜKÇEKMECE","BEYKOZ","ÇATALCA","ÇEKMEKÖY","ESENLER","ESENYURT","EYÜP","FATİH","GAZİOSMANPAŞA","GÜNGÖREN","KADIKÖY","KAĞITHANE","KARTAL","KÜÇÜKÇEKMECE","MALTEPE","PENDİK","SANCAKTEPE","SARIYER","SİLİVRİ","SULTANBEYLİ","SULTANGAZİ","ŞİLE","ŞİŞLİ","TUZLA","ÜSKÜDAR","ÜMRANİYE","ZEYTİNBURNU"};
	private String[] ilceler1={"AKYURT","ALTINDAĞ","AYAŞ","BALA","BEYPAZARI","ÇAMLIDERE","ÇANKAYA","ÇUBUK","ELMADAĞ","ETİMESGUT","EVREN","GÖLBAŞI","GÜDÜL","HAYMANA","KALECİK","KAZAN","KEÇİÖREN","KIZILCAHAMAM","MAMAK","NALLIHAN","POLATLI","PURSAKLAR","SİNCAN","ŞEREFLİKOÇHİSAR","YENİMAHALLE"};
	
	//Spinner'ları ve Adapter'lerini tanımlıyoruz.
	private Spinner spinnerIller;
	private Spinner spinnerIlceler;
	private ArrayAdapter<String> dataAdapterForIller; 
	private ArrayAdapter<String> dataAdapterForIlceler;
	
	
	@Override // Bu metod uygulama açıldığında çalıştırılan metod.
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//xml kısmında hazırladığımğız spinnerları burda tanımladıklarımızla eşleştiriyoruz.
		spinnerIller = (Spinner) findViewById(R.id.spinner1);
		spinnerIlceler = (Spinner) findViewById(R.id.spinner2);
		 
        //Spinner'lar için adapterleri hazırlıyoruz. 
        dataAdapterForIller = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, iller);
        dataAdapterForIlceler = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,ilceler0);
        
        //Listelenecek verilerin görünümünü belirliyoruz.
        dataAdapterForIller.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterForIlceler.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
 
        //Hazırladğımız Adapter'leri Spinner'lara ekliyoruz.
        spinnerIller.setAdapter(dataAdapterForIller);
        spinnerIlceler.setAdapter(dataAdapterForIlceler);
        
        // Listelerden bir eleman seçildiğinde yapılacakları tanımlıyoruz.
		spinnerIller.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				//Hangi il seçilmişse onun ilçeleri adapter'e ekleniyor.
				if(parent.getSelectedItem().toString().equals(iller[0])) 
					dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,ilceler0);
				else if(parent.getSelectedItem().toString().equals(iller[1]))
					dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,ilceler1);
				
				dataAdapterForIlceler.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinnerIlceler.setAdapter(dataAdapterForIlceler);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
		
		spinnerIlceler.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> parent, View view,
							int position, long id) {
						//Seçilen il ve ilçeyi ekranda gösteriyoruz.
						Toast.makeText(getBaseContext(), ""+spinnerIller.getSelectedItem().toString()+"\n"+parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
					}

					public void onNothingSelected(AdapterView<?> parent) {
					}
				});
	}
}
