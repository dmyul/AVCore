package edu.yale.yul.avcore

class DigInstController {
    
    def helper = new DigInstanceService()
    def essence = new EssenceService()
    
    static scaffold = DigInst
    
    def instance = {
        [ins: DigInst.get(params.id)]
    }
    
    def addInstance = {
        DocCore core = DocCore.get(params.id)
        [core: core, mediaType: params.mediaType]
        
    }
    
    def readMediaInfo = {
        DocCore core = DocCore.get(params.id)
        def uploadedFile = request.getFile('payload')
        if(!uploadedFile.empty){
            
            def webRootDir = servletContext.getRealPath("/")
            def userDir = new File(webRootDir, "/uploads")
            userDir.mkdirs()
            uploadedFile.transferTo( new File( userDir, uploadedFile.originalFilename))
      
            File f = new File((userDir.toString() + "/" + uploadedFile.originalFilename))
            if(f.exists()){
                //render ("Upload Successful<br />")
            }
            
            def doc = new XmlSlurper().parse(f)
            
            //determine track count
            HashMap<String, Integer> tracks = new HashMap<String, Integer>(["General": 0, "Video": 0, "Audio": 0])
            doc.File.track.each{
                if(it.@type.equals("General")) {
                    def a = tracks.getAt("General")
                    a++
                    tracks.putAt("General", a)
                }
                else if(it.@type.equals("Video")) {
                    def a = tracks.getAt("Video") 
                    a++
                    tracks.putAt("Video", a)
                }
                else if(it.@type.equals("Audio")) {
                    def a = tracks.getAt("Audio") 
                    a++
                    tracks.putAt("Audio", a)
                }
            }
            
            
            DigInst di = new DigInst();
            def format
            doc.File.track.each{
                if(it.@type.equals("General")) {
                    format = it.Format
                    di.fileName = it.Complete_name
                    di.fileSize = helper.fileSize(it.File_size.toString())
                    di.fileSizeType = helper.fileSizeType(it.File_size.toString())
                    di.dateType = "encoded"
                    di.date = java.sql.Date.valueOf(it.Encoded_date.toString().substring(4,14).trim())
                    di.standard = it.Format
                    di.dataRate = helper.dataRate(it.Overall_bit_rate.toString())
                    di.dataRateType = helper.dataRateType(it.Overall_bit_rate.toString())
                    di.duration = helper.duration(it.Duration.toString())
                    di.annotation = "Format_profile: " + it.Format_profile + ", Codec_ID: " + it.Codec_ID
                    

                }
            }
            di.tracks = helper.tracks(tracks)
            di.docCore = core
            di.mediaType = params.mediaType     
            di.save(flush: true, failOnError: true)
            
            
            doc.File.track.each{
                if(it.@type.equals("Video")) {
                    Essence es = new Essence()
                    es.setDigInst(di)
                    es.trackType = "Video"
                    es.trackStandard = it.Standard
                    es.trackEncoding = it.Format
                    es.trackEncodingProfile = it.Format_profile
                    def bd = it.Bit_depth.toString().split(" ")[0]
                    es.trackBitDepth = Integer.parseInt(bd)
                    def fr = it.Frame_rate.toString().split(" ")[0]
                    es.trackFrameRate = Float.parseFloat(fr)
                    es.trackDataRate = helper.dataRate(it.Bit_rate.toString())
                    es.trackDataRateUnit = helper.dataRateType(it.Bit_rate.toString())
                    es.trackDataRateType = it.Bit_rate_mode
                    es.trackDuration = helper.duration(it.Duration.toString())
                    es.trackAspectRatio = it.Display_aspect_ratio
                    def wi = it.Width.toString().split(" ")[0]
                    def hi = it.Height.toString().split(" ")[0]
                    es.trackFrameSize = (wi + " x " + hi + " px")
                    def annote = new StringBuilder()
                        .append("Color Space: " + it.Color_space + ", ")
                        .append("Chroma sub-sampling: " + it.Chroma_subsampling + ", ")
                        .append("Scan Type: " + it.Scan_type)
                    es.trackAnnotation = annote.toString()
                    es.save(flush: true, failOnError: true)
                }
                else if(it.@type.equals("Audio")) {
                    Essence es = new Essence()
                    es.setDigInst(di)
                    es.trackType = "Audio"
                    es.save(flush: true, failOnError: true)
                }
            }
            
            
            redirect(action: instance, id: di.id)
        }
        
        
    }
}