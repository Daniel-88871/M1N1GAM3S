package com.example.m1n1games;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class Login extends Fragment {

    Button botonLogin;
    Button crearCuenta;
    NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        botonLogin = view.findViewById(R.id.botonlogin);
        crearCuenta = view.findViewById(R.id.crearcuenta);

        botonLogin.setOnClickListener(view1 -> navController.navigate(R.id.action_login_to_menu));
        crearCuenta.setOnClickListener(view1 -> navController.navigate(R.id.action_login_to_crearCuenta));
    }
}