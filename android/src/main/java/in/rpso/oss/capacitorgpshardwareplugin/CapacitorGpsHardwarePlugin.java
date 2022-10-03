package in.rpso.oss.capacitorgpshardwareplugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CapacitorGpsHardwarePlugin  extends BroadcastReceiver {
    public static final String GPS_HARDWARE_STATUS_CHANGE_EVENT_NAME = "gpsHardwareChange";

    interface GpsHardwareStatusChangeListener {
        void onGpsHardwareStatusStatusChanged(boolean status);
    }

    @Nullable
    private GpsHardwareStatusChangeListener statusChangeListener;

    public void setStatusChangeListener(@Nullable GpsHardwareStatusChangeListener listener) {
        this.statusChangeListener = listener;
    }
    public  CapacitorGpsHardwarePlugin(){
        new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
            }
            @Override
            public void onLocationChanged(@NonNull List<Location> locations) {
                LocationListener.super.onLocationChanged(locations);
            }
            @Override
            public void onFlushComplete(int requestCode) {
                LocationListener.super.onFlushComplete(requestCode);
            }
            @Override
            public void onProviderEnabled(@NonNull String provider) {
                LocationListener.super.onProviderEnabled(provider);
                statusChangeListener.onGpsHardwareStatusStatusChanged(true);
            }
            @Override
            public void onProviderDisabled(@NonNull String provider) {
                LocationListener.super.onProviderDisabled(provider);
                statusChangeListener.onGpsHardwareStatusStatusChanged(false);
            }
        };
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().matches("android.location.PROVIDERS_CHANGED"))
        {
            System.out.println("asdahsid0asdiasdiojaopsdji");
        }
    }

    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }
}
