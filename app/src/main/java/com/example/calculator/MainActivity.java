package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Number number;

    public TextView tvResult;

    public ImageButton plus;
    public ImageButton subtraction;
    public ImageButton equal;
    public ImageButton divide;
    public ImageButton multiply;

    public ImageButton clearLastSymbol;

    public ImageButton one;
    public ImageButton two;
    public ImageButton three;
    public ImageButton four;
    public ImageButton five;
    public ImageButton six;
    public ImageButton seven;
    public ImageButton eight;
    public ImageButton nine;

    private OperationEnum operationEnum;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number = new Number();

        operationEnum = OperationEnum.DEFAULT;


        tvResult = (TextView) findViewById(R.id.tvResult);
        plus = (ImageButton) findViewById(R.id.imPlus);
        subtraction = (ImageButton) findViewById(R.id.imSubtraction);
        equal = (ImageButton) findViewById(R.id.imEqual);
        divide = (ImageButton) findViewById(R.id.imDivide);
        multiply = (ImageButton) findViewById(R.id.imMultiply);

        one = (ImageButton) findViewById(R.id.imOne);
        two = (ImageButton) findViewById(R.id.imTwo);
        three = (ImageButton) findViewById(R.id.imThree);
        four = (ImageButton) findViewById(R.id.imFour);
        five = (ImageButton) findViewById(R.id.imFive);
        six = (ImageButton) findViewById(R.id.imSix);
        seven = (ImageButton) findViewById(R.id.imSeven);
        eight = (ImageButton) findViewById(R.id.imEight);
        nine = (ImageButton) findViewById(R.id.imNine);

        clearLastSymbol = (ImageButton) findViewById(R.id.imClearLastSymbol);

        final StringBuilder stringBuild = new StringBuilder();


        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.imOne:
                        stringBuild.append(1);
                        tvResult.setText(stringBuild);
                        break;
                    case R.id.imTwo:
                        stringBuild.append(2);
                        tvResult.setText(stringBuild);
                        break;
                    case R.id.imThree:
                        stringBuild.append(3);
                        tvResult.setText(stringBuild);
                        break;
                    case R.id.imFour:
                        stringBuild.append(4);
                        tvResult.setText(stringBuild);
                        break;
                    case R.id.imFive:
                        stringBuild.append(5);
                        tvResult.setText(stringBuild);
                        break;
                    case R.id.imSix:
                        stringBuild.append(6);
                        tvResult.setText(stringBuild);
                        break;
                    case R.id.imSeven:
                        stringBuild.append(7);
                        tvResult.setText(stringBuild);
                        break;
                    case R.id.imEight:
                        stringBuild.append(8);
                        tvResult.setText(stringBuild);
                        break;
                    case R.id.imNine:
                        stringBuild.append(9);
                        tvResult.setText(stringBuild);
                        break;
                }
            }
        };

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
                number.setNumberOne(Integer.parseInt(a));
                stringBuild.delete(0, stringBuild.length());
                operationEnum = OperationEnum.PLUS;
            }
        });

        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), operationEnum + "", Toast.LENGTH_SHORT).show();
                String a = (String) tvResult.getText();
                number.setNumberOne(Integer.parseInt(a));
                stringBuild.delete(0, stringBuild.length());
                operationEnum = OperationEnum.SUBTRACTION;
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), operationEnum + "", Toast.LENGTH_SHORT).show();
                String a = (String) tvResult.getText();
                number.setNumberOne(Integer.parseInt(a));
                stringBuild.delete(0, stringBuild.length());
                operationEnum = OperationEnum.DIVIDE;
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), operationEnum + "", Toast.LENGTH_SHORT).show();
                String a = (String) tvResult.getText();
                number.setNumberOne(Integer.parseInt(a));
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
                number.setNumberTwo(Integer.parseInt(a));
                stringBuild.delete(0, stringBuild.length());
                int result;
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

                tvResult.setText(Integer.toString(result));

                String b = (String) tvResult.getText();
                number.setNumberOne(Integer.parseInt(b));
                stringBuild.delete(0, stringBuild.length());
            }
        });

    }
}
