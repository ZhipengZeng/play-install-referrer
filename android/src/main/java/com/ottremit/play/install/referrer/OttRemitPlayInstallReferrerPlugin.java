package com.ottremit.play.install.referrer;

import android.os.RemoteException;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "OttRemitPlayInstallReferrer")
public class OttRemitPlayInstallReferrerPlugin extends Plugin {

    // Caution: The install referrer information will be available for 90 days and won't change unless the application is reinstalled.
    // To avoid unnecessary API calls in your app, you should invoke the API only once during the first execution after install.

    @PluginMethod
    public void getReferrerDetails(PluginCall call) {
        InstallReferrerClient referrerClient = InstallReferrerClient
                .newBuilder(getContext())
                .build();
        referrerClient.startConnection(new InstallReferrerStateListener() {
            @Override
            public void onInstallReferrerSetupFinished(int responseCode) {
                switch (responseCode) {
                    case InstallReferrerClient.InstallReferrerResponse.OK:
                        try {
                            ReferrerDetails response = referrerClient.getInstallReferrer();
                            String referrerUrl = response.getInstallReferrer();
                            long referrerClickTime = response.getReferrerClickTimestampSeconds();
                            long appInstallTime = response.getInstallBeginTimestampSeconds();
                            boolean instantExperienceLaunched = response.getGooglePlayInstantParam();
                            String appVersion = response.getInstallVersion();
                            JSObject ret = new JSObject();
                            ret.put("referrerUrl", referrerUrl);
                            ret.put("appVersion", appVersion);
                            ret.put("referrerClickTime", referrerClickTime);
                            ret.put("appInstallTime", appInstallTime);
                            ret.put("instantExperienceLaunched", instantExperienceLaunched);
                            call.resolve(ret);
                        } catch (RemoteException e) {
                            call.reject("Cannot get ReferrerDetails");
                        }
                        break;
                    case InstallReferrerClient.InstallReferrerResponse.FEATURE_NOT_SUPPORTED:
                        call.reject("FEATURE_NOT_SUPPORTED");
                        break;
                    case InstallReferrerClient.InstallReferrerResponse.SERVICE_UNAVAILABLE:
                        call.reject("SERVICE_UNAVAILABLE");
                        break;
                }
                referrerClient.endConnection();
            }

            @Override
            public void onInstallReferrerServiceDisconnected() {
                // Try to restart the connection on the next request to
                // Google Play by calling the startConnection() method.
            }
        });
    }
}
