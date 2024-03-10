package com.bobocode.se;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * A generic comparator that is comparing a random field of the given class. The field is either primitive or
 * {@link Comparable}. It is chosen during comparator instance creation and is used for all comparisons.
 * <p>
 * If no field is available to compare, the constructor throws {@link IllegalArgumentException}
 *
 * @param <T> the type of the objects that may be compared by this comparator
 *<p><p>
 *  <strong>TODO: to get the most out of your learning, <a href="https://www.bobocode.com/learn">visit our website</a></strong>
 *  <p>
 *
 * @author Stanislav Zabramnyi
 */
public class RandomFieldComparator<T> implements Comparator<T> {

    private Field field;
    private Class<T> targetType;

    public RandomFieldComparator(Class<T> targetType) {
        this.targetType = targetType;
        if (targetType == null) throw new NullPointerException();
        Field[] fields = targetType.getDeclaredFields();
        if(fields.length == 0) throw new IllegalArgumentException();
        Random random = new Random();
        int index = random.nextInt(fields.length);
        this.field = fields[index];
        Class<?> fieldType = field.getType();
        boolean implementsComparable = false;
        for (Class<?> iface : fieldType.getInterfaces()) {
            if (iface == Comparable.class) {
                implementsComparable = true;
                break;
            }
        }
        if (!implementsComparable && !fieldType.isPrimitive()) {
            throw new IllegalArgumentException("Field type must be primitive or implement Comparable");
        }
    }

    /**
     * Compares two objects of the class T by the value of the field that was randomly chosen. It allows null values
     * for the fields, and it treats null value greater than a non-null value.
     *
     * @param o1
     * @param o2
     * @return positive int in case of first parameter {@param o1} is greater than second one {@param o2},
     *         zero if objects are equals,
     *         negative int in case of first parameter {@param o1} is less than second one {@param o2}.
     */
    @Override
    public int compare(T o1, T o2) {
        if(o1 == null || o2 == null) throw new NullPointerException();
        try {
            field.setAccessible(true);
            Object value1= field.get(o1);
            Object value2 = field.get(o2);
            if(value1 == null && value2 == null ) {
                return 0;
            }
            else if(value1 == null) {
                return 1;
            }
            else if(value2 == null) {
                return -1;
            }
            if (value1 instanceof Comparable && value2 instanceof Comparable) {
                return ((Comparable) value1).compareTo(value2);
            } else {
                throw new IllegalArgumentException("Field is not comparable: " + field.getName());
            }
        } catch (IllegalAccessException ignored) {
            throw new IllegalArgumentException("Field is not comparable: " + field.getName());
        }
    }

    /**
     * Returns the name of the randomly-chosen comparing field.
     */
    public String getComparingFieldName() {
        return field.getName();
    }

    /**
     * Returns a statement "Random field comparator of class '%s' is comparing '%s'" where the first param is the name
     * of the type T, and the second parameter is the comparing field name.
     *
     * @return a predefined statement
     */
    @Override
    public String toString() {
        return "Random field comparator of class '%s' is comparing '%s'".formatted(targetType.getSimpleName(), field.getName());
    }
}
