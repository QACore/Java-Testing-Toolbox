package support;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;

public final class Validations {

    public static void assertLombokToString(Object obj) {
        Class<?> clazz = obj.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();

        StringBuilder sb = new StringBuilder(clazz.getSimpleName() + '(');

        if (declaredFields.length > 0) {
            if (!isJococoData(declaredFields[0])) {
                appendLombokToStringField(declaredFields[0], obj, sb);
            }

            for (int i = 1; i < declaredFields.length; i++) {
                if (!isJococoData(declaredFields[i])) {
                    appendLombokToStringFieldWithComma(declaredFields[i], obj, sb);
                }
            }
        }

        sb.append(')');

        System.out.println(sb.toString());
        assertEquals(sb.toString(), obj.toString());
    }

    private static void appendLombokToStringFieldWithComma(Field field, Object obj, StringBuilder sb) {
        sb.append(", ");

        appendLombokToStringField(field, obj, sb);
    }

    private static void appendLombokToStringField(Field field, Object obj, StringBuilder sb) {
        field.setAccessible(true);

        sb.append(field.getName());
        sb.append('=');
        try {
            sb.append(field.get(obj));
        } catch (IllegalArgumentException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isJococoData(Field field) {
        // Jacoco coverage tool can add field for internal usage
        // It wont affect release code, of course.

        return field.getName().equals("$jacocoData");
    }

    private Validations() {

    }

}
