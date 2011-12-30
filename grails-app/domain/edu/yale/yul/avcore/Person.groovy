package edu.yale.yul.avcore

class Person {
    String name
    String source
    String url
    
    static belongsTo = [corePerson: CorePerson]
    static constraints = {
        corePerson(nullable: true)
        source(nullable: true)
        url(nullable: true)
    }
    
    String toString(){
        return name
    }
}
