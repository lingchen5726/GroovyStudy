package provgwtest;

import static org.junit.Assert.*;

import com.hp.snap.lguplus.spr.wsclient.DeviceIdentifier
import com.hp.snap.lguplus.spr.wsclient.LGUPDevice
import com.hp.snap.lguplus.spr.wsclient.LGUPSubscriber
import org.junit.Test;
import provgw.Dev
import provgw.Event
import provgw.SPRDevice
import provgw.SPRDeviceIdentifier
import provgw.SPRSubscriber

class T26DelDev01 {

    @Test
    public void test() {
        def dev = new Dev()
        dev.delete(TestConstants.childEntrNo)
        sleep(TestConstants.sleepCount)
        dev.delete(TestConstants.fatherEntrNo)
        sleep(TestConstants.sleepCount)
        dev.delete(TestConstants.motherEntrNo)
        sleep(TestConstants.sleepCount)
        
        def sprs = new SPRSubscriber()
        LGUPSubscriber sChild = sprs.get(TestConstants.childEntrNo)
        assertEquals(null, sChild)
        LGUPSubscriber sFather = sprs.get(TestConstants.fatherEntrNo)
        assertEquals(null, sFather)
        LGUPSubscriber sMother = sprs.get(TestConstants.motherEntrNo)
        assertEquals(null, sMother)

        def sprd = new SPRDevice()
        LGUPDevice dChild = sprd.get(TestConstants.childEntrNo)
        assertEquals(null, dChild)
        LGUPDevice dFather = sprd.get(TestConstants.fatherEntrNo)
        assertEquals(null, dFather)
        LGUPDevice dMother = sprd.get(TestConstants.motherEntrNo)
        assertEquals(null, dMother)
        
        /*Comment for javax.xml.ws.soap.SOAPFaultException: null Caused by: null
        def sprdi = new SPRDeviceIdentifier()
        List<DeviceIdentifier> disChild = sprdi.get(TestConstants.childEntrNo)
        assertEquals(null, disChild)
        List<DeviceIdentifier> disFather = sprdi.get(TestConstants.fatherEntrNo)
        assertEquals(null, disFather)
        List<DeviceIdentifier> disMother = sprdi.get(TestConstants.motherEntrNo)
        assertEquals(null, disMother)
        */

        def event = new Event()
        assertEquals('Done', event.getStatus(TestConstants.childEntrNo, 'DELDEV'))
        assertEquals('Done', event.getStatus(TestConstants.fatherEntrNo, 'DELDEV'))
        assertEquals('Done', event.getStatus(TestConstants.motherEntrNo, 'DELDEV'))
        
    }

}
