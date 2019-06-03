import Foundation



guard let n = Int((readLine()?.trimmingCharacters(in: .whitespacesAndNewlines))!)
    else { fatalError("Bad input") }

let binaryStr = String(n, radix: 2)
let arrayBinary = binaryStr.components(separatedBy: "0")

var max = 0
for split in arrayBinary{
    if split.count > max {
        max = split.count
    }
}

print(max)
