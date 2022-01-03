package com.example.calculator4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityCalculator extends AppCompatActivity {



        private Button parcelableMoveDigitButton;

        private Calculator calculator;        // object of Calculator class
        private TextView inputValue1TextView; // for TextView ID - input_value_1
        private TextView inputValue2TextView; // for TextView ID - input_value_2
        private TextView operatorTextView;    // for TextView ID - input_operation
        private TextView finalResultTextView; // for TextView ID - textView_result
        private TextView completeOperation;   // for TextView ID - complete_operation
        private double numberOne;             // first number
        private double numberTwo;             // second number
        private String operationString;       // current operation
        private static int MAX_CHARACTERS = 12;
        private static final String FIRST_NUMBER_KEY = "first_number";
        private static final String SECOND_NUMBER_KEY = "second_number";
        private static final String OPERATION_KEY = "operation";
        private static final String FINAL_RESULT_KEY = "final_result";
        private static final String COMPLETE_OPERATION_KEY = "complete_operation";
        private static final String OPERATION_STRING_KEY = "operation_string";
        private static final String NUMBER_ONE_KEY = "number_one";
        private static final String NUMBER_TWO_KEY = "number_two";
        private enum operator {
            ADD, SUB, MUL, DIV, MOD, NULL
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_calculator_constraint_layout);
            calculator = new Calculator();
            inputValue1TextView = findViewById(R.id.input_value_1_text_view);   // first number
            inputValue2TextView = findViewById(R.id.input_value_2_text_view);   // second number
            operatorTextView = findViewById(R.id.input_operation_text_view);    //operation
            finalResultTextView = findViewById(R.id.display_text_view);         // final result
            completeOperation = findViewById(R.id.complete_operation_text_view);// string containing the numbers and the operation
            operationString = MainActivityCalculator.operator.NULL.name();


            //    Implementation of saved instance state
            if (savedInstanceState != null) {
                inputValue1TextView.setText(savedInstanceState.getString(FIRST_NUMBER_KEY, ""));
                inputValue2TextView.setText(savedInstanceState.getString(SECOND_NUMBER_KEY, ""));
                operatorTextView.setText(savedInstanceState.getString(OPERATION_KEY, ""));
                finalResultTextView.setText(savedInstanceState.getString(FINAL_RESULT_KEY, ""));
                completeOperation.setText(savedInstanceState.getString(COMPLETE_OPERATION_KEY, ""));
                operationString = savedInstanceState.getString(OPERATION_STRING_KEY, MainActivityCalculator.operator.NULL.name());
                numberOne = savedInstanceState.getDouble(NUMBER_ONE_KEY, 0);
                numberTwo = savedInstanceState.getDouble(NUMBER_TWO_KEY, 0);
            }

            parcelableMoveDigitButton = findViewById(R.id.parcelable_move_digit_button);

            // Parcelable transfer
            parcelableMoveDigitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // create HomeWorkDisplayInfo object
                    HomeWorkDisplayInfo homeWorkDisplayInfo = new HomeWorkDisplayInfo(finalResultTextView.getText().toString(),
                            completeOperation.getText().toString());

                    // create intent to MainActivityCalculator class
                    Intent intent = new Intent(MainActivityCalculator.this, MoveDigit.class);
                    // Add HomeWorkDisplayInfo data as extras to the intent
                    intent.putExtra("Data", homeWorkDisplayInfo);
                    startActivity(intent);
                }
            });

        }

        @Override
        protected void onStart(){
            super.onStart();
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            );
        }

        //    implementation of Saved instance state
        @Override
        protected void onSaveInstanceState(@NonNull Bundle outState) {
            super.onSaveInstanceState(outState);
            outState.putString(FIRST_NUMBER_KEY, inputValue1TextView.getText().toString());
            outState.putString(OPERATION_KEY, operatorTextView.getText().toString());
            outState.putString(SECOND_NUMBER_KEY, inputValue2TextView.getText().toString());
            outState.putString(FINAL_RESULT_KEY, finalResultTextView.getText().toString());
            outState.putString(COMPLETE_OPERATION_KEY, completeOperation.getText().toString());
            outState.putString(OPERATION_STRING_KEY, operationString);
            outState.putDouble(NUMBER_ONE_KEY, numberOne);
            outState.putDouble(NUMBER_TWO_KEY, numberTwo);
        }

        //    method to check where to append the numbers (first or second number)
        private void selectTextViewToAppend(String number) {
            if (operationString.equals(MainActivityCalculator.operator.NULL.name())) {
                if (inputValue1TextView.getText().toString().contains(".")) {
                    MAX_CHARACTERS++;
                }
                if (inputValue1TextView.getText().length() < MAX_CHARACTERS) {
                    inputValue1TextView.append(number);
                    MAX_CHARACTERS = 12;
                } else {
                    MAX_CHARACTERS = 12;
                    Toast.makeText(this, "Не более 12 цифр", Toast.LENGTH_LONG).show();
                }
            } else {
                if (inputValue1TextView.getText().toString().contains(".")) {
                    MAX_CHARACTERS++;
                }
                if (inputValue2TextView.getText().length() < MAX_CHARACTERS) {
                    inputValue2TextView.append(number);
                    MAX_CHARACTERS = 12;
                } else {
                    MAX_CHARACTERS = 12;
                    Toast.makeText(this, "Не более 12 цифр", Toast.LENGTH_LONG).show();
                }

            }
        }

        //     handle operations for numbers
        @SuppressLint("NonConstantResourceId")
        public void onNumClick(View view) {
            if (!finalResultTextView.getText().toString().equals("")) {
                //  onClearClick(view);
            }
            switch (view.getId()) {
                case R.id.button_1_text_view:
                    selectTextViewToAppend("1");
                    break;
                case R.id.button_2_text_view:
                    selectTextViewToAppend("2");
                    break;
                case R.id.button_3_text_view:
                    selectTextViewToAppend("3");
                    break;
                case R.id.button_4_text_view:
                    selectTextViewToAppend("4");
                    break;
                case R.id.button_5_text_view:
                    selectTextViewToAppend("5");
                    break;
                case R.id.button_6_text_view:
                    selectTextViewToAppend("6");
                    break;
                case R.id.button_7_text_view:
                    selectTextViewToAppend("7");
                    break;
                case R.id.button_8_text_view:
                    selectTextViewToAppend("8");
                    break;
                case R.id.button_9_text_view:
                    selectTextViewToAppend("9");
                    break;
                case R.id.button_0_text_view:
                    selectTextViewToAppend("0");
                    break;
                case R.id.button_dot_text_view:
                    if (operationString.equals(MainActivityCalculator.operator.NULL.name())) {
                        if (inputValue1TextView.getText().toString().contains(".")) {
                            Toast.makeText(this, "вы уже ввели десятичную точку", Toast.LENGTH_LONG).show();
                        } else {
                            inputValue1TextView.append(".");
                        }
                    } else {
                        if (inputValue2TextView.getText().toString().contains(".")) {
                            Toast.makeText(this, "вы уже ввели десятичную точку\"", Toast.LENGTH_LONG).show();
                        } else {
                            inputValue2TextView.append(".");
                        }
                    }
                    break;
                default:
                    break;
            }
        }

        //      handle operations for operators
        @SuppressLint("NonConstantResourceId")
        public void onOperatorClick(View view) {
            if (!inputValue1TextView.getText().toString().equals("")) {
                switch (view.getId()) {
                    case R.id.button_addition_text_view:
                        operationString = MainActivityCalculator.operator.ADD.name();
                        operatorTextView.setText("+");
                        break;
                    case R.id.button_subtraction_text_view:
                        operationString = MainActivityCalculator.operator.SUB.name();
                        operatorTextView.setText("-");
                        break;
                    case R.id.button_multiplication_text_view:
                        operationString = MainActivityCalculator.operator.MUL.name();
                        operatorTextView.setText("x");
                        break;
                    case R.id.button_separation_text_view:
                        operationString = MainActivityCalculator.operator.DIV.name();
                        operatorTextView.setText("/");
                        break;
                    case R.id.button_percent_text_view:
                        operationString = MainActivityCalculator.operator.MOD.name();
                        operatorTextView.setText("%");
                        break;

                    default:
                        operationString = MainActivityCalculator.operator.NULL.name();
                        break;
                }

            }

        }


        public void onEqualsClick(View view) {
            //     handle equals click
            if (inputValue1TextView.getText().toString().equals("") || operatorTextView.getText().toString().equals("") || inputValue2TextView.getText().toString().equals("")) {
                Toast.makeText(this, "Введите число или операцию", Toast.LENGTH_LONG).show();
            } else {
                numberOne = Double.parseDouble(inputValue1TextView.getText().toString());
                numberTwo = Double.parseDouble(inputValue2TextView.getText().toString());
                String operation;


                switch (MainActivityCalculator.operator.valueOf(operationString)) {
                    case ADD:
                        finalResultTextView.setText(String.valueOf(calculator.addition(numberOne, numberTwo)));
                        operation = inputValue1TextView.getText().toString() + getString(R.string.text_addition) + inputValue2TextView.getText().toString();
                        inputValue1TextView.setText(String.valueOf(calculator.addition(numberOne, numberTwo)));
                        clearTail();
                        break;
                    case SUB:
                        finalResultTextView.setText(String.valueOf(calculator.subtraction(numberOne, numberTwo)));
                        operation = inputValue1TextView.getText().toString() + getString(R.string.text_subtraction) + inputValue2TextView.getText().toString();
                        inputValue1TextView.setText(String.valueOf(calculator.subtraction(numberOne, numberTwo)));
                        clearTail();
                        break;
                    case MUL:
                        finalResultTextView.setText(String.valueOf(calculator.multiplication(numberOne, numberTwo)));
                        operation = inputValue1TextView.getText().toString() + getString(R.string.text_multiplication) + inputValue2TextView.getText().toString();
                        inputValue1TextView.setText(String.valueOf(calculator.multiplication(numberOne, numberTwo)));
                        clearTail();
                        break;
                    case DIV:
                        try {
                            finalResultTextView.setText(String.valueOf(calculator.division(numberOne, numberTwo)));
                            operation = inputValue1TextView.getText().toString() + getString(R.string.text_separation) + inputValue2TextView.getText().toString();
                            inputValue1TextView.setText(String.valueOf(calculator.division(numberOne, numberTwo)));
                        } catch (IllegalArgumentException e) {
                            Toast.makeText(this, getString(R.string.error), Toast.LENGTH_LONG).show();
                            operation = "";
                            clearAll();
                        }
                        clearTail();
                        break;
                    case MOD:
                        finalResultTextView.setText(String.valueOf(calculator.modulus(numberOne, numberTwo)));
                        operation = inputValue1TextView.getText().toString() + getString(R.string.text_percent) + inputValue2TextView.getText().toString();
                        inputValue1TextView.setText(String.valueOf(calculator.modulus(numberOne, numberTwo)));
                        clearTail();
                        break;
                    case NULL:
                        finalResultTextView.setText(getString(R.string.error));
                        operation = "";
                        break;
                    default:
                        operation = "";
                        break;
                }
                completeOperation.setText(operation);
                // clearAll();
            }
        }

        //    handle clear click
        public void onClearClick(View view) {
            clearAll();
            finalResultTextView.setText("");
            completeOperation.setText("");
        }

        //    clearing most values (needed many times, so created a method to reduce code duplication
        public void clearAll() {
            inputValue1TextView.setText("");
            operatorTextView.setText("");
            inputValue2TextView.setText("");
            numberOne = 0;
            numberTwo = 0;
            operationString = MainActivityCalculator.operator.NULL.name();
        }

        public void clearTail() {
            inputValue2TextView.setText("");
            operatorTextView.setText("");
        }

        //    handle backspace click (the ImageButton) in the layout
        public void onBackspaceClick(View view) {
            view.setOnLongClickListener(v -> {
                clearAll();
                return false;
            });
            if (!inputValue2TextView.getText().toString().equals("")) {
                backspaceImplementation(inputValue2TextView);
            } else {
                if (!operatorTextView.getText().toString().equals("")) {
                    backspaceImplementation(operatorTextView);
                } else {
                    if (!inputValue1TextView.getText().toString().equals("")) {
                        backspaceImplementation(inputValue1TextView);
                    }
                }
            }
        }

        private void backspaceImplementation(TextView view) {
            String backspace = view.getText().toString();
            backspace = backspace.substring(0, backspace.length() - 1);
            view.setText(backspace);
        }
}