package com.banigeo.helloandroid.ui.webpage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.banigeo.helloandroid.databinding.FragmentSlideshowBinding;

public class WebPageFragment extends Fragment {

    private FragmentSlideshowBinding binding;

    private void goToDevSite() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://fmi.unibuc.ro/"));
        startActivity(intent);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        WebPageModel webPageModel =
                new ViewModelProvider(this).get(WebPageModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textSlideshow;
        webPageModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        goToDevSite();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}