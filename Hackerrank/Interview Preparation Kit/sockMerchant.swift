import Foundation

// Complete the sockMerchant function below.
func sockMerchant(n: Int, ar: [Int]) -> Int {
    var pairsOfSocks = 0
    var dictOfNumbers:[Int:Int] = [:]
    for number in ar {
        if dictOfNumbers[number] == nil {
            dictOfNumbers[number] = 1
            continue
        }
        dictOfNumbers[number] = (dictOfNumbers[number])! + 1
    }
    
    for (_, qty) in dictOfNumbers {
        pairsOfSocks += qty / 2 //it will return an int, no need to check the resst
    }
    return pairsOfSocks
}

let stdout = ProcessInfo.processInfo.environment["OUTPUT_PATH"]!
FileManager.default.createFile(atPath: stdout, contents: nil, attributes: nil)
let fileHandle = FileHandle(forWritingAtPath: stdout)!

guard let n = Int((readLine()?.trimmingCharacters(in: .whitespacesAndNewlines))!)
    else { fatalError("Bad input") }

guard let arTemp = readLine() else { fatalError("Bad input") }
let ar: [Int] = arTemp.split(separator: " ").map {
    if let arItem = Int($0.trimmingCharacters(in: .whitespacesAndNewlines)) {
        return arItem
    } else { fatalError("Bad input") }
}

guard ar.count == n else { fatalError("Bad input") }

let result = sockMerchant(n: n, ar: ar)

fileHandle.write(String(result).data(using: .utf8)!)
fileHandle.write("\n".data(using: .utf8)!)
