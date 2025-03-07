package com.example.tp3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tp3.R;

public class MainActivity extends AppCompatActivity {
    // Déclaration des variables membres
    private EditText nombre1;
    private EditText nombre2;
    private EditText resultat;
    private Button btnSomme;
    private Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1) Récupération des composants avec findViewById
        nombre1 = findViewById(R.id.nombre1);
        nombre2 = findViewById(R.id.nombre2);
        resultat = findViewById(R.id.resultat);
        btnSomme = findViewById(R.id.btnSomme);
        btnReset = findViewById(R.id.btnReset);

        // 2) Gestion du clic sur Reset avec un écouteur (classe anonyme)
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Vider les champs de texte
                nombre1.setText("");
                nombre2.setText("");
                resultat.setText("");
            }
        });
    }

    // 3) Méthode pour le bouton Somme (à lier dans le XML avec android:onClick)
    public void calculSomme(View v) {
        // Récupération des valeurs des EditText
        String valeur1 = nombre1.getText().toString();
        String valeur2 = nombre2.getText().toString();

        // Vérification si les champs ne sont pas vides
        if (!valeur1.isEmpty() && !valeur2.isEmpty()) {
            try {
                // Conversion des valeurs en nombres décimaux
                double num1 = Double.parseDouble(valeur1);
                double num2 = Double.parseDouble(valeur2);

                // Calcul de la somme
                double somme = num1 + num2;

                // Affichage du résultat dans l'EditText resultat
                resultat.setText(String.valueOf(somme));
            } catch (NumberFormatException e) {
                resultat.setText("Erreur: Nombres invalides");
            }
        } else {
            resultat.setText("Erreur: Champs vides");
        }
    }
}