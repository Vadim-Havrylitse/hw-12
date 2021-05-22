
public class Main {

    public static void main(String[] args) {
        final Runnable releaseH = () -> System.out.print("H");
        final Runnable releaseO = () -> System.out.print("O");

        String input = "OOOOOOHHHHHOHHHOOHH";

        H2O h2O = new H2O();

//        for (char el : input.toCharArray()) {
//            if (el == 'H'){
//
//                new Thread(() -> h2O.releaseHydrogen(releaseH)).start();
//            }
//            if (el == 'O'){
//                new Thread(() -> h2O.releaseOxygen(releaseO)).start();
//            }
//
//        }

        CustomThreadPoolExecutor customThreadPoolExecutor = new CustomThreadPoolExecutor(5);
        customThreadPoolExecutor.execute(new MyRunnable());
    }
}
