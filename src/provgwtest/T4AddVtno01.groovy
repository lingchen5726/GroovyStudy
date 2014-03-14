package provgwtest;

import static org.junit.Assert.*;

import com.hp.snap.lguplus.spr.wsclient.DeviceIdentifier
import org.junit.Test;
import provgw.Event
import provgw.SPRDeviceIdentifier
import provgw.VtNo

class T4AddVtno01 {

    @Test
    public void test() {
        def vtNo = new VtNo()
        vtNo.add(TestConstants.childEntrNo, TestConstants.childVtImsi, TestConstants.childVtNo);
        
        sleep(TestConstants.sleepCount)
        
        def sprdi = new SPRDeviceIdentifier()
        DeviceIdentifier di0 = sprdi.get(TestConstants.childMsisdn, 0)
        assertEquals(0, di0.getIdentifierType())
        assertEquals(TestConstants.childMsisdn, di0.getIdentifier())
        DeviceIdentifier di1 = sprdi.get(TestConstants.childImsi, 1)
        assertEquals(1, di1.getIdentifierType())
        assertEquals(TestConstants.childImsi, di1.getIdentifier())
        DeviceIdentifier di99 = sprdi.get(TestConstants.childRoamImsi, 99)
        assertEquals(99, di99.getIdentifierType())
        assertEquals(TestConstants.childRoamImsi, di99.getIdentifier())
        DeviceIdentifier diVt0 = sprdi.get(TestConstants.childVtNo, 0)
        assertEquals(0, diVt0.getIdentifierType())
        assertEquals(TestConstants.childVtNo, diVt0.getIdentifier())
        DeviceIdentifier diVt1 = sprdi.get(TestConstants.childVtImsi, 1)
        assertEquals(1, diVt1.getIdentifierType())
        assertEquals(TestConstants.childVtImsi, diVt1.getIdentifier())
        List<DeviceIdentifier> dis = sprdi.get(TestConstants.childEntrNo)
        assertEquals(6, dis.size())

        def event = new Event()
        assertEquals('Done', event.getStatus(TestConstants.childEntrNo, 'ADDVTNO'))
    }

}
