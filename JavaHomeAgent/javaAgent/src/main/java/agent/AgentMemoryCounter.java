package agent;

import java.lang.instrument.Instrumentation;

public class AgentMemoryCounter {
    public  static Instrumentation instrumentation;
    public static void premain(String args, Instrumentation inst) {
        instrumentation=inst;

    }
    public static long getObjectSize(Object obj){
        if (instrumentation==null){
            throw new IllegalStateException("Agent not initialised");
        }
        return instrumentation.getObjectSize(obj);
    }
}
