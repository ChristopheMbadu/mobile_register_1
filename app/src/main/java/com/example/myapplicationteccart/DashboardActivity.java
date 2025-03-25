package com.example.myapplicationteccart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {

    private Button logoutButton, addButton;
    private ListView coursesListView;
    private ArrayList<String> coursesList;
    private CourseAdapter courseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Initialiser les éléments de la vue
        logoutButton = findViewById(R.id.logout_button);
        addButton = findViewById(R.id.add_button);
        coursesListView = findViewById(R.id.courses_listview);

        // Initialiser la liste des cours
        coursesList = new ArrayList<>();
        coursesList.add("Java");
        coursesList.add("C++");
        coursesList.add("python");

        // Initialiser l'adaptateur
        courseAdapter = new CourseAdapter(this, coursesList);
        coursesListView.setAdapter(courseAdapter);

        // Configurer le bouton de déconnexion
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLogoutButtonClick();
            }
        });

        // Configurer le bouton Ajouter
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAddButtonClick();
            }
        });

        // Configurer le clic sur l'icône de la corbeille
        coursesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView trashIcon = view.findViewById(R.id.trash_icon);
                if (trashIcon != null) {
                    onDeleteItemClick(position);
                }
            }
        });
    }

    // Méthode pour gérer la déconnexion
    private void onLogoutButtonClick() {
        Toast.makeText(this, "You have been logged out", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
        startActivity(intent);
        finish(); // Ferme cette activité pour ne pas revenir en arrière
    }

    // Méthode pour ajouter un nouvel élément (ex : ajouter un nouveau cours)
    private void onAddButtonClick() {
        // Tu peux afficher un formulaire ou une activité pour ajouter un cours
        // Pour l'instant, on va simplement ajouter un élément factice
        coursesList.add("New Course");
        courseAdapter.notifyDataSetChanged();
        Toast.makeText(this, "New course added!", Toast.LENGTH_SHORT).show();
    }

    // Méthode pour supprimer un élément de la liste
    void onDeleteItemClick(int position) {
        // Supprimer l'élément de la liste
        coursesList.remove(position);
        courseAdapter.notifyDataSetChanged();
        Toast.makeText(this, "Course deleted", Toast.LENGTH_SHORT).show();
    }
}
