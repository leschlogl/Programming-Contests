import Foundation

// Complete the repeatedString function below.
func repeatedString(s: String, n: Int) -> Int {
    var occurrences = 0
    for c in s {
        if c == "a" {
            occurrences += 1
        }
    }
    occurrences *= n / s.count
    for i in 0..<(n%s.count) {
        if Array(s)[i] == "a" {
            occurrences += 1
        }
    }
    return occurrences
}

let stdout = ProcessInfo.processInfo.environment["OUTPUT_PATH"]!
FileManager.default.createFile(atPath: stdout, contents: nil, attributes: nil)
let fileHandle = FileHandle(forWritingAtPath: stdout)!

guard let s = readLine() else { fatalError("Bad input") }

guard let n = Int((readLine()?.trimmingCharacters(in: .whitespacesAndNewlines))!)
    else { fatalError("Bad input") }

let result = repeatedString(s: s, n: n)

fileHandle.write(String(result).data(using: .utf8)!)
fileHandle.write("\n".data(using: .utf8)!)
