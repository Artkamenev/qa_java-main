package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(Parameterized.class)
public class FelineTest {

    private final int actualKittenCount;
    private final int expectedKittenCount;
    private final Feline feline = new Feline();

    public FelineTest(int kittenCount, int expected) {
        this.actualKittenCount = kittenCount;
        this.expectedKittenCount = expected;
    }

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getNotValidFood(){
        Exception e = Assert.assertThrows(Exception.class, () -> feline.getFood("Тест"));
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", e.getMessage());
    }

    @Parameterized.Parameters
    public static Object[] getKittensCount() {
        return new Object[][]{
                {1, 1},
                {20, 20},
                {4, 4}
        };
    }

    @org.junit.Test
    public void eatMeat() throws Exception {
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        List<String> actualResult = feline.eatMeat();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @org.junit.Test
    public void getKittens() {
        assertEquals(expectedKittenCount, feline.getKittens(actualKittenCount));
    }

    @Test
    public void testGetKittens() {
        feline.getKittens();
        assertEquals(expectedKittenCount, feline.getKittens(actualKittenCount));
    }
}