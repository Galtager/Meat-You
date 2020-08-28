package com.example.meatyouapp.ui.slideshow;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.meatyouapp.R;
import com.shashank.sony.fancyaboutpagelib.FancyAboutPage;

import java.util.Calendar;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;


public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        FancyAboutPage fancyAboutPage=root.findViewById(R.id.fancyaboutpage);
//        fancyAboutPage.setCoverTintColor(Color.BLUE);  //Optional
        fancyAboutPage.setCover(R.drawable.developer_backgrownd); //Pass your cover image
        fancyAboutPage.setName(getString(R.string.myname));
        fancyAboutPage.setDescription(getString(R.string.about_me));
        fancyAboutPage.setAppIcon(R.mipmap.ic_launcher); //Pass your app icon image
        fancyAboutPage.setAppName(getString(R.string.meat_you_app));
        fancyAboutPage.setVersionNameAsAppSubTitle("1.0.0");
        fancyAboutPage.setAppDescription(getString(R.string.app_description)
                +getString(R.string.app_description2)
                +getString(R.string.app_description2)
                +getString(R.string.app_description3)
                +getString(R.string.slogan));
        fancyAboutPage.addEmailLink("galtager@gmail.com");
        fancyAboutPage.addFacebookLink("https://www.facebook.com/gal.tager");
        fancyAboutPage.addGitHubLink("https://github.com/Galtager");
        fancyAboutPage.addTwitterLink("https://twitter.com/");
        return root;
    }
}