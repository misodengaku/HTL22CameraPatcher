package com.misodengaku.lgl22camerapatcher.app;

/**
 * Created by misod_000 on 2014/06/18.
 */

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class LGL22CameraPatcher implements IXposedHookLoadPackage {

    private static final String PACKAGE_ESF = "com.lge.camera";


    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (!lpparam.packageName.equals(PACKAGE_ESF))
            return;

        findAndHookMethod("com.lge.camera.properties.ShutterSoundProperties", lpparam.classLoader, "setShutterSound",  XC_MethodReplacement.returnConstant(false));
        XposedBridge.log("setShutterSound hooked.");
    }

}
