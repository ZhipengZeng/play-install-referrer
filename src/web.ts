import { WebPlugin } from '@capacitor/core';

import type { OttRemitPlayInstallReferrerPlugin } from './definitions';

export class OttRemitPlayInstallReferrerWeb
  extends WebPlugin
  implements OttRemitPlayInstallReferrerPlugin
{
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
