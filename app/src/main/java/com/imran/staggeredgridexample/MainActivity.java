package com.imran.staggeredgridexample;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private StaggeredGridLayoutManager gaggeredGridLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        gaggeredGridLayoutManager = new StaggeredGridLayoutManager(3, 1);
        recyclerView.setLayoutManager(gaggeredGridLayoutManager);

        List<Model> gaggeredList = getListItemData();

        StaggeredAdapter rcAdapter = new StaggeredAdapter(MainActivity.this, gaggeredList);
        recyclerView.setAdapter(rcAdapter);
        recyclerView.addItemDecoration(new SpacesItemDecoration(
                getResources().getDimensionPixelSize(R.dimen.space)));
    }


    private List<Model> getListItemData(){
        List<Model> listViewItems = new ArrayList<Model>();
        listViewItems.add(new Model( "http://starsunfolded.1ygkv60km.netdna-cdn.com/wp-content/uploads/2015/01/Ravichandran-Ashwin.jpg"));
        listViewItems.add(new Model( "http://3.bp.blogspot.com/-dVugs6QddVU/U0dzC4xh9ZI/AAAAAAAAAhk/YX_MIZtJGyM/s1600/MS+Dhoni+Biography.jpg"));
        listViewItems.add(new Model( "http://p.imgci.com/db/PICTURES/CMS/161600/161699.2.jpg"));
        listViewItems.add(new Model( "https://raw.githubusercontent.com/nimran/StaggeredGridExample/master/images/yuvi.jpg"));
        listViewItems.add(new Model( "http://static.abplive.in/wp-content/uploads/sites/5/2016/10/06182729/virat-kohli.jpg"));
        listViewItems.add(new Model( "https://raw.githubusercontent.com/nimran/StaggeredGridExample/master/images/raina.jpg"));
        listViewItems.add(new Model( "http://starsunfolded.1ygkv60km.netdna-cdn.com/wp-content/uploads/2015/01/Rohit-Sharma1.jpg"));
        listViewItems.add(new Model( "http://specials-images.forbesimg.com/imageserve/b11aee7cce54b021e42b6e001a213c08/320x486.jpg"));
        listViewItems.add(new Model( "http://starsunfolded.1ygkv60km.netdna-cdn.com/wp-content/uploads/2015/01/Ajinkya-Rahane.jpeg"));




        return listViewItems;
    }
    private static class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private final int space;
        public SpacesItemDecoration(int space) {
            this.space = space;
        }
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                                   RecyclerView.State state) {
            outRect.bottom = 0;
            int pos = parent.getChildAdapterPosition(view);
            outRect.left = 0;
            outRect.right = 0;
            if (pos < 2)
                outRect.top = 0;
        }
    }
}
