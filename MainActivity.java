package com.example.user.calculatorv2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;       //for using buttons
import android.widget.TextView;     //for output

/**
 * This class is the driver for the logic behind the user interface, it defines which code will run with which button
 * Author: Marina Chirchikova
 */
public class MainActivity extends AppCompatActivity {
    public String line;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //Create number buttons
        Button button0 = (Button)findViewById(R.id.button0);
        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);
        Button button4 = (Button)findViewById(R.id.button4);
        Button button5 = (Button)findViewById(R.id.button5);
        Button button6 = (Button)findViewById(R.id.button6);
        Button button7 = (Button)findViewById(R.id.button7);
        Button button8 = (Button)findViewById(R.id.button8);
        Button button9 = (Button)findViewById(R.id.button9);

        //Create buttons for operations
        Button buttonExp = (Button)findViewById(R.id.buttonExp);
        Button buttonXY = (Button)findViewById(R.id.buttonXY);
        Button buttonTenEx = (Button)findViewById(R.id.buttonTenEx);
        Button buttonC = (Button)findViewById(R.id.buttonC);    //clear
        Button buttonLN = (Button)findViewById(R.id.buttonLN);
        Button buttonSin = (Button)findViewById(R.id.buttonSin);
        Button buttonSqrt = (Button)findViewById(R.id.buttonSqrt);
        Button buttonNeg = (Button)findViewById(R.id.buttonNeg); //negative/positive button
        Button buttonD = (Button)findViewById(R.id.buttonD);    //divide
        Button buttonM = (Button)findViewById(R.id.buttonM);    //multiply
        Button buttonS = (Button)findViewById(R.id.buttonS);    //subtract
        Button buttonA = (Button)findViewById(R.id.buttonA);    //add
        Button buttonR = (Button)findViewById(R.id.buttonR);    //equals sign
        Button buttonP = (Button)findViewById(R.id.buttonP);    //decimal
        Button buttonLeftBracket = (Button)findViewById(R.id.buttonLB);  //left bracket
        Button buttonRightBracket = (Button)findViewById(R.id.buttonRB);  //right bracket

        TextView output = (TextView)findViewById(R.id.editText);
        output.append(String.valueOf(0));
        TextView window = (TextView)findViewById(R.id.textWindow);

        //Creates event handlers for each button

        button0.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView window = (TextView)findViewById(R.id.textWindow);
                        window.setText("");
                        TextView output = (TextView) findViewById(R.id.editText);
                        if (output.getText().toString().equals("0")) {
                            output.setText("");
                        }
                        output.append("0");
                    }
                }
        );

        button1.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView window = (TextView)findViewById(R.id.textWindow);
                        window.setText("");
                        TextView output = (TextView)findViewById(R.id.editText);
                        if(output.getText().toString().equals("0")){
                            output.setText("");
                        }
                        output.append("1");
                    }
                }
        );

        button2.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView window = (TextView)findViewById(R.id.textWindow);
                        window.setText("");
                        TextView output = (TextView)findViewById(R.id.editText);
                        if(output.getText().toString().equals("0")){
                            output.setText("");
                        }
                        output.append("2");
                    }
                }
        );

        button3.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView window = (TextView)findViewById(R.id.textWindow);
                        window.setText("");
                        TextView output = (TextView)findViewById(R.id.editText);
                        if(output.getText().toString().equals("0")){
                            output.setText("");
                        }
                        output.append("3");
                    }
                }
        );

        button4.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView window = (TextView)findViewById(R.id.textWindow);
                        window.setText("");
                        TextView output = (TextView)findViewById(R.id.editText);
                        if(output.getText().toString().equals("0")){
                            output.setText("");
                        }
                        output.append("4");
                    }
                }
        );

        button5.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView window = (TextView)findViewById(R.id.textWindow);
                        window.setText("");
                        TextView output = (TextView)findViewById(R.id.editText);
                        if(output.getText().toString().equals("0")){
                            output.setText("");
                        }
                        output.append("5");
                    }
                }
        );

        button6.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView window = (TextView)findViewById(R.id.textWindow);
                        window.setText("");
                        TextView output = (TextView)findViewById(R.id.editText);
                        if(output.getText().toString().equals("0")){
                            output.setText("");
                        }
                        output.append("6");
                    }
                }
        );

        button7.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView window = (TextView)findViewById(R.id.textWindow);
                        window.setText("");
                        TextView output = (TextView)findViewById(R.id.editText);
                        if(output.getText().toString().equals("0")){
                            output.setText("");
                        }
                        output.append("7");
                    }
                }
        );

        button8.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView window = (TextView)findViewById(R.id.textWindow);
                        window.setText("");
                        TextView output = (TextView)findViewById(R.id.editText);
                        if(output.getText().toString().equals("0")){
                            output.setText("");
                        }
                        output.append("8");
                    }
                }
        );

        button9.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView window = (TextView)findViewById(R.id.textWindow);
                        window.setText("");
                        TextView output = (TextView)findViewById(R.id.editText);
                        if(output.getText().toString().equals("0")){
                            output.setText("");
                        }
                        output.append("9");
                    }
                }
        );

        buttonP.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView window = (TextView)findViewById(R.id.textWindow);
                        window.setText("");
                        TextView output = (TextView)findViewById(R.id.editText);
                        String text = output.getText().toString();
                        String newText = text + ".";
                        output.setText(newText);

                    }
                }
        );

        //This button deletes the rightmost digit of the output string
        buttonNeg.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView window = (TextView)findViewById(R.id.textWindow);
                        window.setText("");
                        TextView output = (TextView)findViewById(R.id.editText);
                        String str = output.getText().toString();
                        int n = str.length();
                        if(n==1){
                            output.setText("0");
                        }
                        else if ((str.substring(n-2)).equals("ln")){
                            String newstr = str.substring(0,n-2);
                            output.setText(newstr);
                        }
                        else if (n >= 3 && (str.substring(n-3)).equals("sin")){
                            String newstr = str.substring(0, n-3);
                            output.setText(newstr);
                        }
                        else if (n >= 4 && (str.substring(n-4)).equals("sqrt")){
                            String newstr = str.substring(0, n-4);
                            output.setText(newstr);
                        }
                        else {
                            String newstr = str.substring(0,n-1);
                            output.setText(newstr);
                        }
                    }
                }
        );

        //Clears the line
        buttonC.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView window = (TextView)findViewById(R.id.textWindow);
                        window.setText("");
                        TextView output = (TextView)findViewById(R.id.editText);
                        output.setText("0");
                    }
                }
        );

        //create event handlers for operations

        buttonA.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView window = (TextView)findViewById(R.id.textWindow);
                        window.setText("");
                        TextView output = (TextView)findViewById(R.id.editText);
                        String text = output.getText().toString();
                        String newText = text + "+";
                        output.setText(newText);
                    }
                }
        );

        buttonS.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView window = (TextView)findViewById(R.id.textWindow);
                        window.setText("");
                        TextView output = (TextView)findViewById(R.id.editText);
                        String text = output.getText().toString();
                        String newText = text + "-";
                        output.setText(newText);
                    }
                }
        );

        buttonM.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView window = (TextView)findViewById(R.id.textWindow);
                        window.setText("");
                        TextView output = (TextView)findViewById(R.id.editText);
                        String text = output.getText().toString();
                        String newText = text + "*";
                        output.setText(newText);
                    }
                }
        );

        buttonD.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView window = (TextView)findViewById(R.id.textWindow);
                        window.setText("");
                        TextView output = (TextView)findViewById(R.id.editText);
                        String text = output.getText().toString();
                        String newText = text + "/";
                        output.setText(newText);
                    }
                }
        );

        buttonExp.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView window = (TextView)findViewById(R.id.textWindow);
                        window.setText("");
                        TextView output = (TextView)findViewById(R.id.editText);
                        if(output.getText().toString().equals("0")){
                            output.setText("");
                        }
                        String text = output.getText().toString();
                        String newText = text + "e^";
                        output.setText(newText);
                    }
                }
        );

        buttonTenEx.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView window = (TextView)findViewById(R.id.textWindow);
                        window.setText("");
                        TextView output = (TextView)findViewById(R.id.editText);
                        if(output.getText().toString().equals("0")){
                            output.setText("");
                        }
                        String text = output.getText().toString();
                        String newText = text + "10^";
                        output.setText(newText);
                    }
                }
        );

        buttonLN.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView window = (TextView)findViewById(R.id.textWindow);
                        window.setText("");
                        TextView output = (TextView)findViewById(R.id.editText);
                        if(output.getText().toString().equals("0")){
                            output.setText("");
                        }
                        String text = output.getText().toString();
                        String newText = text + "ln";
                        output.setText(newText);
                    }
                }
        );

        buttonSin.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView window = (TextView)findViewById(R.id.textWindow);
                        window.setText("");
                        TextView output = (TextView)findViewById(R.id.editText);
                        if(output.getText().toString().equals("0")){
                            output.setText("");
                        }
                        String text = output.getText().toString();
                        String newText = text + "sin";
                        output.setText(newText);
                    }
                }
        );

        buttonSqrt.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView window = (TextView)findViewById(R.id.textWindow);
                        window.setText("");
                        TextView output = (TextView)findViewById(R.id.editText);
                        if(output.getText().toString().equals("0")){
                            output.setText("");
                        }
                        String text = output.getText().toString();
                        String newText = text + "sqrt";
                        output.setText(newText);
                    }
                }
        );

        buttonXY.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView window = (TextView)findViewById(R.id.textWindow);
                        window.setText("");
                        TextView output = (TextView)findViewById(R.id.editText);
                        String text = output.getText().toString();
                        String newText = text + "^";
                        output.setText(newText);
                    }
                }
        );

        buttonLeftBracket.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView window = (TextView)findViewById(R.id.textWindow);
                        window.setText("");
                        TextView output = (TextView)findViewById(R.id.editText);
                        if(output.getText().toString().equals("0")){
                            output.setText("");
                        }
                        String text = output.getText().toString();
                        String newText = text + "(";
                        output.setText(newText);
                    }
                }
        );

        buttonRightBracket.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView window = (TextView)findViewById(R.id.textWindow);
                        window.setText("");
                        TextView output = (TextView)findViewById(R.id.editText);
                        if(output.getText().toString().equals("0")){
                            output.setText("");
                        }
                        String text = output.getText().toString();
                        String newText = text + ")";
                        output.setText(newText);
                    }
                }
        );

        //define result event handler when user presses "="
        buttonR.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v) {
                        TextView output = (TextView) findViewById(R.id.editText);
                        String expression = output.getText().toString();
                        TextView window = (TextView)findViewById(R.id.textWindow);
                        window.setText(expression);
                        output.setText("");
                        double answer;
                        String message;

                        Parser p = new Parser();
                        try{
                            answer = p.parse(expression);
                            String text_answer = Double.toString(answer);
                            output.setText(text_answer);
                        }
                        catch(MathException e){
                            message = e.getMessage();
                            output.setText(message);
                        }
                    }
                }
        );



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
