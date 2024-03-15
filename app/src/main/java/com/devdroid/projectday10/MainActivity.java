package com.devdroid.projectday10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.rvItemsList);


        FileReader fileReader = new FileReader(MainActivity.this);
//        List<Model> list = fileReader.getEmployeeList();
        List<Model> list = readJsonData();

        Adapter adapter = new Adapter(list);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
    private List<Model> readJsonData() {
        List<Model> employeeList = new ArrayList<>();

        try {
            // Read JSON file from assets
            InputStream is = getAssets().open("data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, StandardCharsets.UTF_8);
            Log.d("MainActivity","Json: "+ json);

            // Parse JSON data
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Model employee = new Model(
                        jsonObject.getString("name")
                       // jsonObject.getString("id")
                       // jsonObject.getString("designation"),
                        //jsonObject.getString("phone")
                );
                employeeList.add(employee);
            }

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return employeeList;
    }
}