import Foundation

// Complete the jumpingOnClouds function below.
func jumpingOnClouds(c: [Int]) -> Int {
    var numberOfJumps = 0
    var i = 0

    repeat {
        //can jump 2?
        //should jump2?
        //next 2 should be avoided?
        //Then: JUMP 2
        if i < c.count - 2 &&
            (c[i+2] == 0 ||
                (c[i+2] == 1 && c[i+1] == 1)
            ){
            i += 1
        }
        numberOfJumps += 1
        i += 1
    } while (i < c.count - 1)

    return numberOfJumps
}

let stdout = ProcessInfo.processInfo.environment["OUTPUT_PATH"]!
FileManager.default.createFile(atPath: stdout, contents: nil, attributes: nil)
let fileHandle = FileHandle(forWritingAtPath: stdout)!

guard let n = Int((readLine()?.trimmingCharacters(in: .whitespacesAndNewlines))!)
    else { fatalError("Bad input") }

guard let cTemp = readLine() else { fatalError("Bad input") }
let c: [Int] = cTemp.split(separator: " ").map {
    if let cItem = Int($0.trimmingCharacters(in: .whitespacesAndNewlines)) {
        return cItem
    } else { fatalError("Bad input") }
}

guard c.count == n else { fatalError("Bad input") }

let result = jumpingOnClouds(c: c)

fileHandle.write(String(result).data(using: .utf8)!)
fileHandle.write("\n".data(using: .utf8)!)
