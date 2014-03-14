package provgw
import com.hp.snap.lguplus.spr.wsclient.Subscriber

class SPRSubscriber extends SPRDBModel {

    public SPRSubscriber(Object name) {
        super('SPRSubscriber');
    }

    @Override
    public Object get(ENTR_NO) {
        return ws.getSubscriberById(ENTR_NO)
    }

    @Override
    public Object get(identifiertype, identifier) {
        return ws.getSubscriberByIdentifier(identifiertype, identifier)
    }

    @Override
    public void set(Object args) {
        // TODO Auto-generated method stub
        
    }

    static main(args) {
        def sprs = new SPRSubscriber()
        Subscriber s1 = sprs.get('15994092533')
        println s1.getExternalId()
        Subscriber s2 = sprs.get(0, '010089381739')
        println s1.getExternalId()

    }

}
