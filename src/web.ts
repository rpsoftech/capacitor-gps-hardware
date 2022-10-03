// eslint-disable-next-line @typescript-eslint/consistent-type-imports
import { PluginListenerHandle, WebPlugin } from '@capacitor/core';

import type {
  CapacitorGpsHardwarePluginPlugin,
  GpsHardwareChangeListener,
} from './definitions';

export class CapacitorGpsHardwarePluginWeb
  extends WebPlugin
  implements CapacitorGpsHardwarePluginPlugin
{
  addListner(
    eventName: 'gpsHardwareChange',
    listenerFunc: GpsHardwareChangeListener,
  ): Promise<PluginListenerHandle> & PluginListenerHandle {
    console.log(eventName,listenerFunc);
    throw new Error('Method not implemented.');
  }
  GetGpsHardwareStatus(): Promise<{ enabled: boolean }> {
    throw new Error('Method not implemented.');
  }
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
