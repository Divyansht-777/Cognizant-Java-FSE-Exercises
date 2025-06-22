interface Notifier {
    void send(String message);
}

class EmailNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappedNotifier;

    NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    public void send(String message) {
        wrappedNotifier.send(message);
    }
}

class SMSNotifierDecorator extends NotifierDecorator {
    SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);
        System.out.println("Sending SMS: " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);
        System.out.println("Sending Slack Message: " + message);
    }
}

public class NotificationSystemDemo {
    public static void main(String[] args) {
        Notifier emailOnly = new EmailNotifier();
        System.out.println("Basic Notification:");
        emailOnly.send("Your order has been placed.");

        Notifier emailAndSMS = new SMSNotifierDecorator(new EmailNotifier());
        System.out.println("\nEmail + SMS Notification:");
        emailAndSMS.send("Your order has been shipped.");

        Notifier fullNotification = new SlackNotifierDecorator(
                                        new SMSNotifierDecorator(
                                            new EmailNotifier()));
        System.out.println("\nEmail + SMS + Slack Notification:");
        fullNotification.send("Your order has been delivered.");
    }
}
