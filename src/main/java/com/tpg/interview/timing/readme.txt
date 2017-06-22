Question – 3

Design a comprehensive timing measure tool, which can be used to measure time
consumed for any independent method in other class.

For this questions, I am not quite sure about exactly I need to implement for the tool.
But I came up with some ideas which could be used.

#1: directly use system time to log time
long startTime = System.nanoTime();
// call any method here
long stopTime = System.nanoTime();
System.out.println(stopTime - startTime);

#2: To use some open resource tools like Guava Stopwatch

#3:
To use AOP to define an aspect for the target class/method and @Around to calculate the running time.
For ex:

@Aspect
public class TimingAspect {

    @Around("within(com.tpg.interview.*)")
    public void timingAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("timingAround() is running!");

        long start = System.nanoTime();
        joinPoint.proceed();
        long end = System.nanoTime();

        System.out.println("hijacked : " + joinPoint.getSignature().getClass().getSimpleName() + "." + joinPoint.getSignature().getName());
        System.out.println("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("hijacked timing = " + (end - start));
    }
}