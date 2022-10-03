package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)

public class LionTest {

    @Mock
    private Feline feline;

    @Test
    public void getNotValidLion(){
        Exception e = Assert.assertThrows(Exception.class, () -> new Lion ("Трансгендер", feline));
        assertEquals("Используйте допустимые значения пола животного - самей или самка", e.getMessage());
    }

    @org.junit.Test
    public void getKittens() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getKittens()).thenReturn(5);
        assertEquals(5, lion.getKittens());
    }

    @org.junit.Test
    public void doesHaveMane() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void getFood() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood(Mockito.anyString())).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }
}