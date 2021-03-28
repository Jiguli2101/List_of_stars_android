package id195652724.stars;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ItemCategoryActivity extends AppCompatActivity {
    //создаем ссылку на listView
    private ListView listViewItems;

    private ArrayList<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_category);
        listViewItems = findViewById(R.id.listViewItems);

        //убираем actionbar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        items = new ArrayList<>();
        //создаем обьекты с 3 параметрами ( title, info и img )
        items.add(new Item(getString(R.string.item_Benicio_title), getString(R.string.item_Benicio_info), R.drawable.benicio));
        items.add(new Item(getString(R.string.item_Buscemi_title), getString(R.string.item_Buscemi_info), R.drawable.buscemi));
        items.add(new Item(getString(R.string.item_Chonoshvili_title), getString(R.string.item_Chonoshvili_info), R.drawable.chonoshvili));
        items.add(new Item(getString(R.string.item_Crowe_title), getString(R.string.item_Crowe_info), R.drawable.crowe));
        items.add(new Item(getString(R.string.item_Cusack_title), getString(R.string.item_Cusack_info), R.drawable.cusack));
        items.add(new Item(getString(R.string.item_Depardieu_title), getString(R.string.item_Depardieu_info), R.drawable.depardieu));
        items.add(new Item(getString(R.string.item_Depp_title), getString(R.string.item_Depp_info), R.drawable.depp));
        items.add(new Item(getString(R.string.item_DiCaprio_title), getString(R.string.item_DiCaprio_info), R.drawable.dicaprio));
        items.add(new Item(getString(R.string.item_Diesel_title), getString(R.string.item_Diesel_info), R.drawable.diesel));
        items.add(new Item(getString(R.string.item_Downey_title), getString(R.string.item_Downey_info), R.drawable.downey));
        items.add(new Item(getString(R.string.item_Fichtner_title), getString(R.string.item_Fichtner_info), R.drawable.fichtner));
        items.add(new Item(getString(R.string.item_Hanks_title), getString(R.string.item_Hanks_info), R.drawable.hanks));
        items.add(new Item(getString(R.string.item_Knepper_title), getString(R.string.item_Knepper_info), R.drawable.knepper));
        items.add(new Item(getString(R.string.item_May_title), getString(R.string.item_May_info), R.drawable.may));
        items.add(new Item(getString(R.string.item_Odenkirk_title), getString(R.string.item_Odenkirk_info), R.drawable.odenkirk));
        items.add(new Item(getString(R.string.item_Pike_title), getString(R.string.item_Pike_info), R.drawable.pike));
        items.add(new Item(getString(R.string.item_Pitt_title), getString(R.string.item_Pitt_info), R.drawable.pitt));
        items.add(new Item(getString(R.string.item_Rabourdin_title), getString(R.string.item_Rabourdin_info), R.drawable.rabourdin));
        items.add(new Item(getString(R.string.item_Richard_title), getString(R.string.item_Richard_info), R.drawable.richard));
        items.add(new Item(getString(R.string.item_Simpson_title), getString(R.string.item_Simpson_info), R.drawable.simpson));
        items.add(new Item(getString(R.string.item_Spacey_title), getString(R.string.item_Spacey_info), R.drawable.spacey));
        items.add(new Item(getString(R.string.item_Stone_title), getString(R.string.item_Stone_info), R.drawable.stone));
        items.add(new Item(getString(R.string.item_Weatherly_title), getString(R.string.item_Weatherly_info), R.drawable.weatherly));


        listViewItems = findViewById(R.id.listViewItems);

        ArrayAdapter<Item> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, items);
        listViewItems.setAdapter(adapter);

        listViewItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            //переопределим для конкретного элемента
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item item = items.get(position); //на какой элемент нажали
                Intent intent = new Intent(getApplicationContext(), ItemDetailActivity.class);
                intent.putExtra("title", item.getTitle()); // передаем информацию о конкретной модели
                intent.putExtra("info", item.getInfo()); // передаем информацию о конкретной модели
                intent.putExtra("resId", item.getImageResourceId()); // передаем информацию о конкретной модели
                startActivity(intent);
            }
        });
    }
}