package edu.yale.yul.avcore

class DigInstController {

    static scaffold = DigInst
    
    def instance = {
        [ins: DigInst.get(params.id)]
    }
}
