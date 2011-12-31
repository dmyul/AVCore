package edu.yale.yul.avcore

import grails.converters.XML
import groovy.xml.MarkupBuilder

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
    
    def pbCore = {
        //get the core
        DocCore core = DocCore.get(params.id)
        //init writer and builder
        def writer = new StringWriter()
        def xml = new MarkupBuilder(writer)
        
        //build document
        xml.pbcoreCollection(
            xmlns:'http://www.pbcore.org/PBCore/PBCoreNamespace.html',
            collectionTitle: core.collection.title,
            collectionDescription: core.collection.description){
                pbcoreDescriptionDocument{
                    pbcoreAssetType(source: 'pbcoreAssetType', core.assetType)
                    pbcoreAssetDate(core.assetDate)
                    pbcoreIdentifier(source: core.collection.source, core.identifier)
                    pbcoreTitle(core.title)
                    pbcoreDescription(core.description)
                    pbCoreCreator{
                        creator(source: 'pbCoreCreatorRole', core.creator.person.name)
                        creatorRole(core.creator.role)
                    }
                }
        }
        
        //render document to screen
        render writer.toString()
        
        
    }
    
    
}
