
import java.lang.annotation.Annotation;
import java.util.concurrent.*;

public class CustomThreadPoolExecutor extends ThreadPoolExecutor {

    public CustomThreadPoolExecutor(int corePoolSize) {
        super(corePoolSize,
                100,
                50000,
                TimeUnit.MINUTES,
                new LinkedBlockingQueue<>());
    }

    @Override
    public void execute(Runnable command) {
        Class<?> clazz = command.getClass();
        Annotation[] annotations = command.getClass().getDeclaredAnnotations();
        for (Annotation annotation : annotations){
            if (clazz.isAnnotationPresent(Repeat.class)){
                for (int i = clazz.getAnnotation(Repeat.class).value(); i >0; i--){
                    super.execute(command);
                }
            }
        }
    }
}
