package hm2.agentSize;

import java.lang.instrument.Instrumentation;
public class AgentTester{
    public static void main(String[] args) {
        String s="";
        printObjectSize(s);
    }
    public static void printObjectSize(Object obj) {
        System.out.println(String.format("%s, size=%s", obj.getClass().getSimpleName(),AgentMemoryCounter.getSize(obj)));
    }
}
 class AgentMemoryCounter {
    private   static Instrumentation instrumentation;
    public static void premain(String args, Instrumentation inst) {
        instrumentation=inst;

    }
    public static long getSize(Object obj){
        if (instrumentation==null){
            throw new IllegalStateException("Agent not initialised");
        }
        return instrumentation.getObjectSize(obj);
    }
}

