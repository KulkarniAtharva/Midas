package dev.atharvakulkarni.midas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import dev.atharvakulkarni.midas.databinding.NiyojanBinding;
import dev.atharvakulkarni.midas.databinding.SuchnaBinding;

public class suchna extends Fragment
{
    SuchnaBinding suchnaBinding;
    TextView title;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        suchnaBinding = DataBindingUtil.inflate(inflater, R.layout.suchna, container, false);
        View view = suchnaBinding.getRoot();

        //title = homeBinding.title;




        return view;
    }
}
