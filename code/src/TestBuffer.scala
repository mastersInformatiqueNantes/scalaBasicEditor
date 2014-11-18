import org.junit.Assert._
import org.junit.Test
import org.junit.Before

class Testbuffer {

  var buffer:Buffer = _
  var bufferVide:Buffer = _
  
  @Before def initialize() {
    buffer = new Buffer()
    buffer.set("HelloReplaceWorld")
    
    bufferVide = new Buffer()
  }

  /* ---------- Buffer :: add(index:Int, text:String) ------- */
  @Test def addTextVide() { 
    assertEquals("", bufferVide.contenu)    
    bufferVide.add(0, "Changed")
    assertEquals("Changed", bufferVide.contenu)
  }
   
  @Test def addTextePlein() { 
    buffer.add(5, "Changed")
    assertEquals("HelloChangedReplaceWorld", buffer.contenu)
  }
  
  // Other possibilities are tested with replace
  
  /* ---------- Buffer :: replace(debut:Int, fin:Int, text:String) ------- */
  @Test def replaceDebutInf() { 
    buffer.replace(-100,4, "Changed")
    assertEquals("ChangedReplaceWorld", buffer.contenu)
  }
  
  @Test(expected=classOf[IndexOutOfBoundsException]) def replaceDebutSup() { 
    buffer.replace(100, 6, "Changed")
  }
 
  @Test(expected=classOf[IndexOutOfBoundsException]) def replaceFinInf() { 
    buffer.replace(2, -100, "Changed")
  }
    
  @Test def replaceFinSup() { 
    buffer.replace(12, 100, "Changed")
    assertEquals("HelloReplaceChanged", buffer.contenu)
  }
  
  @Test def replaceDebutInfFinSup() { 
    buffer.replace(-100, 100, "Changed")
    assertEquals("Changed", buffer.contenu)
  }
  
  @Test def replaceTexteVide() { 
    buffer.replace(5, 11, "")
    assertEquals("HelloWorld", buffer.contenu)
  }
    
  @Test def replaceNormal() { 
    buffer.replace(5, 11, "Changed")
    assertEquals("HelloChangedWorld", buffer.contenu)
  }
  
  /* ---------- Buffer :: set(text:String) ------- */
  @Test def setTexteVide() { 
    buffer.set("")
    assertEquals("", buffer.contenu)
  }
  
  @Test def setNormal() { 
    buffer.set("Changed")
    assertEquals("Changed", buffer.contenu)
  }
  
  /* ---------- Buffer :: get():String ------- */
  @Test def getNormal() { 
    assertEquals("HelloReplaceWorld", buffer.get())
  }
  
  /* ---------- Buffer :: clear() ------- */
  @Test def clearNormal() { 
    buffer.clear()
    assertEquals("", buffer.contenu)
  }
}