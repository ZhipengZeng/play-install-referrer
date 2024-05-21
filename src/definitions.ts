export interface OttRemitPlayInstallReferrerPlugin {
  getReferrerDetails(): Promise<{ referrerUrl: string, appVersion: string, referrerClickTime: string, appInstallTime: string, instantExperienceLaunched: boolean }>;
}
