package edu.yale.yul.avcore

class DocCore {
    //Intellectual Content
    String assetType
    Date assetDate
    String title
    String identifier
    String description
    CorePerson creator
    String rightsStatement

    static belongsTo = [collection:Collection]
    
    static hasMany = [subject:Subject, physInst:PhysInst, digInst:DigInst, relation: Relation, people: CorePerson]
    
    static constraints = {
        rightsStatement(nullable: true, size:0..2147483646)
        identifier(nullable: true)

    }
    
    static mapping = {
        rightsStatement(type: 'text')
        
    }
    
    String toString(){
        return title
    }
}
