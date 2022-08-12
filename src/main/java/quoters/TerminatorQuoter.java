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
    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println(message + message);
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
        while (true) {
            Thread.sleep(100);
            context.getBean(Quoter.class).sayQuote();
        }


    }
}
