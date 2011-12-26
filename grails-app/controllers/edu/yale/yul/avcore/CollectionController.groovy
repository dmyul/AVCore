package edu.yale.yul.avcore

class CollectionController {

    static scaffold = Collection
    
    def cols = {
        [cols: Collection.findAll()]
    }
    
    def col = {
        [cols: Collection.get(params.id)]
    }
    
    def createNew = {
    }
    
    def commit = {
        def newCol = new Collection()
        newCol.title = params.title
        newCol.identifier = params.identifier
        newCol.source = params.source
        newCol.description = params.description
        newCol.save(flush:true, failOnError: true)
        
        redirect(action: cols)
    }
    
    def inventory = {
        def col = Collection.get(params.id);
        def cores = []
        def pIns = []
        
        col.docCore.each{
            cores.add(it)
        }
        
        cores.each{
            it.physInst.each{x->
                pIns.add(x)
            }
        }
        
        [col:col, pIns:pIns]
    }
}
