package matematicaJatai.liquidosinflamaveis;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Resultados extends Activity {
	
	public static String value_tipoInflamavel;
	public static String value_PosicaoTanque;
	public static float value_Diametro;
	public static float value_Altura;
	public static float value_Vizinhos;
	public static String value_posTanqViz;
	public static float value_numViz;
	public static float value_dViz;
	public static float value_aViz;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_resultados);
		
		// SE VC FEZ O BUNDLE NA ACTIVITY ANTERIOR, TEM QUE 
				// PEGAR O BUNDLE NESTA ACTIVITY COM O CÓDIGO ABAIXO
				// DO CONTRÁRIO DÁ ERRO...
				Bundle b = getIntent().getExtras();
		        if (b != null){
		        	value_tipoInflamavel = b.getString("valorTipoInflamavel");
		        	//bundle.getString com o segundo argumento só a partir da api level 12...
		        	value_PosicaoTanque = b.getString("valorPosicaoTanque");
		        	value_Diametro = b.getFloat("valorDiametro",0);
		        	value_Altura = b.getFloat("valorAltura",0);  
		        	value_Vizinhos = b.getFloat("valorVizinhos",0);  
		        	
		        	value_posTanqViz = b.getString("valorPosTanqViz");
		        	value_numViz = b.getFloat("valorNumViz");
		        	value_dViz = b.getFloat("valorDViz");
		        	value_aViz = b.getFloat("valorAViz");	        	
		        	
		        }		       
		        
		        float pi = (float) 3.1416;
	        	float area_sup = (pi *  value_Diametro * value_Diametro)/4;
	        	float costado = pi * value_Diametro * value_Altura;
	        	float volume = area_sup * value_Altura;
	        	
	        	 final TextView rNCanhoes = (TextView) findViewById(R.id.textViewR1);
			     final TextView rVazRes = (TextView) findViewById(R.id.textViewR2);
			     final   TextView rVazEsp = (TextView) findViewById(R.id.textViewR3);
			     final   TextView rQApuh = (TextView) findViewById(R.id.textViewR4);
			     final   TextView rQEsp = (TextView) findViewById(R.id.textViewR5);
		
		        final TextView ncanhoes1 = (TextView) findViewById(R.id.resp1);
		     //   final TextView vazaoResfriamento = (TextView) findViewById(R.id.resp2);
		        final TextView vazaoEspuma = (TextView) findViewById(R.id.resp3);
		     //   TextView quantAgua = (TextView) findViewById(R.id.resp4);
		     //   TextView quantEspuma = (TextView) findViewById(R.id.resp5);
		     //   final TextView vazaoTotalSolucao = (TextView) findViewById(R.id.vazaoTotalSolucao);
		     //   TextView quantTotalSolucao = (TextView) findViewById(R.id.quantTotalSolucao);
		        
		        
//-----------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------
//---------------------------------------- tanques horizontais ----------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------		        
		        
		        
		        
		           //---------------------------------------------
			       //---------------------------------------------
			       //---------------------------------------------
				   //-------- Módulo resfriamento
			       //---------------------------------------------
			       //---------------------------------------------
			       //---------------------------------------------
	
		        
		      //---------------------------------------------
		      //------- visualização da vazão de resfriamento
		        
		       final float contaVazResf = 2* costado;
		        
		       if (value_PosicaoTanque.equals("Vertical")) 
		        	rVazRes.setText("Vazão de resfriamento: " + contaVazResf + " litros/min");
		       
		     //---------------------------------------------
		     //-------- Quantidade de linhas manuais e canhões monitores para resfriamento
		       
		       if(value_PosicaoTanque.equals("Vertical") && (contaVazResf/400) < 4) 
		    	   rNCanhoes.setText("Utilize linhas manuais de 1/2 para o resfriamento");
		       
		       if(value_PosicaoTanque.equals("Vertical") && (contaVazResf/800)>= 2 && (contaVazResf/800)<= 4) 
		    	   rNCanhoes.setText("Utilize linhas manuais de 2 1/2 para o resfriamento");
		       
		       if (value_PosicaoTanque.equals("Vertical") && (contaVazResf/800) < 2) 
		    	   rNCanhoes.append("\n"+"Não são recomendadas linhas manuais de 2 1/2 para o resfriamento");
		       
		       if (value_PosicaoTanque.equals("Vertical") && (contaVazResf/2000) > 2) 
		    	   ncanhoes1.setText("Utilize canhões monitores para o resfriamento");
		       
		       if (value_PosicaoTanque.equals("Vertical") && (contaVazResf/2000) < 1) 
		    	   ncanhoes1.setText("Não é recomendado o uso de canhões monitores para o resfriamento");
		       
		       //---------------------------------------------
		       //---------------------------------------------
		       //---------------------------------------------
			   //-------- Módulo Espuma
		       //---------------------------------------------
		       //---------------------------------------------
		       //---------------------------------------------
		       
		       // vazão de espuma
		       float qtdadeEspuma = 0;
		       if (value_PosicaoTanque.equals("Vertical") && value_tipoInflamavel.equals("Hidrocarboneto")) 
		    	   qtdadeEspuma = (float) (6.5* area_sup) ;
		       if (value_PosicaoTanque.equals("Vertical") && value_tipoInflamavel.equals("Solvente polar")) 
		    	   qtdadeEspuma = (float) (9.8* area_sup) ;
		       if (value_PosicaoTanque.equals("Vertical"))
		    		   rVazEsp.setText("Vazão de espuma: " + qtdadeEspuma + " por 65 min");
		       
		       // quantidade de solução de espuma
		       float qsolEspuma = (float) 65*qtdadeEspuma;
		       float qLGE = 0;
		       float qApu = 0; //qtdade de "apu"
		       
		       if (value_PosicaoTanque.equals("Vertical") && value_tipoInflamavel.equals("Hidrocarboneto")) 
		    	   {qApu = (float) (0.97* qsolEspuma); 
		       	   qLGE = (float) (0.03* qsolEspuma); }
		       if (value_PosicaoTanque.equals("Vertical") && value_tipoInflamavel.equals("Solvente polar")) 
		    	   {qApu = (float) (0.94* qsolEspuma) ;
	       	       qLGE = (float) (0.06* qsolEspuma); }
		       
		       if (value_PosicaoTanque.equals("Vertical"))
		    	   rQEsp.setText("A solução de espuma deve ser composta de " + qApu + " litros de água e " 
		    		   + qLGE + " litros de LGE" );
		       
		       //---------------------------------------------
			     //-------- Quantidade de linhas manuais e canhões monitores para espuma
			       
			       if(value_PosicaoTanque.equals("Vertical") && (qsolEspuma/400) < 4) 
			    	   vazaoEspuma.setText("Utilize linhas manuais de 1/2 para a espuma");
			       
			       if(value_PosicaoTanque.equals("Vertical") && (qsolEspuma/800)>= 2 && (contaVazResf/800)<= 4) 
			    	   vazaoEspuma.append("\n"+"Utilize linhas manuais de 2 1/2 para a espuma");
			       
			       if (value_PosicaoTanque.equals("Vertical") && (qsolEspuma/800) < 2) 
			    	   vazaoEspuma.append("\n"+"Não são recomendadas linhas manuais de 2 1/2 para a espuma");
			       
			       if (value_PosicaoTanque.equals("Vertical") && (qsolEspuma/2000) > 2) 
			    	   vazaoEspuma.append("\n"+"Utilize canhões monitores para a espuma");
			       
			       if (value_PosicaoTanque.equals("Vertical") && (qsolEspuma/2000) < 1) 
			    	   vazaoEspuma.append("\n"+"Não é recomendado o uso de canhões monitores para a espuma");
	       	       
		       //---------------------------------------------
		       //---------------------------------------------
		       //---------------------------------------------
			   //-------- Módulo água
		       //---------------------------------------------
		       //---------------------------------------------
		       //---------------------------------------------
	       	   
			       //Quantidade total de água
		    	   
		       // a água da espuma é qApu;
			   // para o cálculo da água do resfriamento: 
			   // tempo, segundo tabela 1:
			    
			   final float volumeTotal = volume; // alterar, se tiver tanques vizinhos
			   float tempo = 0;
			   if (volumeTotal >= 40000) tempo = 360;
			   if ((volumeTotal >= 10000) && (volumeTotal < 40000 )) tempo = 240;
			   if ((volumeTotal >= 1000) && (volumeTotal < 10000 )) tempo = 120;
			   if ((volumeTotal >= 120) && (volumeTotal < 1000 )) tempo = 60;
			   if ((volumeTotal >= 50) && (volumeTotal < 120 )) tempo = 45;
			   if ((volumeTotal >= 20) && (volumeTotal < 50 )) tempo = 30;
			   			   
			   // resfriamento da tampa
			   final float litrosResfTampa = tempo * contaVazResf * (area_sup + costado)/2;
			   final float m3resfTampa = litrosResfTampa /1000;
			   
			   // resfriamento do costado
			   final float litrosResfCostado = tempo * contaVazResf * costado;
			   final float m3resfCostado = litrosResfCostado /1000;
		       
		       final float qTotalApu = (float) (qApu + m3resfTampa + m3resfCostado);
		       
		       if(value_PosicaoTanque.equals("Vertical"))
		    	   rQApuh.setText("Serão necessários, no mínimo, " + qTotalApu + " metros cúbicos de água"); 
		       
//-----------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------
//---------------------------------------- tanques horizontais ----------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------
		       
		       // Nunca resfrie tanques horizontais
		       if (value_PosicaoTanque.equals("Horizontal")) 
		        	rVazRes.setText("Não é recomendado resfriar um tanque horizontal em chamas");
		       
		       
		       //---------------------------------------------
		       //---------------------------------------------
		       //---------------------------------------------
			   //-------- Módulo Espuma para tanques horizontais
		       //---------------------------------------------
		       //---------------------------------------------
		       //---------------------------------------------
		       
		       // vazão de espuma
		    //   float qtdadeEspumaH = 0;
		    //   if (value_PosicaoTanque.equals("Horizontal") && value_tipoInflamavel.equals("Hidrocarboneto")) 
		    //	   qtdadeEspumaH = (float) (6.5* area_sup) ;
		    //   if (value_PosicaoTanque.equals("Horizontal") && value_tipoInflamavel.equals("Solvente polar")) 
		    //	   qtdadeEspumaH = (float) (9.8* area_sup) ;
		    //   rVazEsp.setText("Vazão de espuma: " + qtdadeEspumaH + " por 65 min");
		       
		       
		       // quantidade de solução de espuma
		       float qsolEspumaH = 0;
		       if ((value_Diametro) <= 20) qsolEspumaH = 8000; // 20 min de 400 lpm
		       if ((value_Diametro)> 20 && (value_Diametro)<= 40) qsolEspumaH = 24000; // 30 min x 2 x  400 lpm
		       if ((value_Diametro) <= 20) qsolEspumaH = 36000; // 30 min x 3 x  400 lpm
		       
		       float qLGEH = 0;
		       float qApuH = 0; //qtdade de "apu"
		       
		       if (value_PosicaoTanque.equals("Horizontal") && value_tipoInflamavel.equals("Hidrocarboneto")) 
		    	   {qApuH = (float) (0.97* qsolEspumaH); 
		       	   qLGEH = (float) (0.03* qsolEspumaH); }
		       if (value_PosicaoTanque.equals("Horizontal") && value_tipoInflamavel.equals("Solvente polar")) 
		    	   {qApuH = (float) (0.94* qsolEspumaH) ;
	       	       qLGEH = (float) (0.06* qsolEspumaH); }
		       
		       if (value_PosicaoTanque.equals("Horizontal"))
		    		   rQEsp.setText("A solução de espuma deve ser composta de " + qApuH + " litros de água e " 
		    		   + qLGEH + " litros de LGE" );
		       
		       //---------------------------------------------
			     //-------- Quantidade de linhas manuais e canhões monitores para espuma - tanques horizontais
		      
		       //-------- SEGUNDO A TABELA 2
			       
			       if(value_PosicaoTanque.equals("Horizontal") && (value_Diametro) <= 20) 
			    	   vazaoEspuma.append("\n"+"Utilize, no mínimo, uma linha manual de 400 lpm de solução de espuma por 20 minutos");
			       
			       if(value_PosicaoTanque.equals("Horizontal") && (value_Diametro)> 20 && (value_Diametro)<= 40) 
			    	   vazaoEspuma.append("\n"+"Utilize, no mínimo, duas linhas manuais de 400 lpm de solução de espuma por 30 minutos");
			       
			       if (value_PosicaoTanque.equals("Horizontal") && (value_Diametro) > 40) 
			    	   vazaoEspuma.append("\n"+"Utilize, no mínimo, três linhas manuais de 400 lpm de solução de espuma por 30 minutos");
			      
	       	       
		       //---------------------------------------------
		       //---------------------------------------------
		       //---------------------------------------------
			   //-------- Módulo água para tanques horizontais
		       //---------------------------------------------
		       //---------------------------------------------
		       //---------------------------------------------
	       	   
			       //Quantidade total de água
		    	   
		       // a água da espuma é qApuH;
			   // tempo, segundo tabela 2:
			    
			  // final float volumeTotalH = volume; // alterar, se tiver tanques vizinhos
			  // float tempoH = 0;
			  // if ((value_Diametro) <= 20) tempoH = 20; // 20 min de 400 lpm
		      // if ((value_Diametro)> 20) tempoH = 30; // 30 min x 2 ou 3 x  400 lpm
		            
		       final float qTotalApuH = (float) qApuH/1000;
			       
			       // A ÁGUA É SÓ A DA ESPUMA????
		       
		       if(value_PosicaoTanque.equals("Horizontal"))
		    	   rQApuh.setText("Serão necessários, no mínimo " + qTotalApuH + " metros cúbicos de água"); 
		       
		       
		       
		       
		        
			
				
//-----------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------
//---------------------------------------- Interface ----------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------
		     		       		       
		        
		        
	 Button homeButton3 = (Button) findViewById(R.id.homeCalc3); //BOTÃO HOMECALC2 /= BOTÃO HOMECALC /= 3
	    homeButton3.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				goHome();				
				
	    	}
	    	});
	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.resultados, menu);
		return true;
	}
	
	private void goHome() { //MESMO MÉTODO (INCLUSIVE NOME) DA CLASSE CALCULO1
		Intent goHome = new Intent(this, MainActivity.class);
		 Bundle b = new Bundle();			 
		 goHome.putExtras(b);
         startActivity(goHome);
    }

}
