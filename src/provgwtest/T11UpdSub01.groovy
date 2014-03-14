package provgwtest;

import static org.junit.Assert.*;

import com.hp.snap.lguplus.spr.wsclient.LGUPSubscription
import org.junit.Test;
import provgw.Event
import provgw.SPRSubscription
import provgw.Sub

class T11UpdSub01 {

    @Test
    public void test() {
        def sub = new Sub()
        //Currently no case for change product, just cancel and add another
        sub.update(TestConstants.childEntrNo, '2014-09-01 00:00:00');
        sleep(TestConstants.sleepCount)
        
        def sprsp = new SPRSubscription()
        List<LGUPSubscription> sps = sprsp.get(TestConstants.childEntrNo)
        LGUPSubscription sp = sps.get(0)
        assertEquals(2, sp.getStatus())
        assertEquals(10000001, sp.getProductId())
        //assertTrue(TestUtils.isTimeCorrect('2013-11-04 16:13:53', sp.getStartDate()))
        //assertTrue(TestUtils.isTimeCorrect('2013-11-04 16:13:53', sp.getActivationDate()))
        //assertTrue(TestUtils.isTimeCorrect('2014-08-31 23:59:59', sp.getExpirationDate()))
        //assertEquals(0, sp.getRecurrentCount())
        //assertTrue(TestUtils.isTimeCorrect('2013-11-04 16:13:53', sp.getStartTimestamp()))
        assertTrue(TestUtils.isTimeCorrect(new Date(), sp.getLastSyncedTime()))

        def event = new Event()
        assertEquals('Done', event.getStatus(TestConstants.childEntrNo, 'UPDSUB'))
    }

}
