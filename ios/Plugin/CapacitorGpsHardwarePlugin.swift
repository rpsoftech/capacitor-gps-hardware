import Foundation

@objc public class CapacitorGpsHardwarePlugin: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
