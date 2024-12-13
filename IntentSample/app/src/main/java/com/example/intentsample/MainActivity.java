package com.example.intentsample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        ListView lvMenu = findViewById(R.id.lvMenu);
        List<Map<String, String>> menuList = new ArrayList<>();
        Map<String,String> menu = new HashMap<>();
        menu.put("name","から揚げ定食");
        menu.put("price","800円");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name","ハンバーグ定食");
        menu.put("price","850円");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name","生姜焼き定食");
        menu.put("price","850円");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name","ステーキ定食");
        menu.put("price","1000円");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name","野菜炒め定食1");
        menu.put("price","750円");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name","野菜炒め定食2");
        menu.put("price","750円");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name","野菜炒め定食3");
        menu.put("price","750円");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name","野菜炒め定食4");
        menu.put("price","750円");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name","野菜炒め定食5");
        menu.put("price","750円");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name","野菜炒め定食6");
        menu.put("price","750円");
        menuList.add(menu);

        String[] from = {"name","price"};
        int[] to = {android.R.id.text1, android.R.id.text2};
        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this,menuList,
                android.R.layout.simple_list_item_2,from,to);
        lvMenu.setAdapter(adapter);

        lvMenu.setOnItemClickListener(new ListItemClickListener());

    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id){
            Map<String, String> item = (Map<String, String>) parent.getItemAtPosition(position);

            String menuName = item.get("name");
            String menuPrice = item.get("price");

            Intent intent = new Intent(MainActivity.this, MenuThanksActivity.class);

            intent.putExtra("menuName", menuName);
            intent.putExtra("menuPrice",menuPrice);

            startActivity(intent);
        }
    }
}