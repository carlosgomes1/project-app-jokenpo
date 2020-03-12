package com.qp.pedrapapeloutesoura;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int contVitoria = 0, contEmpate = 0, contDerrota = 0;

            public void selecionarPedra(View view){
                this.opcaoSelecionada("Pedra");
            }

            public void selecionarPapel(View view){
                this.opcaoSelecionada("Papel");
            }

            public void selecionarTesoura(View view){
                this.opcaoSelecionada("Tesoura");
            }

            public void opcaoSelecionada(String escolhaUsuario){
                ImageView imagemResultado = (ImageView) findViewById(R.id.imageResultado);

                TextView textoResultado = (TextView) findViewById(R.id.textResultado);
                TextView textoContadorVitoria = (TextView) findViewById(R.id.contadorVitoria);
                TextView textoContadorDerrota = (TextView) findViewById(R.id.contadorDerrota);
                TextView textoContadorEmpate = (TextView) findViewById(R.id.contadorEmpate);



                String[] opcoes = {"Pedra", "Papel", "Tesoura"};
                int numero = new Random().nextInt(3);
                String escolhaApp = opcoes[numero];

                switch(escolhaApp){
                    case "Pedra" :
                        imagemResultado.setImageResource(R.drawable.pedra);
                        break;
                    case "Papel" :
                        imagemResultado.setImageResource(R.drawable.papel);
                        break;
                    case "Tesoura" :
                        imagemResultado.setImageResource(R.drawable.tesoura);
                        break;
                }

                if( (escolhaApp == "Pedra" && escolhaUsuario == "Tesoura") ||
                        (escolhaApp == "Tesoura" && escolhaUsuario == "Papel") ||
                        (escolhaApp == "Papel" && escolhaUsuario == "Pedra") ){ // App Vence

                    textoResultado.setText("App venceu!");
                    contDerrota = contDerrota +1;

                    textoContadorDerrota.setText("Derrotas: " + contDerrota);

                }else if( (escolhaUsuario == "Pedra" && escolhaApp == "Tesoura") ||
                        (escolhaUsuario == "Tesoura" && escolhaApp == "Papel") ||
                        (escolhaUsuario == "Papel" && escolhaApp == "Pedra") ){ // Usuario Vence

                    textoResultado.setText("Você venceu!");
                    contVitoria = contVitoria + 1;

                    textoContadorVitoria.setText("Vitórias: " + contVitoria);

                }else { // Empate

                    textoResultado.setText("Empate!");
                    contEmpate = contEmpate + 1;

                    textoContadorEmpate.setText("Empates: " + contEmpate);
                }

            }
        }


