package com.mcs.assignment.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mcs.assignment.R;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Display power usage summary
 *
 * @author eranga herath(eranga.herath@pagero.com)
 */
public class Assignment6Fragment extends android.support.v4.app.Fragment implements View.OnClickListener {

    private TextView captureText;
    private RelativeLayout captureLayout;

    // use custom font here
    private Typeface typeface;

    private static final int REQUEST_IMAGE_CAPTURE = 1;

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

        typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/vegur_2.otf");
        initUi();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == getActivity().RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            saveImage(imageBitmap);
        }
    }

    /**
     * Initialize UI components
     */
    private void initUi() {
        captureText = (TextView) getActivity().findViewById(R.id.assignment6_capture_text);
        captureText.setTypeface(typeface, Typeface.BOLD);

        captureLayout = (RelativeLayout) getActivity().findViewById(R.id.assignment6_capture);
        captureLayout.setOnClickListener(this);
    }

    /**
     * Launch camera intent
     */
    private void launchCamera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    /**
     * Compress and save image in SD Card
     *
     * @param finalBitmap captured image
     */
    private void saveImage(Bitmap finalBitmap) {
        // create folder to save images
        String root = Environment.getExternalStorageDirectory().toString();
        File directory = new File(root + "/MCS3106");
        directory.mkdirs();

        // image name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = timeStamp + ".png";

        File file = new File(directory, imageFileName);
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void onClick(View v) {
        if (v == captureLayout) {
            // launch camera
            launchCamera();
        }
    }

}
