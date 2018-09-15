package com.academy.mobile.ddt.tests.full;

import com.academy.mobile.ddt.tests.framework.model.Entities;
import com.academy.mobile.ddt.tests.framework.model.Subscriber;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.academy.mobile.ddt.tests.framework.model.Gender.FEMALE;
import static com.academy.mobile.ddt.tests.framework.model.Gender.MALE;
import static com.academy.util.MatcherAssertExt.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class SubscriberRestTests extends BaseTest {

    @BeforeMethod
    public void prepare() {
        if (manager.ui().ifOn()) {
            manager.ui().goTo().home();
            manager.ui().goTo().subscribers();
        }
    }

    // TODO
    @Test(dataProvider = "modificationProvider")
    public void testModificationSubscriber(Subscriber subscriberBefore, Subscriber subscriberAfter) {
        manager.rest().subscriber().createIfNotPresent(subscriberBefore);
        manager.verify().subscribersFromRestEqualToUi();
        manager.verify().subscribersFromRestEqualToBd();

//        Entities<Subscriber> before = manager.rest().subscriber().all();
//
//        manager.ui().subscriber().verifyIfOnEqualTo(before);
//        manager.bd().subscriber().verifyIfOnEqualTo(before);

        manager.rest().subscriber().modify(subscriberBefore, subscriberAfter);
        manager.rest().subscriber().verifyIsModified();

        Entities<Subscriber> after  = manager.rest().subscriber().all();
        assertThat(after, equalTo(after.withModified(subscriberBefore, subscriberAfter)));

        manager.ui().subscriber().verifyIfSwitchedEqualTo(after);
        manager.bd().subscriber().verifyIfSwitchedEqualTo(after);
    }

    @DataProvider
    private Object[][] modificationProvider() {
        return new Object[][] {
                {
                        Subscriber.newSubscriber()
                                .id(100)
                                .firstName("Evgeniy")
                                .lastName("Onegin")
                                .age(25)
                                .gender(MALE)
                                .build(),

                        Subscriber.newSubscriber()
                                .id(100)
                                .firstName("Maria")
                                .lastName("Pechkina")
                                .age(28)
                                .gender(FEMALE)
                                .build(),
                }
        };
    }
}