// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "CapacitorPlayInstallReferrerLibrary",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "CapacitorPlayInstallReferrerLibrary",
            targets: ["OttRemitPlayInstallReferrerPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "OttRemitPlayInstallReferrerPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/OttRemitPlayInstallReferrerPlugin"),
        .testTarget(
            name: "OttRemitPlayInstallReferrerPluginTests",
            dependencies: ["OttRemitPlayInstallReferrerPlugin"],
            path: "ios/Tests/OttRemitPlayInstallReferrerPluginTests")
    ]
)