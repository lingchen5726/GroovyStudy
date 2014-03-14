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

class T10UpdDev01 {

    @Test
    public void test() {
        def dev = new Dev()
        dev.update(TestConstants.childEntrNo, TestConstants.childUpdMsisdn, TestConstants.childUpdImsi, '2014-08-31 23:59:59')
        sleep(TestConstants.sleepCount)
        
        def sprs = new SPRSubscriber()
        LGUPSubscriber s = sprs.get(TestConstants.childEntrNo)
        assertEquals(TestConstants.expSubStatus, s.getStatus())
        assertEquals(TestConstants.expSubBillDay, s.getBillingDay())
        assertEquals(TestConstants.expSubCountryId, s.getCountryId())
        assertEquals(TestConstants.expSubOpCode, s.getOperatorCode())
        
        def sprd = new SPRDevice()
        LGUPDevice d = sprd.get(TestConstants.childEntrNo)
        assertEquals(TestConstants.childEntrNo, d.getExternalId())
        assertEquals(TestConstants.expDevPlmnId, d.getPlmnId())
        assertEquals(TestConstants.expDevPrdtFmlyId, d.getProductFamilyId())
        assertTrue(TestUtils.isTimeCorrect('2013-09-03 17:08:04', d.getEffectiveDate()))
        assertTrue(TestUtils.isTimeCorrect('2013-09-03 17:08:04', d.getStartTimestamp()))
        assertTrue(TestUtils.isTimeCorrect('2014-08-31 23:59:59', d.getExpirationDate()))
        assertTrue(TestUtils.isTimeCorrect(new Date(), d.getLastSyncedTime()))
        
        def sprdi = new SPRDeviceIdentifier()
        DeviceIdentifier di0 = sprdi.get(TestConstants.childUpdMsisdn, 0)
        assertEquals(0, di0.getIdentifierType())
        assertEquals(TestConstants.childUpdMsisdn, di0.getIdentifier())
        DeviceIdentifier di1 = sprdi.get(TestConstants.childUpdImsi, 1)
        assertEquals(1, di1.getIdentifierType())
        assertEquals(TestConstants.childUpdImsi, di1.getIdentifier())
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
        assertEquals('Done', event.getStatus(TestConstants.childEntrNo, 'UPDDEV'))    
        
    }

}
