package com.example.dialogfragmentactivity;

import android.content.Context;
import android.os.Bundle;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class MyCustomDialog extends DialogFragment {

    private static final String TAG = "MyCustomDialog";
    public interface OnInputListener{
        void sendInput(String input);
    }
    public OnInputListener mOnInputListener;
    private  EditText  mInput;
    private TextView mActionOk, mActionCancel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_mycustom,container , false);
        mActionOk = view.findViewById(R.id.dialogtextOk);
        mActionCancel=view.findViewById(R.id.dialogTextCancel);
        mInput=view.findViewById(R.id.dialogText);

        mActionCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"onClick closing dialog");
                getDialog().dismiss();
            }
        });
        mActionOk .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.d(TAG,"OnClick: Capturing input");
//
              String input = mInput.getText().toString();
//                if(!input.equals("")){
//                    //Easiest  way
//                    ((MainActivity)getActivity()).mInputDisplay.setText((input));
//                }
//                getDialog().dismiss();

               //Best practice.Creating an inteface OnInputListener.

                mOnInputListener.sendInput(input);
                getDialog().dismiss();
            }
        });
        return view;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        mOnInputListener = (OnInputListener) getActivity();
    }
}
