public class LubanThread {
    static {
        System.loadLibrary("LubanThreadNative");
    }

    public static void main(String[] args) {
        LubanThread lubanThread=new LubanThread();
        lubanThread.start0();
    }

    private native void start0();

    public void run(){
        System.out.println("ceshiRunMethod");
    }
}
