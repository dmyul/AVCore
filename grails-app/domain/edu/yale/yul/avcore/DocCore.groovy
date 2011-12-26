package edu.yale.yul.avcore

class DocCore {
    String assetType
    Date assetDate
    String title
    String identifier
    String description
    String creator
    String creatorRole
    String publisher
    String publisherRole
    String rightsStatement
    String relationshipIdentifier
    String relationshipType
    
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
