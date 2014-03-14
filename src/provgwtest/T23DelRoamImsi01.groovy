package provgwtest;

import static org.junit.Assert.*;

import com.hp.snap.lguplus.spr.wsclient.DeviceIdentifier
import org.junit.Test;
import provgw.Event
import provgw.RoamImsi
import provgw.SPRDeviceIdentifier

class T23DelRoamImsi01 {

    @Test
    public void test() {
        def roamImsi = new RoamImsi()
        roamImsi.delete(TestConstants.childEntrNo)
        
        sleep(TestConstants.sleepCount)
        
        def sprdi = new SPRDeviceIdentifier()
        DeviceIdentifier di0 = sprdi.get(TestConstants.childUpdMsisdn, 0)
        assertEquals(0, di0.getIdentifierType())
        assertEquals(TestConstants.childUpdMsisdn, di0.getIdentifier())
        DeviceIdentifier di1 = sprdi.get(TestConstants.childUpdImsi, 1)
        assertEquals(1, di1.getIdentifierType())
        assertEquals(TestConstants.childUpdImsi, di1.getIdentifier())
        List<DeviceIdentifier> dis = sprdi.get(TestConstants.childEntrNo)
        assertEquals(2, dis.size())

        def event = new Event()
        assertEquals('Done', event.getStatus(TestConstants.childEntrNo, 'DELROAMIMSI'))
    }

}
