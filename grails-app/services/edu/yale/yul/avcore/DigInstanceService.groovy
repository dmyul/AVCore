package edu.yale.yul.avcore
import java.util.regex.*

class DigInstanceService {

    static transactional = true

    def test() {
        return "test"
    }
    
    def fileSize(String s) {
        Pattern p = Pattern.compile("\\d* ");
        Matcher m = p.matcher(s)
        if(m.find()) {
            return Integer.parseInt(m.group().trim())
        }
    }
    
    def fileSizeType(String s) {
        Pattern p = Pattern.compile(" \\w*\$");
        Matcher m = p.matcher(s)
        if(m.find()) {
            if(m.group().trim().equals("MiB"))
                return "mb"
        }
    }
    
    def dataRate(String s) {
        Pattern p = Pattern.compile("^\\d \\d*");
        Matcher m = p.matcher(s)
            if(m.find()) {
                def s2 = m.group().split(" ")
                return Integer.parseInt(new StringBuilder().append(s2[0]).append(s2[1]).toString())
            }
    }
    
    def dataRateType(String s) {
        Pattern p = Pattern.compile("\\w+\$")
        Matcher m = p.matcher(s)
        if(m.find())
            return m.group().toLowerCase()
    }
    
    def duration(String s) {
        //15mn 5s
        
        //get minutes
        Pattern p = Pattern.compile("\\d+mn")
        Matcher m = p.matcher(s)
        int min
        if(m.find())
            min = Integer.parseInt(m.group().substring(0, m.group().length() -2)) * 60
        
        
        //get seconds
        int sec
        
        p = Pattern.compile(" \\d+s\$")
        m = p.matcher(s)
        if(m.find())
            sec = Integer.parseInt(m.group().substring(0, m.group().length() -1).trim())
            
        return (min + sec).toString()
    }
    
    def tracks(HashMap h) {
        def audio = h.getAt("Audio")
        def video = h.getAt("Video")
        
        StringBuilder au, vi = new StringBuilder()
        
        
        if(audio > 0) {
            if (audio == 1)
                au.append("1 audio track")
            else if (audio > 1)
                au.append(audio + " audio tracks")
        }
        
        if(video > 0) {
            if (video == 1)
                vi.append("1 video track")
            else if (audio > 1)
                vi.append(audio + " video tracks")
        }
        
        if(video > 0 && audio > 0) {
            return vi.append(" and ").append(vi.toString()).toString()
        }
        else if (video > 0) {
            return vi.toString()
        }
        else if (audio > 0) {
            return au.toString()
        }
    }
}
