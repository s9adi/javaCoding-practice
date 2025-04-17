package Patterns;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class ObserverImpl {
    // subject needs to notify multiple objects
    // new data , state change
    // follows pub sub
}

interface Observer {
    void update(String message);
}

interface Subject{
    void addObserver();
    void notifyObserver();
    void removeObserver();
}

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
class User implements Observer{

    String message;

    @Override
    public void update(String message) {

    }
}

class YoutubeChannel implements  Subject{

    @Override
    public void addObserver() {

    }

    @Override
    public void notifyObserver() {

    }

    @Override
    public void removeObserver() {

    }
}