package edu.yale.yul.avcore

import grails.converters.XML

class PhysInstController {

    def scaffold = PhysInst
    
    def instance = {
        [ins: PhysInst.get(params.id)]
    }
    
    def createSoundPhysInstance = {
        def core = DocCore.get(params.id)
        def dType = PBCoreVocab.findAllByType("DateType")
        def pIns = PBCoreVocab.findAllByType("PhysicalInstance")
        [core:core, dType:dType, pIns: pIns]
    }
    
    
    def createMovingImagePhysInstance = {
        def core = DocCore.get(params.id)
        def dType = PBCoreVocab.findAllByType("DateType")
        def pIns = PBCoreVocab.findAllByType("PhysicalInstance")
        [core:core, dType:dType, pIns: pIns]
    }
    
    def commitInst = {
        def core = DocCore.get(params.core)
        def newPI = new PhysInst(params)
        newPI.setDocCore(core)
        newPI.save(flush: true, failOnError: true)
        flash.message = "New Instance created"
        
        if(newPI.mediaType.equals('Sound'))
            redirect (action: soundInstance, id: newPI.id)
            
        else if(newPI.mediaType.equals('Moving image'))
            redirect (action: movingImageInstance, id: newPI.id)
    }
    
    def updatePhysInst = {
        def instance = PhysInst.get(params.instanceId)
        instance.properties = params
        instance.save(flush: true, failOnError: true)
        flash.message = "Object updated"
        
        if(instance.mediaType.equals('Sound'))
            redirect (action: soundInstance, id: instance.id)
        else if(instance.mediaType.equals('Moving image'))
            redirect (action: movingImageInstance, id: instance.id)
    }
    
    def deletePhysInst = {
        def delPhys = PhysInst.get(params.id)
        def core = delPhys.getDocCore().id
        delPhys.delete()
        redirect(controller: "docCore", action: "core", id: core) 
    }
    
    def editSoundPhysInst = {
        def physIns = PhysInst.get(params.id)
        def dType = PBCoreVocab.findAllByType("DateType")
        def pIns = PBCoreVocab.findAllByType("PhysicalInstance")
   
        [dType:dType, pIns: pIns, instance: physIns]
    }
    
    def editMovingImagePhysInst = {
        def physIns = PhysInst.get(params.id)
        def dType = PBCoreVocab.findAllByType("DateType")
        def pIns = PBCoreVocab.findAllByType("PhysicalInstance")
        
        [dType:dType, pIns: pIns, instance: physIns]
    }
    
    def soundInstance = {
        [ins: PhysInst.get(params.id)]    
    }
    
    def movingImageInstance = {
        [ins: PhysInst.get(params.id)]
    }
}
