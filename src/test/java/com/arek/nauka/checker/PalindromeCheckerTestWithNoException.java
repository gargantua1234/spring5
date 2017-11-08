package com.arek.nauka.checker;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;



@RunWith(JUnitPlatform.class)   //wskazanie klasy wykonujacej testy
@SelectPackages("com.arek.nauka.checker") //wskazanie klas testujacych ktore beda uruchomione
@ExcludeTags("exception")   //wskazanie ze metody tesowe znaczone tagiem "exception" beda pominiete przy wykonywaniu
public class PalindromeCheckerTestWithNoException {
}
