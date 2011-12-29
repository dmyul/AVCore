package edu.yale.yul.avcore

import grails.converters.XML

class PhysInstController {

    def scaffold = PhysInst
    
    def instance = {
        [ins: PhysInst.get(params.id)]
    }
    
    def createSoundInstance = {
        def core = DocCore.get(params.id)
        def dType = PBCoreVocab.findAllByType("dateType")
        def pIns = PBCoreVocab.findAllByType("PhysicalInstance")
        [core:core, dType:dType, pIns: pIns]
    }
    
    def createMovingImageInstance = {
        def core = DocCore.get(params.id)
        def dType = PBCoreVocab.findAllByType("dateType")
        def pIns = PBCoreVocab.findAllByType("PhysicalInstance")
        [core:core, dType:dType, pIns: pIns]
    }
    
    def createMovingPhysicalInstance = {
        def core = DocCore.get(params.id)
        def dType = PBCoreVocab.findAllByType("dateType")
        def pIns = PBCoreVocab.findAllByType("PhysicalInstance")
        [core:core, dType:dType, pIns: pIns]
    }
    
    def commitInst = {
        def core = DocCore.get(params.core)
        def newPI = new PhysInst(params)
        newPI.setDocCore(core)
        newPI.save(flush: true, failOnError: true)
        redirect (action: instance, id: newPI.id)
    }
    
    def deletePhysInst = {
        def delPhys = PhysInst.get(params.id)
        def core = delPhys.getDocCore().id
        delPhys.delete()
        redirect(controller: "docCore", action: "core", id: core) 
    }
    
    def editSoundPhysInst = {
        def physIns = PhysInst.get(params.id)
        render physIns as XML
    }
    
    def editMovingImageInst = {
        def physIns = PhysInst.get(params.id)
        render physIns as XML
    }
    
    def soundInstance = {
        [ins: PhysInst.get(params.id)]    
    }
    
    def movingImageInstance = {
        [ins: PhysInst.get(params.id)]
    }
}
