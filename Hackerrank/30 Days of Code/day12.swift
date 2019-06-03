

// Class Student
class Student: Person {
    var testScores: [Int]
    /*
     *   Initializer
     *
     *   Parameters:
     *   firstName - A string denoting the Person's first name.
     *   lastName - A string denoting the Person's last name.
     *   id - An integer denoting the Person's ID number.
     *   scores - An array of integers denoting the Person's test scores.
     */
    // Write your initializer here
    init(firstName: String, lastName: String, id: Int, scores:[Int]) {
        self.testScores = scores
        super.init(firstName: firstName, lastName: lastName, id: id)
    }
    /*
     *   Method Name: calculate
     *   Return: A character denoting the grade.
     */
    // Write your method here
    func calculate() -> Character {
        let sum = testScores.reduce(0, +)
        let avg = sum / testScores.count
        switch (avg) {
        case 0..<40:
            return "T"
        case 40..<55:
            return "D"
        case 55..<70:
            return "P"
        case 70..<80:
            return "A"
        case 80..<90:
            return "E"
        case 90..<101:
            return "O"
        default:
            return "T"
        }
    }
} // End of class Student


