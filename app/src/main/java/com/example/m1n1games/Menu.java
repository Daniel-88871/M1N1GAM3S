package com.example.m1n1games;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class Menu extends Fragment {

    ImageButton botonLight;
    ImageButton botonConecta4;
    ImageButton botonDamas;
    ImageButton botonSalir;
    ImageButton botonRanking;
    NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        botonLight = view.findViewById(R.id.botonlightsout);
        botonConecta4 = view.findViewById(R.id.botonconecta4);
        botonDamas = view.findViewById(R.id.botondamas);
        botonSalir = view.findViewById(R.id.botonsalir);
        botonRanking = view.findViewById(R.id.botonranking);

        botonLight.setOnClickListener(view1 -> navController.navigate(R.id.action_menu_to_lightsOut));
        botonConecta4.setOnClickListener(view1 -> navController.navigate(R.id.action_menu_to_conecta4));
        botonDamas.setOnClickListener(view1 -> navController.navigate(R.id.action_menu_to_damasChinas));
        botonSalir.setOnClickListener(view1 -> navController.navigate(R.id.action_menu_to_login));
        botonRanking.setOnClickListener(view1 -> navController.navigate(R.id.action_menu_to_ranking));
    }
}