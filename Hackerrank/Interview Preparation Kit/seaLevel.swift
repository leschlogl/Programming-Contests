import Foundation

// Complete the countingValleys function below.
func countingValleys(n: Int, s: String) -> Int {
    var seaLevel = 0
    var numberOfValleys = 0
    var isInsideValley = false

    //basically check the "line" of sea level to detect if is valley or not
    for c in s {
        if c == "U" {
            seaLevel += 1
        } else {
            seaLevel -= 1
        }
        
        if seaLevel < 0 {
            isInsideValley = true
        }
        
        if seaLevel == 0 && isInsideValley {
            isInsideValley = false
            numberOfValleys += 1
        }
    }
    return numberOfValleys
}

let stdout = ProcessInfo.processInfo.environment["OUTPUT_PATH"]!
FileManager.default.createFile(atPath: stdout, contents: nil, attributes: nil)
let fileHandle = FileHandle(forWritingAtPath: stdout)!

guard let n = Int((readLine()?.trimmingCharacters(in: .whitespacesAndNewlines))!)
    else { fatalError("Bad input") }

guard let s = readLine() else { fatalError("Bad input") }

let result = countingValleys(n: n, s: s)

fileHandle.write(String(result).data(using: .utf8)!)
fileHandle.write("\n".data(using: .utf8)!)
