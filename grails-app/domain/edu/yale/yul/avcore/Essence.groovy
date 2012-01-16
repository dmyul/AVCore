package edu.yale.yul.avcore

class Essence {
    
    String trackType
    String trackStandard
    String trackEncoding
    String trackEncodingProfile
    String trackDataRate
    String trackDataRateUnit
    String trackDataRateType
    int trackSamplingRate
    String trackSamplingRateUnit
    int trackBitDepth
    String trackTimeStart
    String trackDuration
    Float trackFrameRate
    String trackFrameSize
    String trackAspectRatio
    String trackAnnotation
    
    static belongsTo = [digInst: DigInst]
    
    static constraints = {
        trackType(nullable: true)
        trackStandard(nullable: true)
        trackEncoding(nullable: true)
        trackEncodingProfile(nullable: true)
        trackDataRate(nullable: true)
        trackDataRateUnit(nullable: true)
        trackDataRateType(nullable: true)
        trackSamplingRate(nullable: true)
        trackSamplingRateUnit(nullable: true)
        trackBitDepth(nullable: true)
        trackTimeStart(nullable: true)
        trackDuration(nullable: true)
        trackFrameRate(nullable: true)
        trackFrameSize(nullable: true)
        trackAspectRatio(nullable: true)
        trackAnnotation(nullable: true)
    }
}
