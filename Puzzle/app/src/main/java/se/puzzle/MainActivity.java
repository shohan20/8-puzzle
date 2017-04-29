package se.puzzle;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.graphics.Color;
import android.os.Handler;
import android.widget.ImageView;

import java.io.IOException;
import java.util.Stack;


public class MainActivity extends AppCompatActivity {

    int arr[]=new int[10];
    public boolean run=false;
    AstarAlgorithm b;
    Stack stack=new Stack();
    final Handler handler = new Handler();
    int[] a = {0,1,2,3,4,5,6,7,8};
    String is[]={"zero","one","two","three","four","five","six","seven","eight"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        update(a);
        runTimer();

    }
    
    public void shuffle(View view){
        run=false;

        String sf="182043765";
        for(int i=0;i<sf.length();i++)
        {
            a[i]=sf.charAt(i)-'0';
        }
        stack=new Stack();
        b=new AstarAlgorithm();
        update(a);
        start();
    }
    

   public void sort(View view) {
        run=true;

    }

    public void start(){
        try {
            Node goalNodeFound=b.puzzlesover(a);
            while (goalNodeFound.parent != null){//loop for goal state iteration
                if(goalNodeFound.move != null){
                    // System.out.println(goalNodeFound.state.toString());
                    stack.push(goalNodeFound.state);
                }
                goalNodeFound = goalNodeFound.parent;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void runTimer() {


        handler.post(new Runnable() {
            @Override
           
            public void run() {
                if (run == true && !stack.isEmpty()) {
                    String str = stack.pop().toString();
                    str = str.replaceAll(",", "");
                    str = str.replaceAll(" ", "");
                    String s = "";
                    int i;
                    for (i = 1; i < str.length() - 1; i++)
                        s += str.charAt(i);
                   
                    for (i = 0; i <= 8; i++) {
                        arr[i] = s.charAt(i) - '0';
                    }
                   
                   update(arr);

                }


                handler.postDelayed(this, 2000);
            }

        });

    }
    
     void update(int u[])
    {
         ImageView zero = (ImageView) findViewById(R.id.zero);
         int resID = getResources().getIdentifier(is[u[0]], "drawable", getPackageName());
         zero.setImageResource(resID);
         ImageView one = (ImageView) findViewById(R.id.one);
         resID = getResources().getIdentifier(is[u[1]], "drawable", getPackageName());
         one.setImageResource(resID);
         ImageView two = (ImageView) findViewById(R.id.two);
         resID = getResources().getIdentifier(is[u[2]], "drawable", getPackageName());
         two.setImageResource(resID);
 
         ImageView three = (ImageView) findViewById(R.id.three);
         resID = getResources().getIdentifier(is[u[3]], "drawable", getPackageName());
         three.setImageResource(resID);
 
         ImageView four = (ImageView) findViewById(R.id.four);
         resID = getResources().getIdentifier(is[u[4]], "drawable", getPackageName());
         four.setImageResource(resID);
 
         ImageView five = (ImageView) findViewById(R.id.five);
         resID = getResources().getIdentifier(is[u[5]], "drawable", getPackageName());
         five.setImageResource(resID);
 
         ImageView six = (ImageView) findViewById(R.id.six);
         resID = getResources().getIdentifier(is[u[6]], "drawable", getPackageName());
         six.setImageResource(resID);
 
         ImageView seven = (ImageView) findViewById(R.id.seven);
         resID = getResources().getIdentifier(is[u[7]], "drawable", getPackageName());
         seven.setImageResource(resID);
 
         ImageView eight = (ImageView) findViewById(R.id.eight);
         resID = getResources().getIdentifier(is[u[8]], "drawable", getPackageName());
         eight.setImageResource(resID);
     }





}