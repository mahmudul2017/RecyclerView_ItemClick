package gorental.com.day13ext2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView.LayoutManager layoutManager;
    List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpdataList();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerAdapter adapter = new RecyclerAdapter(this, list);
        recyclerView.setAdapter(adapter);
        }

    private void setUpdataList() {
        for (int i=0; i<10; i++){
            list.add("Item " +i);
        }
    }
}
