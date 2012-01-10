package edu.yale.yul.avcore

class PBCoreVocabController {
    
    def index = {
    def scaffold = PBCoreVocab
    }
    
    def admin = {
        def list = new HashSet<String>();
        PBCoreVocab.getAll().each{
            list.add(it.type)
        }
        
        [list: list]
    }
    
    def viewList = {
        def type = params.id
        def concepts = PBCoreVocab.findAllByType(type)
        
        [type:type, concepts:concepts]
        
    }
    
    def add = {
        def concept = new PBCoreVocab(params)
        concept.save(flush: true, failOnError: true)
        flash.message = "Concept '" + params.concept + "' added to " + params.type + " look-up list"
        redirect(action: viewList, id: params.type)
    }
    
    def remove = {
        def obj = PBCoreVocab.get(params.id)
        def concept = obj.concept
        def type = obj.type
        obj.delete()
        flash.message = "Concept '" + concept + "' removed from " + type + " look-up list"
        redirect(action: viewList, id: type)
    }
    
    def edit = {}
    
}
