package com.example.studyplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class todolist extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView listView;
    private Button button;

    TextView time;
    Button start_button, restart_button, pause_button;
    int count = 0;
    Boolean stop_loop;

    Handler handler;

    int temporary=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todolist);

        listView = findViewById(R.id.listView);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItem(view);

            }
        });

        items = new ArrayList<>();
        itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(itemsAdapter);
        setUpListViewListener();

        time = (TextView) findViewById(R.id.timer);

        start_button = (Button) findViewById(R.id.startbut);
        restart_button = (Button) findViewById(R.id.restartbut);
        pause_button = (Button) findViewById(R.id.pausebut);

        start_button.setOnClickListener(this);
        restart_button.setOnClickListener(this);
        pause_button.setOnClickListener(this);

        handler = new Handler(getApplicationContext().getMainLooper());


    }

    private void setUpListViewListener() {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long id) {
                Context context = getApplicationContext();
                Toast.makeText(context, "Item Removed", Toast.LENGTH_LONG).show();

                items.remove(i);
                itemsAdapter.notifyDataSetChanged();
                return true;
            }

        });
    }

    private void addItem(View view){
        EditText input = findViewById(R.id.editText2);
        String itemText = input.getText().toString();

        if(!(itemText.equals(""))){
            itemsAdapter.add(itemText);
            input.setText("");
        }
        else {
            Toast.makeText(getApplicationContext(), "Please enter text..", Toast.LENGTH_LONG).show();
        }
        }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.startbut:
                stop_loop = true;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (stop_loop)
                        {
                            try {
                                Thread.sleep(1000);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    int hours = count / 3600;
                                    int minutes = (count % 3600) / 60;
                                    int seconds = count % 60;
                                    time.setText(Integer.toString(hours)+":"+Integer.toString(minutes)+":"+Integer.toString(seconds));
                                    temporary=count;
                                    count++;
                                }
                            });
                        }
                    }
                }).start();
                break;

            case R.id.restartbut:
                stop_loop = false;
                time.setText(null);
                count=0;
                break;

            case R.id.pausebut:
                stop_loop=false;
                temporary=count-1;
                int hours = temporary / 3600;
                int minutes = (temporary % 3600) / 60;
                int seconds = temporary % 60;
                time.setText(Integer.toString(hours)+":"+Integer.toString(minutes)+":"+Integer.toString(seconds));
                break;
        }
    }
}
