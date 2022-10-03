package in.rpso.oss.capacitorgpshardwareplugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.location.GpsStatus;
import android.location.LocationManager;
import android.os.Build;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "CapacitorGpsHardwarePlugin")
public class CapacitorGpsHardwarePluginPlugin extends Plugin {

    private CapacitorGpsHardwarePlugin implementation = new CapacitorGpsHardwarePlugin();

    @Override
    public void load() {
        LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        try {
            if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.N) {
                locationManager.addGpsStatusListener(event -> {
                    System.out.println(event);
                });
            } else {
                locationManager.registerGnssStatusCallback(command -> {
                    System.out.println(command);
                });
            }
        } catch (SecurityException s) {

        }
        CapacitorGpsHardwarePlugin.GpsHardwareStatusChangeListener changeListener = status -> {
            JSObject ret = new JSObject();
            ret.put("enabled", status);
            notifyListeners(CapacitorGpsHardwarePlugin.GPS_HARDWARE_STATUS_CHANGE_EVENT_NAME, ret);
        };
        implementation.setStatusChangeListener(changeListener);
    }

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }

    @PluginMethod
    public void GetGpsHardwareStatus(PluginCall call) {
        LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        boolean value = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        JSObject ret = new JSObject();
        ret.put("enabled", value);
        call.resolve(ret);
    }

    @PluginMethod(returnType = PluginMethod.RETURN_CALLBACK)
    public void addListner(PluginCall call) {
    }
}
