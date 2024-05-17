package com.ottremit.play.install.referrer;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "OttRemitPlayInstallReferrer")
public class OttRemitPlayInstallReferrerPlugin extends Plugin {

    private OttRemitPlayInstallReferrer implementation = new OttRemitPlayInstallReferrer();

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }
}
