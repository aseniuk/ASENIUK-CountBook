package com.example.aseniuk.aseniuk_countbook;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    EditText edit_text;
    Button add_button;
    Button delete_button;
    Button reset_button;
    Button info_button;
    //Button update_button;
    ListView listview;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;
    private int counter;
    private TextView counterNumber;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edit_text = (EditText) findViewById(R.id.editText);
        listview = (ListView) findViewById(R.id.mylist);

        //BUTTONS:
        add_button = (Button) findViewById(R.id.add_counter_button);
        //update_button = (Button) findViewById(R.id.update_button);
        delete_button = (Button) findViewById(R.id.delete_button);
        reset_button = (Button) findViewById(R.id.reset_button);
        info_button = (Button) findViewById(R.id.info_button);


        //the main array list...
        arrayList = new ArrayList<String>();

        //ADAPTER
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_single_choice, arrayList);
        listview.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listview.setAdapter(adapter);

        counterNumber = (TextView) findViewById(R.id.counterNumber); //determines the # of counters in the list

        //SET SELECTED ITEM IN THE LIST
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View v, int pos, long id) {
                edit_text.setText(arrayList.get(pos));
            }
        });


        //HANDLE delete, clear and reset buttons - - - - - - - - - - - - -
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                delete();
                counter = arrayList.size();
                counterNumber.setText(String.valueOf(counter)); //integer to string
            }
        });
//        update_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View arg0) {
//                update();
//                counter = arrayList.size();
//                counterNumber.setText(String.valueOf(counter)); //integer to string
//            }
//        });
        reset_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                clear();
                counter = arrayList.size();
                counterNumber.setText(String.valueOf(counter)); //integer to string
            }
        });

        info_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(MainActivity.this, InfoMenu.class);
                startActivity(i);
            }
        });

        //add_button :
        onButtonClick();




//        String[] tokens = {"dogs", "candy", "birds"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getListView().getContext(), android.R.layout.simple_list_item_1, tokens);
//        getListView().setAdapter(adapter);



    }
    //adding the item to the counter list...
    public void onButtonClick() {
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = edit_text.getText().toString();
                arrayList.add(result);
                adapter.notifyDataSetChanged();

                counter = arrayList.size();
                counterNumber.setText(String.valueOf(counter)); //integer to string
            }
        });
    }
    //deleting the item from the counter list...
    public void delete() {
        int pos=listview.getCheckedItemPosition();
        //System.out.println(pos);

        if (pos > -1 ) {
            //remove the item
            //adapter.remove(arrayList.get(pos));
            //arrayList.remove(pos);
            arrayList.remove(pos);
            //refresh
            adapter.notifyDataSetChanged();

            edit_text.setText("");
            Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "** You need to select something to delete **", Toast.LENGTH_SHORT).show();
        }
    }

    //UPDATE the item values
//    private void update(){
//        String name = edit_text.getText().toString();
//
//        //Get position of the selected item
//        int pos = listview.getCheckedItemPosition();
//
//        if (!name.isEmpty() && name.length()>0) {
//            //REMOVE THE ITEM
//            adapter.remove(arrayList.get(pos));
//
//            //INSERT
//            adapter.insert(name, pos);
//
//            //refresh
//            adapter.notifyDataSetChanged();
//
//            Toast.makeText(getApplicationContext(), "Updated " + name, Toast.LENGTH_SHORT).show();
//        }
//        else {
//            Toast.makeText(getApplicationContext(), "**Nothing to update", Toast.LENGTH_LONG).show();
//        }
//    }

    //CLEAR all items
    private void clear() {
        adapter.clear();

    }


    private void info() {

    }
}
