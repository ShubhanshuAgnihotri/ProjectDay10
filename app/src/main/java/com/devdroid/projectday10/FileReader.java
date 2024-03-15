package com.devdroid.projectday10;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    private Context context;

    public FileReader(Context context) {
        this.context = context;
    }

    public List<Model> getEmployeeList() {
        List<Model> employeeList = new ArrayList<>();

        try {
            // Read JSON file from assets
            String jsonString = loadJSONFromAsset("data.json");
            System.out.println("json data: "+jsonString);

            // Parse JSON data
            JSONArray jsonArray = new JSONArray(jsonString);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                // Create Employee object and add to the list
                Model employee = new Model(
                        jsonObject.getString("name")
                );
                employeeList.add(employee);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return employeeList;
    }

    private String loadJSONFromAsset(String filename) {
        String json;
        try {
            // Read the JSON file from assets
            InputStream is = context.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return json;
    }
}