package edu.yale.yul.avcore

class Collection {
    String title
    String identifier
    String description
    String source
    String repository
    
    
    static hasMany = [docCore:DocCore]
    static constraints = {
        description(size:0..2147483646)
        
    }
    
    String toString(){
        return identifier + ": " + title
    }
    
    
}
