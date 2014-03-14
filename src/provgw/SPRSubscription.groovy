package provgw
import com.hp.snap.lguplus.spr.wsclient.ArrayOfSubscription
import com.hp.snap.lguplus.spr.wsclient.Subscription
import com.hp.snap.lguplus.spr.wsclient.DeviceIdentifier

class SPRSubscription extends SPRDBModel {

    public SPRSubscription(Object name) {
        super('SPRSubscription');
        // TODO Auto-generated constructor stub
    }

    @Override
    public Object get(ENTR_NO) {
        // TODO Auto-generated method stub
        def sprdi = new SPRDeviceIdentifier()
        List<DeviceIdentifier> dis = sprdi.get(ENTR_NO)
        if (null!=dis) {
            DeviceIdentifier di = dis.get(0)
            if (null!=di) {
                ArrayOfSubscription arrsps = ws.findSubscriptions(di.getIdentifierType(), di.getIdentifier())
                if (null!=arrsps) {
                    List<Subscription> sps = arrsps.getSubscription()
                    return sps
                }
            } else {
                return null;
            }
        }
    }

    @Override
    public void set(Object args) {
        // TODO Auto-generated method stub
        
    }

    static main(args) {
        def sprsp = new SPRSubscription()
        //List<Subscription> sp = sprsp.get('662011186399')
        List<Subscription> sp = sprsp.get('882089381788')
        sp.each {
            println ('PRODUCTID is '+it.getProductId()+', Status is '+it.getStatus()+', relatedDeviceid is '+it.getRelatedDeviceId()+', relatedSubscriptionId is '+it.getRelatedSubscriptionId()+', STARTDATE is '+it.getStartDate()+', ACTIVATIONDATE is '+it.getActivationDate()+', EXPIRATIONDATE is '+it.getExpirationDate())
        }
    }

}
