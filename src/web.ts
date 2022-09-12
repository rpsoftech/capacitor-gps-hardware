import { WebPlugin } from '@capacitor/core';

import type { CapacitorGpsHardwarePluginPlugin } from './definitions';

export class CapacitorGpsHardwarePluginWeb extends WebPlugin implements CapacitorGpsHardwarePluginPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
