package matematicaJatai.liquidosinflamaveis;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.text.Html;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Sobre extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sobre);
		
		Button sobreHome = (Button) findViewById(R.id.sobreHomeButton); 
	    sobreHome.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
								goHome();
	    	}
	    	});
	    
	    final String sobreTexto ="Este software faz parte do apêndice do trabalho de"
	    		+ " conclusão de curso de Wiliam Alvez Diniz Júnior para o PROFMAT, no sub-polo "
	    		+ "da Regional Jataí da Universidade Federal de Goiás, sob orientação do Prof. "
	    		+ "Dr. Esdras Teixeira Costa   <br>";
	    
	    final String sobre2 = 	"Wiliam Alvez Diniz Júnior é Capitão QOC do Corpo de Bombeiros Militar"
	    		+ "do estado de Goiás";
	    
	    final String sobre3 = "Em memória do Soldado José Nilson.";
	    
	    TextView sobre1 = (TextView) findViewById(R.id.apresent);
		sobre1.setText(Html.fromHtml(sobreTexto));
		
		TextView tsobre2 = (TextView) findViewById(R.id.capitao);
		tsobre2.setText(Html.fromHtml(sobre2));
		
		TextView tsobre3 = (TextView) findViewById(R.id.zeNilson);
		tsobre3.setText(Html.fromHtml(sobre3));
		
	//	Display display = getWindowManager().getDefaultDisplay();
	//	Point size = new Point();
	//	display.getSize(size);
	//	int width = size.x;
	//	int height = size.y;
		
	}
	    
	    
	    @Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.manual, menu);
			return true;
		}
		
		 private void goHome() {
				Intent goHome = new Intent(this, MainActivity.class);
	            startActivity(goHome);
		    }
	    
	}