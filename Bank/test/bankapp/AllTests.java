package bankapp;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import bankapp.account.PersonalAccountTest;
import bankapp.account.SavingsAccountTest;
import bankapp.bank.BankTest;

@RunWith(Suite.class)
@SuiteClasses({ PersonalAccountTest.class, SavingsAccountTest.class, BankTest.class})
public class AllTests {

}
