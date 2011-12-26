package edu.yale.yul.avcore

class DigInst {
    String fileName
    Date date
    String dateType
    String standard
    String location
    String mediaType
    String generation
    int fileSize
    String fileSizeType
    String duration
    int dataRate
    String dataRateType
    String tracks
    String channelConfiguration
    String checksum
    String checksumType
    String annotation
    
    static belongsTo = [docCore:DocCore]
    static hasMany = [essence:Essence]
    static constraints = {
        annotation(size:0..2147483646)
    }
    
    static mapping = {
        annotation type: 'text'
    }
    
    String toString(){ return fileName}
    
}
