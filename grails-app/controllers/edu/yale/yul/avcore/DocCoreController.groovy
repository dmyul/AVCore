package edu.yale.yul.avcore

import grails.converters.XML

class DocCoreController {

    static scaffold = DocCore
    
    def core = {
        [core: DocCore.get(params.id)]
    }
    
    def coreLab = {
        [core: DocCore.get(params.id)]
    }
    
    def createCore = {
        
        def col = Collection.get(params.colId)
        def asType = PBCoreVocab.findAllByType("AssetType")
        def cRole = PBCoreVocab.findAllByType("CreatorRole")
        def pRole = PBCoreVocab.findAllByType("PublisherRole")
        def vocab = [asType, cRole, pRole]
        [col:col, vocab:vocab]
    }
    
    def deleteCore = {
        def delCore = DocCore.get(params.id)
        def coll = delCore.getCollection().id
        delCore.delete()
        redirect(controller: "collection", action: "col", id: coll) 
        /*
        def delCore = DocCore.get(params.id)
        def col = delCore.getCollection()
        delCore.delete()
        redirect(controller: collection, action: col, id: col.id)
        */
    }
    
    def commit = {
        def creator = new Person()
        creator.name = params.creatorName
        creator.save(flush: true, failOnError: true)
        
        def corePerson = new CorePerson()
        corePerson.person = creator
        corePerson.type = "creator"
        corePerson.role = params.creatorRole
        corePerson.save(flush: true, failOnError: true)
        
        
        
        def col = Collection.get(params.colId)
        def newCore = new DocCore(params)
        newCore.setCollection(col)
        newCore.creator = corePerson
        newCore.save(flush: true, failOnError: true);
        
        redirect (action: core, id: newCore.id)
      
    }
    
    
}
