
@Repeat(4)
class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello!");
    }
}