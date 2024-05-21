import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(OttRemitPlayInstallReferrerPlugin)
public class OttRemitPlayInstallReferrerPlugin: CAPPlugin, CAPBridgedPlugin {
    public let identifier = "OttRemitPlayInstallReferrerPlugin"
    public let jsName = "OttRemitPlayInstallReferrer"
    public let pluginMethods: [CAPPluginMethod] = [
    ]
    @objc override func methodThatRequiresAndroid(_ call: CAPPluginCall) {
        call.unimplemented("Not implemented on iOS.")
    }
}
