package provgw
import com.hp.snap.lguplus.spr.wsclient.SPRExternalWebService

class ProvGWExtWS {
    private static SPRExWS = null;
    private static extWSPort = null;
    
    private ProvGWExtWS() {
    }
    
    public static getWS() {
        if (null.is(SPRExWS)) {
            this.SPRExWS = new SPRExternalWebService(new URL(ProvGWConstants.wsdlUrl))
            if (null.is(extWSPort)) {
                this.extWSPort = SPRExWS.getSPRExternalWebServicePort()
            }
        }
        return this.extWSPort
    }
    
    static main(args) {
        //def provGWExtWS = new ProvGWExtWS()
        def ws = ProvGWExtWS.getWS()
        def s = ws.getSubscriberById('15993898671')
        println s.getStatus()
    }

}
