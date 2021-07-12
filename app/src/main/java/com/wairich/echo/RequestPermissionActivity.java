package com.wairich.echo;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class RequestPermissionActivity extends AppCompatActivity {

    private static final String TAG = "RequestPermisstionActiv";
    public static int mRequestPermissionCode = 0xFE;
    private static EchoLinsenter mEchoLinsenter;
    private static String[] mRequestPermission;

    public static void setEchoLinsenter(Activity ac, String[] requestPermission, EchoLinsenter echoLinsenter, int requestPermissionCode) {
        mRequestPermission = requestPermission;
        mEchoLinsenter = echoLinsenter;
        if (requestPermissionCode != -1) {
            mRequestPermissionCode = requestPermissionCode;
        }
        Intent intent = new Intent(ac, RequestPermissionActivity.class);
        ac.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //使用兼容库就无需判断系统版本
        int hasWriteStoragePermission = ContextCompat.checkSelfPermission(getApplication(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (hasWriteStoragePermission == PackageManager.PERMISSION_GRANTED) {
            //拥有权限，执行操作
            if (mEchoLinsenter != null) {
                mEchoLinsenter.onRequestPermissionSuccess(mRequestPermission, mRequestPermissionCode);
            }
            finish();
        } else {
            //没有权限，向用户请求权限
            ActivityCompat.requestPermissions(this, mRequestPermission, mRequestPermissionCode);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        //通过requestCode来识别是否同一个请求
        if (requestCode == mRequestPermissionCode) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //用户同意，执行操作
                if (mEchoLinsenter != null) {
                    mEchoLinsenter.onRequestPermissionSuccess(permissions, requestCode);
                }
            } else {
                //用户不同意，向用户展示该权限作用
                if (mEchoLinsenter != null) {
                    mEchoLinsenter.onRequestPermissionRefuse(permissions, requestCode);
                }
                Log.d(TAG, "onRequestPermissionsResult: " + grantResults.toString());
            }
        }
        finish();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }
}
