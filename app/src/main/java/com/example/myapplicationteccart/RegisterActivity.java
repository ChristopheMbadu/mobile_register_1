package com.example.myapplicationteccart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    // Déclaration des éléments de la vue
    private EditText emailEditText;
    private EditText nameEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        // Initialisation des vues
        emailEditText = findViewById(R.id.emailregister);
        nameEditText = findViewById(R.id.nom);
        passwordEditText = findViewById(R.id.password);
    }

    // Méthode appelée lorsque l'utilisateur clique sur le bouton register
    public void onRegisterButtonClick(View view) {
        String email = emailEditText.getText().toString().trim();
        String name = nameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        // Vérification des champs
        if (email.isEmpty() || name.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
        } else {
            // Logique pour inscrire l'utilisateur (exemple)
            // À remplacer par la logique réelle d'enregistrement, par exemple, une requête API
            Toast.makeText(this, "Registering with email: " + email, Toast.LENGTH_SHORT).show();

            // Si l'inscription réussit, naviguer vers l'écran de connexion
            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Ferme cette activité après la redirection
        }
    }

    // Méthode appelée lorsque l'utilisateur clique sur le lien pour se connecter
    public void onLoginLinkClick(View view) {
        // Naviguer vers l'écran de connexion
        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
