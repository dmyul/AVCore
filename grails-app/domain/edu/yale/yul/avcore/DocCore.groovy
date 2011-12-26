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
        rightsStatement(size:0..2147483646, nullable:true)
        assetType(nullable:true)
        assetDate(nullable:true)
        title(nullable:true)
        identifier(nullable:true)
        description(nullable:true)
        creator(nullable:true)
        creatorRole(nullable:true)
        relationshipIdentifier(nullable:true)
        relationshipType(nullable:true)
        publisher(nullable:true)
        publisherRole(nullable:true)
        contributor(nullable:true)
        contributorRole(nullable:true) 
    }
    
    static mapping = {
        rightsStatement type: 'text'
    }
    
    String toString(){
        return title
    }
}
