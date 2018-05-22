package java.lang;

public final class Class<T> {
    private final String name;

    private Class(String name) {
        this.name = name;
    }

    public static Class forName(String name) {
                        return new Class(name);
    }

    public String getName() {
        return name;
    }

    public String toString() {
        switch (name) {
            case "void":
            case "boolean":
            case "byte":
            case "char":
            case "short":
            case "int":
            case "long":
            case "float":
            case "double":
                return name;
            default:
                return "class " + getName();
        }
    }
}
