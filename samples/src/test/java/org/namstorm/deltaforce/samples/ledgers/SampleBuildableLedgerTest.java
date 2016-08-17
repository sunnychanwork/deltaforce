package org.namstorm.deltaforce.samples.ledgers;

import junit.framework.TestCase;
import org.junit.Test;
import org.namstorm.deltaforce.samples.ComplexPerson;
import org.namstorm.deltaforce.samples.ComplexPersonBuilder;
import org.namstorm.deltaforce.samples.ledgers.model.SampleBuildableLedgerEntry;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by maxnamstorm on 16/8/2016.
 */
public class SampleBuildableLedgerTest extends TestCase{

    SampleBuildableLedgerEntry entry;
    SampleBuildableLedger ledger;

    ComplexPerson complexPerson;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        ledger = new SampleBuildableLedger();
        complexPerson = new ComplexPersonBuilder().setFirstName("Complex").setLastName("Person").setAge(42).build();

    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();

        ledger = null;


    }

    @Test
    public void testBuildableCommit() {

        entry = ledger.open();

        ledger.edit().editAuthor().setFirstName("mocky").setLastName("mock");

        ledger.commit();

        assertEquals("author first name", "mocky", entry.getAuthor().getFirstName());
        assertEquals("author first name", "mock", entry.getAuthor().getLastName());

        SampleBuildableLedgerEntry newEntry = ledger.open();

        assertNotSame("new entry must be new", entry, newEntry);

        ledger.edit().addCredit(28.8).addDebit(18.8);

        ledger.commit();

        assertEquals("total must be 10", (double)10, newEntry.getTotal());
    }

    @Test
    public void testFrom() {

        entry = ledger.open();

        ledger.edit().editAuthor().from(complexPerson);

        ledger.commit();

        assertEquals("from person was set correctly", complexPerson, entry.getAuthor());


    }


}