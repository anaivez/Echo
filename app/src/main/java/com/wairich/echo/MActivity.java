package com.wairich.echo;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


/**
 * Description:
 * Created by Czm on 2021/7/8 11:52.
 */
public class MActivity extends AppCompatActivity {

    private static final String TAG = "MActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rq_activity);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                EchoPermission
                        .create(this)
                        .request(EchoPermission.CAMERA)
                        .Build(new EchoLinsenter() {
                            @Override
                            public void onRequestPermissionSuccess(String[] requestPermissions, int requestCode) {
                                Log.i(TAG, "onRequestPermissionSuccess: " + requestCode);
                            }

                            @Override
                            public void onRequestPermissionRefuse(String[] requestPermissions, int requestCode) {
                                Log.i(TAG, "onRequestPermissionRefuse: " + requestCode);
                            }
                        });
                break;
            case R.id.btn2:
                EchoPermission
                        .create(this)
                        .requestCode(529)
                        .request( Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        .Build(new EchoLinsenter() {
                            @Override
                            public void onRequestPermissionSuccess(String[] requestPermissions, int requestCode) {
                                Log.i(TAG, "onRequestPermissionSuccess: " + requestCode);
                            }

                            @Override
                            public void onRequestPermissionRefuse(String[] requestPermissions, int requestCode) {
                                Log.i(TAG, "onRequestPermissionRefuse: " + requestCode);
                            }
                        });
                break;
            case R.id.btn3:
                EchoPermission
                        .create(this)
                        .request(Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.ACCESS_COARSE_LOCATION)
                        .Build(new EchoLinsenter() {
                            @Override
                            public void onRequestPermissionSuccess(String[] requestPermissions, int requestCode) {
                                Log.i(TAG, "onRequestPermissionSuccess: " + requestCode);
                            }

                            @Override
                            public void onRequestPermissionRefuse(String[] requestPermissions, int requestCode) {
                                Log.i(TAG, "onRequestPermissionRefuse: " + requestCode);
                            }
                        });
                break;
            case R.id.btn4:
                break;
        }
    }


}
