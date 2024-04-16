import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HippodromeTest {

    @Test
    void NullHorses() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Hippodrome hippodrome = new Hippodrome(null);
                }
        );
        assertEquals("Horses cannot be null.", exception.getMessage());
    }

    @Test
    void EmptyHorses() {
        List<Horse> horses = new ArrayList<>();
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Hippodrome hippodrome = new Hippodrome(horses);
                }
        );
        assertEquals("Horses cannot be empty.", exception.getMessage());
    }

    @Test
    void getHorses() {
        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("Буцефал",2.0,5.0));
        horses.add(new Horse("Лада",1.0,5.0));
        horses.add(new Horse("Снежка",3.0,5.0));
        horses.add(new Horse("Ежевика",4.0,10.0));
        horses.add(new Horse("Кондор",1.0,5.0));
        horses.add(new Horse("Туз пик",2.0,5.0));
        horses.add(new Horse("Буцефал1",2.1,5.0));
        horses.add(new Horse("Лада1",1.1,5.0));
        horses.add(new Horse("Снежка1",3.1,5.0));
        horses.add(new Horse("Ежевика1",4.1,10.0));
        horses.add(new Horse("Кондор1",1.1,5.1));
        horses.add(new Horse("Туз пик1",2.2,5.0));
        horses.add(new Horse("Буцефал2",2.2,5.0));
        horses.add(new Horse("Лада2",1.2,5.0));
        horses.add(new Horse("Снежка2",3.2,5.0));
        horses.add(new Horse("Ежевика2",4.2,10.0));
        horses.add(new Horse("Кондор2",1.2,5.0));
        horses.add(new Horse("Туз пик2",2.2,5.0));
        horses.add(new Horse("Буцефал3",2.3,5.0));
        horses.add(new Horse("Лада3",1.3,5.0));
        horses.add(new Horse("Снежка3",3.3,5.0));
        horses.add(new Horse("Ежевика3",4.3,10.0));
        horses.add(new Horse("Кондор3",1.3,5.0));
        horses.add(new Horse("Туз пик3",2.3,5.0));
        horses.add(new Horse("Буцефал4",2.4,5.0));
        horses.add(new Horse("Лада4",1.4,5.0));
        horses.add(new Horse("Снежка4",3.4,5.0));
        horses.add(new Horse("Ежевика4",4.4,10.0));
        horses.add(new Horse("Кондор4",1.4,5.0));
        horses.add(new Horse("Туз пик4",2.4,5.0));
        Hippodrome hippodrome = new Hippodrome(horses);
        List<Horse> result = hippodrome.getHorses();
        assertArrayEquals(horses.toArray(),result.toArray());
    }

    @Test
    void move() {
        List<Horse> horses = new ArrayList<>();
        Horse horse = Mockito.mock(Horse.class);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
        horses.add(horse);
    Hippodrome hippodrome = new Hippodrome(horses);
    hippodrome.move();

    Mockito.verify(horse, Mockito.times(50)).move();



    }

    @Test
    void getWinner() {
        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("Буцефал",2.0,5.0));
        horses.add(new Horse("Лада",1.0,5.0));
        horses.add(new Horse("Снежка",3.0,5.0));
        horses.add(new Horse("Ежевика",4.0,10.0));
        horses.add(new Horse("Кондор",1.0,5.0));
        horses.add(new Horse("Туз пик",2.0,5.0));
        horses.add(new Horse("Буцефал1",2.1,5.0));
        horses.add(new Horse("Лада1",1.1,5.0));
        horses.add(new Horse("Снежка1",3.1,5.0));
        horses.add(new Horse("Ежевика1",4.1,14.0));
        horses.add(new Horse("Кондор1",1.1,5.1));
        horses.add(new Horse("Туз пик1",2.2,5.0));
        horses.add(new Horse("Буцефал2",2.2,5.0));
        horses.add(new Horse("Лада2",1.2,5.0));
        horses.add(new Horse("Снежка2",3.2,5.0));
        horses.add(new Horse("Ежевика2",4.2,13.0));
        horses.add(new Horse("Кондор2",1.2,5.0));
        horses.add(new Horse("Туз пик2",2.2,5.0));
        horses.add(new Horse("Буцефал3",2.3,5.0));
        horses.add(new Horse("Лада3",1.3,5.0));
        horses.add(new Horse("Снежка3",3.3,5.0));
        horses.add(new Horse("Ежевика3",4.3,12.0));
        horses.add(new Horse("Кондор3",1.3,5.0));
        horses.add(new Horse("Туз пик3",2.3,5.0));
        horses.add(new Horse("Буцефал4",2.4,5.0));
        horses.add(new Horse("Лада4",1.4,5.0));
        horses.add(new Horse("Снежка4",3.4,5.0));
        horses.add(new Horse("Ежевика4",4.4,11.0));
        horses.add(new Horse("Кондор4",1.4,5.0));
        horses.add(new Horse("Туз пик4",2.4,5.0));
        Hippodrome hippodrome = new Hippodrome(horses);
        assertEquals("Ежевика1",hippodrome.getWinner().getName());

    }
}