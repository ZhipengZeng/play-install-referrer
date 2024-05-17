import { registerPlugin } from '@capacitor/core';

import type { OttRemitPlayInstallReferrerPlugin } from './definitions';

const OttRemitPlayInstallReferrer =
  registerPlugin<OttRemitPlayInstallReferrerPlugin>(
    'OttRemitPlayInstallReferrer',
    {
      web: () =>
        import('./web').then(m => new m.OttRemitPlayInstallReferrerWeb()),
    },
  );

export * from './definitions';
export { OttRemitPlayInstallReferrer };
