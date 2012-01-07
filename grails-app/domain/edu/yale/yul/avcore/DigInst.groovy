package edu.yale.yul.avcore

class DigInst {
    String  fileName
    Date    date
    String  dateType
    String  standard
    String  location
    String  mediaType
    String  generation
    int     fileSize
    String  fileSizeType
    String  duration
    int     dataRate
    String  dataRateType
    String  tracks
    String  channelConfiguration
    String  checksum
    String  checksumType
    String  annotation
    String  colors
    String  soundField
    
    static belongsTo = [docCore:DocCore]
    
    static hasMany = [essence:Essence]
    
    static constraints = {
        annotation(size:0..2147483646, nullable: true)
        date(nullable: true)
        dateType(nullable: true)
        standard(nullable: true)
        location(nullable: true)
        generation(nullable: true)
        fileSize(nullable: true)
        fileSizeType(nullable: true)
        duration(nullable: true)
        dataRate(nullable: true)
        dataRateType(nullable: true)
        tracks(nullable: true)
        channelConfiguration(nullable: true)
        checksum(nullable: true)
        checksumType(nullable: true)
        colors(nullable: true)
        soundField(nullable: true)
        
    }
    
    static mapping = {
        annotation type: 'text'
    }
    
    String toString(){ return fileName}
    
}
