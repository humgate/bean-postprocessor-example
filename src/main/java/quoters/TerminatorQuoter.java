package quoters;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.PostConstruct;
@Profiling
public class TerminatorQuoter implements Quoter {
    @InjectRandomInt(min = 2, max = 7)
    private int repeat;
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    @PostProxy
    public void sayQuote() {
        System.out.println("Post proxy (after context refreshed)");
        for (int i = 0; i < repeat; i++) {
            System.out.println("message= " + message);
        }

    }

    @PostConstruct
    public void init() {
        System.out.println("Init: repeat=  " +repeat);

    }

    TerminatorQuoter()  {
        System.out.println("Constructor: repeat= " + repeat);
    }

    public static void main(String[] args) throws InterruptedException {
        var context = new ClassPathXmlApplicationContext("context.xml");
    }
}
