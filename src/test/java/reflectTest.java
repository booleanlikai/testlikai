import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Date;

public class reflectTest {

    @Test
    public void testre() throws ClassNotFoundException {
        String name = "java.util.Date";

        Class cl = Class.forName(name);
        Class supercl = cl.getSuperclass();
        String modifiers = Modifier.toString(cl.getModifiers());
        if (modifiers.length() > 0) System.out.printf(modifiers + " ");
        System.out.print("calss" + name);
        if (supercl != null && supercl != Object.class)
            System.out.print("extends" + supercl.getName());
        System.out.print("\n{\n");
        printConstructors(cl);
        System.out.println();
        printMethods(cl);
        System.out.println();
        printFields(cl);
        System.out.println("}");


    }


    public void printConstructors(Class cl) {
        Constructor[] c = cl.getDeclaredConstructors();
        for (Constructor c1 : c) {
            String name = c1.getName();
            System.out.print("   ");
            String modifiers = Modifier.toString(c1.getModifiers());
            if (modifiers.length() > 0)
                System.out.print(modifiers + "");
            System.out.print(name + "(");
            Class[] paraType = c1.getParameterTypes();
            for (int i = 0; i < paraType.length; i++) {
                if (i > 0) System.out.print(", ");
                System.out.print(paraType[i].getName());
            }
            System.out.println(");");
        }
    }

    public void printMethods(Class cl) {
        Method[] methods = cl.getDeclaredMethods();
        for (Method m : methods) {
            Class rettype = m.getReturnType();
            String name = rettype.getName();
            System.out.print("   ");
            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length() > 0)
                System.out.printf(modifiers + "");
            System.out.printf(rettype.getName() + "  " + name + "(");
            Class[] paramTypes = m.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) System.out.print(", ");
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    public void printFields(Class cl) {
        Field[] fields = cl.getDeclaredFields();
        for (Field f : fields) {
            Class type = f.getType();
            String name = f.getName();
            System.out.print("   ");
            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length() > 0)
                System.out.printf(modifiers + "");
            System.out.printf(type.getName() + "  " + name + "(");
        }
    }
}
