package edu.yale.yul.avcore

class Essence {
    
    String trackType
    String trackStandard
    String trackEncoding
    String trackDataRate
    String trackDataRateUnit
    String trackDataRateType
    int trackSamplingRate
    String trackSamplingRateUnit
    int trackBitDepth
    String trackTimeStart
    String trackDuration
    
    static belongsTo = [digInst: DigInst]
    
    static constraints = {
    }
}
