package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public TextView tvResult;
    public int numberOne;
    public int numberTwo;
    public ImageButton plus;
    public ImageButton subtraction;
    public ImageButton equal;
    public ImageButton divide;
    public ImageButton multiply;

    public ImageButton one;
    public ImageButton two;
    public ImageButton three;
    public ImageButton four;
    public ImageButton five;
    public ImageButton six;
    public ImageButton seven;
    public ImageButton eight;
    public ImageButton nine;

    public String number;
    private Operation operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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


        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "SLAVIK IS REALY MACHINE", Toast.LENGTH_SHORT).show();
                String a = (String) tvResult.getText();
                setNumberOne(Integer.parseInt(a));
                stringBuild.delete(0, stringBuild.length());
                operation = Operation.PLUS;
            }
        });

        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),operation+"", Toast.LENGTH_SHORT).show();
                String a = (String) tvResult.getText();
                setNumberOne(Integer.parseInt(a));
                stringBuild.delete(0,stringBuild.length());
                operation = Operation.SUBTRACTION;
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),operation+"",Toast.LENGTH_SHORT).show();
                String a = (String) tvResult.getText();
                setNumberOne(Integer.parseInt(a));
                stringBuild.delete(0,stringBuild.length());
                operation = Operation.DIVIDE;
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),operation+"",Toast.LENGTH_SHORT).show();
                String a = (String) tvResult.getText();
                setNumberOne(Integer.parseInt(a));
                stringBuild.delete(0,stringBuild.length());
                operation = Operation.MULTIPLY;
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "SVLAVIK IS XYI", Toast.LENGTH_SHORT).show();
                String a = (String) tvResult.getText();
                setNumberTwo(Integer.parseInt(a));
                stringBuild.delete(0, stringBuild.length());
                int result = 0;
                switch (operation) {
                    case PLUS:
                        result = getNumberOne() + getNumberTwo();
                        break;
                    case SUBTRACTION:
                        result = getNumberOne() - getNumberTwo();
                        break;
                    case DIVIDE:
                        result = getNumberOne() / getNumberTwo();
                        break;
                    case MULTIPLY:
                        result = getNumberOne() * getNumberTwo();
                        break;

                }

                tvResult.setText(Integer.toString(result));

                String b = (String) tvResult.getText();
                setNumberOne(Integer.parseInt(b));
                stringBuild.delete(0,stringBuild.length());
            }
        });

    }


    public int setNumberOne(int a) {
        return this.numberOne = a;
    }

    public int setNumberTwo(int a) {
        return this.numberTwo = a;
    }

    public int getNumberOne() {
        return numberOne;
    }

    public int getNumberTwo() {
        return numberTwo;
    }
}
