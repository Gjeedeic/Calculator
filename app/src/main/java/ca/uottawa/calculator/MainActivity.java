package ca.uottawa.calculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends Activity {
    private enum Operator {none, add, minus, multiply, divide}

    private Double data1=null, data2 =null; //used to Double instead so I can make them null when no number is used
    private Operator curroptr = Operator.none; //current operator to be used when pressed
    private Operator defoptr = Operator.none; // operator actioned in the next press
    private boolean firstclick=true; //keeps track if it is the first click for a number to remove what is in mantissa

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn00Click(View view) {

        EditText eText = (EditText) findViewById(R.id.resultEdit);
        if(firstclick){
            eText.setText("");
            firstclick=false;
        }
        eText.setText(eText.getText() + "0");
    }

    public void btn01Click(View view) {
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        if(firstclick){
            eText.setText("");
            firstclick=false;
        }
        eText.setText(eText.getText() + "1");
    }

    public void btn02Click(View view) {
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        if(firstclick){
            eText.setText("");
            firstclick=false;
        }
        eText.setText(eText.getText() + "2");
    }

    public void btn03Click(View view) {
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        if(firstclick){
            eText.setText("");
            firstclick=false;
        }
        eText.setText(eText.getText() + "3");
    }

    public void btn04Click(View view) {
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        if(firstclick){
            eText.setText("");
            firstclick=false;
        }
        eText.setText(eText.getText() + "4");
    }

    public void btn05Click(View view) {
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        if(firstclick){
            eText.setText("");
            firstclick=false;
        }
        eText.setText(eText.getText() + "5");
    }

    public void btn06Click(View view) {
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        if(firstclick){
            eText.setText("");
            firstclick=false;
        }
        eText.setText(eText.getText() + "6");
    }

    public void btn07Click(View view) {
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        if(firstclick){
            eText.setText("");
            firstclick=false;
        }
        eText.setText(eText.getText() + "7");
    }

    public void btn08Click(View view) {
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        if(firstclick){
            eText.setText("");
            firstclick=false;
        }
        eText.setText(eText.getText() + "8");
    }

    public void btn09Click(View view) {
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        if(firstclick){
            eText.setText("");
            firstclick=false;
        }
        eText.setText(eText.getText() + "9");
    }

    public void btnAddClick(View view) {
        if (data1 == null) {
            EditText eText = (EditText) findViewById(R.id.resultEdit);
            if (eText.getText().toString().isEmpty()){data1=0.0;} //if nothing is entered it takes 0 as the number
            else{ data1 = Double.parseDouble(eText.getText().toString());}
            defoptr = Operator.add;
            eText.setText("");
            firstclick=true;

        } else {
            EditText eText = (EditText) findViewById(R.id.resultEdit);
            if (eText.getText().toString().isEmpty()){data2=0.0;}
            else{ data2 = Double.parseDouble(eText.getText().toString());}//if nothing is entered it takes 0 as the number

            if (defoptr != Operator.none) {
                curroptr = defoptr;
                defoptr = Operator.add;
            } else {
                curroptr = Operator.add;
                defoptr = Operator.none;

            }

            data1 = calc(curroptr, data1, data2);

            double result=data1;
            if ((data1 - (int) result) != 0)
                eText.setText(String.valueOf(data1));
            else
                eText.setText(String.valueOf((int) result));
            firstclick=true;
        }
    }

    public void btnMinusClick(View view) {
        if (data1 == null) {
            EditText eText = (EditText) findViewById(R.id.resultEdit);
            if (eText.getText().toString().isEmpty()){data1=0.0;}
            else{ data1 = Double.parseDouble(eText.getText().toString());}//if nothing is entered it takes 0 as the number
            defoptr = Operator.minus;
            eText.setText("");
            firstclick=true;
        } else {
            EditText eText = (EditText) findViewById(R.id.resultEdit);
            if (eText.getText().toString().isEmpty()){data2=0.0;}
            else{ data2 = Double.parseDouble(eText.getText().toString());}//if nothing is entered it takes 0 as the number

            if (defoptr != Operator.none) {
                curroptr = defoptr;
                defoptr = Operator.minus;
            } else {
                curroptr = Operator.minus;
                defoptr = Operator.none;

            }

            data1 = calc(curroptr, data1, data2);
            double result=data1;
            if ((data1 - (int) result) != 0)
                eText.setText(String.valueOf(data1));
            else
                eText.setText(String.valueOf((int) result));
            firstclick=true;
        }
    }

    public void btnMultiplyClick(View view) {
        if (data1 == null) {
            EditText eText = (EditText) findViewById(R.id.resultEdit);
            if (eText.getText().toString().isEmpty()){data1=0.0;}
            else{ data1 = Double.parseDouble(eText.getText().toString());}//if nothing is entered it takes 0 as the number
            defoptr = Operator.multiply;
            eText.setText("");
            firstclick=true;
        } else {
            EditText eText = (EditText) findViewById(R.id.resultEdit);
            if (eText.getText().toString().isEmpty()){data2=0.0;}
            else{ data2 = Double.parseDouble(eText.getText().toString());}//if nothing is entered it takes 0 as the number


            if (defoptr != Operator.none) {
                curroptr = defoptr;
                defoptr = Operator.multiply;
            } else {
                curroptr = Operator.multiply;
                defoptr = Operator.none;

            }

            data1 = calc(curroptr, data1, data2);
            double result=data1;
            if ((data1 - (int) result) != 0)
                eText.setText(String.valueOf(data1));
            else
                eText.setText(String.valueOf((int) result));
            firstclick=true;

        }
    }


    public void btnDivideClick(View view) {
       if (data1 == null) {
            EditText eText = (EditText) findViewById(R.id.resultEdit);
           if (eText.getText().toString().isEmpty()){data1=0.0;}//if nothing is entered it takes 0 as the number
           else{ data1 = Double.parseDouble(eText.getText().toString());}
            defoptr = Operator.divide;
            eText.setText("");
           firstclick=true;
        } else {
            EditText eText = (EditText) findViewById(R.id.resultEdit);
           if (eText.getText().toString().isEmpty()){data2=0.0;}
           else{ data2 = Double.parseDouble(eText.getText().toString());}//if nothing is entered it takes 0 as the number

            if (defoptr != Operator.none) {
                curroptr = defoptr;
                defoptr = Operator.divide;
            } else {
                curroptr = Operator.divide;
                defoptr = Operator.none;

            }


           data1 = calc(curroptr, data1, data2);
           double result=data1;
           if ((data1 - (int) result) != 0)
               eText.setText(String.valueOf(data1));
           else
               eText.setText(String.valueOf((int) result));

           firstclick=true;


        }
    }
    //clears number if number in the Mantissa and if no number is in the Mantissa it clears all operations
    public void btnClearClick(View view) {

        EditText eText = (EditText) findViewById(R.id.resultEdit);
        if (eText.getText().toString().isEmpty()){
            curroptr=Operator.none;
            defoptr=Operator.none;
            data1=null;
            data2=null;
            firstclick=true;
            }
        else{
            eText.setText("");
            firstclick=true;
        }
    }

    public void btnDotClick(View view) {
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        if(firstclick){
            eText.setText("0.");
            firstclick=false;
        }
        else{
        if (eText.getText().toString().indexOf(".") < 0) { // checks to see if there is a dot in the mantissa already


            eText.setText(eText.getText() + ".");}
        }

    }

    public void btnResultClick(View view) {
        if (defoptr != Operator.none) {
            EditText eText = (EditText) findViewById(R.id.resultEdit);
            if (eText.getText().toString().isEmpty()){data2=0.0;}
            else{ data2 = Double.parseDouble(eText.getText().toString());}//if nothing is entered it takes 0 as the number
            double result = calc(defoptr, data1, data2);
            defoptr = Operator.none;
            curroptr=Operator.none;
            data1=null;  // returned both values to null if user continues calc it will capture the one on the mantissa screen
            data2=null;
            if ((result - (int) result) != 0)
                eText.setText(String.valueOf(result));
            else
                eText.setText(String.valueOf((int) result));
            firstclick=true;
        }


    }
    //method to execute arithmetic operations
    public double calc(Operator operation, double a, double b) {
        double result = 0;

        if (operation == Operator.add) {
            result = a + b;
        } else if (operation == Operator.minus) {
            result = a - b;
        } else if (operation == Operator.multiply) {
            result = a * b;
        } else if (operation == Operator.divide) {
            result = a / b;
        }

        return result;
    }

}