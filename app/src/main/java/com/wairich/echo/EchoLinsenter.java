package com.wairich.echo;

/**
 * Description:
 * Created by Czm on 2021/7/8 11:20.
 */
public interface EchoLinsenter {


    void onRequestPermissionSuccess(String[] requestPermissions, int requestCode);


    void onRequestPermissionRefuse(String[] requestPermissions, int requestCode);

}
