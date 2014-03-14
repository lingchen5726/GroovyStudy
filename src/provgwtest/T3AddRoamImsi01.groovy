package provgwtest;

import static org.junit.Assert.*;

import com.hp.snap.lguplus.spr.wsclient.DeviceIdentifier
import org.junit.Test;
import provgw.Event
import provgw.RoamImsi
import provgw.SPRDeviceIdentifier

class T3AddRoamImsi01 {

    @Test
    public void test() {
        def roamImsi = new RoamImsi()
        roamImsi.add(TestConstants.childEntrNo, TestConstants.childRoamImsi);
        
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
        List<DeviceIdentifier> dis = sprdi.get(TestConstants.childEntrNo)
        assertEquals(4, dis.size())

        def event = new Event()
        assertEquals('Done', event.getStatus(TestConstants.childEntrNo, 'ADDROAMIMSI'))
    }

}
