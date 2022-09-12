import { registerPlugin } from '@capacitor/core';

import type { CapacitorGpsHardwarePluginPlugin } from './definitions';

const CapacitorGpsHardwarePlugin = registerPlugin<CapacitorGpsHardwarePluginPlugin>('CapacitorGpsHardwarePlugin', {
  web: () => import('./web').then(m => new m.CapacitorGpsHardwarePluginWeb()),
});

export * from './definitions';
export { CapacitorGpsHardwarePlugin };
