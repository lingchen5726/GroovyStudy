package provgwtest;

import static org.junit.Assert.*;

import com.hp.snap.lguplus.spr.wsclient.DeviceIdentifier
import org.junit.Test;
import provgw.Event
import provgw.RoamImsi
import provgw.SPRDeviceIdentifier

class T12UpdRoamImsi01 {

    @Test
    public void test() {
        def roamImsi = new RoamImsi()
        roamImsi.update(TestConstants.childEntrNo, TestConstants.childUpdRoamImsi, '2012-07-09 18:47:24', '2014-08-31 23:59:59');
        
        sleep(TestConstants.sleepCount)
        
        def sprdi = new SPRDeviceIdentifier()
        DeviceIdentifier di0 = sprdi.get(TestConstants.childUpdMsisdn, 0)
        assertEquals(0, di0.getIdentifierType())
        assertEquals(TestConstants.childUpdMsisdn, di0.getIdentifier())
        DeviceIdentifier di1 = sprdi.get(TestConstants.childUpdImsi, 1)
        assertEquals(1, di1.getIdentifierType())
        assertEquals(TestConstants.childUpdImsi, di1.getIdentifier())
        DeviceIdentifier di99 = sprdi.get(TestConstants.childUpdRoamImsi, 99)
        assertEquals(99, di99.getIdentifierType())
        assertEquals(TestConstants.childUpdRoamImsi, di99.getIdentifier())
        DeviceIdentifier diVt0 = sprdi.get(TestConstants.childVtNo, 0)
        assertEquals(0, diVt0.getIdentifierType())
        assertEquals(TestConstants.childVtNo, diVt0.getIdentifier())
        DeviceIdentifier diVt1 = sprdi.get(TestConstants.childVtImsi, 1)
        assertEquals(1, diVt1.getIdentifierType())
        assertEquals(TestConstants.childVtImsi, diVt1.getIdentifier())
        List<DeviceIdentifier> dis = sprdi.get(TestConstants.childEntrNo)
        assertEquals(6, dis.size())

        def event = new Event()
        assertEquals('Done', event.getStatus(TestConstants.childEntrNo, 'UPDROAMIMSI'))
    }

}
