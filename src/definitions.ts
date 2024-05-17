export interface OttRemitPlayInstallReferrerPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
