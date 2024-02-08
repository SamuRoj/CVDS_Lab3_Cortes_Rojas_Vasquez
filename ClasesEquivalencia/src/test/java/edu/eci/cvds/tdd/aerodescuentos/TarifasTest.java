package edu.eci.cvds.tdd.aerodescuentos;

import org.junit.Assert;
import org.junit.Test;

public class TarifasTest {
    @Test
    public void verifyNegativeFee() {
        CalculadorDescuentos calculador = new CalculadorDescuentos();
        try{
            calculador.calculoTarifa(-1, 10, 10);
            Assert.fail();
        }
        catch(Throwable e){
            Assert.assertEquals(true, true);
        }
    }

    @Test
    public void verifyNegativeDays() {
        CalculadorDescuentos calculador = new CalculadorDescuentos();
        try{
            calculador.calculoTarifa(10000, -10, 10);
            Assert.fail();
        }
        catch(Throwable e){
            Assert.assertEquals(true, true);
        }
    }

    @Test
    public void verifyNegativeAge() {
        CalculadorDescuentos calculador = new CalculadorDescuentos();
        try{
            calculador.calculoTarifa(10000, 10, -10);
            Assert.fail();
        }
        catch(Throwable e){
            Assert.assertEquals(true, true);
        }
    }

    @Test
    public void successfulFeeCalculation() {
        CalculadorDescuentos calculador = new CalculadorDescuentos();
        try{
            double total = calculador.calculoTarifa(1000000, 10, 10);
            Assert.assertEquals(950000, total,0);
        }
        catch(Throwable e){
            Assert.fail();
        }
    }
    // TODO Complete with more test cases
}