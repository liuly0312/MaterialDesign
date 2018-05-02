package robot.boocax.com.materialdesign;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private int count;

    private Fruits[] fruits = {new Fruits("Apple", R.mipmap.apple), new Fruits("Banana", R.mipmap.banana),
            new Fruits("Orange", R.mipmap.orange), new Fruits("Watermelon", R.mipmap.watermelon),
            new Fruits("Pear", R.mipmap.pear), new Fruits("Grape", R.mipmap.grape),
            new Fruits("Pineapple", R.mipmap.pineapple), new Fruits("Strawberry", R.mipmap.strawberry),
            new Fruits("Cherry", R.mipmap.cherry), new Fruits("Mango", R.mipmap.mango)};

    private List<Fruits> fruitList = new ArrayList<>();

    private FruitAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        ActionBar actionBar = getSupportActionBar();
        if (null != actionBar) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_menu);

        }

        NavigationView navigationView = findViewById(R.id.nav_view);//获取navigationview实例
        navigationView.setCheckedItem(R.id.nav_call);//将call菜单设置为默认选中
        //设置菜单项选中事件的监听器.
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_call:
                        Log.i("navigationView", "nav_call");
                        break;
                    case R.id.nav_friends:
                        Log.i("navigationView", "nav_friends");
                        break;
                    case R.id.nav_location:
                        Log.i("navigationView", "nav_location");
                        break;
                    case R.id.nav_mail:
                        Log.i("navigationView", "nav_mail");
                        break;
                    case R.id.nav_task:
                        Log.i("navigationView", "nav_task");
                        break;
                }
                return true;
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "this is fab", Toast.LENGTH_LONG).show();
                count = 1;
                Log.i("SnackBar", "count=" + count);
                Snackbar.make(v, "Data delete", Snackbar.LENGTH_LONG)
                        .setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "Data restored", Toast.LENGTH_LONG).show();
                                count = 0;
                                Log.i("SnackBar", "count=" + count);
                            }
                        }).show();
            }
        });

        initFruits();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(Gravity.START);
                break;
            case R.id.backup:
                Toast.makeText(this, "You clicked Backup", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(this, "You clicked Delete", Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings:
                Toast.makeText(this, "You clicked Settings", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }


    private void initFruits() {
        fruitList.clear();
        for (int i = 0; i < 50; i++) {
            Random random = new Random();
            int index = random.nextInt(fruits.length);
            fruitList.add(fruits[index]);
        }
    }
}
