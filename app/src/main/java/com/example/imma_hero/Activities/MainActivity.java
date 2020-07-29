package com.example.imma_hero.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.imma_hero.Fragments.MainFragment;
import com.example.imma_hero.Fragments.PickPowerFragment;
import com.example.imma_hero.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragment_container);

        if( fragment == null){
            fragment = new MainFragment();
            manager.beginTransaction().add(R.id.fragment_container,fragment).commit();
        }
    }

    public void loadPickPowerScreen(){
        PickPowerFragment pickPowerFragment = new PickPowerFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,pickPowerFragment).addToBackStack(null).commit();
        //add to the back stack
    }
}