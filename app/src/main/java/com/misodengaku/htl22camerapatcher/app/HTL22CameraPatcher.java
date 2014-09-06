package com.misodengaku.htl22camerapatcher.app;

/**
 * Created by misod_000 on 2014/06/18.
 */

import android.os.Build;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class HTL22CameraPatcher implements IXposedHookLoadPackage {

    private static final String PACKAGE_ESF = "com.android.camera";


    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (!lpparam.packageName.equals(PACKAGE_ESF))
            return;
        XposedBridge.log("HTL22CameraPatcher");
        XposedBridge.log("Model: " + Build.MODEL);
        findAndHookMethod("com.android.camera.CameraThread", lpparam.classLoader, "isShutterSoundNeeded",  XC_MethodReplacement.returnConstant(false));
        XposedBridge.log("isShutterSoundNeeded");
        
    }

}
