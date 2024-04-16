import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.only;

class HorseTest {

    @Test
    void nullHorse(){

    Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Horse horse = new Horse(null,2.0,5.0);
                }
        );
       assertEquals("Name cannot be null.", exception.getMessage());
        }

    @ParameterizedTest
    @CsvSource({" ' '", " '\t'"
    ," '\n'", "\r'"})
    void nullHorseIsEmpty(String name){

        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Horse horse = new Horse(name,2.0,5.0);
                }
        );
        assertEquals("Name cannot be blank.", exception.getMessage());
    }

    @Test
    void nullHorseSpeed(){

        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Horse horse = new Horse("Жеребец",-2.0,5.0);
                }
        );
        assertEquals("Speed cannot be negative.", exception.getMessage());
    }

    @Test
    void nullHorseDistance(){

        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Horse horse = new Horse("Жеребец",2.0,-5.0);
                }
        );
        assertEquals("Distance cannot be negative.", exception.getMessage());
    }

    @Test
    void getName() throws NoSuchFieldException, IllegalAccessException {

        Horse horse = new Horse("Жеребец",2.0,5.0);
        Field name = Horse.class.getDeclaredField("name");
        name.setAccessible(true);
        String nameResulted = (String) name.get(horse);
        assertEquals("Жеребец",nameResulted);
    }

    @Test
    void getSpeed() throws NoSuchFieldException, IllegalAccessException {

        Horse horse = new Horse("Жеребец",2.0,5.0);
        Field expSpeed = Horse.class.getDeclaredField("speed");
        expSpeed.setAccessible(true);
        Double result = (Double) expSpeed.get(horse);
        assertEquals(2.0,result);
    }

    @Test
    void getDistance() {
        Double expDistance = 5.0;
        Horse horse = new Horse("Жеребец",2.0,expDistance);
        Double result = horse.getDistance();
        assertEquals(expDistance,result);
    }

    @Test
    void getDistanceIsNull() {

        Horse horse = new Horse("Жеребец",2.0);
        Double result = horse.getDistance();
        assertEquals(0,result);
    }

    @Test
    void move() {
        try (MockedStatic<Horse> mockObject =  mockStatic(Horse.class)) {

            Horse horse = new Horse("Name", 2, 3);

            horse.move();
            mockObject.verify( () -> Horse.getRandomDouble(0.2,0.9));
        }
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.3, 0.4, 0.5})
    void checkGetRandomDoubleMethod(double arg) {
        try (MockedStatic<Horse> mockObject =  mockStatic(Horse.class)) {
            mockObject.when(() -> Horse.getRandomDouble(0.2, 0.9)).thenReturn(arg);
            Horse horse = new Horse("Name", 2, 3);
            Double probMove = horse.getDistance() + horse.getSpeed() * Horse.getRandomDouble(0.2, 0.9);
            horse.move();
            assertEquals(probMove, horse.getDistance());
        }
    }

}