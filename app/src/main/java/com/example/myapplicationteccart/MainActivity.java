package com.example.myapplicationteccart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplicationteccart.R;

public class MainActivity extends AppCompatActivity {

    // Déclaration des éléments de la vue
    private EditText emailEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        // Initialisation des vues
        emailEditText = findViewById(R.id.emaillogin);
        passwordEditText = findViewById(R.id.password);
    }

    // Méthode appelée lorsque l'utilisateur clique sur le bouton login
    public void onLoginButtonClick(View view) {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        // Vérification simple de l'email et du mot de passe
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill in both fields", Toast.LENGTH_SHORT).show();
        } else {
            // Vérification du format de l'email avec une expression régulière
            if (!isValidEmail(email)) {
                Toast.makeText(this, "Please enter a valid email address", Toast.LENGTH_SHORT).show();
            } else {
                // Logique pour se connecter (exemple)
                // À remplacer par la logique réelle de connexion, par exemple, une requête API
                Toast.makeText(this, "Logging in with email: " + email, Toast.LENGTH_SHORT).show();

                // Si la connexion réussit, passer à une autre activité, par exemple, un tableau de bord
                Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        }
    }

    // Méthode pour valider si l'email est dans un format valide.
    private boolean isValidEmail(String email) {
        // Expression régulière pour valider un email
        String emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        return email.matches(emailPattern);
    }

    // Méthode appelée lorsque l'utilisateur clique sur le lien pour s'inscrire
    public void onRegisterLinkClick(View view) {
        // Naviguer vers l'écran d'inscription
        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
}
