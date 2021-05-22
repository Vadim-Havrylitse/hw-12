import java.text.Annotation;
import java.util.concurrent.*;

public class CustomThreadPoolExecutor extends ThreadPoolExecutor {

    public CustomThreadPoolExecutor(int corePoolSize) {
        super(corePoolSize,
                100,
                50000,
                TimeUnit.MINUTES,
                new LinkedBlockingQueue<Runnable>());
    }

    @Override
    public void execute(Runnable command) {
        Annotation[] annotations = (Annotation[]) command.getClass().getDeclaredAnnotations();
        for (Annotation annotation : annotations){
            if (annotation.getClass().getName().equals(Repeat.class.getName())){
                for (int i = (int)annotation.getValue(); i >0; i--){
                    super.execute(command);
                }
            }
        }


    }
}
