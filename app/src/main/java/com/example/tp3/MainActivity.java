package com.examp5le.tp3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tp3.R;

public class MainActivity extends AppCompatActivity {
    // Déclaration des variables membres
    private EditText editText1;
    private EditText editText2;
    private TextView textResult;
    private Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1) Récupération des composants avec findViewById
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        textResult = findViewById(R.id.textResult);
        btnReset = findViewById(R.id.btnReset);

        // 2) Gestion du clic sur Reset avec un écouteur (classe anonyme)
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Vider les champs de texte
                editText1.setText("");
                editText2.setText("");
                textResult.setText("");
            }
        });
    }

    // 3) Méthode pour le bouton Somme (définie dans XML avec android:onClick)
    public void calculSomme(View v) {
        // Récupération des valeurs des EditText
        String valeur1 = editText1.getText().toString();
        String valeur2 = editText2.getText().toString();

        // Vérification si les champs ne sont pas vides
        if (!valeur1.isEmpty() && !valeur2.isEmpty()) {
            try {
                // Conversion des valeurs en nombres
                double nombre1 = Double.parseDouble(valeur1);
                double nombre2 = Double.parseDouble(valeur2);

                // Calcul de la somme
                double somme = nombre1 + nombre2;

                // Affichage du résultat dans le TextView
                textResult.setText("Somme : " + somme);
            } catch (NumberFormatException e) {
                textResult.setText("Erreur : Entrer des nombres valides");
            }
        } else {
            textResult.setText("Erreur : Remplir tous les champs");
        }
    }
}