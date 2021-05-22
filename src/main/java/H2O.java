import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class H2O {

    static Semaphore barrierH = new Semaphore(2);
    static Semaphore barrierO = new Semaphore(1);
    CyclicBarrier BARRIER = new CyclicBarrier(3, () -> System.out.println());


    public void releaseHydrogen(Runnable runnable) {
        try {
            barrierH.acquire();
            BARRIER.await();
            runnable.run();
            barrierH.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public void releaseOxygen(Runnable runnable) {
        try {
            barrierO.acquire();
            BARRIER.await();
            runnable.run();
            barrierO.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
