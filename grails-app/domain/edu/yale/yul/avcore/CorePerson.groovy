package edu.yale.yul.avcore

class CorePerson {
    
    Person person
    String type
    String role

    static constraints = {
    }
    
    String toString() {
        return (person.toString() + " [" + role + "]")
    }
}
