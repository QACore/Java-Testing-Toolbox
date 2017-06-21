package support;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public final class Validations {

    public static void assertLombokToString(Object obj) {
        Class<?> clazz = obj.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();

        StringBuilder sb = new StringBuilder(clazz.getSimpleName() + '(');

        if (declaredFields.length > 0) {
            List<String> fieldAndValue = new ArrayList<>(declaredFields.length);

            try {
                for (int i = 0; i < declaredFields.length; i++) {
                    declaredFields[i].setAccessible(true);

                    if (!isJococoData(declaredFields[i]) && !Modifier.isStatic(declaredFields[i].getModifiers())) {
                        fieldAndValue.add(declaredFields[i].getName() + "=" + declaredFields[i].get(obj));
                    }
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }

            if (!fieldAndValue.isEmpty()) {
                sb.append(String.join(", ", fieldAndValue));
            }
        }

        sb.append(')');

        assertEquals(sb.toString(), obj.toString());
    }

    // Jacoco coverage tool can add field for internal usage
    // It wont affect release code, of course.
    private static boolean isJococoData(Field field) {
        return field.getName().equals("$jacocoData");
    }

    private Validations() {

    }

}
