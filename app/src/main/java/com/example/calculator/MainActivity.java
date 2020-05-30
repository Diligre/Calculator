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
                        stringBuild.append(0);
                        break;
                    case R.id.imOne:
                        stringBuild.append(1);
                        break;
                    case R.id.imTwo:
                        stringBuild.append(2);
                        break;
                    case R.id.imThree:
                        stringBuild.append(3);
                        break;
                    case R.id.imFour:
                        stringBuild.append(4);
                        break;
                    case R.id.imFive:
                        stringBuild.append(5);
                        break;
                    case R.id.imSix:
                        stringBuild.append(6);
                        break;
                    case R.id.imSeven:
                        stringBuild.append(7);
                        break;
                    case R.id.imEight:
                        stringBuild.append(8);
                        break;
                    case R.id.imNine:
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
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "SLAVIK IS REALY MACHINE", Toast.LENGTH_SHORT).show();
                String a = (String) tvResult.getText();
                number.setNumberOne(Double.parseDouble(a));
                stringBuild.delete(0, stringBuild.length());
                operationEnum = OperationEnum.PLUS;
            }
        });

        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (stringBuild.length() == 0) {
                    stringBuild.append("-");
                    tvResult.setText(stringBuild);
                } else {
                    Toast.makeText(getApplicationContext(), operationEnum + "", Toast.LENGTH_SHORT).show();
                    String a = (String) tvResult.getText();
                    number.setNumberOne(Double.parseDouble(a));
                    stringBuild.delete(0, stringBuild.length());
                    operationEnum = OperationEnum.SUBTRACTION;
                }
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), operationEnum + "", Toast.LENGTH_SHORT).show();
                String a = (String) tvResult.getText();
                number.setNumberOne(Double.parseDouble(a));
                stringBuild.delete(0, stringBuild.length());
                operationEnum = OperationEnum.DIVIDE;
            }
        });

        colon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (stringBuild.length() == 0){
                    stringBuild.append("0.");
                }
                else {
                    stringBuild.append(".");
                }
                tvResult.setText(stringBuild);
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), operationEnum + "", Toast.LENGTH_SHORT).show();
                String a = (String) tvResult.getText();
                number.setNumberOne(Double.parseDouble(a));
                stringBuild.delete(0, stringBuild.length());
                operationEnum = OperationEnum.MULTIPLY;
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "SVLAVIK IS XYI", Toast.LENGTH_SHORT).show();
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
            }
        });
    }
}
