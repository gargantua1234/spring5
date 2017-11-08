package com.arek.nauka.checker;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;


@DisplayName("StringChecker tests")
class StringCheckerTest {

    private static StringChecker checker;

    @BeforeAll
    static void setup(){
        checker = new StringChecker();
        System.out.println("Setup");
    }

    @BeforeEach
    void beforeEachInvocation(){
        System.out.println("Before each test");
    }

    @AfterEach
    void afterEachInvocation(){
        System.out.println("After each test");
    }

    @AfterAll
    static void tearDown(){
        checker = null;
        System.out.println("Cleaning");
    }

    @Test
    @DisplayName("if not palindrome return false")
    void testNotPalindromeReturnFalse(){
        assertAll("not  palindromes",
                ()-> assertThat(checker.isPalindrome("Sentence"))
                        .isFalse(),
                () -> assertThat(checker.isPalindrome("Line of text"))
                        .isFalse(),
                () -> assertThat(checker.isPalindrome("Upper Cammel Case"))
                    .isFalse()
        );
    }

    @Test
    @DisplayName("for palindrome should return true")
    void testTrueIfWordIsAPalindrome(){
        assertAll("palindromes",
                () -> assertThat(checker.isPalindrome("alula"))
                        .isTrue(),
                () -> assertThat(checker
                        .isPalindrome("Al lets Della call Ed Stella"))
                        .isTrue(),
                () -> assertThat(checker
                        .isPalindrome("Amen icy cinema"))
                        .isTrue()
        );
    }

    @Test
    @DisplayName("Non alphanumeric chars should be ignored")
    void testShouldIgnoreNonAlphanumericCharsInComparison(){
        assertAll("palindromes",
                () -> assertThat(checker
                        .isPalindrome("Amore, Roma."))
                        .isTrue(),
                () -> assertThat(checker
                        .isPalindrome("Are we not pure? “No sir!” " +
                                "Panama’s moody Noriega brags. “It is " +
                                "garbage!” Irony dooms a man; a prisoner" +
                                " up to new era."))
                        .isTrue(),
                () -> assertThat(checker
                        .isPalindrome("Are Mac ‘n’ Oliver ever " +
                                "evil on camera?"))
                        .isTrue()
                );
    }

    @Test
    @DisplayName("For empty word the method should throw an exception")
    @Tag("exception")
    void testExceptionThrowsIfWordIsEmpty(){
        Throwable exception = assertThrows(IllegalArgumentException.class,
                ()-> checker.isPalindrome(""));
        assertThat(exception.getMessage()).isEqualTo("You can not check the empty word");
    }


    @Test
    @DisplayName("For null word method should throw an illegal argument wxception")
    @Tag("exception")
    void testExceptionThrowsIfWordIsNull(){
        Throwable exception = assertThrows(IllegalArgumentException.class,
                ()-> checker.isPalindrome(null));
        assertThat(exception.getMessage()).isEqualTo("You can not check the empty word");
    }

    @Test
    @Disabled           //wylaczanie testów
    @DisplayName("This test is disabled")
    void testSkippedTest(){
        System.out.println("This test is skipped");
    }
    
    @DisplayName("Repeated test")
    @RepeatedTest(value = 5, name = "{displayName}" +
            " - repetition {currentRepetition} of {totalRepetitions}")  /*powtarzanie testów,  value - liczba powtórzeń */
    void testRepeated(){
        assertThat(checker.isPalindrome("kajak")).isTrue();
    }
}
