package provgwtest;

import static org.junit.Assert.*;

import com.hp.snap.lguplus.spr.wsclient.LGUPSubscription
import org.junit.Test;
import provgw.SPRSubscription
import provgw.Sub
import provgw.Event

class T2AddSub01 {

    @Test
    public void test() {
        def date = new Date()
        def seqno = date.getTime()/1000
        def sub = new Sub()
        sub.add(TestConstants.childEntrNo, TestConstants.childSpId, seqno);
        sleep(TestConstants.sleepCount)
        
        def sprsp = new SPRSubscription()
        List<LGUPSubscription> sps = sprsp.get(TestConstants.childEntrNo)
        LGUPSubscription sp = sps.get(0)
        assertEquals(2, sp.getStatus())
        assertEquals(10000001, sp.getProductId())
        assertTrue(TestUtils.isTimeCorrect('2013-11-04 16:13:53', sp.getStartDate()))
        assertTrue(TestUtils.isTimeCorrect('2013-11-04 16:13:53', sp.getActivationDate()))
        assertTrue(TestUtils.isTimeCorrect('2013-12-01 00:00:00', sp.getExpirationDate()))
        assertEquals(0, sp.getRecurrentCount())
        assertTrue(TestUtils.isTimeCorrect('2013-11-04 16:13:53', sp.getStartTimestamp()))
        assertTrue(TestUtils.isTimeCorrect(new Date(), sp.getLastSyncedTime()))

        def event = new Event()
        assertEquals('Done', event.getStatus(TestConstants.childEntrNo, 'ADDSUB'))
    }

}
