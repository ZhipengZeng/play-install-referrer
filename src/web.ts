import { WebPlugin } from '@capacitor/core';

import type { OttRemitPlayInstallReferrerPlugin } from './definitions';

export class OttRemitPlayInstallReferrerWeb
  extends WebPlugin
  implements OttRemitPlayInstallReferrerPlugin {
  getReferrerDetails(): Promise<{ referrerUrl: string; appVersion: string; referrerClickTime: string; appInstallTime: string; instantExperienceLaunched: boolean; }> {
    throw new Error('Method not implemented.');
  }
}
