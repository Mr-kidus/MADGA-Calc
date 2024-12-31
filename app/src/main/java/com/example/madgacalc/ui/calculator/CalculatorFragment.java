package com.example.madgacalc.ui.calculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.madgacalc.R;
import com.example.madgacalc.databinding.FragmentCalculatorBinding;

public class CalculatorFragment extends Fragment {

    private FragmentCalculatorBinding binding;
    private CalculatorViewModel calculatorViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        calculatorViewModel =
                new ViewModelProvider(this).get(CalculatorViewModel.class);

        binding = FragmentCalculatorBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView display = binding.textHome;
        calculatorViewModel.getCurrentInput().observe(getViewLifecycleOwner(), display::setText);

        // Set up button click listeners
        setUpButtonListeners();

        return root;
    }

    private void setUpButtonListeners() {
        // Numeric and operator buttons
        binding.btn0.setOnClickListener(v -> calculatorViewModel.appendToInput("0"));
        binding.btn1.setOnClickListener(v -> calculatorViewModel.appendToInput("1"));
        binding.btn2.setOnClickListener(v -> calculatorViewModel.appendToInput("2"));
        binding.btn3.setOnClickListener(v -> calculatorViewModel.appendToInput("3"));
        binding.btn4.setOnClickListener(v -> calculatorViewModel.appendToInput("4"));
        binding.btn5.setOnClickListener(v -> calculatorViewModel.appendToInput("5"));
        binding.btn6.setOnClickListener(v -> calculatorViewModel.appendToInput("6"));
        binding.btn7.setOnClickListener(v -> calculatorViewModel.appendToInput("7"));
        binding.btn8.setOnClickListener(v -> calculatorViewModel.appendToInput("8"));
        binding.btn9.setOnClickListener(v -> calculatorViewModel.appendToInput("9"));

        binding.btnPlus.setOnClickListener(v -> calculatorViewModel.performCalculation("+"));
        binding.btnMinus.setOnClickListener(v -> calculatorViewModel.performCalculation("-"));
        binding.btnMultiply.setOnClickListener(v -> calculatorViewModel.performCalculation("*"));
        binding.btnDivide.setOnClickListener(v -> calculatorViewModel.performCalculation("/"));

        binding.btnEquals.setOnClickListener(v -> calculatorViewModel.calculateResult());

        binding.btnClear.setOnClickListener(v -> calculatorViewModel.clearInput());
        binding.btnBackspace.setOnClickListener(v -> calculatorViewModel.backspaceInput());

        // Scientific buttons
        binding.btnSin.setOnClickListener(v -> calculatorViewModel.performScientificFunction("sin"));
        binding.btnCos.setOnClickListener(v -> calculatorViewModel.performScientificFunction("cos"));
        binding.btnTan.setOnClickListener(v -> calculatorViewModel.performScientificFunction("tan"));

        binding.btnScientificToggle.setOnClickListener(v -> toggleScientificMode());
    }

    private void toggleScientificMode() {
        if (binding.scientificButtonsGrid.getVisibility() == View.VISIBLE) {
            binding.scientificButtonsGrid.setVisibility(View.GONE);
        } else {
            binding.scientificButtonsGrid.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
