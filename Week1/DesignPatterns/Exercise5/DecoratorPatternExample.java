package Exercise5;

interface Notifier {
    void send(String message);
}

class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending EMAIL: " + message);
    }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    @Override
    public void send(String message) {
        wrappedNotifier.send(message); // Delegation
    }
}

class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);  // Call base
        sendSMS(message);     // Add new behavior
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);   // Call base
        sendSlack(message);    // Add new behavior
    }

    private void sendSlack(String message) {
        System.out.println("Sending Slack message: " + message);
    }
}

public class DecoratorPatternExample {
    public static void main(String[] args) {
        Notifier emailOnly = new EmailNotifier();

        // Email + SMS
        Notifier emailAndSMS = new SMSNotifierDecorator(emailOnly);

        // Email + SMS + Slack
        Notifier allChannels = new SlackNotifierDecorator(emailAndSMS);

        System.out.println("Basic Notification:");
        emailOnly.send("System reboot at 2 AM");

        System.out.println("\nEmail + SMS Notification:");
        emailAndSMS.send("Server down alert!");

        System.out.println("\nEmail + SMS + Slack Notification:");
        allChannels.send("Critical security breach!");
    }
}
