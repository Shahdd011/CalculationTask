package ejbs;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CalculationService {

    @PersistenceContext
    private EntityManager entityManager;

    public int performCalculation(int number1, int number2, String operation) {
        switch (operation) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                if (number2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return number1 / number2;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
    }
    
}
