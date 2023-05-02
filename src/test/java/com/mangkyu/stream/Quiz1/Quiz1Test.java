package com.mangkyu.stream.Quiz1;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Quiz1Test {

    private final Answer1 answer = new Answer1();
    private final Quiz1 quiz = new Quiz1();

    @Test
    void quiz1() throws IOException {
        assertThat(quiz.quiz1()).isEqualTo(answer.quiz1());
    }

    @Test
    void quiz2() throws IOException {
        assertThat(quiz.quiz2()).isEqualTo(answer.quiz2());
    }

    @Test
    void quiz3() throws IOException {
        assertThat(quiz.quiz3()).isEqualTo(answer.quiz3());
    }

    @Test
    void wordProcessTest() {
        List<String> words = Arrays.asList("TONY", "a", "hULK", "B", "america", "X", "nebula", "Korea");

        String result = words.stream()
                .filter(w -> w.length() > 1)
                .map(String::toUpperCase)
                .map(w -> w.substring(0, 1))
                .collect(Collectors.joining(" "));

        assertEquals(result, "T H A N K");
    }

    @Test
    void customFunction() {
        Function<String, String> function = word -> word.toUpperCase();
        assertEquals(function.apply("text"), "TEXT");
    }

}