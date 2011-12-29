package edu.yale.yul.avcore

class DocCore {
    //Intellectual Content
    String assetType
    Date assetDate
    String title
    String identifier
    String description
    String creator
    String creatorRole
    String relationshipIdentifier
    String relationshipType
    
    //Intellectual Property
    String publisher
    String publisherRole
    String rightsStatement
    String contributor
    String contributorRole 
    
    
    
    static belongsTo = [collection:Collection]
    
    static hasMany = [subject:Subject, physInst:PhysInst, digInst:DigInst, relation: Relation]
    
    static constraints = {
        rightsStatement(size:0..2147483646)

    }
    
    static mapping = {
        rightsStatement type: 'text'
    }
    
    String toString(){
        return title
    }
}
