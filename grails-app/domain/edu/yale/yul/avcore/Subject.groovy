package edu.yale.yul.avcore

class Subject {
    
    String type
    String source
    String subject
    
    String toString(){
        return type.toUpperCase() + " " + subject
    }
    

    static constraints = {
    }
}
