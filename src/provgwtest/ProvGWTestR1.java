package provgwtest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ T1AddDev1.class, T2AddSub01.class, T3AddRoamImsi01.class,
    T4AddVtno01.class, T5AddSmsDeny01.class, T6AddWlitIso01.class, T7AddSmsNotc01.class, T8AddAgnt01.class,
    T9AddUnion01.class, T10UpdDev01.class, T11UpdSub01.class, T12UpdRoamImsi01.class, T13UpdVtno01.class,
        T14UpdSmsDeny01.class, T15UpdWlitIso01.class, T16UpdSmsNotc01.class, T17UpdAgnt01.class, T18DelAgnt01.class,
        T19DelSmsNotc01.class, T20DelWlitIso01.class, T21DelSmsDeny01.class, T22DelVtno01.class,
        T23DelRoamImsi01.class, T25DelSub01.class, T26DelDev01.class })
public class ProvGWTestR1 {

}
