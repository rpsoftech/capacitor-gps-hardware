// eslint-disable-next-line @typescript-eslint/consistent-type-imports
import { PluginListenerHandle } from "@capacitor/core";

export interface CapacitorGpsHardwarePluginPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  GetGpsHardwareStatus():Promise<GpsHardwareStatus>
  addListner(eventName: 'gpsHardwareChange', listenerFunc:GpsHardwareChangeListener): Promise<PluginListenerHandle> & PluginListenerHandle;
}
export declare type GpsHardwareChangeListener = (status:GpsHardwareStatus ) => void;
export interface GpsHardwareStatus{enabled:boolean} 