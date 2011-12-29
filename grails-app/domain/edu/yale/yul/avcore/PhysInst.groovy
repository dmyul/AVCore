package edu.yale.yul.avcore

class PhysInst {
    String barcode
    String label
    Date date
    String dateType
    String physDesc
    String dimensions
    String dimensionsType
    String location
    String mediaType
    String generation
    String tracks
    String channelConfiguration
    String colors
    String material
    String sound
    
    
    static belongsTo = [docCore: DocCore]
    
    static constraints = {

        dimensions(nullable: true)
        dimensionsType(nullable: true)
        tracks(nullable:true)
        channelConfiguration(nullable: true)
        colors(nullable: true)
        material(nullable: true)
        sound(nullable: true)
    }
    
    String toString(){
        return label
    }
}
