package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Number number;
    private OperationEnum operationEnum;
    private StringBuilder stringBuild;

    private Boolean boolka;
    private Boolean comBool;

    public TextView tvResult;

    public ImageButton plus;
    public ImageButton subtraction;
    public ImageButton equal;
    public ImageButton divide;
    public ImageButton multiply;
    public ImageButton clearLastSymbol;
    public ImageButton colon;

    public ImageButton zero;
    public ImageButton one;
    public ImageButton two;
    public ImageButton three;
    public ImageButton four;
    public ImageButton five;
    public ImageButton six;
    public ImageButton seven;
    public ImageButton eight;
    public ImageButton nine;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolka = false;
        comBool = false;

        number = new Number();
        operationEnum = OperationEnum.DEFAULT;
        stringBuild = new StringBuilder();

        tvResult = (TextView) findViewById(R.id.tvResult);
        plus = (ImageButton) findViewById(R.id.imPlus);
        subtraction = (ImageButton) findViewById(R.id.imSubtraction);
        equal = (ImageButton) findViewById(R.id.imEqual);
        divide = (ImageButton) findViewById(R.id.imDivide);
        multiply = (ImageButton) findViewById(R.id.imMultiply);
        clearLastSymbol = (ImageButton) findViewById(R.id.imClearLastSymbol);
        colon = (ImageButton) findViewById(R.id.imColon);

        zero = (ImageButton) findViewById(R.id.imZero);
        one = (ImageButton) findViewById(R.id.imOne);
        two = (ImageButton) findViewById(R.id.imTwo);
        three = (ImageButton) findViewById(R.id.imThree);
        four = (ImageButton) findViewById(R.id.imFour);
        five = (ImageButton) findViewById(R.id.imFive);
        six = (ImageButton) findViewById(R.id.imSix);
        seven = (ImageButton) findViewById(R.id.imSeven);
        eight = (ImageButton) findViewById(R.id.imEight);
        nine = (ImageButton) findViewById(R.id.imNine);


        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.imZero:
                        if (boolka) {
                            stringBuild.append(0);
                        } else if (stringBuild.indexOf("0") != 0) {
                            stringBuild.append(0);
                        }
                        break;
                    case R.id.imOne:
                        if (stringBuild.length() == 1 && stringBuild.indexOf("0") == 0) {
                            stringBuild.delete(0, stringBuild.length());
                        }
                        stringBuild.append(1);
                        break;
                    case R.id.imTwo:
                        if (stringBuild.length() == 1 && stringBuild.indexOf("0") == 0) {
                            stringBuild.delete(0, stringBuild.length());
                        }
                        stringBuild.append(2);
                        break;
                    case R.id.imThree:
                        if (stringBuild.length() == 1 && stringBuild.indexOf("0") == 0) {
                            stringBuild.delete(0, stringBuild.length());
                        }
                        stringBuild.append(3);
                        break;
                    case R.id.imFour:
                        if (stringBuild.length() == 1 && stringBuild.indexOf("0") == 0) {
                            stringBuild.delete(0, stringBuild.length());
                        }
                        stringBuild.append(4);
                        break;
                    case R.id.imFive:
                        if (stringBuild.length() == 1 && stringBuild.indexOf("0") == 0) {
                            stringBuild.delete(0, stringBuild.length());
                        }
                        stringBuild.append(5);
                        break;
                    case R.id.imSix:
                        if (stringBuild.length() == 1 && stringBuild.indexOf("0") == 0) {
                            stringBuild.delete(0, stringBuild.length());
                        }
                        stringBuild.append(6);
                        break;
                    case R.id.imSeven:
                        if (stringBuild.length() == 1 && stringBuild.indexOf("0") == 0) {
                            stringBuild.delete(0, stringBuild.length());
                        }
                        stringBuild.append(7);
                        break;
                    case R.id.imEight:
                        if (stringBuild.length() == 1 && stringBuild.indexOf("0") == 0) {
                            stringBuild.delete(0, stringBuild.length());
                        }
                        stringBuild.append(8);
                        break;
                    case R.id.imNine:
                        if (stringBuild.length() == 1 && stringBuild.indexOf("0") == 0) {
                            stringBuild.delete(0, stringBuild.length());
                        }
                        stringBuild.append(9);
                        break;
                }
                tvResult.setText(stringBuild);
            }
        };

        zero.setOnClickListener(onClickListener);
        one.setOnClickListener(onClickListener);
        two.setOnClickListener(onClickListener);
        three.setOnClickListener(onClickListener);
        four.setOnClickListener(onClickListener);
        five.setOnClickListener(onClickListener);
        six.setOnClickListener(onClickListener);
        seven.setOnClickListener(onClickListener);
        eight.setOnClickListener(onClickListener);
        nine.setOnClickListener(onClickListener);

        clearLastSymbol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int leng = stringBuild.indexOf(".");

                if (stringBuild.length() != 0) {
                    stringBuild.delete(stringBuild.length() - 1, stringBuild.length());
                    tvResult.setText(stringBuild);
                } else {
                    if (tvResult.length() != 0) {
                        stringBuild.append(tvResult.getText());
                        stringBuild.delete(stringBuild.length() - 1, stringBuild.length());
                        tvResult.setText(stringBuild);
                    }
                }
                if (tvResult.getText().length() < 1) {
                    tvResult.setText("0");
                }
                if (leng < stringBuild.length()) {
                    boolka = false;
                    comBool = false;
                }

            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = (String) tvResult.getText();
                number.setNumberOne(Double.parseDouble(a));
                stringBuild.delete(0, stringBuild.length());
                operationEnum = OperationEnum.PLUS;
                boolka = false;
                comBool = false;
            }
        });

        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operationEnum = OperationEnum.PLUS;
                if (number.getNumberOne() != 0 && tvResult.getText() != "0" ){
                    String a = (String) tvResult.getText();
                    number.setNumberOne(Double.parseDouble(a));
                    stringBuild.delete(0, stringBuild.length());
                    operationEnum = OperationEnum.SUBTRACTION;
                    boolka = false;
                    comBool = false;
                } else {
                    if (stringBuild.length() != 0) {
                        if (stringBuild.length() == 1 && !stringBuild.substring(0, 0).equals("-")) {
                            stringBuild.append("0.0");
                            tvResult.setText(stringBuild);
                        }
                        String a = (String) tvResult.getText();
                        number.setNumberOne(Double.parseDouble(a));
                        stringBuild.delete(0, stringBuild.length());
                        operationEnum = OperationEnum.SUBTRACTION;
                        boolka = false;
                        comBool = false;

                    } else {
                        String a = (String) tvResult.getText();
                        number.setNumberOne(Double.parseDouble(a));
                        stringBuild.delete(0, stringBuild.length());
                        operationEnum = OperationEnum.SUBTRACTION;
                        boolka = false;
                        comBool = false;

                        stringBuild.append("-");
                        tvResult.setText(stringBuild);
                    }
                }
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = (String) tvResult.getText();
                number.setNumberOne(Double.parseDouble(a));
                stringBuild.delete(0, stringBuild.length());
                operationEnum = OperationEnum.DIVIDE;
                boolka = false;
                comBool = false;
            }
        });

        colon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!comBool) {
                    if (stringBuild.length() == 0) {
                        stringBuild.append("0.");
                    } else if (!stringBuild.substring(stringBuild.length() - 1, stringBuild.length()).equals(".")) {
                        stringBuild.append(".");
                    }
                    boolka = true;
                }
                comBool = true;
                tvResult.setText(stringBuild);
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = (String) tvResult.getText();
                number.setNumberOne(Double.parseDouble(a));
                stringBuild.delete(0, stringBuild.length());
                operationEnum = OperationEnum.MULTIPLY;
                boolka = false;
                comBool = false;
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String a = (String) tvResult.getText();
                number.setNumberTwo(Double.parseDouble(a));
                stringBuild.delete(0, stringBuild.length());
                double result;
                switch (operationEnum) {
                    case PLUS:
                        result = number.getNumberOne() + number.getNumberTwo();
                        break;
                    case SUBTRACTION:
                        result = number.getNumberOne() - number.getNumberTwo();
                        break;
                    case DIVIDE:
                        result = number.getNumberOne() / number.getNumberTwo();
                        break;
                    case MULTIPLY:
                        result = number.getNumberOne() * number.getNumberTwo();
                        break;
                    case DEFAULT:
                        result = 0;
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + operationEnum);
                }

                tvResult.setText(Double.toString(result));

                String b = (String) tvResult.getText();
                number.setNumberOne(Double.parseDouble(b));
                stringBuild.delete(0, stringBuild.length());
                boolka = false;
                comBool = false;
            }
        });
    }
}
