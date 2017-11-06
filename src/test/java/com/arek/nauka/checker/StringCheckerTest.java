package com.arek.nauka.checker;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.assertThat;

//import static org.junit.jupiter.api.Assertions.assertFalse;

//import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertAll;

@Tag("Unit tests")
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

    @AfterAll
    static void tearDown(){
        checker = null;
        System.out.println("Cleaning");
    }

    @Test
    @DisplayName("For empty word should return false")
    void testIsNotAPalindromeIfWordIsEmpty(){
        assertThat(checker.isPalindrome("")).isEqualTo(false);
    }

    @Test
    @DisplayName("Null object is not a palindrome")
    void testFalseIfWordIsNull(){
       assertThat(checker.isPalindrome(null)).isEqualTo(false);
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
    void testShouldIgnorNonAlphanumericCharsInComparison(){
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

}
