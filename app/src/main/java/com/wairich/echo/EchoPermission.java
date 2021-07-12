package com.wairich.echo;

import android.Manifest;
import android.app.Activity;

/**
 * Description:
 * Created by Czm on 2021/7/8 11:07.
 */
public class EchoPermission {

    //通讯录权限组
    public static String[] CONTACTS = new String[]{
            Manifest.permission.WRITE_CONTACTS,
            Manifest.permission.GET_ACCOUNTS,
            Manifest.permission.READ_CONTACTS};
    //通话权限组
    public static String[] PHONE = new String[]{
            Manifest.permission.READ_CALL_LOG,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.CALL_PHONE,
            Manifest.permission.WRITE_CALL_LOG,
            Manifest.permission.USE_SIP,
            Manifest.permission.PROCESS_OUTGOING_CALLS,
            Manifest.permission.ADD_VOICEMAIL};
    //日历、日程信息权限组
    public static String[] CALENDAR = new String[]{
            Manifest.permission.READ_CALENDAR,
            Manifest.permission.WRITE_CALENDAR};
    //摄像头权限组
    public static String[] CAMERA = new String[]{
            Manifest.permission.CAMERA};
    //身体传感器权限组
    public static String[] SENSORS = new String[]{
            Manifest.permission.BODY_SENSORS};
    //定位权限组
    public static String[] LOCATION = new String[]{
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION};
    //外部存储卡权限组
    public static String[] STORAGE = new String[]{
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};
    //录音权限组
    public static String[] MICROPHONE = new String[]{
            Manifest.permission.RECORD_AUDIO};
    //短信权限组
    public static String[] SMS = new String[]{
            Manifest.permission.READ_SMS,
            Manifest.permission.RECEIVE_WAP_PUSH,
            Manifest.permission.RECEIVE_MMS,
            Manifest.permission.RECEIVE_SMS,
            Manifest.permission.SEND_SMS};

    private static RequestPermission requestPermission;
    private static String[] permissionss;
    private static EchoPermission echoPermission;
    private static Activity ac;
    private static int requestPermissionCode;

    public static RequestPermission create(Activity activity) {
        if (requestPermission == null) {
            requestPermission = new RequestPermission();
        }
        requestPermissionCode = 0xFE;
        ac = activity;
        return requestPermission;
    }

    static class RequestPermission {
        public void Build(EchoLinsenter linsenter) {
            RequestPermissionActivity.setEchoLinsenter(ac, permissionss, linsenter, requestPermissionCode);
        }

        public RequestPermission requestCode(int requestCode) {
            requestPermissionCode = requestCode;
            return this;

        }

        public RequestPermission request(String... permissions) {
            permissionss = permissions;
            return this;
        }


    }

}
