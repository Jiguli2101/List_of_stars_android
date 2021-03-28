package id195652724.stars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemDetailActivity extends AppCompatActivity {

    private TextView textViewTitle;
    private TextView textViewInfo;
    private ImageView imageViewItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        textViewTitle = findViewById(R.id.textViewTitle);
        textViewInfo = findViewById(R.id.textViewInfo);
        imageViewItem = findViewById(R.id.imageViewItem);

        Intent intent = getIntent();

        // получаем данные через интент при условии если
        if (intent.hasExtra ("title") && intent.hasExtra ("info") && intent.hasExtra ("resId")) {
            String title = intent.getStringExtra("title");
            String info = intent.getStringExtra("info");
            int resId = intent.getIntExtra("resId", -1); // -1 - это знач. по умолчанию в случае отсутствия resId

            textViewTitle.setText(title);
            textViewInfo.setText(info);
            imageViewItem.setImageResource(resId);
        }else{
            Intent backToCategory = new Intent (this, ItemCategoryActivity.class);
            startActivity(backToCategory);
        }
    }
}