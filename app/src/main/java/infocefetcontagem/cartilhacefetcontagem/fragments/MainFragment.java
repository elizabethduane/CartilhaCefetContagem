package infocefetcontagem.cartilhacefetcontagem.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.Arrays;

import infocefetcontagem.cartilhacefetcontagem.R;
import infocefetcontagem.cartilhacefetcontagem.models.Sector;
import infocefetcontagem.cartilhacefetcontagem.models.AppData;

import static android.os.Build.VERSION_CODES.M;

public class MainFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        Window window = this.getActivity().getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.primaryDarkColor));

        if (Build.VERSION.SDK_INT >= M) {
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);//  set status text dark
        }



        ImageView icon_facebook = (ImageView) view.findViewById(R.id.icon_facebook);
        ImageView icon_instagram = (ImageView) view.findViewById(R.id.icon_instagram);
        ImageView icon_twitter= (ImageView) view.findViewById(R.id.icon_twitter);
        ImageView icon_linkedin = (ImageView) view.findViewById(R.id.icon_linkedin);

        icon_facebook.setClickable(true);
        icon_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickSocial(view);
            }
        });

        icon_twitter.setClickable(true);
        icon_twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickSocial(view);
            }
        });

        icon_instagram.setClickable(true);
        icon_instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickSocial(view);
            }
        });

        icon_linkedin.setClickable(true);
        icon_linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickSocial(view);
            }
        });

        return view;

    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.menu_search,menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
        SearchView searchView =  (SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

             ///   adapter.filterData(newText);
               // expandAll();
                return false;
            }
        });
    }

    public void onClickSocial(View view){

        String url = "www.cefetmg.br";

        switch (view.getId()){
            case R.id.icon_facebook:
                url = "https://www.facebook.com/cefetmgcontagem/?fref=ts";
                break;
            case R.id.icon_instagram:
                url = "https://www.instagram.com/cefetmg_contagem/";
                break;
            case R.id.icon_linkedin:
                url = "https://www.linkedin.com/edu/school?id=10506&trk=prof-following-school-logo";
                break;
            case R.id.icon_twitter:
                url = "https://twitter.com/cefet_mg";
                break;
        }

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

}