package in.rpso.oss.capacitorgpshardwareplugin;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "CapacitorGpsHardwarePlugin")
public class CapacitorGpsHardwarePluginPlugin extends Plugin {

    private CapacitorGpsHardwarePlugin implementation = new CapacitorGpsHardwarePlugin();

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }
}
