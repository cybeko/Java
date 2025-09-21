package hw3_threads;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
public class Program {
	public static void main(String[] args) throws InterruptedException {
		Observable<String> observable = Observable.just("a", "b", "c");
		
		observable.subscribe(				
				item -> System.out.println("Received: " + item),
				error -> System.err.println("Error: " + error),
				() -> System.out.println("Done")
        );
		
		Observable<Integer> observable2 = Observable.range(1, 10); 

        observable2  
            .filter(x -> x > 5)
            .subscribe(
	                item -> System.out.println("Recieved: " + item),
	                Throwable::printStackTrace,
	                () -> System.out.println("Done")
            );

        Flowable<Integer> flowable = Flowable.range(1, 20)
                .parallel(4)
                .runOn(Schedulers.io())
                .map(i -> {
                    System.out.println("Processing " + i + " on: " + Thread.currentThread().getName());
                    Thread.sleep(200);
                    return i;
                })
                .sequential();

        	flowable.subscribe(
	                item -> System.out.println("Received: " + item + " on: " + Thread.currentThread().getName()),
	                Throwable::printStackTrace,
	                () -> System.out.println("Done")
            );

            Thread.sleep(5000);

                
	}
}
