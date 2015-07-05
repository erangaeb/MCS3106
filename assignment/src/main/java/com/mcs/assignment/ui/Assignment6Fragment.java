package com.mcs.assignment.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.maps.model.TileOverlay;
import com.mcs.assignment.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Display power usage summary
 *
 * @author eranga herath(eranga.herath@pagero.com)
 */
public class Assignment6Fragment extends android.support.v4.app.Fragment implements View.OnClickListener {

    RelativeLayout launchCameraLayout;

    // use custom font here
    private Typeface typeface;

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int REQUEST_FILE_CHOOSER = 2;

    /**
     * {@inheritDoc}
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.layout_assignment6, container, false);

        return root;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initUi();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == getActivity().RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            saveIamge(imageBitmap);
        } else if (requestCode == REQUEST_FILE_CHOOSER) {
            String Fpath = data.getData().getPath();

            try {
                File file = new File(Fpath);
                System.out.println(Fpath);
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while ((line = br.readLine()) != null) {
                    //Log.i("Test", "text : " + text + " : end");
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void initUi() {
        typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/vegur_2.otf");

        launchCameraLayout = (RelativeLayout) getActivity().findViewById(R.id.assignment1_camera);
        launchCameraLayout.setOnClickListener(this);
    }

    private void launchCamera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    private void saveIamge(Bitmap finalBitmap) {
        // create folder to save images
        String root = Environment.getExternalStorageDirectory().toString();
        File myDir = new File(root + "/MCS3106");
        myDir.mkdirs();

        // image name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = timeStamp + ".png";

        File file = new File (myDir, imageFileName);
        if (file.exists()) file.delete();
        try {
            FileOutputStream out = new FileOutputStream(file);
            finalBitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.flush();
            out.close();
            Toast.makeText(this.getActivity(), "Successfully saved image", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this.getActivity(), "Failed to saved image", Toast.LENGTH_LONG).show();
        }
    }

    public void openFolder() {
        Intent i = new Intent(Intent.ACTION_GET_CONTENT);
        i.setType("*/*");
        startActivityForResult(i, REQUEST_FILE_CHOOSER);
    }

    @Override
    public void onClick(View v) {
        if (v == launchCameraLayout) {
            // launch camera
            launchCamera();
        }
    }

}
