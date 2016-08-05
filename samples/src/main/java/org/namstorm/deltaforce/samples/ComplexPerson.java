package org.namstorm.deltaforce.samples;

import org.namstorm.deltaforce.annotations.DeltaBuilder;
import org.namstorm.deltaforce.annotations.DeltaField;

import java.util.Map;

/**
 * Created by maxnam-storm on 5/8/2016.
 */
@DeltaBuilder
public class ComplexPerson {
    public int getIntValue() {
        return intValue;
    }

    public short getShortValue() {
        return shortValue;
    }

    public long getLongValue() {
        return longValue;
    }

    public byte getByteValue() {
        return byteValue;
    }

    public float getFloatValue() {
        return floatValue;
    }

    public double getDoubleValue() {
        return doubleValue;
    }

    public int[] getValues() {
        return intValues;
    }

    public Map getMeta() {
        return meta;
    }

    int intValue;
    short shortValue;
    long longValue;
    byte byteValue;
    float floatValue;
    double doubleValue;
    int[] intValues;
    private int[] privateIntValues;

    public void setPrivateIntValues(int[] privateIntValues) {
        this.privateIntValues = privateIntValues;
    }

    public int[] getIntValues() {

        return intValues;
    }

    public int[] getPrivateIntValues() {
        return privateIntValues;
    }

    @DeltaField(ignore = true)
    Map meta;


}