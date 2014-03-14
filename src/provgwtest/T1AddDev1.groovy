/****************************************************************
** Product	:	HP Subscriber Network Application Policy
** Module	:	FIXME: <RTP/Scheduler, should be your maven project name>
** Date: Mar 7, 2014				
** Author: FIXME: chling
** (C) Copyright 2014, Hewlett-Packard Company, All Rights Reserved.
** This software is the proprietary information of HP, Inc.  
** Use is subject to license terms.
*****************************************************************
** Description:   
** FIXME: <A few lines of description of what the program file is about and what it does.> 
** FIXME: <The list of all the class names which have been implemented if multiple classes is implemented in this file.>
****************************************************************/
package provgwtest;

import static org.junit.Assert.*;

import com.hp.snap.lguplus.spr.wsclient.DeviceIdentifier
import com.hp.snap.lguplus.spr.wsclient.LGUPSubscriber
import com.hp.snap.lguplus.spr.wsclient.LGUPDevice
import java.text.SimpleDateFormat
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import provgw.DummyTable
import provgw.DummyWS
import provgw.Event
import provgw.LegacyTable;
import provgw.Dev;
import provgw.SPRDevice
import provgw.SPRDeviceIdentifier
import provgw.SPRSubscriber

/**
 * FIXME: <A few lines of description of what class is about and what it does.> 
 *
 * <HR/><B>Modification Block</B>
 * <P>
 * Version: FIXME: 1.0.1 <BR>
 * Author: FIXME: chling
 * Date: Mar 7, 2014
 * TAG: <A short name to find out all changed made by this modification.>
 * Comments: Created.
 * Bug fix NO.: <If required>
 * </P>
 * <P>
 * ... Other Modifications following above structure.
 * </P>
 **/

class T1AddDev1 {

    /**
     * FIXME: <A brief description of what the method does.> 
     * FIXME: Algorithm: <MUST exist if the method is more than 10 lines. Remove if it is simple.>
     * <An Algorithm in pure English, describing the logic used in the implementation. 
     * This should not contain to any Syntax of Java, in fact, it should be language independent, 
     * and should be targeted to any new comer in the maintenance of the code.>
     *
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        def dt = new DummyTable()
        dt.clear(TestConstants.childEntrNo)
        dt.clear(TestConstants.fatherEntrNo)
        dt.clear(TestConstants.motherEntrNo)
        def dws = new DummyWS()
        try {
            dws.clear(TestConstants.childEntrNo)
            dws.clear(TestConstants.fatherEntrNo)
            dws.clear(TestConstants.motherEntrNo) 
        } catch (com.hp.snap.lguplus.spr.wsclient.SPRWSException_Exception e) {
            //e.println()
        }
    }

    @Test
    public void test() {
        def dev = new Dev()
        dev.add(TestConstants.childEntrNo, TestConstants.childMsisdn, TestConstants.childImsi)
        dev.query(TestConstants.childEntrNo)
        sleep(TestConstants.sleepCount)
        
        def sprs = new SPRSubscriber()
        LGUPSubscriber s = sprs.get(TestConstants.childEntrNo)
        assertEquals(TestConstants.expSubStatus, s.getStatus())
        assertEquals(TestConstants.expSubBillDay, s.getBillingDay())
        assertEquals(TestConstants.expSubCountryId, s.getCountryId())
        assertEquals(TestConstants.expSubOpCode, s.getOperatorCode())
        LGUPSubscriber sMsisdn = sprs.get(0, TestConstants.childMsisdn)
        assertEquals(TestConstants.expSubStatus, sMsisdn.getStatus())
        assertEquals(TestConstants.expSubBillDay, sMsisdn.getBillingDay())
        assertEquals(TestConstants.expSubCountryId, sMsisdn.getCountryId())
        assertEquals(TestConstants.expSubOpCode, sMsisdn.getOperatorCode())
        LGUPSubscriber sImsi = sprs.get(1, TestConstants.childImsi)
        assertEquals(TestConstants.expSubStatus, sImsi.getStatus())
        assertEquals(TestConstants.expSubBillDay, sImsi.getBillingDay())
        assertEquals(TestConstants.expSubCountryId, sImsi.getCountryId())
        assertEquals(TestConstants.expSubOpCode, sImsi.getOperatorCode())

        def sprd = new SPRDevice()
        LGUPDevice d = sprd.get(TestConstants.childEntrNo)
        assertEquals(TestConstants.childEntrNo, d.getExternalId())
        assertEquals(TestConstants.expDevPlmnId, d.getPlmnId())
        assertEquals(TestConstants.expDevPrdtFmlyId, d.getProductFamilyId())
        assertTrue(TestUtils.isTimeCorrect('2013-09-03 17:08:04', d.getEffectiveDate()))
        assertTrue(TestUtils.isTimeCorrect('2013-09-03 17:08:04', d.getStartTimestamp()))
        assertTrue(TestUtils.isTimeCorrect('2013-10-01 00:00:00', d.getExpirationDate()))
        assertTrue(TestUtils.isTimeCorrect(new Date(), d.getLastSyncedTime()))
        
        def sprdi = new SPRDeviceIdentifier()
        DeviceIdentifier di0 = sprdi.get(TestConstants.childMsisdn, 0)
        assertEquals(0, di0.getIdentifierType())
        assertEquals(TestConstants.childMsisdn, di0.getIdentifier())
        DeviceIdentifier di1 = sprdi.get(TestConstants.childImsi, 1)
        assertEquals(1, di1.getIdentifierType())
        assertEquals(TestConstants.childImsi, di1.getIdentifier())
        List<DeviceIdentifier> dis = sprdi.get(TestConstants.childEntrNo)
        assertEquals(2, dis.size())
        
        def event = new Event()
        assertEquals('Done', event.getStatus(TestConstants.childEntrNo, 'ADDDEV'))
               
    }

}
