export interface CapacitorGpsHardwarePluginPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
