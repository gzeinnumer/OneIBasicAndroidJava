package com.gzeinnumer.oneibasicandroidjava.day2;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.gzeinnumer.oneibasicandroidjava.databinding.ActivityDay2Binding;
import com.gzeinnumer.oneibasicandroidjava.day2.sample.SampleFragmentActivity;

public class Day2Activity extends AppCompatActivity {

    private ActivityDay2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDay2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle(getClass().getSimpleName());

        initOnClick();
    }

    private void initOnClick() {
        binding.btnPermission.setOnClickListener(view -> {
            requestPermissionCamera();
        });
        binding.btnActionView.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://www.github.com/gzeinnumer"));
            startActivity(i);
        });
        binding.btnActionCall.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_DIAL);
            i.setData(Uri.parse("tel:123456789"));
            startActivity(i);
        });
        binding.btnActionSentTo.setOnClickListener(view -> {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
            emailIntent.setData(Uri.parse("mailto:m.fadli.zein.17@gmail.com"));
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        });
        binding.btnFragment.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), SampleFragmentActivity.class);
            startActivity(intent);
        });
    }

    private ActivityResultLauncher<String> requestPermissionLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
                Toast.makeText(this, isGranted + "", Toast.LENGTH_SHORT).show();
            });

    private void requestPermissionCamera() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Granted", Toast.LENGTH_SHORT).show();
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Need Camera Permission!");
                builder.setMessage("To continue using this application, CAMERA permissin must be granted");
                builder.setPositiveButton("Grant Permission", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        requestPermissionLauncher.launch(Manifest.permission.CAMERA);
                    }
                });
                builder.setNegativeButton("No Thanks", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create();
                builder.show();

            } else {
                requestPermissionLauncher.launch(Manifest.permission.CAMERA);
            }
        }
    }

}