
package shout.ejb;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.AccessTimeout;
import javax.ejb.ConcurrencyManagement;
import static javax.ejb.ConcurrencyManagementType.CONTAINER;
import javax.ejb.Lock;
import static javax.ejb.LockType.READ;
import static javax.ejb.LockType.WRITE;
import javax.ejb.Singleton;


@ConcurrencyManagement(CONTAINER)
@AccessTimeout(value = 120000)
@Singleton
public class ShoutBoardEJB implements ShoutBoardEJBRemote {

    private ArrayList<String> shoutList;

    @PostConstruct
    public void initialize() {

        shoutList = new ArrayList<>();
    }

    @Override
    @Lock(WRITE)
    public void addShout(String shout) {

        shoutList.add(shout);

    }

    @Override
    @Lock(READ)
    public String[] getAllShouts() {

        return shoutList.toArray(new String[0]);

    }

}
