package com.chat.xteam.metalk.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.chat.xteam.metalk.R;

import java.util.ArrayList;
import java.util.List;


public class NewsFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    WebView webView;
    Spinner spinner;
    List<String> categories;
    ArrayAdapter<String> arrayAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_news, null, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        spinner = (Spinner) view.findViewById(R.id.spinner);
        categories = new ArrayList<>();

        categories.add("Kenh14");
        categories.add("Vnexpress");
        categories.add("DanTri");
        categories.add("24h");
        categories.add("BoTay");
        categories.add("XemVn");
        arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, categories);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        webView = (WebView) view.findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        webView.setWebViewClient(new WebViewClient());
        webSettings.setJavaScriptEnabled(true);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//        Toast.makeText(getContext(), "" + i, Toast.LENGTH_SHORT).show();
        switch (i) {
            case 0:

                webView.loadUrl("http://kenh14.vn/");

                break;
            case 1:
                webView.loadUrl("https://vnexpress.net/");
                break;
            case 2:
                webView.loadUrl("http://dantri.com.vn/");

                break;
            case 3:
                webView.loadUrl("http://www.24h.com.vn/");

                break;
            case 4:
                webView.loadUrl("https://botay.com/");

                break;
            case 5:
                webView.loadUrl("http://xem.vn/");
                break;
                default:
                    webView.loadUrl("http://kenh14.vn/");
                    break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}
