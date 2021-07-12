# Echo
权限申请

使用方法

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
                        
* create
当前activity
* request
请求权限(建议在使用需要权限功能前进行请求申请需要的权限组，不要一启动就申请好几个)
* requestCode
请求码，用于判断是那一次请求
* onRequestPermissionSuccess
授权成功回调
* onRequestPermissionRefuse
授权拒绝回调

