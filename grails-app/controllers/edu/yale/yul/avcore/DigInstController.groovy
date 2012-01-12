package edu.yale.yul.avcore

class DigInstController {
    def helper = new DigInstanceService()
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
            /*
            render "Class: ${uploadedFile.class}"
            render "<br />Name: ${uploadedFile.name}"
            render "<br />OriginalFileName: ${uploadedFile.originalFilename}"
            render "<br />Size: ${uploadedFile.size}"
            render "<br />ContentType: ${uploadedFile.contentType}"
            */
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
            
            println tracks
            println tracks.getClass()
            
            DigInst di = new DigInst();
            doc.File.track.each{
                if(it.@type.equals("General")) {
                    
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
            redirect(action: instance, id: di.id)
        }
        
        
    }
}