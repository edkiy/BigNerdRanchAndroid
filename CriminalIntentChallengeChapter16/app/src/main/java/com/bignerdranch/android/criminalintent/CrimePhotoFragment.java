package com.bignerdranch.android.criminalintent;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by kyle.roe on 06/06/16.
 */
public class CrimePhotoFragment extends DialogFragment {

    private static final String ARG_PHOTO = "arg_photo";

    public static final String EXTRA_PHOTO = "com.bignerdranch.android.criminalintent.photo";

    private ImageView mImageView;

    public static CrimePhotoFragment newInstance(String bitmap) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_PHOTO, bitmap);

        CrimePhotoFragment fragment = new CrimePhotoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_crime_photo, null);

        mImageView = (ImageView) view.findViewById(R.id.crime_photo);

        final String photoFilePath = (String) getArguments().getSerializable(ARG_PHOTO);

        Bitmap bitmap = PictureUtils.getScaledBitmap(photoFilePath, getActivity());
        //mImageView.setImageBitmap(bitmap);

        return new AlertDialog.Builder(getActivity())
                .setView(view)
                .setTitle(R.string.crime_photo_title)
                .setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                sendResult(Activity.RESULT_OK);
                            }
                        })
                .create();
    }

    private void sendResult(int resultCode) {
        if (getTargetFragment() == null) {
            return;
        }

        Intent intent = new Intent();
        //intent.putExtra(EXTRA_PHOTO);
        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, intent);
    }
}
