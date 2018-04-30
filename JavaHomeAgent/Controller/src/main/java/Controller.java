import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;
public class Controller {
    public static void main(String[] args) {
        String targetName=args[0];
        VirtualMachineDescriptor targetJvm=null;
        for(VirtualMachineDescriptor descriptor: VirtualMachine.list()){
            if(descriptor.displayName().startsWith(targetName)){
                targetJvm=descriptor;
                break;
            }
        }
        String agentJar=args[1];
        try {
            VirtualMachine vm=VirtualMachine.attach(targetJvm);
            vm.loadAgent(agentJar,null);
            vm.detach();
        }catch (Throwable e){
            e.printStackTrace();
        }



    }
}
