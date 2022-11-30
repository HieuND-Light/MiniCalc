package com.hieund.minicalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn0;

    private Button btn_calc;
    private Button btn_add;
    private Button btn_subtract;
    private Button btn_multiple;
    private Button btn_divide;

    private Button btn_back;
    private Button btn_clear;

    private TextView text1;
    private TextView text2;

    private final char ADD = '+';
    private final char SUBTRACT = '-';
    private final char MULTIPLE = '*';
    private final char DIVIDE = '/';
    private final char CALC = '=';
    private char ACTION;

    private int var1;
    private int var2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                text1.setText(text1.getText().toString()+"1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                text1.setText(text1.getText().toString()+"2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                text1.setText(text1.getText().toString()+"3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                text1.setText(text1.getText().toString()+"4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                text1.setText(text1.getText().toString()+"5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                text1.setText(text1.getText().toString()+"6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                text1.setText(text1.getText().toString()+"7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                text1.setText(text1.getText().toString()+"8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                text1.setText(text1.getText().toString()+"9");
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                text1.setText(text1.getText().toString()+"0");
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (text1.getText().length() > 0) {
                    getVar1();
                    text2.setText(var1 + "+");
                    text1.setText(null);

                } else {
                    text2.setText("Error");
                }
            }
        });

        btn_subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (text1.getText().length() > 0) {
                    getVar1();
                    text2.setText(var1 + "-");
                    text1.setText(null);
                } else {
                    text2.setText("Error");
                }
            }
        });

        btn_multiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (text1.getText().length() > 0) {
                    getVar1();
                    text2.setText(var1 + "x");
                    text1.setText(null);
                } else {
                    text2.setText("Error");
                }
            }
        });

        btn_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (text1.getText().length() > 0) {
                    getVar1();
                    text2.setText(var1 + "/");
                    text1.setText(null);
                } else {
                    text2.setText("Error");
                }
            }
        });

        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (text1.getText().length() > 0){
                    getVar1();
                    getVar2();
                    if (!(var2 == 0)) {
                        operation();
                        text1.setText(String.valueOf(var1));
                        text2.setText(null);
                    } else {
                        text1.setText("Infinity");
                        text2.setText(null);
                    }
                } else {
                    text2.setText("Error");
                }
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (text1.getText().length() > 0) {
                    CharSequence temp = text1.getText().toString();
                    text1.setText(temp.subSequence(0, temp.length() - 1));
                } else {
                    var1 = 0;
                    var2 = 0;
                    text1.setText("");
                    text2.setText("");
                }
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var1 = 0;
                var2 = 0;
                text1.setText("");
                text2.setText("");
            }
        });
    }

    private void initView() {
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
        btn6 = findViewById(R.id.btn_6);
        btn7 = findViewById(R.id.btn_7);
        btn8 = findViewById(R.id.btn_8);
        btn9 = findViewById(R.id.btn_9);
        btn0 = findViewById(R.id.btn_0);

        btn_calc = findViewById(R.id.btn_calc);
        btn_add = findViewById(R.id.btn_plus);
        btn_subtract = findViewById(R.id.btn_minus);
        btn_multiple = findViewById(R.id.btn_multiply);
        btn_divide = findViewById(R.id.btn_divide);

        btn_back = findViewById(R.id.btn_BS);
        btn_clear = findViewById(R.id.btn_CE);

        text1 = findViewById(R.id.textView);
        text2 = findViewById(R.id.textView2);
    }

    private void ifErrorOnOutput() {
        if (text2.getText().toString().equals("Error")) {
            text2.setText("");
        }
    }

    private int getVar1() {
        if (text1.getText().toString().isEmpty()) {
            var1 = 0;
        } else if (!text1.getText().toString().isEmpty() && text2.getText().toString().isEmpty()) {
            var1 = Integer.parseInt(text1.getText().toString());
        } else if (!text1.getText().toString().isEmpty() && !text2.getText().toString().isEmpty()) {
            var1 = Integer.parseInt(text2.getText().toString().
                    substring(0 ,text2.getText().toString().length() - 1));
        }
        return var1;
    }
    private int getVar2(){
        if (text1.getText().toString().isEmpty()) {
            var2 = 0;
        } else if (!text1.getText().toString().isEmpty() && text2.getText().toString().isEmpty()) {
            var2 = 0;
        } else if (!text1.getText().toString().isEmpty() && !text2.getText().toString().isEmpty()) {
            var2 = Integer.parseInt(text1.getText().toString());
        }
        return var2;
    }

    private void operation() {
        String inputExpression = text2.getText().toString();
        if (!inputExpression.isEmpty() && !inputExpression.equals("Error")) {
            if (inputExpression.contains("+")) {
                var1 = var1 + var2;
            } else if (inputExpression.contains("-")) {
                var1 = var1 - var2;
            } else if (inputExpression.contains("x")) {
                var1 = var1 * var2;
            } else if (inputExpression.contains("/")) {
                var1 = var1 / var2;
            }
        }
    }
}