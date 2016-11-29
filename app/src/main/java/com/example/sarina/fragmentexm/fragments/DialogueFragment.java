package com.example.sarina.fragmentexm.fragments;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.example.sarina.fragmentexm.R;

/**
 * Created by Sarina on 11/28/2016.
 */



public class DialogueFragment extends DialogFragment {
Button btndig;
    EditText pass1;
    EditText pass2;
    EditText email;

    OnCompleteDismissListener mOnCompleteDismissListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
       // getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mOnCompleteDismissListener= (OnCompleteDismissListener) getActivity();
    }


    public void setmOnCompleteDismissListener(OnCompleteDismissListener mOnCompleteDismissListener){
        this.mOnCompleteDismissListener=mOnCompleteDismissListener;
    }

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frag_diag,container,false);
        pass1=(EditText)view.findViewById(R.id.etpass);
        pass2=(EditText)view.findViewById(R.id.etpasscon);
        email=(EditText)view.findViewById(R.id.email);
        btndig=(Button)view.findViewById(R.id.button);
        btndig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mOnCompleteDismissListener!=null){
                    mOnCompleteDismissListener.getText(email.getText().toString(),pass1.getText().toString());
                }
            }
        });


        String txtpass1     =  pass1.getText().toString();

        String txtpass2     =  pass2.getText().toString();

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);


    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        Dialog mDialog=super.onCreateDialog(savedInstanceState);
        mDialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return mDialog;
    }
}
